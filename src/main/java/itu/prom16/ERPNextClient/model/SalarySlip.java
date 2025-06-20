package itu.prom16.ERPNextClient.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

/**
 *
 * @author Fanou
 */
@Entity
@Table(name = "tabSalary Slip")
public class SalarySlip {
    @Id
    @Column(name = "name", length = 140, nullable = false)
    private String name;

    @Column(name = "creation")
    private LocalDateTime creation;

    @Column(name = "modified")
    private LocalDateTime modified;

    @Column(name = "modified_by", length = 140)
    private String modifiedBy;

    @Column(name = "owner", length = 140)
    private String owner;

    @Column(name = "docstatus", nullable = false)
    private Integer docstatus;

    @Column(name = "idx", nullable = false)
    private Integer idx;

    @Column(name = "employee", length = 140)
    private String employee;

    @Column(name = "employee_name", length = 140)
    private String employeeName;

    @Column(name = "company", length = 140)
    private String company;

    @Column(name = "department", length = 140)
    private String department;

    @Column(name = "designation", length = 140)
    private String designation;

    @Column(name = "branch", length = 140)
    private String branch;

    @Column(name = "posting_date")
    private LocalDate postingDate;

    @Column(name = "letter_head", length = 140)
    private String letterHead;

    @Column(name = "status", length = 140)
    private String status;

    @Column(name = "salary_withholding", length = 140)
    private String salaryWithholding;

    @Column(name = "salary_withholding_cycle", length = 140)
    private String salaryWithholdingCycle;

    @Column(name = "currency", length = 140)
    private String currency;

    @Column(name = "exchange_rate", precision = 21, scale = 9, nullable = false)
    private BigDecimal exchangeRate;

