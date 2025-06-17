package itu.prom16.ERPNextClient.DTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import itu.prom16.ERPNextClient.config.FlexibleLocalDateTimeDeserializer;

/**
 *
 * @author Fanou
 */
public class SalaryDetailDTO {
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

    @JsonProperty("salary_component")
    private String salaryComponent;

    @JsonProperty("abbr")
    private String abbr;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("year_to_date")
    private double yearToDate;

    @JsonProperty("is_recurring_additional_salary")
    private int isRecurringAdditionalSalary;

    @JsonProperty("statistical_component")
    private int statisticalComponent;

    @JsonProperty("depends_on_payment_days")
    private int dependsOnPaymentDays;

    @JsonProperty("exempted_from_income_tax")
    private int exemptedFromIncomeTax;

    @JsonProperty("is_tax_applicable")
    private int isTaxApplicable;

    @JsonProperty("is_flexible_benefit")
    private int isFlexibleBenefit;

    @JsonProperty("variable_based_on_taxable_salary")
    private int variableBasedOnTaxableSalary;

    @JsonProperty("do_not_include_in_total")
    private int doNotIncludeInTotal;

    @JsonProperty("deduct_full_tax_on_selected_payroll_date")
    private int deductFullTaxOnSelectedPayrollDate;

    @JsonProperty("amount_based_on_formula")
    private int amountBasedOnFormula;

    @JsonProperty("default_amount")
    private double defaultAmount;

    @JsonProperty("additional_amount")
    private double additionalAmount;

    @JsonProperty("tax_on_flexible_benefit")
    private int taxOnFlexibleBenefit;

    @JsonProperty("tax_on_additional_salary")
    private int taxOnAdditionalSalary;

    @JsonProperty("parent")
    private String parent;

    @JsonProperty("parentfield")
    private String parentfield;

    @JsonProperty("parenttype")
    private String parenttype;

    @JsonProperty("doctype")
    private String doctype;

    public SalaryDetailDTO() {}

