package itu.prom16.ERPNextClient.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Fanou
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplierQuotationDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("owner")
    private String owner;

    @JsonProperty("creation")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime creation;

    @JsonProperty("modified")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
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

    @JsonProperty("status")
    private String status;

    @JsonProperty("transaction_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate transactionDate;

    @JsonProperty("valid_till")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate validTill;

    @JsonProperty("quotation_number")
    private String quotationNumber;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("conversion_rate")
    private double conversionRate;

    @JsonProperty("buying_price_list")
    private String buyingPriceList;

    @JsonProperty("price_list_currency")
    private String priceListCurrency;

    @JsonProperty("plc_conversion_rate")
    private double plcConversionRate;

    @JsonProperty("ignore_pricing_rule")
    private int ignorePricingRule;

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

    @JsonProperty("apply_discount_on")
    private String applyDiscountOn;

    @JsonProperty("base_discount_amount")
    private double baseDiscountAmount;

    @JsonProperty("additional_discount_percentage")
    private double additionalDiscountPercentage;

    @JsonProperty("discount_amount")
    private double discountAmount;

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

    @JsonProperty("rounded_total")
    private double roundedTotal;

    @JsonProperty("in_words")
    private String inWords;

    @JsonProperty("disable_rounded_total")
    private int disableRoundedTotal;

    @JsonProperty("shipping_address")
    private String shippingAddress;

    @JsonProperty("shipping_address_display")
    private String shippingAddressDisplay;

    @JsonProperty("billing_address")
    private String billingAddress;

    @JsonProperty("billing_address_display")
    private String billingAddressDisplay;

    @JsonProperty("group_same_items")
    private int groupSameItems;

    @JsonProperty("language")
    private String language;

    @JsonProperty("is_subcontracted")
    private int isSubcontracted;

    @JsonProperty("doctype")
    private String doctype;

    @JsonProperty("items")
    private List<SupplierQuotationItemDTO> items;

    public SupplierQuotationDTO() {
    }

    public SupplierQuotationDTO(String name, String owner, LocalDateTime creation, LocalDateTime modified, String modifiedBy, int docstatus, int idx, String title, String namingSeries, String supplier, String supplierName, String company, String status, LocalDate transactionDate, LocalDate validTill, String quotationNumber, String currency, double conversionRate, String buyingPriceList, String priceListCurrency, double plcConversionRate, int ignorePricingRule, double totalQty, double totalNetWeight, double baseTotal, double baseNetTotal, double total, double netTotal, String taxCategory, double baseTaxesAndChargesAdded, double baseTaxesAndChargesDeducted, double baseTotalTaxesAndCharges, double taxesAndChargesAdded, double taxesAndChargesDeducted, double totalTaxesAndCharges, String applyDiscountOn, double baseDiscountAmount, double additionalDiscountPercentage, double discountAmount, double baseGrandTotal, double baseRoundingAdjustment, double baseRoundedTotal, String baseInWords, double grandTotal, double roundingAdjustment, double roundedTotal, String inWords, int disableRoundedTotal, String shippingAddress, String shippingAddressDisplay, String billingAddress, String billingAddressDisplay, int groupSameItems, String language, int isSubcontracted, String doctype, List<SupplierQuotationItemDTO> items) {
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
        this.status = status;
        this.transactionDate = transactionDate;
        this.validTill = validTill;
        this.quotationNumber = quotationNumber;
        this.currency = currency;
        this.conversionRate = conversionRate;
        this.buyingPriceList = buyingPriceList;
        this.priceListCurrency = priceListCurrency;
        this.plcConversionRate = plcConversionRate;
        this.ignorePricingRule = ignorePricingRule;
        this.totalQty = totalQty;
        this.totalNetWeight = totalNetWeight;
        this.baseTotal = baseTotal;
        this.baseNetTotal = baseNetTotal;
        this.total = total;
        this.netTotal = netTotal;
        this.taxCategory = taxCategory;
        this.baseTaxesAndChargesAdded = baseTaxesAndChargesAdded;
        this.baseTaxesAndChargesDeducted = baseTaxesAndChargesDeducted;
        this.baseTotalTaxesAndCharges = baseTotalTaxesAndCharges;
        this.taxesAndChargesAdded = taxesAndChargesAdded;
        this.taxesAndChargesDeducted = taxesAndChargesDeducted;
        this.totalTaxesAndCharges = totalTaxesAndCharges;
        this.applyDiscountOn = applyDiscountOn;
        this.baseDiscountAmount = baseDiscountAmount;
        this.additionalDiscountPercentage = additionalDiscountPercentage;
        this.discountAmount = discountAmount;
        this.baseGrandTotal = baseGrandTotal;
        this.baseRoundingAdjustment = baseRoundingAdjustment;
        this.baseRoundedTotal = baseRoundedTotal;
        this.baseInWords = baseInWords;
        this.grandTotal = grandTotal;
        this.roundingAdjustment = roundingAdjustment;
        this.roundedTotal = roundedTotal;
        this.inWords = inWords;
        this.disableRoundedTotal = disableRoundedTotal;
        this.shippingAddress = shippingAddress;
        this.shippingAddressDisplay = shippingAddressDisplay;
        this.billingAddress = billingAddress;
        this.billingAddressDisplay = billingAddressDisplay;
        this.groupSameItems = groupSameItems;
        this.language = language;
        this.isSubcontracted = isSubcontracted;
        this.doctype = doctype;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public LocalDateTime getCreation() {
        return creation;
    }

    public void setCreation(LocalDateTime creation) {
        this.creation = creation;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public int getDocstatus() {
        return docstatus;
    }

    public void setDocstatus(int docstatus) {
        this.docstatus = docstatus;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNamingSeries() {
        return namingSeries;
    }

    public void setNamingSeries(String namingSeries) {
        this.namingSeries = namingSeries;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalDate getValidTill() {
        return validTill;
    }

    public void setValidTill(LocalDate validTill) {
        this.validTill = validTill;
    }

    public String getQuotationNumber() {
        return quotationNumber;
    }

    public void setQuotationNumber(String quotationNumber) {
        this.quotationNumber = quotationNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public String getBuyingPriceList() {
        return buyingPriceList;
    }

    public void setBuyingPriceList(String buyingPriceList) {
        this.buyingPriceList = buyingPriceList;
    }

    public String getPriceListCurrency() {
        return priceListCurrency;
    }

    public void setPriceListCurrency(String priceListCurrency) {
        this.priceListCurrency = priceListCurrency;
    }

    public double getPlcConversionRate() {
        return plcConversionRate;
    }

    public void setPlcConversionRate(double plcConversionRate) {
        this.plcConversionRate = plcConversionRate;
    }

    public int getIgnorePricingRule() {
        return ignorePricingRule;
    }

    public void setIgnorePricingRule(int ignorePricingRule) {
        this.ignorePricingRule = ignorePricingRule;
    }

    public double getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(double totalQty) {
        this.totalQty = totalQty;
    }

    public double getTotalNetWeight() {
        return totalNetWeight;
    }

    public void setTotalNetWeight(double totalNetWeight) {
        this.totalNetWeight = totalNetWeight;
    }

    public double getBaseTotal() {
        return baseTotal;
    }

    public void setBaseTotal(double baseTotal) {
        this.baseTotal = baseTotal;
    }

    public double getBaseNetTotal() {
        return baseNetTotal;
    }

    public void setBaseNetTotal(double baseNetTotal) {
        this.baseNetTotal = baseNetTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(double netTotal) {
        this.netTotal = netTotal;
    }

    public String getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(String taxCategory) {
        this.taxCategory = taxCategory;
    }

    public double getBaseTaxesAndChargesAdded() {
        return baseTaxesAndChargesAdded;
    }

    public void setBaseTaxesAndChargesAdded(double baseTaxesAndChargesAdded) {
        this.baseTaxesAndChargesAdded = baseTaxesAndChargesAdded;
    }

    public double getBaseTaxesAndChargesDeducted() {
        return baseTaxesAndChargesDeducted;
    }

    public void setBaseTaxesAndChargesDeducted(double baseTaxesAndChargesDeducted) {
        this.baseTaxesAndChargesDeducted = baseTaxesAndChargesDeducted;
    }

    public double getBaseTotalTaxesAndCharges() {
        return baseTotalTaxesAndCharges;
    }

    public void setBaseTotalTaxesAndCharges(double baseTotalTaxesAndCharges) {
        this.baseTotalTaxesAndCharges = baseTotalTaxesAndCharges;
    }

    public double getTaxesAndChargesAdded() {
        return taxesAndChargesAdded;
    }

    public void setTaxesAndChargesAdded(double taxesAndChargesAdded) {
        this.taxesAndChargesAdded = taxesAndChargesAdded;
    }

    public double getTaxesAndChargesDeducted() {
        return taxesAndChargesDeducted;
    }

    public void setTaxesAndChargesDeducted(double taxesAndChargesDeducted) {
        this.taxesAndChargesDeducted = taxesAndChargesDeducted;
    }

    public double getTotalTaxesAndCharges() {
        return totalTaxesAndCharges;
    }

    public void setTotalTaxesAndCharges(double totalTaxesAndCharges) {
        this.totalTaxesAndCharges = totalTaxesAndCharges;
    }

    public String getApplyDiscountOn() {
        return applyDiscountOn;
    }

    public void setApplyDiscountOn(String applyDiscountOn) {
        this.applyDiscountOn = applyDiscountOn;
    }

    public double getBaseDiscountAmount() {
        return baseDiscountAmount;
    }

    public void setBaseDiscountAmount(double baseDiscountAmount) {
        this.baseDiscountAmount = baseDiscountAmount;
    }

    public double getAdditionalDiscountPercentage() {
        return additionalDiscountPercentage;
    }

    public void setAdditionalDiscountPercentage(double additionalDiscountPercentage) {
        this.additionalDiscountPercentage = additionalDiscountPercentage;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getBaseGrandTotal() {
        return baseGrandTotal;
    }

    public void setBaseGrandTotal(double baseGrandTotal) {
        this.baseGrandTotal = baseGrandTotal;
    }

    public double getBaseRoundingAdjustment() {
        return baseRoundingAdjustment;
    }

    public void setBaseRoundingAdjustment(double baseRoundingAdjustment) {
        this.baseRoundingAdjustment = baseRoundingAdjustment;
    }

    public double getBaseRoundedTotal() {
        return baseRoundedTotal;
    }

    public void setBaseRoundedTotal(double baseRoundedTotal) {
        this.baseRoundedTotal = baseRoundedTotal;
    }

    public String getBaseInWords() {
        return baseInWords;
    }

    public void setBaseInWords(String baseInWords) {
        this.baseInWords = baseInWords;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public double getRoundingAdjustment() {
        return roundingAdjustment;
    }

    public void setRoundingAdjustment(double roundingAdjustment) {
        this.roundingAdjustment = roundingAdjustment;
    }

    public double getRoundedTotal() {
        return roundedTotal;
    }

    public void setRoundedTotal(double roundedTotal) {
        this.roundedTotal = roundedTotal;
    }

    public String getInWords() {
        return inWords;
    }

    public void setInWords(String inWords) {
        this.inWords = inWords;
    }

    public int getDisableRoundedTotal() {
        return disableRoundedTotal;
    }

    public void setDisableRoundedTotal(int disableRoundedTotal) {
        this.disableRoundedTotal = disableRoundedTotal;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingAddressDisplay() {
        return shippingAddressDisplay;
    }

    public void setShippingAddressDisplay(String shippingAddressDisplay) {
        this.shippingAddressDisplay = shippingAddressDisplay;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBillingAddressDisplay() {
        return billingAddressDisplay;
    }

    public void setBillingAddressDisplay(String billingAddressDisplay) {
        this.billingAddressDisplay = billingAddressDisplay;
    }

    public int getGroupSameItems() {
        return groupSameItems;
    }

    public void setGroupSameItems(int groupSameItems) {
        this.groupSameItems = groupSameItems;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getIsSubcontracted() {
        return isSubcontracted;
    }

    public void setIsSubcontracted(int isSubcontracted) {
        this.isSubcontracted = isSubcontracted;
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    public List<SupplierQuotationItemDTO> getItems() {
        return items;
    }

    public void setItems(List<SupplierQuotationItemDTO> items) {
        this.items = items;
    }
}
