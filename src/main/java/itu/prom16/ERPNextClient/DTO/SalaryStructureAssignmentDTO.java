package itu.prom16.ERPNextClient.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import itu.prom16.ERPNextClient.config.FlexibleLocalDateTimeDeserializer;

/**
 *
 * @author Fanou
 */
public class SalaryStructureAssignmentDTO {
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

    @JsonProperty("employee")
    private String employee;

    @JsonProperty("employee_name")
    private String employeeName;

    @JsonProperty("salary_structure")
    private String salaryStructure;

    @JsonProperty("from_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;

    @JsonProperty("company")
    private String company;

    @JsonProperty("payroll_payable_account")
    private String payrollPayableAccount;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("base")
    private double base;

    @JsonProperty("variable")
    private double variable;

    @JsonProperty("taxable_earnings_till_date")
    private double taxableEarningsTillDate;

    @JsonProperty("tax_deducted_till_date")
    private double taxDeductedTillDate;

    public SalaryStructureAssignmentDTO() {}

    public SalaryStructureAssignmentDTO(String name, String owner, LocalDateTime creation, LocalDateTime modified,
            String modifiedBy, int docstatus, int idx, String employee, String employeeName,
            String salaryStructure, LocalDate fromDate, String company, String payrollPayableAccount, String currency,
            double base, double variable, double taxableEarningsTillDate, double taxDeductedTillDate) { 
        this.name = name;
        this.owner = owner;
        this.creation = creation;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
        this.docstatus = docstatus;
        this.idx = idx;
        this.employee = employee;
        this.employeeName = employeeName;
        this.salaryStructure = salaryStructure;
        this.fromDate = fromDate;
        this.company = company;
        this.payrollPayableAccount = payrollPayableAccount;
        this.currency = currency;
        this.base = base;
        this.variable = variable;
        this.taxableEarningsTillDate = taxableEarningsTillDate;
        this.taxDeductedTillDate = taxDeductedTillDate;
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

    public String getEmployee() { return employee; }
    public void setEmployee(String employee) { this.employee = employee; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getSalaryStructure() { return salaryStructure; }
    public void setSalaryStructure(String salaryStructure) { this.salaryStructure = salaryStructure; }

    public LocalDate getFromDate() { return fromDate; }
    public void setFromDate(LocalDate fromDate) { this.fromDate = fromDate; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getPayrollPayableAccount() { return payrollPayableAccount; }
    public void setPayrollPayableAccount(String payrollPayableAccount) { this.payrollPayableAccount = payrollPayableAccount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public double getBase() { return base; }
    public void setBase(double base) { this.base = base; }

    public double getVariable() { return variable; }
    public void setVariable(double variable) { this.variable = variable; }

    public double getTaxableEarningsTillDate() { return taxableEarningsTillDate; }
    public void setTaxableEarningsTillDate(double taxableEarningsTillDate) { this.taxableEarningsTillDate = taxableEarningsTillDate; }

    public double getTaxDeductedTillDate() { return taxDeductedTillDate; }
    public void setTaxDeductedTillDate(double taxDeductedTillDate) { this.taxDeductedTillDate = taxDeductedTillDate; }


}