    @Column(name = "payroll_frequency", length = 140)
    private String payrollFrequency;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "salary_structure", length = 140)
    private String salaryStructure;

    @Column(name = "payroll_entry", length = 140)
    private String payrollEntry;

    @Column(name = "mode_of_payment", length = 140)
    private String modeOfPayment;

    @Column(name = "salary_slip_based_on_timesheet", nullable = false)
    private Boolean salarySlipBasedOnTimesheet;

    @Column(name = "deduct_tax_for_unclaimed_employee_benefits", nullable = false)
    private Boolean deductTaxForUnclaimedEmployeeBenefits;

    @Column(name = "deduct_tax_for_unsubmitted_tax_exemption_proof", nullable = false)
    private Boolean deductTaxForUnsubmittedTaxExemptionProof;

    @Column(name = "total_working_days", precision = 21, scale = 9, nullable = false)
    private BigDecimal totalWorkingDays;

    @Column(name = "unmarked_days", precision = 21, scale = 9, nullable = false)
    private BigDecimal unmarkedDays;

    @Column(name = "leave_without_pay", precision = 21, scale = 9, nullable = false)
    private BigDecimal leaveWithoutPay;

    @Column(name = "absent_days", precision = 21, scale = 9, nullable = false)
    private BigDecimal absentDays;

    @Column(name = "payment_days", precision = 21, scale = 9, nullable = false)
    private BigDecimal paymentDays;

    @Column(name = "total_working_hours", precision = 21, scale = 9, nullable = false)
    private BigDecimal totalWorkingHours;

    @Column(name = "hour_rate", precision = 21, scale = 9, nullable = false)
    private BigDecimal hourRate;

    @Column(name = "base_hour_rate", precision = 21, scale = 9, nullable = false)
    private BigDecimal baseHourRate;

    @Column(name = "gross_pay", precision = 21, scale = 9, nullable = false)
    private BigDecimal grossPay;

    @Column(name = "base_gross_pay", precision = 21, scale = 9, nullable = false)
    private BigDecimal baseGrossPay;

    @Column(name = "gross_year_to_date", precision = 21, scale = 9, nullable = false)
    private BigDecimal grossYearToDate;

    @Column(name = "base_gross_year_to_date", precision = 21, scale = 9, nullable = false)
    private BigDecimal baseGrossYearToDate;

    @Column(name = "total_deduction", precision = 21, scale = 9, nullable = false)
    private BigDecimal totalDeduction;

    @Column(name = "base_total_deduction", precision = 21, scale = 9, nullable = false)
    private BigDecimal baseTotalDeduction;

    @Column(name = "net_pay", precision = 21, scale = 9, nullable = false)
    private BigDecimal netPay;

    @Column(name = "base_net_pay", precision = 21, scale = 9, nullable = false)
    private BigDecimal baseNetPay;

    @Column(name = "rounded_total", precision = 21, scale = 9, nullable = false)
    private BigDecimal roundedTotal;

    @Column(name = "base_rounded_total", precision = 21, scale = 9, nullable = false)
    private BigDecimal baseRoundedTotal;

    @Column(name = "year_to_date", precision = 21, scale = 9, nullable = false)
    private BigDecimal yearToDate;

    @Column(name = "base_year_to_date", precision = 21, scale = 9, nullable = false)
    private BigDecimal baseYearToDate;

    @Column(name = "month_to_date", precision = 21, scale = 9, nullable = false)
    private BigDecimal monthToDate;

    @Column(name = "base_month_to_date", precision = 21, scale = 9, nullable = false)
    private BigDecimal baseMonthToDate;

    @Column(name = "total_in_words", length = 240)
    private String totalInWords;

    @Column(name = "base_total_in_words", length = 240)
    private String baseTotalInWords;

    @Column(name = "ctc", precision = 21, scale = 9, nullable = false)
    private BigDecimal ctc;

    @Column(name = "income_from_other_sources", precision = 21, scale = 9, nullable = false)
    private BigDecimal incomeFromOtherSources;

    @Column(name = "total_earnings", precision = 21, scale = 9, nullable = false)
    private BigDecimal totalEarnings;

    @Column(name = "non_taxable_earnings", precision = 21, scale = 9, nullable = false)
    private BigDecimal nonTaxableEarnings;

    @Column(name = "standard_tax_exemption_amount", precision = 21, scale = 9, nullable = false)
    private BigDecimal standardTaxExemptionAmount;

    @Column(name = "tax_exemption_declaration", precision = 21, scale = 9, nullable = false)
    private BigDecimal taxExemptionDeclaration;

    @Column(name = "deductions_before_tax_calculation", precision = 21, scale = 9, nullable = false)
    private BigDecimal deductionsBeforeTaxCalculation;

    @Column(name = "annual_taxable_amount", precision = 21, scale = 9, nullable = false)
    private BigDecimal annualTaxableAmount;

    @Column(name = "income_tax_deducted_till_date", precision = 21, scale = 9, nullable = false)
    private BigDecimal incomeTaxDeductedTillDate;

    @Column(name = "current_month_income_tax", precision = 21, scale = 9, nullable = false)
    private BigDecimal currentMonthIncomeTax;

    @Column(name = "future_income_tax_deductions", precision = 21, scale = 9, nullable = false)
    private BigDecimal futureIncomeTaxDeductions;

    @Column(name = "total_income_tax", precision = 21, scale = 9, nullable = false)
    private BigDecimal totalIncomeTax;

    @Column(name = "journal_entry", length = 140)
    private String journalEntry;

    @Column(name = "amended_from", length = 140)
    private String amendedFrom;

    @Column(name = "bank_name", length = 140)
    private String bankName;

    @Column(name = "bank_account_no", length = 140)
    private String bankAccountNo;

    @Column(name = "_user_tags", columnDefinition = "text")
    private String userTags;

    @Column(name = "_comments", columnDefinition = "text")
    private String comments;

    @Column(name = "_assign", columnDefinition = "text")
    private String assign;

    @Column(name = "_liked_by", columnDefinition = "text")
    private String likedBy;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDateTime getCreation() { return creation; }
    public void setCreation(LocalDateTime creation) { this.creation = creation; }

    public LocalDateTime getModified() { return modified; }
    public void setModified(LocalDateTime modified) { this.modified = modified; }

    public String getModifiedBy() { return modifiedBy; }
    public void setModifiedBy(String modifiedBy) { this.modifiedBy = modifiedBy; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public Integer getDocstatus() { return docstatus; }
    public void setDocstatus(Integer docstatus) { this.docstatus = docstatus; }

    public Integer getIdx() { return idx; }
    public void setIdx(Integer idx) { this.idx = idx; }

    public String getEmployee() { return employee; }
    public void setEmployee(String employee) { this.employee = employee; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

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

    public BigDecimal getExchangeRate() { return exchangeRate; }
    public void setExchangeRate(BigDecimal exchangeRate) { this.exchangeRate = exchangeRate; }

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

    public Boolean getSalarySlipBasedOnTimesheet() { return salarySlipBasedOnTimesheet; }
    public void setSalarySlipBasedOnTimesheet(Boolean salarySlipBasedOnTimesheet) { this.salarySlipBasedOnTimesheet = salarySlipBasedOnTimesheet; }

    public Boolean getDeductTaxForUnclaimedEmployeeBenefits() { return deductTaxForUnclaimedEmployeeBenefits; }
    public void setDeductTaxForUnclaimedEmployeeBenefits(Boolean deductTaxForUnclaimedEmployeeBenefits) { this.deductTaxForUnclaimedEmployeeBenefits = deductTaxForUnclaimedEmployeeBenefits; }

    public Boolean getDeductTaxForUnsubmittedTaxExemptionProof() { return deductTaxForUnsubmittedTaxExemptionProof; }
    public void setDeductTaxForUnsubmittedTaxExemptionProof(Boolean deductTaxForUnsubmittedTaxExemptionProof) { this.deductTaxForUnsubmittedTaxExemptionProof = deductTaxForUnsubmittedTaxExemptionProof; }

    public BigDecimal getTotalWorkingDays() { return totalWorkingDays; }
    public void setTotalWorkingDays(BigDecimal totalWorkingDays) { this.totalWorkingDays = totalWorkingDays; }

    public BigDecimal getUnmarkedDays() { return unmarkedDays; }
    public void setUnmarkedDays(BigDecimal unmarkedDays) { this.unmarkedDays = unmarkedDays; }

    public BigDecimal getLeaveWithoutPay() { return leaveWithoutPay; }
    public void setLeaveWithoutPay(BigDecimal leaveWithoutPay) { this.leaveWithoutPay = leaveWithoutPay; }

    public BigDecimal getAbsentDays() { return absentDays; }
    public void setAbsentDays(BigDecimal absentDays) { this.absentDays = absentDays; }

    public BigDecimal getPaymentDays() { return paymentDays; }
    public void setPaymentDays(BigDecimal paymentDays) { this.paymentDays = paymentDays; }

    public BigDecimal getTotalWorkingHours() { return totalWorkingHours; }
    public void setTotalWorkingHours(BigDecimal totalWorkingHours) { this.totalWorkingHours = totalWorkingHours; }

    public BigDecimal getHourRate() { return hourRate; }
    public void setHourRate(BigDecimal hourRate) { this.hourRate = hourRate; }

    public BigDecimal getBaseHourRate() { return baseHourRate; }
    public void setBaseHourRate(BigDecimal baseHourRate) { this.baseHourRate = baseHourRate; }

    public BigDecimal getGrossPay() { return grossPay; }
    public void setGrossPay(BigDecimal grossPay) { this.grossPay = grossPay; }

    public BigDecimal getBaseGrossPay() { return baseGrossPay; }
    public void setBaseGrossPay(BigDecimal baseGrossPay) { this.baseGrossPay = baseGrossPay; }

    public BigDecimal getGrossYearToDate() { return grossYearToDate; }
    public void setGrossYearToDate(BigDecimal grossYearToDate) { this.grossYearToDate = grossYearToDate; }

    public BigDecimal getBaseGrossYearToDate() { return baseGrossYearToDate; }
    public void setBaseGrossYearToDate(BigDecimal baseGrossYearToDate) { this.baseGrossYearToDate = baseGrossYearToDate; }

    public BigDecimal getTotalDeduction() { return totalDeduction; }
    public void setTotalDeduction(BigDecimal totalDeduction) { this.totalDeduction = totalDeduction; }

    public BigDecimal getBaseTotalDeduction() { return baseTotalDeduction; }
    public void setBaseTotalDeduction(BigDecimal baseTotalDeduction) { this.baseTotalDeduction = baseTotalDeduction; }

    public BigDecimal getNetPay() { return netPay; }
    public void setNetPay(BigDecimal netPay) { this.netPay = netPay; }

    public BigDecimal getBaseNetPay() { return baseNetPay; }
    public void setBaseNetPay(BigDecimal baseNetPay) { this.baseNetPay = baseNetPay; }

    public BigDecimal getRoundedTotal() { return roundedTotal; }
    public void setRoundedTotal(BigDecimal roundedTotal) { this.roundedTotal = roundedTotal; }

    public BigDecimal getBaseRoundedTotal() { return baseRoundedTotal; }
    public void setBaseRoundedTotal(BigDecimal baseRoundedTotal) { this.baseRoundedTotal = baseRoundedTotal; }

    public BigDecimal getYearToDate() { return yearToDate; }
    public void setYearToDate(BigDecimal yearToDate) { this.yearToDate = yearToDate; }

    public BigDecimal getBaseYearToDate() { return baseYearToDate; }
    public void setBaseYearToDate(BigDecimal baseYearToDate) { this.baseYearToDate = baseYearToDate; }

    public BigDecimal getMonthToDate() { return monthToDate; }
    public void setMonthToDate(BigDecimal monthToDate) { this.monthToDate = monthToDate; }

    public BigDecimal getBaseMonthToDate() { return baseMonthToDate; }
    public void setBaseMonthToDate(BigDecimal baseMonthToDate) { this.baseMonthToDate = baseMonthToDate; }

    public String getTotalInWords() { return totalInWords; }
    public void setTotalInWords(String totalInWords) { this.totalInWords = totalInWords; }

    public String getBaseTotalInWords() { return baseTotalInWords; }
    public void setBaseTotalInWords(String baseTotalInWords) { this.baseTotalInWords = baseTotalInWords; }

    public BigDecimal getCtc() { return ctc; }
    public void setCtc(BigDecimal ctc) { this.ctc = ctc; }

    public BigDecimal getIncomeFromOtherSources() { return incomeFromOtherSources; }
    public void setIncomeFromOtherSources(BigDecimal incomeFromOtherSources) { this.incomeFromOtherSources = incomeFromOtherSources; }

    public BigDecimal getTotalEarnings() { return totalEarnings; }
    public void setTotalEarnings(BigDecimal totalEarnings) { this.totalEarnings = totalEarnings; }

    public BigDecimal getNonTaxableEarnings() { return nonTaxableEarnings; }
    public void setNonTaxableEarnings(BigDecimal nonTaxableEarnings) { this.nonTaxableEarnings = nonTaxableEarnings; }

    public BigDecimal getStandardTaxExemptionAmount() { return standardTaxExemptionAmount; }
    public void setStandardTaxExemptionAmount(BigDecimal standardTaxExemptionAmount) { this.standardTaxExemptionAmount = standardTaxExemptionAmount; }

    public BigDecimal getTaxExemptionDeclaration() { return taxExemptionDeclaration; }
    public void setTaxExemptionDeclaration(BigDecimal taxExemptionDeclaration) { this.taxExemptionDeclaration = taxExemptionDeclaration; }

    public BigDecimal getDeductionsBeforeTaxCalculation() { return deductionsBeforeTaxCalculation; }
    public void setDeductionsBeforeTaxCalculation(BigDecimal deductionsBeforeTaxCalculation) { this.deductionsBeforeTaxCalculation = deductionsBeforeTaxCalculation; }

    public BigDecimal getAnnualTaxableAmount() { return annualTaxableAmount; }
    public void setAnnualTaxableAmount(BigDecimal annualTaxableAmount) { this.annualTaxableAmount = annualTaxableAmount; }

    public BigDecimal getIncomeTaxDeductedTillDate() { return incomeTaxDeductedTillDate; }
    public void setIncomeTaxDeductedTillDate(BigDecimal incomeTaxDeductedTillDate) { this.incomeTaxDeductedTillDate = incomeTaxDeductedTillDate; }

    public BigDecimal getCurrentMonthIncomeTax() { return currentMonthIncomeTax; }
    public void setCurrentMonthIncomeTax(BigDecimal currentMonthIncomeTax) { this.currentMonthIncomeTax = currentMonthIncomeTax; }

    public BigDecimal getFutureIncomeTaxDeductions() { return futureIncomeTaxDeductions; }
    public void setFutureIncomeTaxDeductions(BigDecimal futureIncomeTaxDeductions) { this.futureIncomeTaxDeductions = futureIncomeTaxDeductions; }

    public BigDecimal getTotalIncomeTax() { return totalIncomeTax; }
    public void setTotalIncomeTax(BigDecimal totalIncomeTax) { this.totalIncomeTax = totalIncomeTax; }

    public String getJournalEntry() { return journalEntry; }
    public void setJournalEntry(String journalEntry) { this.journalEntry = journalEntry; }

    public String getAmendedFrom() { return amendedFrom; }
    public void setAmendedFrom(String amendedFrom) { this.amendedFrom = amendedFrom; }

    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }

    public String getBankAccountNo() { return bankAccountNo; }
    public void setBankAccountNo(String bankAccountNo) { this.bankAccountNo = bankAccountNo; }

    public String getUserTags() { return userTags; }
    public void setUserTags(String userTags) { this.userTags = userTags; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    public String getAssign() { return assign; }
    public void setAssign(String assign) { this.assign = assign; }

    public String getLikedBy() { return likedBy; }
    public void setLikedBy(String likedBy) { this.likedBy = likedBy; }

    
}