    public SalaryDetailDTO(String name, String owner, LocalDateTime creation, LocalDateTime modified,
            String modifiedBy, int docstatus, int idx, String salaryComponent, String abbr, double amount,
            double yearToDate, int isRecurringAdditionalSalary, int statisticalComponent, int dependsOnPaymentDays,
            int exemptedFromIncomeTax, int isTaxApplicable, int isFlexibleBenefit, int variableBasedOnTaxableSalary,
            int doNotIncludeInTotal, int deductFullTaxOnSelectedPayrollDate, int amountBasedOnFormula,
            double defaultAmount, double additionalAmount, int taxOnFlexibleBenefit, int taxOnAdditionalSalary,
            String parent, String parentfield, String parenttype, String doctype) {
        this.name = name;
        this.owner = owner;
        this.creation = creation;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
        this.docstatus = docstatus;
        this.idx = idx;
        this.salaryComponent = salaryComponent;
        this.abbr = abbr;
        this.amount = amount;
        this.yearToDate = yearToDate;
        this.isRecurringAdditionalSalary = isRecurringAdditionalSalary;
        this.statisticalComponent = statisticalComponent;
        this.dependsOnPaymentDays = dependsOnPaymentDays;
        this.exemptedFromIncomeTax = exemptedFromIncomeTax;
        this.isTaxApplicable = isTaxApplicable;
        this.isFlexibleBenefit = isFlexibleBenefit;
        this.variableBasedOnTaxableSalary = variableBasedOnTaxableSalary;
        this.doNotIncludeInTotal = doNotIncludeInTotal;
        this.deductFullTaxOnSelectedPayrollDate = deductFullTaxOnSelectedPayrollDate;
        this.amountBasedOnFormula = amountBasedOnFormula;
        this.defaultAmount = defaultAmount;
        this.additionalAmount = additionalAmount;
        this.taxOnFlexibleBenefit = taxOnFlexibleBenefit;
        this.taxOnAdditionalSalary = taxOnAdditionalSalary;
        this.parent = parent;
        this.parentfield = parentfield;
        this.parenttype = parenttype;
        this.doctype = doctype;
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

    public String getSalaryComponent() { return salaryComponent; }
    public void setSalaryComponent(String salaryComponent) { this.salaryComponent = salaryComponent; }

    public String getAbbr() { return abbr; }
    public void setAbbr(String abbr) { this.abbr = abbr; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public double getYearToDate() { return yearToDate; }
    public void setYearToDate(double yearToDate) { this.yearToDate = yearToDate; }

    public int getIsRecurringAdditionalSalary() { return isRecurringAdditionalSalary; }
    public void setIsRecurringAdditionalSalary(int isRecurringAdditionalSalary) { this.isRecurringAdditionalSalary = isRecurringAdditionalSalary; }

    public int getStatisticalComponent() { return statisticalComponent; }
    public void setStatisticalComponent(int statisticalComponent) { this.statisticalComponent = statisticalComponent; }

    public int getDependsOnPaymentDays() { return dependsOnPaymentDays; }
    public void setDependsOnPaymentDays(int dependsOnPaymentDays) { this.dependsOnPaymentDays = dependsOnPaymentDays; }

    public int getExemptedFromIncomeTax() { return exemptedFromIncomeTax; }
    public void setExemptedFromIncomeTax(int exemptedFromIncomeTax) { this.exemptedFromIncomeTax = exemptedFromIncomeTax; }

    public int getIsTaxApplicable() { return isTaxApplicable; }
    public void setIsTaxApplicable(int isTaxApplicable) { this.isTaxApplicable = isTaxApplicable; }

    public int getIsFlexibleBenefit() { return isFlexibleBenefit; }
    public void setIsFlexibleBenefit(int isFlexibleBenefit) { this.isFlexibleBenefit = isFlexibleBenefit; }

    public int getVariableBasedOnTaxableSalary() { return variableBasedOnTaxableSalary; }
    public void setVariableBasedOnTaxableSalary(int variableBasedOnTaxableSalary) { this.variableBasedOnTaxableSalary = variableBasedOnTaxableSalary; }

    public int getDoNotIncludeInTotal() { return doNotIncludeInTotal; }
    public void setDoNotIncludeInTotal(int doNotIncludeInTotal) { this.doNotIncludeInTotal = doNotIncludeInTotal; }

    public int getDeductFullTaxOnSelectedPayrollDate() { return deductFullTaxOnSelectedPayrollDate; }
    public void setDeductFullTaxOnSelectedPayrollDate(int deductFullTaxOnSelectedPayrollDate) { this.deductFullTaxOnSelectedPayrollDate = deductFullTaxOnSelectedPayrollDate; }

    public int getAmountBasedOnFormula() { return amountBasedOnFormula; }
    public void setAmountBasedOnFormula(int amountBasedOnFormula) { this.amountBasedOnFormula = amountBasedOnFormula; }

    public double getDefaultAmount() { return defaultAmount; }
    public void setDefaultAmount(double defaultAmount) { this.defaultAmount = defaultAmount; }

    public double getAdditionalAmount() { return additionalAmount; }
    public void setAdditionalAmount(double additionalAmount) { this.additionalAmount = additionalAmount; }

    public int getTaxOnFlexibleBenefit() { return taxOnFlexibleBenefit; }
    public void setTaxOnFlexibleBenefit(int taxOnFlexibleBenefit) { this.taxOnFlexibleBenefit = taxOnFlexibleBenefit; }

    public int getTaxOnAdditionalSalary() { return taxOnAdditionalSalary; }
    public void setTaxOnAdditionalSalary(int taxOnAdditionalSalary) { this.taxOnAdditionalSalary = taxOnAdditionalSalary; }

    public String getParent() { return parent; }
    public void setParent(String parent) { this.parent = parent; }

    public String getParentfield() { return parentfield; }
    public void setParentfield(String parentfield) { this.parentfield = parentfield; }

    public String getParenttype() { return parenttype; }
    public void setParenttype(String parenttype) { this.parenttype = parenttype; }

    public String getDoctype() { return doctype; }
    public void setDoctype(String doctype) { this.doctype = doctype; }
}
