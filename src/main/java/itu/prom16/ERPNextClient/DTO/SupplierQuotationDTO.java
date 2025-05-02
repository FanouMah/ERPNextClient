package itu.prom16.ERPNextClient.DTO;

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
    private String creation;

    @JsonProperty("modified")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private String modified;

    @JsonProperty("modified_by")
    private String modifiedBy;

    @JsonProperty("docstatus")
    private Integer docstatus;

    @JsonProperty("idx")
    private Integer idx;

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
    private String transactionDate;

    @JsonProperty("valid_till")
    private String validTill;

    @JsonProperty("quotation_number")
    private String quotationNumber;

    @JsonProperty("amended_from")
    private String amendedFrom;

    @JsonProperty("cost_center")
    private String costCenter;

    @JsonProperty("project")
    private String project;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("conversion_rate")
    private Double conversionRate;

    @JsonProperty("buying_price_list")
    private String buyingPriceList;

    @JsonProperty("price_list_currency")
    private String priceListCurrency;

    @JsonProperty("plc_conversion_rate")
    private Double plcConversionRate;

    @JsonProperty("ignore_pricing_rule")
    private Integer ignorePricingRule;

    @JsonProperty("total_qty")
    private Double totalQty;

    @JsonProperty("total_net_weight")
    private Double totalNetWeight;

    @JsonProperty("base_total")
    private Double baseTotal;

    @JsonProperty("base_net_total")
    private Double baseNetTotal;

    @JsonProperty("total")
    private Double total;

    @JsonProperty("net_total")
    private Double netTotal;

    @JsonProperty("tax_category")
    private String taxCategory;

    @JsonProperty("taxes_and_charges")
    private String taxesAndCharges;

    @JsonProperty("shipping_rule")
    private String shippingRule;

    @JsonProperty("incoterm")
    private String incoterm;

    @JsonProperty("named_place")
    private String namedPlace;

    @JsonProperty("base_taxes_and_charges_added")
    private Double baseTaxesAndChargesAdded;

    @JsonProperty("base_taxes_and_charges_deducted")
    private Double baseTaxesAndChargesDeducted;

    @JsonProperty("base_total_taxes_and_charges")
    private Double baseTotalTaxesAndCharges;

    @JsonProperty("taxes_and_charges_added")
    private Double taxesAndChargesAdded;

    @JsonProperty("taxes_and_charges_deducted")
    private Double taxesAndChargesDeducted;

    @JsonProperty("total_taxes_and_charges")
    private Double totalTaxesAndCharges;

    @JsonProperty("apply_discount_on")
    private String applyDiscountOn;

    @JsonProperty("base_discount_amount")
    private Double baseDiscountAmount;

    @JsonProperty("additional_discount_percentage")
    private Double additionalDiscountPercentage;

    @JsonProperty("discount_amount")
    private Double discountAmount;

    @JsonProperty("base_grand_total")
    private Double baseGrandTotal;

    @JsonProperty("base_rounding_adjustment")
    private Double baseRoundingAdjustment;

    @JsonProperty("base_rounded_total")
    private Double baseRoundedTotal;

    @JsonProperty("base_in_words")
    private String baseInWords;

    @JsonProperty("grand_total")
    private Double grandTotal;

    @JsonProperty("rounding_adjustment")
    private Double roundingAdjustment;

    @JsonProperty("rounded_total")
    private Double roundedTotal;

    @JsonProperty("in_words")
    private String inWords;

    @JsonProperty("disable_rounded_total")
    private Integer disableRoundedTotal;

    @JsonProperty("other_charges_calculation")
    private String otherChargesCalculation;

    @JsonProperty("supplier_address")
    private String supplierAddress;

    @JsonProperty("address_display")
    private String addressDisplay;

    @JsonProperty("contact_person")
    private String contactPerson;

    @JsonProperty("contact_display")
    private String contactDisplay;

    @JsonProperty("contact_mobile")
    private String contactMobile;

    @JsonProperty("contact_email")
    private String contactEmail;

    @JsonProperty("shipping_address")
    private String shippingAddress;

    @JsonProperty("shipping_address_display")
    private String shippingAddressDisplay;

    @JsonProperty("billing_address")
    private String billingAddress;

    @JsonProperty("billing_address_display")
    private String billingAddressDisplay;

    @JsonProperty("tc_name")
    private String tcName;

    @JsonProperty("terms")
    private String terms;

    @JsonProperty("letter_head")
    private String letterHead;

    @JsonProperty("group_same_items")
    private Integer groupSameItems;

    @JsonProperty("select_print_heading")
    private String selectPrintHeading;

    @JsonProperty("language")
    private String language;

    @JsonProperty("auto_repeat")
    private String autoRepeat;

    @JsonProperty("is_subcontracted")
    private Integer isSubcontracted;

    @JsonProperty("opportunity")
    private String opportunity;

    // Default constructor
    public SupplierQuotationDTO() {
    }

    // Parameterized constructor
    public SupplierQuotationDTO(String name, String owner, String creation, String modified, String modifiedBy, Integer docstatus, Integer idx, String title, String namingSeries, String supplier, String supplierName, String company, String status, String transactionDate, String validTill, String quotationNumber, String amendedFrom, String costCenter, String project, String currency, Double conversionRate, String buyingPriceList, String priceListCurrency, Double plcConversionRate, Integer ignorePricingRule, Double totalQty, Double totalNetWeight, Double baseTotal, Double baseNetTotal, Double total, Double netTotal, String taxCategory, String taxesAndCharges, String shippingRule, String incoterm, String namedPlace, Double baseTaxesAndChargesAdded, Double baseTaxesAndChargesDeducted, Double baseTotalTaxesAndCharges, Double taxesAndChargesAdded, Double taxesAndChargesDeducted, Double totalTaxesAndCharges, String applyDiscountOn, Double baseDiscountAmount, Double additionalDiscountPercentage, Double discountAmount, Double baseGrandTotal, Double baseRoundingAdjustment, Double baseRoundedTotal, String baseInWords, Double grandTotal, Double roundingAdjustment, Double roundedTotal, String inWords, Integer disableRoundedTotal, String otherChargesCalculation, String supplierAddress, String addressDisplay, String contactPerson, String contactDisplay, String contactMobile, String contactEmail, String shippingAddress, String shippingAddressDisplay, String billingAddress, String billingAddressDisplay, String tcName, String terms, String letterHead, Integer groupSameItems, String selectPrintHeading, String language, String autoRepeat, Integer isSubcontracted, String opportunity) {
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
        this.amendedFrom = amendedFrom;
        this.costCenter = costCenter;
        this.project = project;
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
        this.taxesAndCharges = taxesAndCharges;
        this.shippingRule = shippingRule;
        this.incoterm = incoterm;
        this.namedPlace = namedPlace;
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
        this.otherChargesCalculation = otherChargesCalculation;
        this.supplierAddress = supplierAddress;
        this.addressDisplay = addressDisplay;
        this.contactPerson = contactPerson;
        this.contactDisplay = contactDisplay;
        this.contactMobile = contactMobile;
        this.contactEmail = contactEmail;
        this.shippingAddress = shippingAddress;
        this.shippingAddressDisplay = shippingAddressDisplay;
        this.billingAddress = billingAddress;
        this.billingAddressDisplay = billingAddressDisplay;
        this.tcName = tcName;
        this.terms = terms;
        this.letterHead = letterHead;
        this.groupSameItems = groupSameItems;
        this.selectPrintHeading = selectPrintHeading;
        this.language = language;
        this.autoRepeat = autoRepeat;
        this.isSubcontracted = isSubcontracted;
        this.opportunity = opportunity;
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

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Integer getDocstatus() {
        return docstatus;
    }

    public void setDocstatus(Integer docstatus) {
        this.docstatus = docstatus;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
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

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getValidTill() {
        return validTill;
    }

    public void setValidTill(String validTill) {
        this.validTill = validTill;
    }

    public String getQuotationNumber() {
        return quotationNumber;
    }

    public void setQuotationNumber(String quotationNumber) {
        this.quotationNumber = quotationNumber;
    }

    public String getAmendedFrom() {
        return amendedFrom;
    }

    public void setAmendedFrom(String amendedFrom) {
        this.amendedFrom = amendedFrom;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
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

    public Double getPlcConversionRate() {
        return plcConversionRate;
    }

    public void setPlcConversionRate(Double plcConversionRate) {
        this.plcConversionRate = plcConversionRate;
    }

    public Integer getIgnorePricingRule() {
        return ignorePricingRule;
    }

    public void setIgnorePricingRule(Integer ignorePricingRule) {
        this.ignorePricingRule = ignorePricingRule;
    }

    public Double getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(Double totalQty) {
        this.totalQty = totalQty;
    }

    public Double getTotalNetWeight() {
        return totalNetWeight;
    }

    public void setTotalNetWeight(Double totalNetWeight) {
        this.totalNetWeight = totalNetWeight;
    }

    public Double getBaseTotal() {
        return baseTotal;
    }

    public void setBaseTotal(Double baseTotal) {
        this.baseTotal = baseTotal;
    }

    public Double getBaseNetTotal() {
        return baseNetTotal;
    }

    public void setBaseNetTotal(Double baseNetTotal) {
        this.baseNetTotal = baseNetTotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(Double netTotal) {
        this.netTotal = netTotal;
    }

    public String getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(String taxCategory) {
        this.taxCategory = taxCategory;
    }

    public String getTaxesAndCharges() {
        return taxesAndCharges;
    }

    public void setTaxesAndCharges(String taxesAndCharges) {
        this.taxesAndCharges = taxesAndCharges;
    }

    public String getShippingRule() {
        return shippingRule;
    }

    public void setShippingRule(String shippingRule) {
        this.shippingRule = shippingRule;
    }

    public String getIncoterm() {
        return incoterm;
    }

    public void setIncoterm(String incoterm) {
        this.incoterm = incoterm;
    }

    public String getNamedPlace() {
        return namedPlace;
    }

    public void setNamedPlace(String namedPlace) {
        this.namedPlace = namedPlace;
    }

    public Double getBaseTaxesAndChargesAdded() {
        return baseTaxesAndChargesAdded;
    }

    public void setBaseTaxesAndChargesAdded(Double baseTaxesAndChargesAdded) {
        this.baseTaxesAndChargesAdded = baseTaxesAndChargesAdded;
    }

    public Double getBaseTaxesAndChargesDeducted() {
        return baseTaxesAndChargesDeducted;
    }

    public void setBaseTaxesAndChargesDeducted(Double baseTaxesAndChargesDeducted) {
        this.baseTaxesAndChargesDeducted = baseTaxesAndChargesDeducted;
    }

    public Double getBaseTotalTaxesAndCharges() {
        return baseTotalTaxesAndCharges;
    }

    public void setBaseTotalTaxesAndCharges(Double baseTotalTaxesAndCharges) {
        this.baseTotalTaxesAndCharges = baseTotalTaxesAndCharges;
    }

    public Double getTaxesAndChargesAdded() {
        return taxesAndChargesAdded;
    }

    public void setTaxesAndChargesAdded(Double taxesAndChargesAdded) {
        this.taxesAndChargesAdded = taxesAndChargesAdded;
    }

    public Double getTaxesAndChargesDeducted() {
        return taxesAndChargesDeducted;
    }

    public void setTaxesAndChargesDeducted(Double taxesAndChargesDeducted) {
        this.taxesAndChargesDeducted = taxesAndChargesDeducted;
    }

    public Double getTotalTaxesAndCharges() {
        return totalTaxesAndCharges;
    }

    public void setTotalTaxesAndCharges(Double totalTaxesAndCharges) {
        this.totalTaxesAndCharges = totalTaxesAndCharges;
    }

    public String getApplyDiscountOn() {
        return applyDiscountOn;
    }

    public void setApplyDiscountOn(String applyDiscountOn) {
        this.applyDiscountOn = applyDiscountOn;
    }

    public Double getBaseDiscountAmount() {
        return baseDiscountAmount;
    }

    public void setBaseDiscountAmount(Double baseDiscountAmount) {
        this.baseDiscountAmount = baseDiscountAmount;
    }

    public Double getAdditionalDiscountPercentage() {
        return additionalDiscountPercentage;
    }

    public void setAdditionalDiscountPercentage(Double additionalDiscountPercentage) {
        this.additionalDiscountPercentage = additionalDiscountPercentage;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getBaseGrandTotal() {
        return baseGrandTotal;
    }

    public void setBaseGrandTotal(Double baseGrandTotal) {
        this.baseGrandTotal = baseGrandTotal;
    }

    public Double getBaseRoundingAdjustment() {
        return baseRoundingAdjustment;
    }

    public void setBaseRoundingAdjustment(Double baseRoundingAdjustment) {
        this.baseRoundingAdjustment = baseRoundingAdjustment;
    }

    public Double getBaseRoundedTotal() {
        return baseRoundedTotal;
    }

    public void setBaseRoundedTotal(Double baseRoundedTotal) {
        this.baseRoundedTotal = baseRoundedTotal;
    }

    public String getBaseInWords() {
        return baseInWords;
    }

    public void setBaseInWords(String baseInWords) {
        this.baseInWords = baseInWords;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Double getRoundingAdjustment() {
        return roundingAdjustment;
    }

    public void setRoundingAdjustment(Double roundingAdjustment) {
        this.roundingAdjustment = roundingAdjustment;
    }

    public Double getRoundedTotal() {
        return roundedTotal;
    }

    public void setRoundedTotal(Double roundedTotal) {
        this.roundedTotal = roundedTotal;
    }

    public String getInWords() {
        return inWords;
    }

    public void setInWords(String inWords) {
        this.inWords = inWords;
    }

    public Integer getDisableRoundedTotal() {
        return disableRoundedTotal;
    }

    public void setDisableRoundedTotal(Integer disableRoundedTotal) {
        this.disableRoundedTotal = disableRoundedTotal;
    }

    public String getOtherChargesCalculation() {
        return otherChargesCalculation;
    }

    public void setOtherChargesCalculation(String otherChargesCalculation) {
        this.otherChargesCalculation = otherChargesCalculation;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getAddressDisplay() {
        return addressDisplay;
    }

    public void setAddressDisplay(String addressDisplay) {
        this.addressDisplay = addressDisplay;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactDisplay() {
        return contactDisplay;
    }

    public void setContactDisplay(String contactDisplay) {
        this.contactDisplay = contactDisplay;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
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

    public String getTcName() {
        return tcName;
    }

    public void setTcName(String tcName) {
        this.tcName = tcName;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getLetterHead() {
        return letterHead;
    }

    public void setLetterHead(String letterHead) {
        this.letterHead = letterHead;
    }

    public Integer getGroupSameItems() {
        return groupSameItems;
    }

    public void setGroupSameItems(Integer groupSameItems) {
        this.groupSameItems = groupSameItems;
    }

    public String getSelectPrintHeading() {
        return selectPrintHeading;
    }

    public void setSelectPrintHeading(String selectPrintHeading) {
        this.selectPrintHeading = selectPrintHeading;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAutoRepeat() {
        return autoRepeat;
    }

    public void setAutoRepeat(String autoRepeat) {
        this.autoRepeat = autoRepeat;
    }

    public Integer getIsSubcontracted() {
        return isSubcontracted;
    }

    public void setIsSubcontracted(Integer isSubcontracted) {
        this.isSubcontracted = isSubcontracted;
    }

    public String getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(String opportunity) {
        this.opportunity = opportunity;
    }
}
