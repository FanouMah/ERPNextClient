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
public class SalaryComponentDTO {
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

    @JsonProperty("salary_component_abbr")
    private String salaryComponentAbbr;

    @JsonProperty("type")
    private String type;

    @JsonProperty("depends_on_payment_days")
    private int dependsOnPaymentDays;

    @JsonProperty("is_tax_applicable")
    private int isTaxApplicable;

    @JsonProperty("deduct_full_tax_on_selected_payroll_date")
    private int deductFullTaxOnSelectedPayrollDate;

    @JsonProperty("variable_based_on_taxable_salary")
    private int variableBasedOnTaxableSalary;

    @JsonProperty("is_income_tax_component")
    private int isIncomeTaxComponent;

    @JsonProperty("exempted_from_income_tax")
    private int exemptedFromIncomeTax;

    @JsonProperty("round_to_the_nearest_integer")
    private int roundToTheNearestInteger;

    @JsonProperty("statistical_component")
    private int statisticalComponent;

    @JsonProperty("do_not_include_in_total")
    private int doNotIncludeInTotal;

    @JsonProperty("remove_if_zero_valued")
    private int removeIfZeroValued;

    @JsonProperty("disabled")
    private int disabled;

    @JsonProperty("amount")
    private int amount;

    @JsonProperty("amount_based_on_formula")
    private int amountBasedOnFormula;

    @JsonProperty("formula")
    private String formula;

    @JsonProperty("is_flexible_benefit")
    private int isFlexibleBenefit;

    @JsonProperty("max_benefit_amount")
    private int maxBenefitAmount;

    @JsonProperty("pay_against_benefit_claim")
    private int payAgainstBenefitClaim;

    @JsonProperty("only_tax_impact")
    private int onlyTaxImpact;

    @JsonProperty("create_separate_payment_entry_against_benefit_claim")
    private int createSeparatePaymentEntryAgainstBenefitClaim;

    @JsonProperty("doctype")
    private String doctype;

    @JsonProperty("accounts")
    private List<SalaryComponentAccountDTO> accounts;

    public SalaryComponentDTO() {}
    
