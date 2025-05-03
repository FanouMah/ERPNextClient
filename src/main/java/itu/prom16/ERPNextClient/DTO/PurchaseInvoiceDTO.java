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
public class PurchaseInvoiceDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private String owner;
    @JsonProperty("creation")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime creation;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    @JsonProperty("modified")
    private LocalDateTime modified;
    @JsonProperty("modified_by")
    private String modifiedBy;
    @JsonProperty("docstatus")
    private int docstatus;
    @JsonProperty("idx")
    private int idx;
    @JsonProperty("title")
    private String title;
    @JsonProperty("naming_series")
    private String namingSeries;
    @JsonProperty("supplier")
    private String supplier;
    @JsonProperty("supplier_name")
    private String supplierName;
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
    @JsonProperty("is_paid")
    private int isPaid;
    @JsonProperty("is_return")
    private int isReturn;
    @JsonProperty("update_outstanding_for_self")
    private int updateOutstandingForSelf;
    @JsonProperty("update_billed_amount_in_purchase_order")
    private int updateBilledAmountInPurchaseOrder;
    @JsonProperty("update_billed_amount_in_purchase_receipt")
    private int updateBilledAmountInPurchaseReceipt;
    @JsonProperty("apply_tds")
    private int applyTds;
    @JsonProperty("bill_date")
    private String billDate;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("conversion_rate")
    private double conversionRate;
    @JsonProperty("use_transaction_date_exchange_rate")
    private int useTransactionDateExchangeRate;
    @JsonProperty("buying_price_list")
    private String buyingPriceList;
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
    @JsonProperty("total_net_weight")
    private double totalNetWeight;
    @JsonProperty("base_total")
    private double baseTotal;
    @JsonProperty("base_net_total")
    private double baseNetTotal;
    @JsonProperty("total")
    private double total;
    @JsonProperty("net_total")
    private double netTotal;
    @JsonProperty("tax_withholding_net_total")
    private double taxWithholdingNetTotal;
    @JsonProperty("base_tax_withholding_net_total")
    private double baseTaxWithholdingNetTotal;
    @JsonProperty("tax_category")
    private String taxCategory;
    @JsonProperty("base_taxes_and_charges_added")
    private double baseTaxesAndChargesAdded;
    @JsonProperty("base_taxes_and_charges_deducted")
    private double baseTaxesAndChargesDeducted;
    @JsonProperty("base_total_taxes_and_charges")
    private double baseTotalTaxesAndCharges;
    @JsonProperty("taxes_and_charges_added")
    private double taxesAndChargesAdded;
    @JsonProperty("taxes_and_charges_deducted")
    private double taxesAndChargesDeducted;
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
    @JsonProperty("additional_discount_percentage")
    private double additionalDiscountPercentage;
    @JsonProperty("discount_amount")
    private double discountAmount;
    @JsonProperty("base_paid_amount")
    private double basePaidAmount;
    @JsonProperty("paid_amount")
    private double paidAmount;
    @JsonProperty("allocate_advances_automatically")
    private int allocateAdvancesAutomatically;
    @JsonProperty("only_include_allocated_payments")
    private int onlyIncludeAllocatedPayments;
    @JsonProperty("write_off_amount")
    private double writeOffAmount;
    @JsonProperty("base_write_off_amount")
    private double baseWriteOffAmount;
    @JsonProperty("status")
    private String status;
    @JsonProperty("per_received")
    private double perReceived;
    @JsonProperty("credit_to")
    private String creditTo;
    @JsonProperty("party_account_currency")
    private String partyAccountCurrency;
    @JsonProperty("is_opening")
    private String isOpening;
    @JsonProperty("against_expense_account")
    private String againstExpenseAccount;
    @JsonProperty("language")
    private String language;
    @JsonProperty("on_hold")
    private int onHold;
    @JsonProperty("is_internal_supplier")
    private int isInternalSupplier;
    @JsonProperty("supplier_group")
    private String supplierGroup;
    @JsonProperty("remarks")
    private String remarks;

    public PurchaseInvoiceDTO() {}

    public PurchaseInvoiceDTO(String name, String owner, LocalDateTime creation, LocalDateTime modified, String modifiedBy, int docstatus, int idx, String title, String namingSeries, String supplier, String supplierName, String company, LocalDate postingDate, LocalTime postingTime, int setPostingTime, LocalDate dueDate, int isPaid, int isReturn, int updateOutstandingForSelf, int updateBilledAmountInPurchaseOrder, int updateBilledAmountInPurchaseReceipt, int applyTds, String billDate, String currency, double conversionRate, int useTransactionDateExchangeRate, String buyingPriceList, String priceListCurrency, double plcConversionRate, int ignorePricingRule, int updateStock, String setWarehouse, double totalQty, double totalNetWeight, double baseTotal, double baseNetTotal, double total, double netTotal, double taxWithholdingNetTotal, double baseTaxWithholdingNetTotal, String taxCategory, double baseTaxesAndChargesAdded, double baseTaxesAndChargesDeducted, double baseTotalTaxesAndCharges, double taxesAndChargesAdded, double taxesAndChargesDeducted, double totalTaxesAndCharges, double baseGrandTotal, double baseRoundingAdjustment, double baseRoundedTotal, String baseInWords, double grandTotal, double roundingAdjustment, int useCompanyRoundoffCostCenter, double roundedTotal, String inWords, double totalAdvance, double outstandingAmount, int disableRoundedTotal, String applyDiscountOn, double baseDiscountAmount, double additionalDiscountPercentage, double discountAmount, double basePaidAmount, double paidAmount, int allocateAdvancesAutomatically, int onlyIncludeAllocatedPayments, double writeOffAmount, double baseWriteOffAmount, String status, double perReceived, String creditTo, String partyAccountCurrency, String isOpening, String againstExpenseAccount, String language, int onHold, int isInternalSupplier, String supplierGroup, String remarks) {
        this.name = name;
        this.owner = owner;
        this.creation = creation;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
        this.docstatus = docstatus;
        this.idx = idx;
        this.title = title;
        this.namingSeries = namingSeries;
        this.supplier = supplier;
        this.supplierName = supplierName;
        this.company = company;
        this.postingDate = postingDate;
        this.postingTime = postingTime;
        this.setPostingTime = setPostingTime;
        this.dueDate = dueDate;
        this.isPaid = isPaid;
        this.isReturn = isReturn;
        this.updateOutstandingForSelf = updateOutstandingForSelf;
        this.updateBilledAmountInPurchaseOrder = updateBilledAmountInPurchaseOrder;
        this.updateBilledAmountInPurchaseReceipt = updateBilledAmountInPurchaseReceipt;
        this.applyTds = applyTds;
        this.billDate = billDate;
        this.currency = currency;
        this.conversionRate = conversionRate;
        this.useTransactionDateExchangeRate = useTransactionDateExchangeRate;
        this.buyingPriceList = buyingPriceList;
        this.priceListCurrency = priceListCurrency;
        this.plcConversionRate = plcConversionRate;
        this.ignorePricingRule = ignorePricingRule;
        this.updateStock = updateStock;
        this.setWarehouse = setWarehouse;
        this.totalQty = totalQty;
        this.totalNetWeight = totalNetWeight;
        this.baseTotal = baseTotal;
        this.baseNetTotal = baseNetTotal;
        this.total = total;
        this.netTotal = netTotal;
        this.taxWithholdingNetTotal = taxWithholdingNetTotal;
        this.baseTaxWithholdingNetTotal = baseTaxWithholdingNetTotal;
        this.taxCategory = taxCategory;
        this.baseTaxesAndChargesAdded = baseTaxesAndChargesAdded;
        this.baseTaxesAndChargesDeducted = baseTaxesAndChargesDeducted;
        this.baseTotalTaxesAndCharges = baseTotalTaxesAndCharges;
        this.taxesAndChargesAdded = taxesAndChargesAdded;
        this.taxesAndChargesDeducted = taxesAndChargesDeducted;
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
        this.additionalDiscountPercentage = additionalDiscountPercentage;
        this.discountAmount = discountAmount;
        this.basePaidAmount = basePaidAmount;
        this.paidAmount = paidAmount;
        this.allocateAdvancesAutomatically = allocateAdvancesAutomatically;
        this.onlyIncludeAllocatedPayments = onlyIncludeAllocatedPayments;
        this.writeOffAmount = writeOffAmount;
        this.baseWriteOffAmount = baseWriteOffAmount;
        this.status = status;
        this.perReceived = perReceived;
        this.creditTo = creditTo;
        this.partyAccountCurrency = partyAccountCurrency;
        this.isOpening = isOpening;
        this.againstExpenseAccount = againstExpenseAccount;
        this.language = language;
        this.onHold = onHold;
        this.isInternalSupplier = isInternalSupplier;
        this.supplierGroup = supplierGroup;
        this.remarks = remarks;
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

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getNamingSeries() { return namingSeries; }
    public void setNamingSeries(String namingSeries) { this.namingSeries = namingSeries; }

    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }

    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public LocalDate getPostingDate() { return postingDate; }
    public void setPostingDate(LocalDate postingDate) { this.postingDate = postingDate; }

    public LocalTime getPostingTime() { return postingTime; }
    public void setPostingTime(LocalTime postingTime) { this.postingTime = postingTime; }

    public int getSetPostingTime() { return setPostingTime; }
    public void setSetPostingTime(int setPostingTime) { this.setPostingTime = setPostingTime; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public int getIsPaid() { return isPaid; }
    public void setIsPaid(int isPaid) { this.isPaid = isPaid; }

    public int getIsReturn() { return isReturn; }
    public void setIsReturn(int isReturn) { this.isReturn = isReturn; }

    public int getUpdateOutstandingForSelf() { return updateOutstandingForSelf; }
    public void setUpdateOutstandingForSelf(int updateOutstandingForSelf) { this.updateOutstandingForSelf = updateOutstandingForSelf; }

    public int getUpdateBilledAmountInPurchaseOrder() { return updateBilledAmountInPurchaseOrder; }
    public void setUpdateBilledAmountInPurchaseOrder(int updateBilledAmountInPurchaseOrder) { this.updateBilledAmountInPurchaseOrder = updateBilledAmountInPurchaseOrder; }

    public int getUpdateBilledAmountInPurchaseReceipt() { return updateBilledAmountInPurchaseReceipt; }
    public void setUpdateBilledAmountInPurchaseReceipt(int updateBilledAmountInPurchaseReceipt) { this.updateBilledAmountInPurchaseReceipt = updateBilledAmountInPurchaseReceipt; }

    public int getApplyTds() { return applyTds; }
    public void setApplyTds(int applyTds) { this.applyTds = applyTds; }

    public String getBillDate() { return billDate; }
    public void setBillDate(String billDate) { this.billDate = billDate; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public double getConversionRate() { return conversionRate; }
    public void setConversionRate(double conversionRate) { this.conversionRate = conversionRate; }

    public int getUseTransactionDateExchangeRate() { return useTransactionDateExchangeRate; }
    public void setUseTransactionDateExchangeRate(int useTransactionDateExchangeRate) { this.useTransactionDateExchangeRate = useTransactionDateExchangeRate; }

    public String getBuyingPriceList() { return buyingPriceList; }
    public void setBuyingPriceList(String buyingPriceList) { this.buyingPriceList = buyingPriceList; }

    public String getPriceListCurrency() { return priceListCurrency; }
    public void setPriceListCurrency(String priceListCurrency) { this.priceListCurrency = priceListCurrency; }

    public double getPlcConversionRate() { return plcConversionRate; }
    public void setPlcConversionRate(double plcConversionRate) { this.plcConversionRate = plcConversionRate; }

    public int getIgnorePricingRule() { return ignorePricingRule; }
    public void setIgnorePricingRule(int ignorePricingRule) { this.ignorePricingRule = ignorePricingRule; }

    public int getUpdateStock() { return updateStock; }
    public void setUpdateStock(int updateStock) { this.updateStock = updateStock; }

    public String getSetWarehouse() { return setWarehouse; }
    public void setSetWarehouse(String setWarehouse) { this.setWarehouse = setWarehouse; }

    public double getTotalQty() { return totalQty; }
    public void setTotalQty(double totalQty) { this.totalQty = totalQty; }

    public double getTotalNetWeight() { return totalNetWeight; }
    public void setTotalNetWeight(double totalNetWeight) { this.totalNetWeight = totalNetWeight; }

    public double getBaseTotal() { return baseTotal; }
    public void setBaseTotal(double baseTotal) { this.baseTotal = baseTotal; }

    public double getBaseNetTotal() { return baseNetTotal; }
    public void setBaseNetTotal(double baseNetTotal) { this.baseNetTotal = baseNetTotal; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public double getNetTotal() { return netTotal; }
    public void setNetTotal(double netTotal) { this.netTotal = netTotal; }

    public double getTaxWithholdingNetTotal() { return taxWithholdingNetTotal; }
    public void setTaxWithholdingNetTotal(double taxWithholdingNetTotal) { this.taxWithholdingNetTotal = taxWithholdingNetTotal; }

    public double getBaseTaxWithholdingNetTotal() { return baseTaxWithholdingNetTotal; }
    public void setBaseTaxWithholdingNetTotal(double baseTaxWithholdingNetTotal) { this.baseTaxWithholdingNetTotal = baseTaxWithholdingNetTotal; }

    public String getTaxCategory() { return taxCategory; }
    public void setTaxCategory(String taxCategory) { this.taxCategory = taxCategory; }

    public double getBaseTaxesAndChargesAdded() { return baseTaxesAndChargesAdded; }
    public void setBaseTaxesAndChargesAdded(double baseTaxesAndChargesAdded) { this.baseTaxesAndChargesAdded = baseTaxesAndChargesAdded; }

    public double getBaseTaxesAndChargesDeducted() { return baseTaxesAndChargesDeducted; }
    public void setBaseTaxesAndChargesDeducted(double baseTaxesAndChargesDeducted) { this.baseTaxesAndChargesDeducted = baseTaxesAndChargesDeducted; }

    public double getBaseTotalTaxesAndCharges() { return baseTotalTaxesAndCharges; }
    public void setBaseTotalTaxesAndCharges(double baseTotalTaxesAndCharges) { this.baseTotalTaxesAndCharges = baseTotalTaxesAndCharges; }

    public double getTaxesAndChargesAdded() { return taxesAndChargesAdded; }
    public void setTaxesAndChargesAdded(double taxesAndChargesAdded) { this.taxesAndChargesAdded = taxesAndChargesAdded; }

    public double getTaxesAndChargesDeducted() { return taxesAndChargesDeducted; }
    public void setTaxesAndChargesDeducted(double taxesAndChargesDeducted) { this.taxesAndChargesDeducted = taxesAndChargesDeducted; }

    public double getTotalTaxesAndCharges() { return totalTaxesAndCharges; }
    public void setTotalTaxesAndCharges(double totalTaxesAndCharges) { this.totalTaxesAndCharges = totalTaxesAndCharges; }

    public double getBaseGrandTotal() { return baseGrandTotal; }
    public void setBaseGrandTotal(double baseGrandTotal) { this.baseGrandTotal = baseGrandTotal; }

    public double getBaseRoundingAdjustment() { return baseRoundingAdjustment; }
    public void setBaseRoundingAdjustment(double baseRoundingAdjustment) { this.baseRoundingAdjustment = baseRoundingAdjustment; }

    public double getBaseRoundedTotal() { return baseRoundedTotal; }
    public void setBaseRoundedTotal(double baseRoundedTotal) { this.baseRoundedTotal = baseRoundedTotal; }

    public String getBaseInWords() { return baseInWords; }
    public void setBaseInWords(String baseInWords) { this.baseInWords = baseInWords; }

    public double getGrandTotal() { return grandTotal; }
    public void setGrandTotal(double grandTotal) { this.grandTotal = grandTotal; }

    public double getRoundingAdjustment() { return roundingAdjustment; }
    public void setRoundingAdjustment(double roundingAdjustment) { this.roundingAdjustment = roundingAdjustment; }

    public int getUseCompanyRoundoffCostCenter() { return useCompanyRoundoffCostCenter; }
    public void setUseCompanyRoundoffCostCenter(int useCompanyRoundoffCostCenter) { this.useCompanyRoundoffCostCenter = useCompanyRoundoffCostCenter; }

    public double getRoundedTotal() { return roundedTotal; }
    public void setRoundedTotal(double roundedTotal) { this.roundedTotal = roundedTotal; }

    public String getInWords() { return inWords; }
    public void setInWords(String inWords) { this.inWords = inWords; }

    public double getTotalAdvance() { return totalAdvance; }
    public void setTotalAdvance(double totalAdvance) { this.totalAdvance = totalAdvance; }

    public double getOutstandingAmount() { return outstandingAmount; }
    public void setOutstandingAmount(double outstandingAmount) { this.outstandingAmount = outstandingAmount; }

    public int getDisableRoundedTotal() { return disableRoundedTotal; }
    public void setDisableRoundedTotal(int disableRoundedTotal) { this.disableRoundedTotal = disableRoundedTotal; }

    public String getApplyDiscountOn() { return applyDiscountOn; }
    public void setApplyDiscountOn(String applyDiscountOn) { this.applyDiscountOn = applyDiscountOn; }

    public double getBaseDiscountAmount() { return baseDiscountAmount; }
    public void setBaseDiscountAmount(double baseDiscountAmount) { this.baseDiscountAmount = baseDiscountAmount; }

    public double getAdditionalDiscountPercentage() { return additionalDiscountPercentage; }
    public void setAdditionalDiscountPercentage(double additionalDiscountPercentage) { this.additionalDiscountPercentage = additionalDiscountPercentage; }

    public double getDiscountAmount() { return discountAmount; }
    public void setDiscountAmount(double discountAmount) { this.discountAmount = discountAmount; }

    public double getBasePaidAmount() { return basePaidAmount; }
    public void setBasePaidAmount(double basePaidAmount) { this.basePaidAmount = basePaidAmount; }

    public double getPaidAmount() { return paidAmount; }
    public void setPaidAmount(double paidAmount) { this.paidAmount = paidAmount; }

    public int getAllocateAdvancesAutomatically() { return allocateAdvancesAutomatically; }
    public void setAllocateAdvancesAutomatically(int allocateAdvancesAutomatically) { this.allocateAdvancesAutomatically = allocateAdvancesAutomatically; }

    public int getOnlyIncludeAllocatedPayments() { return onlyIncludeAllocatedPayments; }
    public void setOnlyIncludeAllocatedPayments(int onlyIncludeAllocatedPayments) { this.onlyIncludeAllocatedPayments = onlyIncludeAllocatedPayments; }

    public double getWriteOffAmount() { return writeOffAmount; }
    public void setWriteOffAmount(double writeOffAmount) { this.writeOffAmount = writeOffAmount; }

    public double getBaseWriteOffAmount() { return baseWriteOffAmount; }
    public void setBaseWriteOffAmount(double baseWriteOffAmount) { this.baseWriteOffAmount = baseWriteOffAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getPerReceived() { return perReceived; }
    public void setPerReceived(double perReceived) { this.perReceived = perReceived; }

    public String getCreditTo() { return creditTo; }
    public void setCreditTo(String creditTo) { this.creditTo = creditTo; }

    public String getPartyAccountCurrency() { return partyAccountCurrency; }
    public void setPartyAccountCurrency(String partyAccountCurrency) { this.partyAccountCurrency = partyAccountCurrency; }

    public String getIsOpening() { return isOpening; }
    public void setIsOpening(String isOpening) { this.isOpening = isOpening; }

    public String getAgainstExpenseAccount() { return againstExpenseAccount; }
    public void setAgainstExpenseAccount(String againstExpenseAccount) { this.againstExpenseAccount = againstExpenseAccount; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public int getOnHold() { return onHold; }
    public void setOnHold(int onHold) { this.onHold = onHold; }

    public int getIsInternalSupplier() { return isInternalSupplier; }
    public void setIsInternalSupplier(int isInternalSupplier) { this.isInternalSupplier = isInternalSupplier; }

    public String getSupplierGroup() { return supplierGroup; }
    public void setSupplierGroup(String supplierGroup) { this.supplierGroup = supplierGroup; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}
