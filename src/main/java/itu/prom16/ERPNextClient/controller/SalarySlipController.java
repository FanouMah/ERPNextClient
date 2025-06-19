package itu.prom16.ERPNextClient.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import itu.prom16.ERPNextClient.DTO.EmployeeDTO;
import itu.prom16.ERPNextClient.DTO.SalaryDetailDTO;
import itu.prom16.ERPNextClient.DTO.SalarySlipDTO;
import itu.prom16.ERPNextClient.DTO.SalaryStructureAssignmentDTO;
import itu.prom16.ERPNextClient.DTO.SalaryStructureDTO;
import itu.prom16.ERPNextClient.exception.CSRFTokenException;
import itu.prom16.ERPNextClient.exception.ValidationException;
import itu.prom16.ERPNextClient.model.SalarySlipsMonth;
import itu.prom16.ERPNextClient.service.EmployeeService;
import itu.prom16.ERPNextClient.service.PDFGeneratorService;
import itu.prom16.ERPNextClient.service.SalarySlipService;
import itu.prom16.ERPNextClient.service.SalaryStructureAssignmentService;
import itu.prom16.ERPNextClient.service.SalaryStructureService;
import itu.prom16.ERPNextClient.utils.Tools;

/**
 *
 * @author Fanou
 */
@Controller
public class SalarySlipController {
    @Autowired
    private SalarySlipService salarySlipService;

    @Autowired
    private PDFGeneratorService pdfGeneratorService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SalaryStructureAssignmentService salaryStructureAssignmentService;

    @Autowired
    private SalaryStructureService salaryStructureService;    
    
    @GetMapping(value = "/salary-slip/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getPayslipPDF(
            @CookieValue(value = "sid", required = false) String sid,
            @RequestParam("name") String salarySlipName) {    
            try {
                SalarySlipDTO salarySlip = salarySlipService.getSalarySlip(sid, salarySlipName);

                byte[] pdf = pdfGeneratorService.generateSalarySlipPDF(salarySlip);

                System.out.println(pdf);
                if (pdf == null) {
                    return ResponseEntity.notFound().build();
                }

                String safeFilename = salarySlip.getName().replaceAll("[^a-zA-Z0-9]", "_") + ".pdf";

                return ResponseEntity.ok()
                        .header("Content-Disposition", "attachment; filename=\"" + safeFilename + "\"")
                        .body(pdf);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().build();
            }
        }