    public SalaryComponentDTO(String name, String owner, LocalDateTime creation, LocalDateTime modified,
            String modifiedBy, int docstatus, int idx, String salaryComponent, String salaryComponentAbbr, String type,
            int dependsOnPaymentDays, int isTaxApplicable, int deductFullTaxOnSelectedPayrollDate,
            int variableBasedOnTaxableSalary, int isIncomeTaxComponent, int exemptedFromIncomeTax,
            int roundToTheNearestInteger, int statisticalComponent, int doNotIncludeInTotal, int removeIfZeroValued,
            int disabled, int amount, int amountBasedOnFormula, String formula, int isFlexibleBenefit,
            int maxBenefitAmount, int payAgainstBenefitClaim, int onlyTaxImpact,
            int createSeparatePaymentEntryAgainstBenefitClaim, String doctype, List<SalaryComponentAccountDTO> accounts) {
        this.name = name;
        this.owner = owner;
        this.creation = creation;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
        this.docstatus = docstatus;
        this.idx = idx;
        this.salaryComponent = salaryComponent;
        this.salaryComponentAbbr = salaryComponentAbbr;
        this.type = type;
        this.dependsOnPaymentDays = dependsOnPaymentDays;
        this.isTaxApplicable = isTaxApplicable;
        this.deductFullTaxOnSelectedPayrollDate = deductFullTaxOnSelectedPayrollDate;
        this.variableBasedOnTaxableSalary = variableBasedOnTaxableSalary;
        this.isIncomeTaxComponent = isIncomeTaxComponent;
        this.exemptedFromIncomeTax = exemptedFromIncomeTax;
        this.roundToTheNearestInteger = roundToTheNearestInteger;
        this.statisticalComponent = statisticalComponent;
        this.doNotIncludeInTotal = doNotIncludeInTotal;
        this.removeIfZeroValued = removeIfZeroValued;
        this.disabled = disabled;
        this.amount = amount;
        this.amountBasedOnFormula = amountBasedOnFormula;
        this.formula = formula;
        this.isFlexibleBenefit = isFlexibleBenefit;
        this.maxBenefitAmount = maxBenefitAmount;
        this.payAgainstBenefitClaim = payAgainstBenefitClaim;
        this.onlyTaxImpact = onlyTaxImpact;
        this.createSeparatePaymentEntryAgainstBenefitClaim = createSeparatePaymentEntryAgainstBenefitClaim;
        this.doctype = doctype;
        this.accounts = accounts;
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

    public String getSalaryComponentAbbr() { return salaryComponentAbbr; }
    public void setSalaryComponentAbbr(String salaryComponentAbbr) { this.salaryComponentAbbr = salaryComponentAbbr; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getDependsOnPaymentDays() { return dependsOnPaymentDays; }
    public void setDependsOnPaymentDays(int dependsOnPaymentDays) { this.dependsOnPaymentDays = dependsOnPaymentDays; }

    public int getIsTaxApplicable() { return isTaxApplicable; }
    public void setIsTaxApplicable(int isTaxApplicable) { this.isTaxApplicable = isTaxApplicable; }

    public int getDeductFullTaxOnSelectedPayrollDate() { return deductFullTaxOnSelectedPayrollDate; }
    public void setDeductFullTaxOnSelectedPayrollDate(int deductFullTaxOnSelectedPayrollDate) { this.deductFullTaxOnSelectedPayrollDate = deductFullTaxOnSelectedPayrollDate; }

    public int getVariableBasedOnTaxableSalary() { return variableBasedOnTaxableSalary; }
    public void setVariableBasedOnTaxableSalary(int variableBasedOnTaxableSalary) { this.variableBasedOnTaxableSalary = variableBasedOnTaxableSalary; }

    public int getIsIncomeTaxComponent() { return isIncomeTaxComponent; }
    public void setIsIncomeTaxComponent(int isIncomeTaxComponent) { this.isIncomeTaxComponent = isIncomeTaxComponent; }

    public int getExemptedFromIncomeTax() { return exemptedFromIncomeTax; }
    public void setExemptedFromIncomeTax(int exemptedFromIncomeTax) { this.exemptedFromIncomeTax = exemptedFromIncomeTax; }

    public int getRoundToTheNearestInteger() { return roundToTheNearestInteger; }
    public void setRoundToTheNearestInteger(int roundToTheNearestInteger) { this.roundToTheNearestInteger = roundToTheNearestInteger; }

    public int getStatisticalComponent() { return statisticalComponent; }
    public void setStatisticalComponent(int statisticalComponent) { this.statisticalComponent = statisticalComponent; }

    public int getDoNotIncludeInTotal() { return doNotIncludeInTotal; }
    public void setDoNotIncludeInTotal(int doNotIncludeInTotal) { this.doNotIncludeInTotal = doNotIncludeInTotal; }

    public int getRemoveIfZeroValued() { return removeIfZeroValued; }
    public void setRemoveIfZeroValued(int removeIfZeroValued) { this.removeIfZeroValued = removeIfZeroValued; }

    public int getDisabled() { return disabled; }
    public void setDisabled(int disabled) { this.disabled = disabled; }

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    public int getAmountBasedOnFormula() { return amountBasedOnFormula; }
    public void setAmountBasedOnFormula(int amountBasedOnFormula) { this.amountBasedOnFormula = amountBasedOnFormula; }

    public String getFormula() { return formula; }
    public void setFormula(String formula) { this.formula = formula; }

    public int getIsFlexibleBenefit() { return isFlexibleBenefit; }
    public void setIsFlexibleBenefit(int isFlexibleBenefit) { this.isFlexibleBenefit = isFlexibleBenefit; }

    public int getMaxBenefitAmount() { return maxBenefitAmount; }
    public void setMaxBenefitAmount(int maxBenefitAmount) { this.maxBenefitAmount = maxBenefitAmount; }

    public int getPayAgainstBenefitClaim() { return payAgainstBenefitClaim; }
    public void setPayAgainstBenefitClaim(int payAgainstBenefitClaim) { this.payAgainstBenefitClaim = payAgainstBenefitClaim; }

    public int getOnlyTaxImpact() { return onlyTaxImpact; }
    public void setOnlyTaxImpact(int onlyTaxImpact) { this.onlyTaxImpact = onlyTaxImpact; }

    public int getCreateSeparatePaymentEntryAgainstBenefitClaim() { return createSeparatePaymentEntryAgainstBenefitClaim; }
    public void setCreateSeparatePaymentEntryAgainstBenefitClaim(int createSeparatePaymentEntryAgainstBenefitClaim) { this.createSeparatePaymentEntryAgainstBenefitClaim = createSeparatePaymentEntryAgainstBenefitClaim; }

    public String getDoctype() { return doctype; }
    public void setDoctype(String doctype) { this.doctype = doctype; }

    public List<SalaryComponentAccountDTO> getAccounts() { return accounts; }
    public void setAccounts(List<SalaryComponentAccountDTO> accounts) { this.accounts = accounts;} 
}
