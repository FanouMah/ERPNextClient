package itu.prom16.ERPNextClient.DTO;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import itu.prom16.ERPNextClient.config.FlexibleLocalDateTimeDeserializer;

/**
 *
 * @author Fanou
 */
public class SalaryStructureDTO {
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

    @JsonProperty("is_active")
    private String isActive;

    @JsonProperty("is_default")
    private String isDefault;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("leave_encashment_amount_per_day")
    private double leaveEncashmentAmountPerDay;

    @JsonProperty("max_benefits")
    private double maxBenefits;

    @JsonProperty("salary_slip_based_on_timesheet")
    private double salarySlipBasedOnTimesheet;

    @JsonProperty("payroll_frequency")
    private String payrollFrequency;

    @JsonProperty("hour_rate")
    private double hourRate;

    @JsonProperty("total_earning")
    private double totalEarning;

    @JsonProperty("total_deduction")
    private double totalDeduction;

    @JsonProperty("net_pay")
    private double netPay;

    @JsonProperty("doctype")
    private String doctype;

    @JsonProperty("earnings")
    private List<SalaryDetailDTO> earnings; 

    @JsonProperty("deductions")
    private List<SalaryDetailDTO> deductions;

    public SalaryStructureDTO() {}

    public SalaryStructureDTO(String name, String owner, LocalDateTime creation, LocalDateTime modified,
            String modifiedBy, int docstatus, int idx, String company, String isActive, String isDefault,
            String currency, double leaveEncashmentAmountPerDay, double maxBenefits, double salarySlipBasedOnTimesheet,
            String payrollFrequency, double hourRate, double totalEarning, double totalDeduction, double netPay,
            String doctype, List<SalaryDetailDTO> earnings, List<SalaryDetailDTO> deductions) {
        this.name = name;
        this.owner = owner;
        this.creation = creation;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
        this.docstatus = docstatus;
        this.idx = idx;
        this.company = company;
        this.isActive = isActive;
        this.isDefault = isDefault;
        this.currency = currency;
        this.leaveEncashmentAmountPerDay = leaveEncashmentAmountPerDay;
        this.maxBenefits = maxBenefits;
        this.salarySlipBasedOnTimesheet = salarySlipBasedOnTimesheet;
        this.payrollFrequency = payrollFrequency;
        this.hourRate = hourRate;
        this.totalEarning = totalEarning;
        this.totalDeduction = totalDeduction;
        this.netPay = netPay;
        this.doctype = doctype;
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

    public String getIsActive() { return isActive; }
    public void setIsActive(String isActive) { this.isActive = isActive; }

    public String getIsDefault() { return isDefault; }
    public void setIsDefault(String isDefault) { this.isDefault = isDefault; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public double getLeaveEncashmentAmountPerDay() { return leaveEncashmentAmountPerDay; }
    public void setLeaveEncashmentAmountPerDay(double leaveEncashmentAmountPerDay) { this.leaveEncashmentAmountPerDay = leaveEncashmentAmountPerDay; }

    public double getMaxBenefits() { return maxBenefits; }
    public void setMaxBenefits(double maxBenefits) { this.maxBenefits = maxBenefits; }

    public double getSalarySlipBasedOnTimesheet() { return salarySlipBasedOnTimesheet; }
    public void setSalarySlipBasedOnTimesheet(double salarySlipBasedOnTimesheet) { this.salarySlipBasedOnTimesheet = salarySlipBasedOnTimesheet; }

    public String getPayrollFrequency() { return payrollFrequency; }
    public void setPayrollFrequency(String payrollFrequency) { this.payrollFrequency = payrollFrequency; }

    public double getHourRate() { return hourRate; }
    public void setHourRate(double hourRate) { this.hourRate = hourRate; }

    public double getTotalEarning() { return totalEarning; }
    public void setTotalEarning(double totalEarning) { this.totalEarning = totalEarning; }

    public double getTotalDeduction() { return totalDeduction; }
    public void setTotalDeduction(double totalDeduction) { this.totalDeduction = totalDeduction; }

    public double getNetPay() { return netPay; }
    public void setNetPay(double netPay) { this.netPay = netPay; }

    public String getDoctype() { return doctype; }
    public void setDoctype(String doctype) { this.doctype = doctype; }

    public List<SalaryDetailDTO> getEarnings() { return earnings; }
    public void setEarnings(List<SalaryDetailDTO> earnings) { this.earnings = earnings; }

    public List<SalaryDetailDTO> getDeductions() { return deductions; }
    public void setDeductions(List<SalaryDetailDTO> deductions) { this.deductions = deductions; }
}
