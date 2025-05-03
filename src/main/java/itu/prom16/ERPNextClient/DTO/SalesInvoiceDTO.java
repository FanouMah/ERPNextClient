package itu.prom16.ERPNextClient.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Fanou
 */
public class SalesInvoiceDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private String owner;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    @JsonProperty("creation")
    private LocalDateTime creation;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    @JsonProperty("modified")
    private LocalDateTime modified;
    @JsonProperty("modified_by")
    private String modifiedBy;
    @JsonProperty("docstatus")
    private int docstatus;
    @JsonProperty("title")
    private String title;
    @JsonProperty("naming_series")
    private String namingSeries;
    @JsonProperty("customer")
    private String customer;
    @JsonProperty("customer_name")
    private String customerName;
    @JsonProperty("company")
    private String company;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("posting_date")
    private LocalDate postingDate;

    @JsonProperty("posting_time")
    @JsonFormat(pattern = "H:mm:ss.SSSSSS")
    private LocalTime postingTime;
    

    @JsonProperty("set_posting_time")
    private int setPostingTime;

    
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("due_date")
    private LocalDate dueDate;
    @JsonProperty("is_pos")
    private int isPos;
    @JsonProperty("is_consolidated")
    private int isConsolidated;
    @JsonProperty("is_return")
    private int isReturn;
    @JsonProperty("update_outstanding_for_self")
    private int updateOutstandingForSelf;
    @JsonProperty("update_billed_amount_in_sales_order")
    private int updateBilledAmountInSalesOrder;
    @JsonProperty("update_billed_amount_in_delivery_note")
    private int updateBilledAmountInDeliveryNote;
    @JsonProperty("is_debit_note")
    private int isDebitNote;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("conversion_rate")
    private double conversionRate;
    @JsonProperty("selling_price_list")
    private String sellingPriceList;
    @JsonProperty("price_list_currency")
    private String priceListCurrency;
    @JsonProperty("plc_conversion_rate")
    private double plcConversionRate;
    @JsonProperty("ignore_pricing_rule")
    private int ignorePricingRule;
    @JsonProperty("update_stock")
    private int updateStock;
    @JsonProperty("set_warehouse")
    private String setWarehouse;
    @JsonProperty("total_qty")
    private double totalQty;
    @JsonProperty("base_total")
    private double baseTotal;
    @JsonProperty("base_net_total")
    private double baseNetTotal;
    @JsonProperty("total")
    private double total;
    @JsonProperty("net_total")
    private double netTotal;
    @JsonProperty("base_total_taxes_and_charges")
    private double baseTotalTaxesAndCharges;
    @JsonProperty("total_taxes_and_charges")
    private double totalTaxesAndCharges;
    @JsonProperty("base_grand_total")
    private double baseGrandTotal;
    @JsonProperty("base_rounding_adjustment")
    private double baseRoundingAdjustment;
    @JsonProperty("base_rounded_total")
    private double baseRoundedTotal;
    @JsonProperty("base_in_words")
    private String baseInWords;
    @JsonProperty("grand_total")
    private double grandTotal;
    @JsonProperty("rounding_adjustment")
    private double roundingAdjustment;
    @JsonProperty("use_company_roundoff_cost_center")
    private int useCompanyRoundoffCostCenter;
    @JsonProperty("rounded_total")
    private double roundedTotal;
    @JsonProperty("in_words")
    private String inWords;
    @JsonProperty("total_advance")
    private double totalAdvance;
    @JsonProperty("outstanding_amount")
    private double outstandingAmount;
    @JsonProperty("disable_rounded_total")
    private int disableRoundedTotal;
    @JsonProperty("apply_discount_on")
    private String applyDiscountOn;
    @JsonProperty("base_discount_amount")
    private double baseDiscountAmount;
    @JsonProperty("is_cash_or_non_trade_discount")
    private int isCashOrNonTradeDiscount;
    @JsonProperty("additional_discount_percentage")
    private double additionalDiscountPercentage;
    @JsonProperty("discount_amount")
    private double discountAmount;
    @JsonProperty("total_billing_hours")
    private double totalBillingHours;
    @JsonProperty("total_billing_amount")
    private double totalBillingAmount;
    @JsonProperty("base_paid_amount")
    private double basePaidAmount;
    @JsonProperty("paid_amount")
    private double paidAmount;
    @JsonProperty("base_change_amount")
    private double baseChangeAmount;
    @JsonProperty("change_amount")
    private double changeAmount;
    @JsonProperty("allocate_advances_automatically")
    private int allocateAdvancesAutomatically;
    @JsonProperty("only_include_allocated_payments")
    private int onlyIncludeAllocatedPayments;
    @JsonProperty("write_off_amount")
    private double writeOffAmount;
    @JsonProperty("base_write_off_amount")
    private double baseWriteOffAmount;
    @JsonProperty("write_off_outstanding_amount_automatically")
    private int writeOffOutstandingAmountAutomatically;
    @JsonProperty("redeem_loyalty_points")
    private int redeemLoyaltyPoints;
    @JsonProperty("loyalty_points")
    private int loyaltyPoints;
    @JsonProperty("loyalty_amount")
    private double loyaltyAmount;
    @JsonProperty("debit_to")
    private String debitTo;
    @JsonProperty("party_account_currency")
    private String partyAccountCurrency;
    @JsonProperty("is_opening")
    private String isOpening;
    @JsonProperty("against_income_account")
    private String againstIncomeAccount;
    @JsonProperty("amount_eligible_for_commission")
    private double amountEligibleForCommission;
    @JsonProperty("commission_rate")
    private double commissionRate;
    @JsonProperty("total_commission")
    private double totalCommission;
    @JsonProperty("language")
    private String language;
    @JsonProperty("status")
    private String status;
    @JsonProperty("customer_group")
    private String customerGroup;
    @JsonProperty("is_internal_customer")
    private int isInternalCustomer;
    @JsonProperty("is_discounted")
    private int isDiscounted;
    @JsonProperty("remarks")
    private String remarks;

    public SalesInvoiceDTO() {}

    public SalesInvoiceDTO(String name, String owner, LocalDateTime creation, LocalDateTime modified, String modifiedBy, int docstatus, String title, String namingSeries, String customer, String customerName, String company, LocalDate postingDate, LocalTime postingTime, int setPostingTime, LocalDate dueDate, int isPos, int isConsolidated, int isReturn, int updateOutstandingForSelf, int updateBilledAmountInSalesOrder, int updateBilledAmountInDeliveryNote, int isDebitNote, String currency, double conversionRate, String sellingPriceList, String priceListCurrency, double plcConversionRate, int ignorePricingRule, int updateStock, String setWarehouse, double totalQty, double baseTotal, double baseNetTotal, double total, double netTotal, double baseTotalTaxesAndCharges, double totalTaxesAndCharges, double baseGrandTotal, double baseRoundingAdjustment, double baseRoundedTotal, String baseInWords, double grandTotal, double roundingAdjustment, int useCompanyRoundoffCostCenter, double roundedTotal, String inWords, double totalAdvance, double outstandingAmount, int disableRoundedTotal, String applyDiscountOn, double baseDiscountAmount, int isCashOrNonTradeDiscount, double additionalDiscountPercentage, double discountAmount, double totalBillingHours, double totalBillingAmount, double basePaidAmount, double paidAmount, double baseChangeAmount, double changeAmount, int allocateAdvancesAutomatically, int onlyIncludeAllocatedPayments, double writeOffAmount, double baseWriteOffAmount, int writeOffOutstandingAmountAutomatically, int redeemLoyaltyPoints, int loyaltyPoints, double loyaltyAmount, String debitTo, String partyAccountCurrency, String isOpening, String againstIncomeAccount, double amountEligibleForCommission, double commissionRate, double totalCommission, String language, String status, String customerGroup, int isInternalCustomer, int isDiscounted, String remarks) { 
        this.name = name;
        this.owner = owner;
        this.creation = creation;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
        this.docstatus = docstatus;
        this.title = title;
        this.namingSeries = namingSeries;
        this.customer = customer;
        this.customerName = customerName;
        this.company = company;
        this.postingDate = postingDate;
        this.postingTime = postingTime;
        this.setPostingTime = setPostingTime;
        this.dueDate = dueDate;
        this.isPos = isPos;
        this.isConsolidated = isConsolidated;
        this.isReturn = isReturn;
        this.updateOutstandingForSelf = updateOutstandingForSelf;
        this.updateBilledAmountInSalesOrder = updateBilledAmountInSalesOrder;
        this.updateBilledAmountInDeliveryNote = updateBilledAmountInDeliveryNote;
        this.isDebitNote = isDebitNote;
        this.currency = currency;
        this.conversionRate = conversionRate;
        this.sellingPriceList = sellingPriceList;
        this.priceListCurrency = priceListCurrency;
        this.plcConversionRate = plcConversionRate;
        this.ignorePricingRule = ignorePricingRule;
        this.updateStock = updateStock;
        this.setWarehouse = setWarehouse;
        this.totalQty = totalQty;
        this.baseTotal = baseTotal;
        this.baseNetTotal = baseNetTotal;
        this.total = total;
        this.netTotal = netTotal;
        this.baseTotalTaxesAndCharges = baseTotalTaxesAndCharges;
        this.totalTaxesAndCharges = totalTaxesAndCharges;
        this.baseGrandTotal = baseGrandTotal;
        this.baseRoundingAdjustment = baseRoundingAdjustment;
        this.baseRoundedTotal = baseRoundedTotal;
        this.baseInWords = baseInWords;
        this.grandTotal = grandTotal;
        this.roundingAdjustment = roundingAdjustment;
        this.useCompanyRoundoffCostCenter = useCompanyRoundoffCostCenter;
        this.roundedTotal = roundedTotal;
        this.inWords = inWords;
        this.totalAdvance = totalAdvance;
        this.outstandingAmount = outstandingAmount;
        this.disableRoundedTotal = disableRoundedTotal;
        this.applyDiscountOn = applyDiscountOn;
        this.baseDiscountAmount = baseDiscountAmount;
        this.isCashOrNonTradeDiscount = isCashOrNonTradeDiscount;
        this.additionalDiscountPercentage = additionalDiscountPercentage;
        this.discountAmount = discountAmount;
        this.totalBillingHours = totalBillingHours;
        this.totalBillingAmount = totalBillingAmount;
        this.basePaidAmount = basePaidAmount;
        this.paidAmount = paidAmount;
        this.baseChangeAmount = baseChangeAmount;
        this.changeAmount = changeAmount;
        this.allocateAdvancesAutomatically = allocateAdvancesAutomatically;
        this.onlyIncludeAllocatedPayments = onlyIncludeAllocatedPayments;
        this.writeOffAmount = writeOffAmount;
        this.baseWriteOffAmount = baseWriteOffAmount;
        this.writeOffOutstandingAmountAutomatically = writeOffOutstandingAmountAutomatically;
        this.redeemLoyaltyPoints = redeemLoyaltyPoints;
        this.loyaltyPoints = loyaltyPoints;
        this.loyaltyAmount = loyaltyAmount;
        this.debitTo = debitTo;
        this.partyAccountCurrency = partyAccountCurrency;
        this.isOpening = isOpening;
        this.againstIncomeAccount = againstIncomeAccount;
        this.amountEligibleForCommission = amountEligibleForCommission;
        this.commissionRate = commissionRate;
        this.totalCommission = totalCommission;
        this.language = language;
        this.status = status;
        this.customerGroup = customerGroup;
        this.isInternalCustomer = isInternalCustomer;
        this.isDiscounted = isDiscounted;
        this.remarks = remarks;
    }

    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public String getOwner() { return owner;}
    public void setOwner(String owner) { this.owner = owner;}

    public LocalDateTime getCreation() { return creation;}
    public void setCreation(LocalDateTime creation) { this.creation = creation;}

    public LocalDateTime getModified() { return modified;}
    public void setModified(LocalDateTime modified) { this.modified = modified;}

    public String getModifiedBy() { return modifiedBy;}
    public void setModifiedBy(String modifiedBy) { this.modifiedBy = modifiedBy;}

    public int getDocstatus() { return docstatus;}
    public void setDocstatus(int docstatus) { this.docstatus = docstatus;}

    public String getTitle() { return title;}
    public void setTitle(String title) { this.title = title;}

    public String getNamingSeries() { return namingSeries;}
    public void setNamingSeries(String namingSeries) { this.namingSeries = namingSeries;}

    public String getCustomer() { return customer;}
    public void setCustomer(String customer) { this.customer = customer;}

    public String getCustomerName() { return customerName;}
    public void setCustomerName(String customerName) { this.customerName = customerName;}

    public String getCompany() { return company;}
    public void setCompany(String company) { this.company = company;}

    public LocalDate getPostingDate() { return postingDate;}
    public void setPostingDate(LocalDate postingDate) { this.postingDate = postingDate;}

    public LocalTime getPostingTime() { return postingTime;}
    public void setPostingTime(LocalTime postingTime) { this.postingTime = postingTime;}

    public int getSetPostingTime() { return setPostingTime;}
    public void setSetPostingTime(int setPostingTime) { this.setPostingTime = setPostingTime;}

    public LocalDate getDueDate() { return dueDate;}
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate;}

    public int getIsPos() { return isPos;}
    public void setIsPos(int isPos) { this.isPos = isPos;}

    public int getIsConsolidated() { return isConsolidated;}
    public void setIsConsolidated(int isConsolidated) { this.isConsolidated = isConsolidated;}

    public int getIsReturn() { return isReturn;}
    public void setIsReturn(int isReturn) { this.isReturn = isReturn;}

    public int getUpdateOutstandingForSelf() { return updateOutstandingForSelf;}
    public void setUpdateOutstandingForSelf(int updateOutstandingForSelf) { this.updateOutstandingForSelf = updateOutstandingForSelf;}

    public int getUpdateBilledAmountInSalesOrder() { return updateBilledAmountInSalesOrder;}
    public void setUpdateBilledAmountInSalesOrder(int updateBilledAmountInSalesOrder) { this.updateBilledAmountInSalesOrder = updateBilledAmountInSalesOrder;}

    public int getUpdateBilledAmountInDeliveryNote() { return updateBilledAmountInDeliveryNote;}
    public void setUpdateBilledAmountInDeliveryNote(int updateBilledAmountInDeliveryNote) { this.updateBilledAmountInDeliveryNote = updateBilledAmountInDeliveryNote;}

    public int getIsDebitNote() { return isDebitNote;}
    public void setIsDebitNote(int isDebitNote) { this.isDebitNote = isDebitNote;}

    public String getCurrency() { return currency;}
    public void setCurrency(String currency) { this.currency = currency;}

    public double getConversionRate() { return conversionRate;}
    public void setConversionRate(double conversionRate) { this.conversionRate = conversionRate;}

    public String getSellingPriceList() { return sellingPriceList;}
    public void setSellingPriceList(String sellingPriceList) { this.sellingPriceList = sellingPriceList;}

    public String getPriceListCurrency() { return priceListCurrency;}
    public void setPriceListCurrency(String priceListCurrency) { this.priceListCurrency = priceListCurrency;}

    public double getPlcConversionRate() { return plcConversionRate;}
    public void setPlcConversionRate(double plcConversionRate) { this.plcConversionRate = plcConversionRate;}

    public int getIgnorePricingRule() { return ignorePricingRule;}
    public void setIgnorePricingRule(int ignorePricingRule) { this.ignorePricingRule = ignorePricingRule;}

    public int getUpdateStock() { return updateStock;}
    public void setUpdateStock(int updateStock) { this.updateStock = updateStock;}

    public String getSetWarehouse() { return setWarehouse;}
    public void setSetWarehouse(String setWarehouse) { this.setWarehouse = setWarehouse;}

    public double getTotalQty() { return totalQty;}
    public void setTotalQty(double totalQty) { this.totalQty = totalQty;}

    public double getBaseTotal() { return baseTotal;}
    public void setBaseTotal(double baseTotal) { this.baseTotal = baseTotal;}

    public double getBaseNetTotal() { return baseNetTotal;}
    public void setBaseNetTotal(double baseNetTotal) { this.baseNetTotal = baseNetTotal;}

    public double getTotal() { return total;}
    public void setTotal(double total) { this.total = total;}

    public double getNetTotal() { return netTotal;}
    public void setNetTotal(double netTotal) { this.netTotal = netTotal;}

    public double getBaseTotalTaxesAndCharges() { return baseTotalTaxesAndCharges;}
    public void setBaseTotalTaxesAndCharges(double baseTotalTaxesAndCharges) { this.baseTotalTaxesAndCharges = baseTotalTaxesAndCharges;}

    public double getTotalTaxesAndCharges() { return totalTaxesAndCharges;}
    public void setTotalTaxesAndCharges(double totalTaxesAndCharges) { this.totalTaxesAndCharges = totalTaxesAndCharges;}

    public double getBaseGrandTotal() { return baseGrandTotal;}
    public void setBaseGrandTotal(double baseGrandTotal) { this.baseGrandTotal = baseGrandTotal;}

    public double getBaseRoundingAdjustment() { return baseRoundingAdjustment;}
    public void setBaseRoundingAdjustment(double baseRoundingAdjustment) { this.baseRoundingAdjustment = baseRoundingAdjustment;}

    public double getBaseRoundedTotal() { return baseRoundedTotal;}
    public void setBaseRoundedTotal(double baseRoundedTotal) { this.baseRoundedTotal = baseRoundedTotal;}

    public String getBaseInWords() { return baseInWords;}
    public void setBaseInWords(String baseInWords) { this.baseInWords = baseInWords;}

    public double getGrandTotal() { return grandTotal;}
    public void setGrandTotal(double grandTotal) { this.grandTotal = grandTotal;}

    public double getRoundingAdjustment() { return roundingAdjustment;}
    public void setRoundingAdjustment(double roundingAdjustment) { this.roundingAdjustment = roundingAdjustment;}

    public int getUseCompanyRoundoffCostCenter() { return useCompanyRoundoffCostCenter;}
    public void setUseCompanyRoundoffCostCenter(int useCompanyRoundoffCostCenter) { this.useCompanyRoundoffCostCenter = useCompanyRoundoffCostCenter;}

    public double getRoundedTotal() { return roundedTotal;}
    public void setRoundedTotal(double roundedTotal) { this.roundedTotal = roundedTotal;}

    public String getInWords() { return inWords;}
    public void setInWords(String inWords) { this.inWords = inWords;}

    public double getTotalAdvance() { return totalAdvance;}
    public void setTotalAdvance(double totalAdvance) { this.totalAdvance = totalAdvance;}

    public double getOutstandingAmount() { return outstandingAmount;}
    public void setOutstandingAmount(double outstandingAmount) { this.outstandingAmount = outstandingAmount;}

    public int getDisableRoundedTotal() { return disableRoundedTotal;}
    public void setDisableRoundedTotal(int disableRoundedTotal) { this.disableRoundedTotal = disableRoundedTotal;}

    public String getApplyDiscountOn() { return applyDiscountOn;}
    public void setApplyDiscountOn(String applyDiscountOn) { this.applyDiscountOn = applyDiscountOn;}

    public double getBaseDiscountAmount() { return baseDiscountAmount;}
    public void setBaseDiscountAmount(double baseDiscountAmount) { this.baseDiscountAmount = baseDiscountAmount;}

    public int getIsCashOrNonTradeDiscount() { return isCashOrNonTradeDiscount;}
    public void setIsCashOrNonTradeDiscount(int isCashOrNonTradeDiscount) { this.isCashOrNonTradeDiscount = isCashOrNonTradeDiscount;}

    public double getAdditionalDiscountPercentage() { return additionalDiscountPercentage;}
    public void setAdditionalDiscountPercentage(double additionalDiscountPercentage) { this.additionalDiscountPercentage = additionalDiscountPercentage;}

    public double getDiscountAmount() { return discountAmount;}
    public void setDiscountAmount(double discountAmount) { this.discountAmount = discountAmount;}

    public double getTotalBillingHours() { return totalBillingHours;}
    public void setTotalBillingHours(double totalBillingHours) { this.totalBillingHours = totalBillingHours;}

    public double getTotalBillingAmount() { return totalBillingAmount;}
    public void setTotalBillingAmount(double totalBillingAmount) { this.totalBillingAmount = totalBillingAmount;}

    public double getBasePaidAmount() { return basePaidAmount;}
    public void setBasePaidAmount(double basePaidAmount) { this.basePaidAmount = basePaidAmount;}

    public double getPaidAmount() { return paidAmount;}
    public void setPaidAmount(double paidAmount) { this.paidAmount = paidAmount;}

    public double getBaseChangeAmount() { return baseChangeAmount;}
    public void setBaseChangeAmount(double baseChangeAmount) { this.baseChangeAmount = baseChangeAmount;}

    public double getChangeAmount() { return changeAmount;}
    public void setChangeAmount(double changeAmount) { this.changeAmount = changeAmount;}

    public int getAllocateAdvancesAutomatically() { return allocateAdvancesAutomatically;}
    public void setAllocateAdvancesAutomatically(int allocateAdvancesAutomatically) { this.allocateAdvancesAutomatically = allocateAdvancesAutomatically;}

    public int getOnlyIncludeAllocatedPayments() { return onlyIncludeAllocatedPayments;}
    public void setOnlyIncludeAllocatedPayments(int onlyIncludeAllocatedPayments) { this.onlyIncludeAllocatedPayments = onlyIncludeAllocatedPayments;}

    public double getWriteOffAmount() { return writeOffAmount;}
    public void setWriteOffAmount(double writeOffAmount) { this.writeOffAmount = writeOffAmount;}

    public double getBaseWriteOffAmount() { return baseWriteOffAmount;}
    public void setBaseWriteOffAmount(double baseWriteOffAmount) { this.baseWriteOffAmount = baseWriteOffAmount;}

    public int getWriteOffOutstandingAmountAutomatically() { return writeOffOutstandingAmountAutomatically;}
    public void setWriteOffOutstandingAmountAutomatically(int writeOffOutstandingAmountAutomatically) { this.writeOffOutstandingAmountAutomatically = writeOffOutstandingAmountAutomatically;}

    public int getRedeemLoyaltyPoints() { return redeemLoyaltyPoints;}
    public void setRedeemLoyaltyPoints(int redeemLoyaltyPoints) { this.redeemLoyaltyPoints = redeemLoyaltyPoints;}

    public int getLoyaltyPoints() { return loyaltyPoints;}
    public void setLoyaltyPoints(int loyaltyPoints) { this.loyaltyPoints = loyaltyPoints;}

    public double getLoyaltyAmount() { return loyaltyAmount;}
    public void setLoyaltyAmount(double loyaltyAmount) { this.loyaltyAmount = loyaltyAmount;}

    public String getDebitTo() { return debitTo;}
    public void setDebitTo(String debitTo) { this.debitTo = debitTo;}

    public String getPartyAccountCurrency() { return partyAccountCurrency;}
    public void setPartyAccountCurrency(String partyAccountCurrency) { this.partyAccountCurrency = partyAccountCurrency;}

    public String getIsOpening() { return isOpening;}
    public void setIsOpening(String isOpening) { this.isOpening = isOpening;}

    public String getAgainstIncomeAccount() { return againstIncomeAccount;}
    public void setAgainstIncomeAccount(String againstIncomeAccount) { this.againstIncomeAccount = againstIncomeAccount;}

    public double getAmountEligibleForCommission() { return amountEligibleForCommission;}
    public void setAmountEligibleForCommission(double amountEligibleForCommission) { this.amountEligibleForCommission = amountEligibleForCommission;}

    public double getCommissionRate() { return commissionRate;}
    public void setCommissionRate(double commissionRate) { this.commissionRate = commissionRate;}

    public double getTotalCommission() { return totalCommission;}
    public void setTotalCommission(double totalCommission) { this.totalCommission = totalCommission;}

    public String getLanguage() { return language;}
    public void setLanguage(String language) { this.language = language;}

    public String getStatus() { return status;}
    public void setStatus(String status) { this.status = status;}

    public String getCustomerGroup() { return customerGroup;}
    public void setCustomerGroup(String customerGroup) { this.customerGroup = customerGroup;}

    public int getIsInternalCustomer() { return isInternalCustomer;}
    public void setIsInternalCustomer(int isInternalCustomer) { this.isInternalCustomer = isInternalCustomer;}

    public int getIsDiscounted() { return isDiscounted;}
    public void setIsDiscounted(int isDiscounted) { this.isDiscounted = isDiscounted;}

    public String getRemarks() { return remarks;}
    public void setRemarks(String remarks) { this.remarks = remarks;}
}