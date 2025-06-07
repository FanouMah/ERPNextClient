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
public class SalarySlipDTO {
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
    private int docstatus;

    @JsonProperty("idx")
    private int idx;

    @JsonProperty("company")
    private String company;
    
    @JsonProperty("employee")
    private String employee;

    @JsonProperty("employee_name")
    private String employeeName;

    @JsonProperty("department")
    private String department;

    @JsonProperty("designation")
    private String designation;

    @JsonProperty("branch")
    private String branch;

    @JsonProperty("posting_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate postingDate;

    @JsonProperty("letter_head")
    private String letterHead;

    @JsonProperty("status")
    private String status;

    @JsonProperty("salary_withholding")
    private String salaryWithholding;

    @JsonProperty("salary_withholding_cycle")
    private String salaryWithholdingCycle;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("exchange_rate")
    private double exchangeRate;

    @JsonProperty("payroll_frequency")
    private String payrollFrequency;

    @JsonProperty("start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonProperty("end_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @JsonProperty("salary_structure")
    private String salaryStructure;

    @JsonProperty("payroll_entry")
    private String payrollEntry;

    @JsonProperty("mode_of_payment")
    private String modeOfPayment;

    @JsonProperty("salary_slip_based_on_timesheet")
    private int salarySlipBasedOnTimesheet;

    @JsonProperty("deduct_tax_for_unclaimed_employee_benefits")
    private int deductTaxForUnclaimedEmployeeBenefits;

    @JsonProperty("deduct_tax_for_unsubmitted_tax_exemption_proof")
    private int deductTaxForUnsubmittedTaxExemptionProof;

    @JsonProperty("total_working_days")
    private int totalWorkingDays;

    @JsonProperty("unmarked_days")
    private int unmarkedDays;

    @JsonProperty("leave_without_pay")
    private int leaveWithoutPay;

    @JsonProperty("absent_days")
    private int absentDays;

    @JsonProperty("payment_days")
    private int paymentDays;

    @JsonProperty("total_working_hours")
    private double totalWorkingHours;

    @JsonProperty("hour_rate")
    private double hourRate;

    @JsonProperty("base_hour_rate")
    private double baseHourRate;

    @JsonProperty("gross_pay")
    private double grossPay;

    @JsonProperty("base_gross_pay")
    private double baseGrossPay;

    @JsonProperty("gross_year_to_date")
    private double grossYearToDate;

    @JsonProperty("base_gross_year_to_date")
    private double baseGrossYearToDate;

    @JsonProperty("total_deduction")
    private double totalDeduction;

    @JsonProperty("base_total_deduction")
    private double baseTotalDeduction;

    @JsonProperty("net_pay")
    private double netPay;

    @JsonProperty("base_net_pay")
    private double baseNetPay;

    @JsonProperty("rounded_total")
    private double roundedTotal;

    @JsonProperty("base_rounded_total")
    private double baseRoundedTotal;

    @JsonProperty("year_to_date")
    private double yearToDate;

    @JsonProperty("base_year_to_date")
    private double baseYearToDate;

    @JsonProperty("month_to_date")
    private double monthToDate;

    @JsonProperty("base_month_to_date")
    private double baseMonthToDate;

    @JsonProperty("total_in_words")
    private String totalInWords;

    @JsonProperty("base_total_in_words")
    private String baseTotalInWords;

    @JsonProperty("ctc")
    private double ctc;

    @JsonProperty("income_from_other_sources")
    private double incomeFromOtherSources;

    @JsonProperty("total_earnings")
    private double totalEarnings;

    @JsonProperty("non_taxable_earnings")
    private double nonTaxableEarnings;

    @JsonProperty("standard_tax_exemption_amount")
    private double standardTaxExemptionAmount;

    @JsonProperty("tax_exemption_declaration")
    private double taxExemptionDeclaration;

    @JsonProperty("deductions_before_tax_calculation")
    private double deductionsBeforeTaxCalculation;

    @JsonProperty("annual_taxable_amount")
    private double annualTaxableAmount;

    @JsonProperty("income_tax_deducted_till_date")
    private double incomeTaxDeductedTillDate;

    @JsonProperty("current_month_income_tax")
    private double currentMonthIncomeTax;

    @JsonProperty("future_income_tax_deductions")
    private double futureIncomeTaxDeductions;

    @JsonProperty("total_income_tax")
    private double totalIncomeTax;

    @JsonProperty("journal_entry")
    private String journalEntry;

    @JsonProperty("amended_from")
    private String amendedFrom;

    @JsonProperty("bank_name")
    private String bankName;

    @JsonProperty("bank_account_no")
    private String bankAccountNo;

    @JsonProperty("earnings")
    private List<Object> earnings; 

    @JsonProperty("deductions")
    private List<Object> deductions;

    public SalarySlipDTO() {
    }

    public SalarySlipDTO(String name, String owner, LocalDateTime creation, LocalDateTime modified, String modifiedBy,
            int docstatus, int idx, String company, String employee, String employeeName, String department,
            String designation, String branch, LocalDate postingDate, String letterHead, String status,
            String salaryWithholding, String salaryWithholdingCycle, String currency, double exchangeRate,
            String payrollFrequency, LocalDate startDate, LocalDate endDate, String salaryStructure,
            String payrollEntry, String modeOfPayment, int salarySlipBasedOnTimesheet,
            int deductTaxForUnclaimedEmployeeBenefits, int deductTaxForUnsubmittedTaxExemptionProof,
            int totalWorkingDays, int unmarkedDays, int leaveWithoutPay, int absentDays, int paymentDays,
            double totalWorkingHours, double hourRate, double baseHourRate, double grossPay, double baseGrossPay,
            double grossYearToDate, double baseGrossYearToDate, double totalDeduction, double baseTotalDeduction,
            double netPay, double baseNetPay, double roundedTotal, double baseRoundedTotal, double yearToDate,
            double baseYearToDate, double monthToDate, double baseMonthToDate, String totalInWords,
            String baseTotalInWords, double ctc, double incomeFromOtherSources, double totalEarnings,
            double nonTaxableEarnings, double standardTaxExemptionAmount, double taxExemptionDeclaration,
            double deductionsBeforeTaxCalculation, double annualTaxableAmount, double incomeTaxDeductedTillDate,
            double currentMonthIncomeTax, double futureIncomeTaxDeductions, double totalIncomeTax, String journalEntry,
            String amendedFrom, String bankName, String bankAccountNo, List<Object> earnings, List<Object> deductions) { 
        this.name = name;
        this.owner = owner;
        this.creation = creation;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
        this.docstatus = docstatus;
        this.idx = idx;
        this.company = company;
        this.employee = employee;
        this.employeeName = employeeName;
        this.department = department;
        this.designation = designation;
        this.branch = branch;
        this.postingDate = postingDate;
        this.letterHead = letterHead;
        this.status = status;
        this.salaryWithholding = salaryWithholding;
        this.salaryWithholdingCycle = salaryWithholdingCycle;
        this.currency = currency;
        this.exchangeRate = exchangeRate;
        this.payrollFrequency = payrollFrequency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.salaryStructure = salaryStructure;
        this.payrollEntry = payrollEntry;
        this.modeOfPayment = modeOfPayment;
        this.salarySlipBasedOnTimesheet = salarySlipBasedOnTimesheet;
        this.deductTaxForUnclaimedEmployeeBenefits = deductTaxForUnclaimedEmployeeBenefits;
        this.deductTaxForUnsubmittedTaxExemptionProof = deductTaxForUnsubmittedTaxExemptionProof;
        this.totalWorkingDays = totalWorkingDays;
        this.unmarkedDays = unmarkedDays;
        this.leaveWithoutPay = leaveWithoutPay;
        this.absentDays = absentDays;
        this.paymentDays = paymentDays;
        this.totalWorkingHours = totalWorkingHours;
        this.hourRate = hourRate;
        this.baseHourRate = baseHourRate;
        this.grossPay = grossPay;
        this.baseGrossPay = baseGrossPay;
        this.grossYearToDate = grossYearToDate;
        this.baseGrossYearToDate = baseGrossYearToDate;
        this.totalDeduction = totalDeduction;
        this.baseTotalDeduction = baseTotalDeduction;
        this.netPay = netPay;
        this.baseNetPay = baseNetPay;
        this.roundedTotal = roundedTotal;
        this.baseRoundedTotal = baseRoundedTotal;
        this.yearToDate = yearToDate;
        this.baseYearToDate = baseYearToDate;
        this.monthToDate = monthToDate;
        this.baseMonthToDate = baseMonthToDate;
        this.totalInWords = totalInWords;
        this.baseTotalInWords = baseTotalInWords;
        this.ctc = ctc;
        this.incomeFromOtherSources = incomeFromOtherSources;
        this.totalEarnings = totalEarnings;
        this.nonTaxableEarnings = nonTaxableEarnings;
        this.standardTaxExemptionAmount = standardTaxExemptionAmount;
        this.taxExemptionDeclaration = taxExemptionDeclaration;
        this.deductionsBeforeTaxCalculation = deductionsBeforeTaxCalculation;
        this.annualTaxableAmount = annualTaxableAmount;
        this.incomeTaxDeductedTillDate = incomeTaxDeductedTillDate;
        this.currentMonthIncomeTax = currentMonthIncomeTax;
        this.futureIncomeTaxDeductions = futureIncomeTaxDeductions;
        this.totalIncomeTax = totalIncomeTax;
        this.journalEntry = journalEntry;
        this.amendedFrom = amendedFrom;
        this.bankName = bankName;
        this.bankAccountNo = bankAccountNo;
        this.earnings = earnings;
        this.deductions = deductions;
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

    public int getDocstatus() { return docstatus; }
    public void setDocstatus(int docstatus) { this.docstatus = docstatus; }

    public int getIdx() { return idx; }
    public void setIdx(int idx) { this.idx = idx; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getEmployee() { return employee; }
    public void setEmployee(String employee) { this.employee = employee; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public LocalDate getPostingDate() { return postingDate; }
    public void setPostingDate(LocalDate postingDate) { this.postingDate = postingDate; }

    public String getLetterHead() { return letterHead; }
    public void setLetterHead(String letterHead) { this.letterHead = letterHead; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getSalaryWithholding() { return salaryWithholding; }
    public void setSalaryWithholding(String salaryWithholding) { this.salaryWithholding = salaryWithholding; }

    public String getSalaryWithholdingCycle() { return salaryWithholdingCycle; }
    public void setSalaryWithholdingCycle(String salaryWithholdingCycle) { this.salaryWithholdingCycle = salaryWithholdingCycle; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public double getExchangeRate() { return exchangeRate; }
    public void setExchangeRate(double exchangeRate) { this.exchangeRate = exchangeRate; }

    public String getPayrollFrequency() { return payrollFrequency; }
    public void setPayrollFrequency(String payrollFrequency) { this.payrollFrequency = payrollFrequency; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getSalaryStructure() { return salaryStructure; }
    public void setSalaryStructure(String salaryStructure) { this.salaryStructure = salaryStructure; }

    public String getPayrollEntry() { return payrollEntry; }
    public void setPayrollEntry(String payrollEntry) { this.payrollEntry = payrollEntry; }

    public String getModeOfPayment() { return modeOfPayment; }
    public void setModeOfPayment(String modeOfPayment) { this.modeOfPayment = modeOfPayment; }

    public int getSalarySlipBasedOnTimesheet() { return salarySlipBasedOnTimesheet; }
    public void setSalarySlipBasedOnTimesheet(int salarySlipBasedOnTimesheet) { this.salarySlipBasedOnTimesheet = salarySlipBasedOnTimesheet; }

    public int getDeductTaxForUnclaimedEmployeeBenefits() { return deductTaxForUnclaimedEmployeeBenefits; }
    public void setDeductTaxForUnclaimedEmployeeBenefits(int deductTaxForUnclaimedEmployeeBenefits) { this.deductTaxForUnclaimedEmployeeBenefits = deductTaxForUnclaimedEmployeeBenefits; }

    public int getDeductTaxForUnsubmittedTaxExemptionProof() { return deductTaxForUnsubmittedTaxExemptionProof; }
    public void setDeductTaxForUnsubmittedTaxExemptionProof(int deductTaxForUnsubmittedTaxExemptionProof) { this.deductTaxForUnsubmittedTaxExemptionProof = deductTaxForUnsubmittedTaxExemptionProof; }

    public int getTotalWorkingDays() { return totalWorkingDays; }
    public void setTotalWorkingDays(int totalWorkingDays) { this.totalWorkingDays = totalWorkingDays; }

    public int getUnmarkedDays() { return unmarkedDays; }
    public void setUnmarkedDays(int unmarkedDays) { this.unmarkedDays = unmarkedDays; }

    public int getLeaveWithoutPay() { return leaveWithoutPay; }
    public void setLeaveWithoutPay(int leaveWithoutPay) { this.leaveWithoutPay = leaveWithoutPay; }

    public int getAbsentDays() { return absentDays; }
    public void setAbsentDays(int absentDays) { this.absentDays = absentDays; }

    public int getPaymentDays() { return paymentDays; }
    public void setPaymentDays(int paymentDays) { this.paymentDays = paymentDays; }

    public double getTotalWorkingHours() { return totalWorkingHours; }
    public void setTotalWorkingHours(double totalWorkingHours) { this.totalWorkingHours = totalWorkingHours; }

    public double getHourRate() { return hourRate; }
    public void setHourRate(double hourRate) { this.hourRate = hourRate; }

    public double getBaseHourRate() { return baseHourRate; }
    public void setBaseHourRate(double baseHourRate) { this.baseHourRate = baseHourRate; }

    public double getGrossPay() { return grossPay; }
    public void setGrossPay(double grossPay) { this.grossPay = grossPay; }

    public double getBaseGrossPay() { return baseGrossPay; }
    public void setBaseGrossPay(double baseGrossPay) { this.baseGrossPay = baseGrossPay; }

    public double getGrossYearToDate() { return grossYearToDate; }
    public void setGrossYearToDate(double grossYearToDate) { this.grossYearToDate = grossYearToDate; }

    public double getBaseGrossYearToDate() { return baseGrossYearToDate; }
    public void setBaseGrossYearToDate(double baseGrossYearToDate) { this.baseGrossYearToDate = baseGrossYearToDate; }

    public double getTotalDeduction() { return totalDeduction; }
    public void setTotalDeduction(double totalDeduction) { this.totalDeduction = totalDeduction; }

    public double getBaseTotalDeduction() { return baseTotalDeduction; }
    public void setBaseTotalDeduction(double baseTotalDeduction) { this.baseTotalDeduction = baseTotalDeduction; }

    public double getNetPay() { return netPay; }
    public void setNetPay(double netPay) { this.netPay = netPay; }

    public double getBaseNetPay() { return baseNetPay; }
    public void setBaseNetPay(double baseNetPay) { this.baseNetPay = baseNetPay; }

    public double getRoundedTotal() { return roundedTotal; }
    public void setRoundedTotal(double roundedTotal) { this.roundedTotal = roundedTotal; }

    public double getBaseRoundedTotal() { return baseRoundedTotal; }
    public void setBaseRoundedTotal(double baseRoundedTotal) { this.baseRoundedTotal = baseRoundedTotal; }

    public double getYearToDate() { return yearToDate; }
    public void setYearToDate(double yearToDate) { this.yearToDate = yearToDate; }

    public double getBaseYearToDate() { return baseYearToDate; }
    public void setBaseYearToDate(double baseYearToDate) { this.baseYearToDate = baseYearToDate; }

    public double getMonthToDate() { return monthToDate; }
    public void setMonthToDate(double monthToDate) { this.monthToDate = monthToDate; }

    public double getBaseMonthToDate() { return baseMonthToDate; }
    public void setBaseMonthToDate(double baseMonthToDate) { this.baseMonthToDate = baseMonthToDate; }

    public String getTotalInWords() { return totalInWords; }
    public void setTotalInWords(String totalInWords) { this.totalInWords = totalInWords; }

    public String getBaseTotalInWords() { return baseTotalInWords; }
    public void setBaseTotalInWords(String baseTotalInWords) { this.baseTotalInWords = baseTotalInWords; }

    public double getCtc() { return ctc; }
    public void setCtc(double ctc) { this.ctc = ctc; }

    public double getIncomeFromOtherSources() { return incomeFromOtherSources; }
    public void setIncomeFromOtherSources(double incomeFromOtherSources) { this.incomeFromOtherSources = incomeFromOtherSources; }

    public double getTotalEarnings() { return totalEarnings; }
    public void setTotalEarnings(double totalEarnings) { this.totalEarnings = totalEarnings; }

    public double getNonTaxableEarnings() { return nonTaxableEarnings; }
    public void setNonTaxableEarnings(double nonTaxableEarnings) { this.nonTaxableEarnings = nonTaxableEarnings; }

    public double getStandardTaxExemptionAmount() { return standardTaxExemptionAmount; }
    public void setStandardTaxExemptionAmount(double standardTaxExemptionAmount) { this.standardTaxExemptionAmount = standardTaxExemptionAmount; }

    public double getTaxExemptionDeclaration() { return taxExemptionDeclaration; }
    public void setTaxExemptionDeclaration(double taxExemptionDeclaration) { this.taxExemptionDeclaration = taxExemptionDeclaration; }

    public double getDeductionsBeforeTaxCalculation() { return deductionsBeforeTaxCalculation; }
    public void setDeductionsBeforeTaxCalculation(double deductionsBeforeTaxCalculation) { this.deductionsBeforeTaxCalculation = deductionsBeforeTaxCalculation; }

    public double getAnnualTaxableAmount() { return annualTaxableAmount; }
    public void setAnnualTaxableAmount(double annualTaxableAmount) { this.annualTaxableAmount = annualTaxableAmount; }

    public double getIncomeTaxDeductedTillDate() { return incomeTaxDeductedTillDate; }
    public void setIncomeTaxDeductedTillDate(double incomeTaxDeductedTillDate) { this.incomeTaxDeductedTillDate = incomeTaxDeductedTillDate; }

    public double getCurrentMonthIncomeTax() { return currentMonthIncomeTax; }
    public void setCurrentMonthIncomeTax(double currentMonthIncomeTax) { this.currentMonthIncomeTax = currentMonthIncomeTax; }

    public double getFutureIncomeTaxDeductions() { return futureIncomeTaxDeductions; }
    public void setFutureIncomeTaxDeductions(double futureIncomeTaxDeductions) { this.futureIncomeTaxDeductions = futureIncomeTaxDeductions; }

    public double getTotalIncomeTax() { return totalIncomeTax; }
    public void setTotalIncomeTax(double totalIncomeTax) { this.totalIncomeTax = totalIncomeTax; }

    public String getJournalEntry() { return journalEntry; }
    public void setJournalEntry(String journalEntry) { this.journalEntry = journalEntry; }

    public String getAmendedFrom() { return amendedFrom; }
    public void setAmendedFrom(String amendedFrom) { this.amendedFrom = amendedFrom; }

    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }

    public String getBankAccountNo() { return bankAccountNo; }
    public void setBankAccountNo(String bankAccountNo) { this.bankAccountNo = bankAccountNo; }

    public List<Object> getEarnings() { return earnings; }
    public void setEarnings(List<Object> earnings) { this.earnings = earnings; }

    public List<Object> getDeductions() { return deductions; }
    public void setDeductions(List<Object> deductions) { this.deductions = deductions; }
}
