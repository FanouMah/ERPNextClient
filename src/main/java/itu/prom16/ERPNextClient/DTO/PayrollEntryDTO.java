package itu.prom16.ERPNextClient.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import itu.prom16.ERPNextClient.config.FlexibleLocalDateTimeDeserializer;

/**
 *
 * @author Fanou
 */
public class PayrollEntryDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("owner")
    private String owner;

    @JsonProperty("creation")
    @JsonDeserialize(using = FlexibleLocalDateTimeDeserializer.class)
    private LocalDateTime creation;

    @JsonProperty("modified")
    @JsonDeserialize(using = FlexibleLocalDateTimeDeserializer.class)
    private LocalDateTime modified;

    @JsonProperty("modified_by")
    private String modifiedBy;

    @JsonProperty("docstatus")
    private Integer docstatus;

    @JsonProperty("idx")
    private Integer idx;

    @JsonProperty("posting_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate postingDate;

    @JsonProperty("company")
    private String company;

    @JsonProperty("payroll_payable_account")
    private String payrollPayableAccount;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("exchange_rate")
    private String exchangeRate;

    @JsonProperty("status")
    private String status;

    @JsonProperty("salary_slip_based_on_timesheet")
    private Integer salarySlipBasedOnTimesheet;

    @JsonProperty("payroll_frequency")
    private String payrollFrequency;

    @JsonProperty("start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonProperty("end_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @JsonProperty("deduct_tax_for_unclaimed_employee_benefits")
    private Integer deductTaxForUnclaimedEmployeeBenefits;

    @JsonProperty("deduct_tax_for_unsubmitted_tax_exemption_proof")
    private Integer deductTaxForUnsubmittedTaxExemptionProof;

    @JsonProperty("number_of_employees")
    private Integer numberOfEmployees;

    @JsonProperty("validate_attendance")
    private Integer validateAttendance;

    @JsonProperty("cost_center")
    private String costCenter;

    @JsonProperty("salary_slips_created")
    private Integer salarySlipsCreated;

    @JsonProperty("salary_slips_submitted")
    private Integer salarySlipsSubmitted;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("doctype")
    private String doctype;

    @JsonProperty("employees")
    private List<PayrollEmployeeDetailDTO> employees;

    public PayrollEntryDTO() {}

    public PayrollEntryDTO(String name, String owner, LocalDateTime creation, LocalDateTime modified, String modifiedBy,
            Integer docstatus, Integer idx, LocalDate postingDate, String company, String payrollPayableAccount,
            String currency, String exchangeRate, String status, Integer salarySlipBasedOnTimesheet,
            String payrollFrequency, LocalDate startDate, LocalDate endDate,
            Integer deductTaxForUnclaimedEmployeeBenefits, Integer deductTaxForUnsubmittedTaxExemptionProof,
            Integer numberOfEmployees, Integer validateAttendance, String costCenter, Integer salarySlipsCreated,
            Integer salarySlipsSubmitted, String errorMessage, String doctype, List<PayrollEmployeeDetailDTO> employees) {
        this.name = name;
        this.owner = owner;
        this.creation = creation;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
        this.docstatus = docstatus;
        this.idx = idx;
        this.postingDate = postingDate;
        this.company = company;
        this.payrollPayableAccount = payrollPayableAccount;
        this.currency = currency;
        this.exchangeRate = exchangeRate;
        this.status = status;
        this.salarySlipBasedOnTimesheet = salarySlipBasedOnTimesheet;
        this.payrollFrequency = payrollFrequency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deductTaxForUnclaimedEmployeeBenefits = deductTaxForUnclaimedEmployeeBenefits;
        this.deductTaxForUnsubmittedTaxExemptionProof = deductTaxForUnsubmittedTaxExemptionProof;
        this.numberOfEmployees = numberOfEmployees;
        this.validateAttendance = validateAttendance;
        this.costCenter = costCenter;
        this.salarySlipsCreated = salarySlipsCreated;
        this.salarySlipsSubmitted = salarySlipsSubmitted;
        this.errorMessage = errorMessage;
        this.doctype = doctype;
        this.employees = employees;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public LocalDateTime getCreation() { return creation; }
    public void setCreation(LocalDateTime creation) { this.creation = creation; }

    public LocalDateTime getModified() { return modified; }
    public void setModified(LocalDateTime modified) { this.modified = modified; }

    public String getModifiedBy() { return modifiedBy; }
    public void setModifiedBy(String modifiedBy) { this.modifiedBy = modifiedBy; }

    public Integer getDocstatus() { return docstatus; }
    public void setDocstatus(Integer docstatus) { this.docstatus = docstatus; }

    public Integer getIdx() { return idx; }
    public void setIdx(Integer idx) { this.idx = idx; }

    public LocalDate getPostingDate() { return postingDate; }
    public void setPostingDate(LocalDate postingDate) { this.postingDate = postingDate; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getPayrollPayableAccount() { return payrollPayableAccount; }
    public void setPayrollPayableAccount(String payrollPayableAccount) { this.payrollPayableAccount = payrollPayableAccount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getExchangeRate() { return exchangeRate; }
    public void setExchangeRate(String exchangeRate) { this.exchangeRate = exchangeRate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getSalarySlipBasedOnTimesheet() { return salarySlipBasedOnTimesheet; }
    public void setSalarySlipBasedOnTimesheet(Integer salarySlipBasedOnTimesheet) { this.salarySlipBasedOnTimesheet = salarySlipBasedOnTimesheet; }

    public String getPayrollFrequency() { return payrollFrequency; }
    public void setPayrollFrequency(String payrollFrequency) { this.payrollFrequency = payrollFrequency; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public Integer getDeductTaxForUnclaimedEmployeeBenefits() { return deductTaxForUnclaimedEmployeeBenefits; }
    public void setDeductTaxForUnclaimedEmployeeBenefits(Integer deductTaxForUnclaimedEmployeeBenefits) { this.deductTaxForUnclaimedEmployeeBenefits = deductTaxForUnclaimedEmployeeBenefits; }

    public Integer getDeductTaxForUnsubmittedTaxExemptionProof() { return deductTaxForUnsubmittedTaxExemptionProof; }
    public void setDeductTaxForUnsubmittedTaxExemptionProof(Integer deductTaxForUnsubmittedTaxExemptionProof) { this.deductTaxForUnsubmittedTaxExemptionProof = deductTaxForUnsubmittedTaxExemptionProof; }

    public Integer getNumberOfEmployees() { return numberOfEmployees; }
    public void setNumberOfEmployees(Integer numberOfEmployees) { this.numberOfEmployees = numberOfEmployees; }

    public Integer getValidateAttendance() { return validateAttendance; }
    public void setValidateAttendance(Integer validateAttendance) { this.validateAttendance = validateAttendance; }

    public String getCostCenter() { return costCenter; }
    public void setCostCenter(String costCenter) { this.costCenter = costCenter; }

    public Integer getSalarySlipsCreated() { return salarySlipsCreated; }
    public void setSalarySlipsCreated(Integer salarySlipsCreated) { this.salarySlipsCreated = salarySlipsCreated; }

    public Integer getSalarySlipsSubmitted() { return salarySlipsSubmitted; }
    public void setSalarySlipsSubmitted(Integer salarySlipsSubmitted) { this.salarySlipsSubmitted = salarySlipsSubmitted; }

    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    public String getDoctype() { return doctype; }
    public void setDoctype(String doctype) { this.doctype = doctype; }

    public List<PayrollEmployeeDetailDTO> getEmployees() { return employees; }
    public void setEmployees(List<PayrollEmployeeDetailDTO> employees) { this.employees = employees; }

    
}