    @GetMapping("/salary-slips/update")
    public String showUpdateSalarySlipForm(
        @CookieValue(value = "sid", required = false) String sid, Model model) {
        if (sid != null) {
            try {
                SalaryStructureDTO salaryStructure = salaryStructureService.getSalaryStructure(sid);
                if (salaryStructure != null) {
                    List<SalaryDetailDTO> salaryDetails = salaryStructure.getEarnings();
                    salaryDetails.addAll(salaryStructure.getDeductions());
                    model.addAttribute("salaryDetails", salaryDetails);
                }
            } catch (CSRFTokenException ex) {
                return "redirect:/logout";
            } catch (RuntimeException e) {
                model.addAttribute("code", "500");
                model.addAttribute("error", e.getMessage());
                return "error-500";
            }
            return "update-salary-slips";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/salary-slips/update")
    public String updateSalarySlip(
            @CookieValue(value = "sid", required = false) String sid, 
            Model model,
            RedirectAttributes redirectAttributes,
            @RequestParam(value = "salaryElement", required = true) String salaryElement,
            @RequestParam(value = "signeSalaryElement", required = true) String signeSalaryElement,
            @RequestParam(value = "amountSalaryElement", required = true) Double amountSalaryElement,
            @RequestParam(value = "signeBase", required = true) String signeBase,
            @RequestParam(value = "pourcentageBase", required = true) Double pourcentageBase) {
        
        if (sid != null) {
            try {
                String abbrSalaryElement = salaryElement.split(";")[0]; 
                String typeSalaryElement = salaryElement.split(";")[1]; 

                // List<SalarySlipDTO> salarySlips = new ArrayList<>();

                // for (SalarySlipDTO ss : salarySlipService.getSalarySlips(sid)) {
                //     SalaryDetailDTO salaryDetail = null;
                //     if (typeSalaryElement.equals("earnings")) {
                //         for (SalaryDetailDTO sd : ss.getEarnings()) {
                //             if (sd.getAbbr().equals(abbrSalaryElement)) {
                //                 salaryDetail = sd;
                //             }
                //         }
                //     } else if (typeSalaryElement.equals("deductions")) {
                //         for (SalaryDetailDTO sd : ss.getDeductions()) {
                //             if (sd.getAbbr().equals(abbrSalaryElement)) {
                //                 salaryDetail = sd;
                //             }
                //         }
                //     } 

                //     if (salaryDetail != null) {
                //         if (signeSalaryElement.equals("inf")) {
                //             if (salaryDetail.getAmount() < amountSalaryElement) {
                //                 salarySlips.add(ss);
                //             }
                //         } else if (signeSalaryElement.equals("sup")) {
                //             if (salaryDetail.getAmount() > amountSalaryElement) {
                //                 salarySlips.add(ss);
                //             }
                //         }
                //     }
                // }

                List<SalarySlipDTO> salarySlips = salarySlipService.getSalarySlips(sid).stream()
                    .filter(ss -> {
                        List<SalaryDetailDTO> details = typeSalaryElement.equals("earnings") ? ss.getEarnings() : ss.getDeductions();
                        return details.stream()
                            .filter(sd -> sd.getAbbr().equals(abbrSalaryElement))
                            .anyMatch(sd -> 
                                ("inf".equals(signeSalaryElement) && sd.getAmount() < amountSalaryElement) ||
                                ("sup".equals(signeSalaryElement) && sd.getAmount() > amountSalaryElement)
                            );
                    })
                    .collect(Collectors.toList());
                
                if (salarySlips.isEmpty()) {
                    throw new ValidationException("No Salary Found");
                }

                int salaryUpdated = 0;

                for (SalarySlipDTO salarySlip : salarySlips) {
                    //cancel salary assignment by employee and date
                    SalaryStructureAssignmentDTO ssa = salaryStructureAssignmentService.cancelSSAtByEmployeeAndfromDate(sid, salarySlip.getEmployee(), salarySlip.getPostingDate().toString());
                    if (ssa == null) {
                        throw new ValidationException("No Salary Structure Assignment Found for " + salarySlip.getEmployee() + " on " + salarySlip.getPostingDate());   
                    }

                    //create salary assignment with new base
                    SalaryStructureAssignmentDTO newSsa = new SalaryStructureAssignmentDTO();
                    newSsa.setAmendedFrom(ssa.getName());
                    newSsa.setEmployee(ssa.getEmployee());
                    newSsa.setSalaryStructure(ssa.getSalaryStructure());
                    newSsa.setFromDate(ssa.getFromDate());
                    newSsa.setCompany(ssa.getCompany());
                    newSsa.setPayrollPayableAccount(ssa.getPayrollPayableAccount());
                    Double ratioBase = ssa.getBase() * pourcentageBase / 100;
                    if (signeBase.equals("plus")) {
                        newSsa.setBase(ssa.getBase() + ratioBase);
                    } else if (signeBase.equals("moins")) {
                        newSsa.setBase(ssa.getBase() - ratioBase);
                    } 
                    
                    newSsa = salaryStructureAssignmentService.createSalaryStructureAssignment(sid, newSsa);
                    newSsa = salaryStructureAssignmentService.submitSSA(sid, newSsa.getName());

                    //cancel salary slip by name
                    salarySlip = salarySlipService.cancelSalarySlip(sid, salarySlip.getName());

                    //create salary slip
                    SalarySlipDTO ss = new SalarySlipDTO();
                    ss.setEmployee(salarySlip.getEmployee());
                    ss.setPayrollFrequency("Monthly");
                    ss.setPostingDate(salarySlip.getPostingDate());
                    ss.setAmendedFrom(salarySlip.getName());

                    ss = salarySlipService.createSalarySlip(sid, ss);
                    ss = salarySlipService.submitSalarySlip(sid, ss.getName());

                    salaryUpdated++;
                }

                redirectAttributes.addFlashAttribute("success", salaryUpdated);

            } catch (CSRFTokenException ex) {
                return "redirect:/logout";
            } catch (ValidationException ve) {
                redirectAttributes.addFlashAttribute("error", ve.getMessage());
                return "redirect:/salary-slips/update";
            } catch (RuntimeException e) {
                model.addAttribute("code", "500");
                model.addAttribute("error", e.getMessage());
                return "error-500";
            }
            return "redirect:/salary-slips/update";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/salary-slips/new")
    public String showSalarySlipForm(@CookieValue(value = "sid", required = false) String sid, Model model) {
        if (sid != null) {
            try {
                List<EmployeeDTO> employees = employeeService.getEmployees(sid);
                model.addAttribute("employees", employees);
            } catch (CSRFTokenException ex) {
                return "redirect:/logout";
            } catch (RuntimeException e) {
                model.addAttribute("code", "500");
                model.addAttribute("error", e.getMessage());
                return "error-500";
            } 
            return "new-salary-slips";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/salary-slips/new")
    public String createSalarySlip(
        @CookieValue(value = "sid", required = false) String sid, 
        Model model,
        RedirectAttributes redirectAttributes,
        @RequestParam(value = "employee", required = true) String employee,
        @RequestParam(value = "base", required = false) Double base,
        @RequestParam(value = "start-month", required = true) String startMonth,
        @RequestParam(value = "end-month", required = true) String endMonth) throws Exception {

        if (sid != null) {
            try {
                List<String> postigDates = Tools.StartMonthsBetweenTwoMonth(startMonth, endMonth);
                List<String> errors = new ArrayList<>();
                List<String> success = new ArrayList<>();
                int createdDocuments = 0;
                int createdSSA = 0;
                int createdSS = 0;
                for (String postingDate : postigDates) {

                    SalarySlipDTO ss = new SalarySlipDTO();
                    ss.setEmployee(employee);
                    ss.setPayrollFrequency("Monthly");
                    ss.setPostingDate(LocalDate.parse(postingDate));

                    if (base != null) {
                        SalaryStructureAssignmentDTO ssa = new SalaryStructureAssignmentDTO();
                        ssa.setEmployee(employee);
                        ssa.setBase(base);
                        ssa.setFromDate(LocalDate.parse(postingDate));
                        ssa.setSalaryStructure(salaryStructureService.getSalaryStructureName(sid));

                        try {
                            ssa = salaryStructureAssignmentService.createSalaryStructureAssignment(sid, ssa);
                            try {
                                ssa = salaryStructureAssignmentService.submitSSA(sid, ssa.getName());
                                createdDocuments ++;
                                createdSSA ++;
                            } catch (ValidationException e) {
                                salaryStructureAssignmentService.deleteSSSA(sid, ssa.getName());
                                errors.add(ss.getPostingDate().getMonth() + " " + ss.getPostingDate().getYear() + " : " + e.getMessage());
                                continue;
                            }
                        } catch (ValidationException e) {
                            errors.add(ss.getPostingDate().getMonth() + " " + ss.getPostingDate().getYear() + " : " + e.getMessage());
                            continue;
                        }
                    }

                    ss =  salarySlipService.createSalarySlip(sid, ss);
                    try {
                        ss = salarySlipService.submitSalarySlip(sid, ss.getName());
                        createdDocuments ++;
                        createdSS ++;
                    } catch (ValidationException e) {
                        salarySlipService.deleteSalarySlip(sid, ss.getName());
                        errors.add(ss.getPostingDate().getMonth() + " " + ss.getPostingDate().getYear() + " : " + e.getMessage());
                        continue;
                    }
                    success.add(ss.getPostingDate().getMonth() + " " + ss.getPostingDate().getYear());
                }
                redirectAttributes.addFlashAttribute("success",String.join(", ", success));
                redirectAttributes.addFlashAttribute("errors", errors);
                redirectAttributes.addFlashAttribute("createdDocuments", createdDocuments);
                redirectAttributes.addFlashAttribute("createdSSA", createdSSA);
                redirectAttributes.addFlashAttribute("createdSS", createdSS);
            } catch (CSRFTokenException ex) {
                return "redirect:/logout";
            } catch (ValidationException ve) {
                redirectAttributes.addFlashAttribute("error", ve.getMessage());
                return "redirect:/salary-slips/new";
            } catch (RuntimeException e) {
                model.addAttribute("code", "500");
                model.addAttribute("error", e.getMessage());
                return "error-500";
            }
            return "redirect:/salary-slips/new";
        } else {
            return "redirect:/";
        }
    }
    
    @GetMapping("/salary-slips")
    public String showSalarySlips(
        @CookieValue(value = "sid", required = false) String sid,
        Model model,
        @RequestParam(value = "filter-month", required = false) String filterMonth
    ) {
        if (sid != null) {
            try {
                List<SalarySlipDTO> salarySlips;
                if (filterMonth != null && !filterMonth.isEmpty()) {
                    salarySlips = salarySlipService.getSalarySlipsByMonth(sid, filterMonth);
                    model.addAttribute("filterMonth", filterMonth);
                } else {
                    salarySlips = salarySlipService.getSalarySlips(sid);
                }
                double sommeRoundedTotal = 0;
                double sommeEarnings = 0;
                double sommeDeductions = 0;
                double sommeNetPay = 0;
                for (SalarySlipDTO ss : salarySlips) {
                    sommeRoundedTotal += ss.getRoundedTotal();
                    sommeEarnings += ss.getGrossPay();
                    sommeDeductions += ss.getTotalDeduction();
                    sommeNetPay += ss.getNetPay();
                }
                model.addAttribute("salarySlips", salarySlips);
                model.addAttribute("sommeRoundedTotal", sommeRoundedTotal);
                model.addAttribute("sommeNetPay", sommeNetPay);
                model.addAttribute("sommeEarnings", sommeEarnings);
                model.addAttribute("sommeDeductions", sommeDeductions);
            } catch (CSRFTokenException ex) {
                return "redirect:/logout";
            } catch (RuntimeException e) {
                model.addAttribute("code", "500");
                model.addAttribute("error", e.getMessage());
                return "error-500";
            } 
            return "salary-slips";
        } else {
            return "redirect:/";
        }
    }

    
    @GetMapping("/salary-slips/dashboard")
    public String showSalarySlipsDashboard(
        @CookieValue(value = "sid", required = false) String sid,
        Model model,
        @RequestParam(value = "filter-year", required = false) String filterYear
    ) {
        if (sid != null) {
            try {
                List<SalarySlipDTO> salarySlips = salarySlipService.getSalarySlipsByYear(sid, filterYear);
    
                if (filterYear == null || filterYear.trim().isEmpty()) {
                    filterYear = java.time.Year.now().toString();
                } 
    
                model.addAttribute("filterYear", filterYear);
    
                // Groupement des salaires par "yyyy-MM"
                Map<String, List<SalarySlipDTO>> grouped = salarySlips.stream()
                    .collect(Collectors.groupingBy(ss -> ss.getPostingDate().format(DateTimeFormatter.ofPattern("yyyy-MM"))));
    
                List<SalarySlipsMonth> salarySlipsMonths = new ArrayList<>();
    
                // Boucle sur les 12 mois de l’année sélectionnée
                for (int month = 1; month <= 12; month++) {
                    String key = String.format("%s-%02d", filterYear, month);
                    List<SalarySlipDTO> slips = grouped.getOrDefault(key, new ArrayList<>());
    
                    BigDecimal totalEarnings = slips.stream()
                        .map(ss -> BigDecimal.valueOf(ss.getGrossPay()))
                        .filter(Objects::nonNull)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
    
                    BigDecimal totalDeductions = slips.stream()
                        .map(ss -> BigDecimal.valueOf(ss.getTotalDeduction()))
                        .filter(Objects::nonNull)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
    
                    BigDecimal totalNetPay = slips.stream()
                        .map(ss -> BigDecimal.valueOf(ss.getNetPay()))
                        .filter(Objects::nonNull)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
    
                    salarySlipsMonths.add(new SalarySlipsMonth(key, totalEarnings, totalDeductions, totalNetPay, slips));
                }
    
                model.addAttribute("salarySlipsMonths", salarySlipsMonths);
    
            } catch (CSRFTokenException ex) {
                return "redirect:/logout";
            } catch (RuntimeException e) {
                model.addAttribute("code", "500");
                model.addAttribute("error", e.getMessage());
                return "error-500";
            }
            return "salary-slips-dashboard";
        } else {
            return "redirect:/";
        }
    }    
}
