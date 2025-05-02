package itu.prom16.ERPNextClient.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Fanou
 */
public class PurchaseOrderDTO {
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

    @JsonProperty("order_confirmation_no")
    private String orderConfirmationNo;

    @JsonProperty("order_confirmation_date")
    private String orderConfirmationDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("transaction_date")
    private LocalDate transactionDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("schedule_date")
    private LocalDate scheduleDate;

    @JsonProperty("company")
    private String company;

    @JsonProperty("apply_tds")
    private Integer applyTds;

    @JsonProperty("tax_withholding_category")
    private String taxWithholdingCategory;

    @JsonProperty("is_subcontracted")
    private Integer isSubcontracted;

    @JsonProperty("supplier_warehouse")
    private String supplierWarehouse;

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

    @JsonProperty("scan_barcode")
    private String scanBarcode;

    @JsonProperty("set_from_warehouse")
    private String setFromWarehouse;

    @JsonProperty("set_warehouse")
    private String setWarehouse;

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

    @JsonProperty("tax_withholding_net_total")
    private Double taxWithholdingNetTotal;

    @JsonProperty("base_tax_withholding_net_total")
    private Double baseTaxWithholdingNetTotal;

    @JsonProperty("set_reserve_warehouse")
    private String setReserveWarehouse;

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

    @JsonProperty("base_grand_total")
    private Double baseGrandTotal;

    @JsonProperty("base_rounding_adjustment")
    private Double baseRoundingAdjustment;

    @JsonProperty("base_in_words")
    private String baseInWords;

    @JsonProperty("base_rounded_total")
    private Double baseRoundedTotal;

    @JsonProperty("grand_total")
    private Double grandTotal;

    @JsonProperty("rounding_adjustment")
    private Double roundingAdjustment;

    @JsonProperty("rounded_total")
    private Double roundedTotal;

    @JsonProperty("disable_rounded_total")
    private Integer disableRoundedTotal;

    @JsonProperty("in_words")
    private String inWords;

    @JsonProperty("advance_paid")
    private Double advancePaid;

    @JsonProperty("apply_discount_on")
    private String applyDiscountOn;

    @JsonProperty("base_discount_amount")
    private Double baseDiscountAmount;

    @JsonProperty("additional_discount_percentage")
    private Double additionalDiscountPercentage;

    @JsonProperty("discount_amount")
    private Double discountAmount;

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

    @JsonProperty("dispatch_address")
    private String dispatchAddress;

    @JsonProperty("dispatch_address_display")
    private String dispatchAddressDisplay;

    @JsonProperty("shipping_address")
    private String shippingAddress;

    @JsonProperty("shipping_address_display")
    private String shippingAddressDisplay;

    @JsonProperty("billing_address")
    private String billingAddress;

    @JsonProperty("billing_address_display")
    private String billingAddressDisplay;

    @JsonProperty("customer")
    private String customer;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("customer_contact_person")
    private String customerContactPerson;

    @JsonProperty("customer_contact_display")
    private String customerContactDisplay;

    @JsonProperty("customer_contact_mobile")
    private String customerContactMobile;

    @JsonProperty("customer_contact_email")
    private String customerContactEmail;

    @JsonProperty("payment_terms_template")
    private String paymentTermsTemplate;

    @JsonProperty("tc_name")
    private String tcName;

    @JsonProperty("terms")
    private String terms;

    @JsonProperty("status")
    private String status;

    @JsonProperty("per_billed")
    private Double perBilled;

    @JsonProperty("per_received")
    private Double perReceived;

    @JsonProperty("letter_head")
    private String letterHead;

    @JsonProperty("group_same_items")
    private Integer groupSameItems;

    @JsonProperty("select_print_heading")
    private String selectPrintHeading;

    @JsonProperty("language")
    private String language;

    @JsonProperty("from_date")
    private String fromDate;

    @JsonProperty("to_date")
    private String toDate;

    @JsonProperty("auto_repeat")
    private String autoRepeat;

    @JsonProperty("is_internal_supplier")
    private Integer isInternalSupplier;

    @JsonProperty("represents_company")
    private String representsCompany;

    @JsonProperty("ref_sq")
    private String refSq;

    @JsonProperty("party_account_currency")
    private String partyAccountCurrency;

    @JsonProperty("inter_company_order_reference")
    private String interCompanyOrderReference;

    @JsonProperty("is_old_subcontracting_flow")
    private Integer isOldSubcontractingFlow;


    public PurchaseOrderDTO() {
    }

    public PurchaseOrderDTO(String name, String owner, LocalDateTime creation, LocalDateTime modified, String modifiedBy,
                        Integer docstatus, Integer idx, String title, String namingSeries, String supplier,
                        String supplierName, String orderConfirmationNo, String orderConfirmationDate,
                        LocalDate transactionDate, LocalDate scheduleDate, String company, Integer applyTds,
                        String taxWithholdingCategory, Integer isSubcontracted, String supplierWarehouse,
                        String amendedFrom, String costCenter, String project, String currency, Double conversionRate,
                        String buyingPriceList, String priceListCurrency, Double plcConversionRate,
                        Integer ignorePricingRule, String scanBarcode, String setFromWarehouse, String setWarehouse,
                        Double totalQty, Double totalNetWeight, Double baseTotal, Double baseNetTotal, Double total,
                        Double netTotal, Double taxWithholdingNetTotal, Double baseTaxWithholdingNetTotal,
                        String setReserveWarehouse, String taxCategory, String taxesAndCharges, String shippingRule,
                        String incoterm, String namedPlace, Double baseTaxesAndChargesAdded,
                        Double baseTaxesAndChargesDeducted, Double baseTotalTaxesAndCharges,
                        Double taxesAndChargesAdded, Double taxesAndChargesDeducted, Double totalTaxesAndCharges,
                        Double baseGrandTotal, Double baseRoundingAdjustment, String baseInWords,
                        Double baseRoundedTotal, Double grandTotal, Double roundingAdjustment, Double roundedTotal,
                        Integer disableRoundedTotal, String inWords, Double advancePaid, String applyDiscountOn,
                        Double baseDiscountAmount, Double additionalDiscountPercentage, Double discountAmount,
                        String otherChargesCalculation, String supplierAddress, String addressDisplay,
                        String contactPerson, String contactDisplay, String contactMobile, String contactEmail,
                        String dispatchAddress, String dispatchAddressDisplay, String shippingAddress,
                        String shippingAddressDisplay, String billingAddress, String billingAddressDisplay,
                        String customer, String customerName, String customerContactPerson,
                        String customerContactDisplay, String customerContactMobile, String customerContactEmail,
                        String paymentTermsTemplate, String tcName, String terms, String status, Double perBilled,
                        Double perReceived, String letterHead, Integer groupSameItems, String selectPrintHeading,
                        String language, String fromDate, String toDate, String autoRepeat, Integer isInternalSupplier,
                        String representsCompany, String refSq, String partyAccountCurrency,
                        String interCompanyOrderReference, Integer isOldSubcontractingFlow) {
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
        this.orderConfirmationNo = orderConfirmationNo;
        this.orderConfirmationDate = orderConfirmationDate;
        this.transactionDate = transactionDate;
        this.scheduleDate = scheduleDate;
        this.company = company;
        this.applyTds = applyTds;
        this.taxWithholdingCategory = taxWithholdingCategory;
        this.isSubcontracted = isSubcontracted;
        this.supplierWarehouse = supplierWarehouse;
        this.amendedFrom = amendedFrom;
        this.costCenter = costCenter;
        this.project = project;
        this.currency = currency;
        this.conversionRate = conversionRate;
        this.buyingPriceList = buyingPriceList;
        this.priceListCurrency = priceListCurrency;
        this.plcConversionRate = plcConversionRate;
        this.ignorePricingRule = ignorePricingRule;
        this.scanBarcode = scanBarcode;
        this.setFromWarehouse = setFromWarehouse;
        this.setWarehouse = setWarehouse;
        this.totalQty = totalQty;
        this.totalNetWeight = totalNetWeight;
        this.baseTotal = baseTotal;
        this.baseNetTotal = baseNetTotal;
        this.total = total;
        this.netTotal = netTotal;
        this.taxWithholdingNetTotal = taxWithholdingNetTotal;
        this.baseTaxWithholdingNetTotal = baseTaxWithholdingNetTotal;
        this.setReserveWarehouse = setReserveWarehouse;
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
        this.baseGrandTotal = baseGrandTotal;
        this.baseRoundingAdjustment = baseRoundingAdjustment;
        this.baseInWords = baseInWords;
        this.baseRoundedTotal = baseRoundedTotal;
        this.grandTotal = grandTotal;
        this.roundingAdjustment = roundingAdjustment;
        this.roundedTotal = roundedTotal;
        this.disableRoundedTotal = disableRoundedTotal;
        this.inWords = inWords;
        this.advancePaid = advancePaid;
        this.applyDiscountOn = applyDiscountOn;
        this.baseDiscountAmount = baseDiscountAmount;
        this.additionalDiscountPercentage = additionalDiscountPercentage;
        this.discountAmount = discountAmount;
        this.otherChargesCalculation = otherChargesCalculation;
        this.supplierAddress = supplierAddress;
        this.addressDisplay = addressDisplay;
        this.contactPerson = contactPerson;
        this.contactDisplay = contactDisplay;
        this.contactMobile = contactMobile;
        this.contactEmail = contactEmail;
        this.dispatchAddress = dispatchAddress;
        this.dispatchAddressDisplay = dispatchAddressDisplay;
        this.shippingAddress = shippingAddress;
        this.shippingAddressDisplay = shippingAddressDisplay;
        this.billingAddress = billingAddress;
        this.billingAddressDisplay = billingAddressDisplay;
        this.customer = customer;
        this.customerName = customerName;
        this.customerContactPerson = customerContactPerson;
        this.customerContactDisplay = customerContactDisplay;
        this.customerContactMobile = customerContactMobile;
        this.customerContactEmail = customerContactEmail;
        this.paymentTermsTemplate = paymentTermsTemplate;
        this.tcName = tcName;
        this.terms = terms;
        this.status = status;
        this.perBilled = perBilled;
        this.perReceived = perReceived;
        this.letterHead = letterHead;
        this.groupSameItems = groupSameItems;
        this.selectPrintHeading = selectPrintHeading;
        this.language = language;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.autoRepeat = autoRepeat;
        this.isInternalSupplier = isInternalSupplier;
        this.representsCompany = representsCompany;
        this.refSq = refSq;
        this.partyAccountCurrency = partyAccountCurrency;
        this.interCompanyOrderReference = interCompanyOrderReference;
        this.isOldSubcontractingFlow = isOldSubcontractingFlow;
    }

    // Getters and Setters

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

    public Integer getDocstatus() { return docstatus; }
    public void setDocstatus(Integer docstatus) { this.docstatus = docstatus; }

    public Integer getIdx() { return idx; }
    public void setIdx(Integer idx) { this.idx = idx; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getNamingSeries() { return namingSeries; }
    public void setNamingSeries(String namingSeries) { this.namingSeries = namingSeries; }

    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }

    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }

    public String getOrderConfirmationNo() { return orderConfirmationNo; }
    public void setOrderConfirmationNo(String orderConfirmationNo) { this.orderConfirmationNo = orderConfirmationNo; }

    public String getOrderConfirmationDate() { return orderConfirmationDate; }
    public void setOrderConfirmationDate(String orderConfirmationDate) { this.orderConfirmationDate = orderConfirmationDate; }

    public LocalDate getTransactionDate() { return transactionDate; }
    public void setTransactionDate(LocalDate transactionDate) { this.transactionDate = transactionDate; }

    public LocalDate getScheduleDate() { return scheduleDate; }
    public void setScheduleDate(LocalDate scheduleDate) { this.scheduleDate = scheduleDate; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public Integer getApplyTds() { return applyTds; }
    public void setApplyTds(Integer applyTds) { this.applyTds = applyTds; }

    public String getTaxWithholdingCategory() { return taxWithholdingCategory; }
    public void setTaxWithholdingCategory(String taxWithholdingCategory) { this.taxWithholdingCategory = taxWithholdingCategory; }

    public Integer getIsSubcontracted() { return isSubcontracted; }
    public void setIsSubcontracted(Integer isSubcontracted) { this.isSubcontracted = isSubcontracted; }

    public String getSupplierWarehouse() { return supplierWarehouse; }
    public void setSupplierWarehouse(String supplierWarehouse) { this.supplierWarehouse = supplierWarehouse; }

    public String getAmendedFrom() { return amendedFrom; }
    public void setAmendedFrom(String amendedFrom) { this.amendedFrom = amendedFrom; }

    public String getCostCenter() { return costCenter; }
    public void setCostCenter(String costCenter) { this.costCenter = costCenter; }

    public String getProject() { return project; }
    public void setProject(String project) { this.project = project; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public Double getConversionRate() { return conversionRate; }
    public void setConversionRate(Double conversionRate) { this.conversionRate = conversionRate; }

    public String getBuyingPriceList() { return buyingPriceList; }
    public void setBuyingPriceList(String buyingPriceList) { this.buyingPriceList = buyingPriceList; }

    public String getPriceListCurrency() { return priceListCurrency; }
    public void setPriceListCurrency(String priceListCurrency) { this.priceListCurrency = priceListCurrency; }

    public Double getPlcConversionRate() { return plcConversionRate; }
    public void setPlcConversionRate(Double plcConversionRate) { this.plcConversionRate = plcConversionRate; }

    public Integer getIgnorePricingRule() { return ignorePricingRule; }
    public void setIgnorePricingRule(Integer ignorePricingRule) { this.ignorePricingRule = ignorePricingRule; }

    public String getScanBarcode() { return scanBarcode; }
    public void setScanBarcode(String scanBarcode) { this.scanBarcode = scanBarcode; }

    public String getSetFromWarehouse() { return setFromWarehouse; }
    public void setSetFromWarehouse(String setFromWarehouse) { this.setFromWarehouse = setFromWarehouse; }

    public String getSetWarehouse() { return setWarehouse; }
    public void setSetWarehouse(String setWarehouse) { this.setWarehouse = setWarehouse; }

    public Double getTotalQty() { return totalQty; }
    public void setTotalQty(Double totalQty) { this.totalQty = totalQty; }

    public Double getTotalNetWeight() { return totalNetWeight; }
    public void setTotalNetWeight(Double totalNetWeight) { this.totalNetWeight = totalNetWeight; }

    public Double getBaseTotal() { return baseTotal; }
    public void setBaseTotal(Double baseTotal) { this.baseTotal = baseTotal; }

    public Double getBaseNetTotal() { return baseNetTotal; }
    public void setBaseNetTotal(Double baseNetTotal) { this.baseNetTotal = baseNetTotal; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public Double getNetTotal() { return netTotal; }
    public void setNetTotal(Double netTotal) { this.netTotal = netTotal; }

    public Double getTaxWithholdingNetTotal() { return taxWithholdingNetTotal; }
    public void setTaxWithholdingNetTotal(Double taxWithholdingNetTotal) { this.taxWithholdingNetTotal = taxWithholdingNetTotal; }

    public Double getBaseTaxWithholdingNetTotal() { return baseTaxWithholdingNetTotal; }
    public void setBaseTaxWithholdingNetTotal(Double baseTaxWithholdingNetTotal) { this.baseTaxWithholdingNetTotal = baseTaxWithholdingNetTotal; }

    public String getSetReserveWarehouse() { return setReserveWarehouse; }
    public void setSetReserveWarehouse(String setReserveWarehouse) { this.setReserveWarehouse = setReserveWarehouse; }

    public String getTaxCategory() { return taxCategory; }
    public void setTaxCategory(String taxCategory) { this.taxCategory = taxCategory; }

    public String getTaxesAndCharges() { return taxesAndCharges; }
    public void setTaxesAndCharges(String taxesAndCharges) { this.taxesAndCharges = taxesAndCharges; }

    public String getShippingRule() { return shippingRule; }
    public void setShippingRule(String shippingRule) { this.shippingRule = shippingRule; }

    public String getIncoterm() { return incoterm; }
    public void setIncoterm(String incoterm) { this.incoterm = incoterm; }

    public String getNamedPlace() { return namedPlace; }
    public void setNamedPlace(String namedPlace) { this.namedPlace = namedPlace; }

    public Double getBaseTaxesAndChargesAdded() { return baseTaxesAndChargesAdded; }
    public void setBaseTaxesAndChargesAdded(Double baseTaxesAndChargesAdded) { this.baseTaxesAndChargesAdded = baseTaxesAndChargesAdded; }

    public Double getBaseTaxesAndChargesDeducted() { return baseTaxesAndChargesDeducted; }
    public void setBaseTaxesAndChargesDeducted(Double baseTaxesAndChargesDeducted) { this.baseTaxesAndChargesDeducted = baseTaxesAndChargesDeducted; }

    public Double getBaseTotalTaxesAndCharges() { return baseTotalTaxesAndCharges; }
    public void setBaseTotalTaxesAndCharges(Double baseTotalTaxesAndCharges) { this.baseTotalTaxesAndCharges = baseTotalTaxesAndCharges; }

    public Double getTaxesAndChargesAdded() { return taxesAndChargesAdded; }
    public void setTaxesAndChargesAdded(Double taxesAndChargesAdded) { this.taxesAndChargesAdded = taxesAndChargesAdded; }

    public Double getTaxesAndChargesDeducted() { return taxesAndChargesDeducted; }
    public void setTaxesAndChargesDeducted(Double taxesAndChargesDeducted) { this.taxesAndChargesDeducted = taxesAndChargesDeducted; }

    public Double getTotalTaxesAndCharges() { return totalTaxesAndCharges; }
    public void setTotalTaxesAndCharges(Double totalTaxesAndCharges) { this.totalTaxesAndCharges = totalTaxesAndCharges; }

    public Double getBaseGrandTotal() { return baseGrandTotal; }
    public void setBaseGrandTotal(Double baseGrandTotal) { this.baseGrandTotal = baseGrandTotal; }

    public Double getBaseRoundingAdjustment() { return baseRoundingAdjustment; }
    public void setBaseRoundingAdjustment(Double baseRoundingAdjustment) { this.baseRoundingAdjustment = baseRoundingAdjustment; }

    public String getBaseInWords() { return baseInWords; }
    public void setBaseInWords(String baseInWords) { this.baseInWords = baseInWords; }

    public Double getBaseRoundedTotal() { return baseRoundedTotal; }
    public void setBaseRoundedTotal(Double baseRoundedTotal) { this.baseRoundedTotal = baseRoundedTotal; }

    public Double getGrandTotal() { return grandTotal; }
    public void setGrandTotal(Double grandTotal) { this.grandTotal = grandTotal; }

    public Double getRoundingAdjustment() { return roundingAdjustment; }
    public void setRoundingAdjustment(Double roundingAdjustment) { this.roundingAdjustment = roundingAdjustment; }

    public Double getRoundedTotal() { return roundedTotal; }
    public void setRoundedTotal(Double roundedTotal) { this.roundedTotal = roundedTotal; }

    public Integer getDisableRoundedTotal() { return disableRoundedTotal; }
    public void setDisableRoundedTotal(Integer disableRoundedTotal) { this.disableRoundedTotal = disableRoundedTotal; }

    public String getInWords() { return inWords; }
    public void setInWords(String inWords) { this.inWords = inWords; }

    public Double getAdvancePaid() { return advancePaid; }
    public void setAdvancePaid(Double advancePaid) { this.advancePaid = advancePaid; }

    public String getApplyDiscountOn() { return applyDiscountOn; }
    public void setApplyDiscountOn(String applyDiscountOn) { this.applyDiscountOn = applyDiscountOn; }

    public Double getBaseDiscountAmount() { return baseDiscountAmount; }
    public void setBaseDiscountAmount(Double baseDiscountAmount) { this.baseDiscountAmount = baseDiscountAmount; }

    public Double getAdditionalDiscountPercentage() { return additionalDiscountPercentage; }
    public void setAdditionalDiscountPercentage(Double additionalDiscountPercentage) { this.additionalDiscountPercentage = additionalDiscountPercentage; }

    public Double getDiscountAmount() { return discountAmount; }
    public void setDiscountAmount(Double discountAmount) { this.discountAmount = discountAmount; }

    public String getOtherChargesCalculation() { return otherChargesCalculation; }
    public void setOtherChargesCalculation(String otherChargesCalculation) { this.otherChargesCalculation = otherChargesCalculation; }

    public String getSupplierAddress() { return supplierAddress; }
    public void setSupplierAddress(String supplierAddress) { this.supplierAddress = supplierAddress; }

    public String getAddressDisplay() { return addressDisplay; }
    public void setAddressDisplay(String addressDisplay) { this.addressDisplay = addressDisplay; }

    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }

    public String getContactDisplay() { return contactDisplay; }
    public void setContactDisplay(String contactDisplay) { this.contactDisplay = contactDisplay; }

    public String getContactMobile() { return contactMobile; }
    public void setContactMobile(String contactMobile) { this.contactMobile = contactMobile; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public String getDispatchAddress() { return dispatchAddress; }
    public void setDispatchAddress(String dispatchAddress) { this.dispatchAddress = dispatchAddress; }

    public String getDispatchAddressDisplay() { return dispatchAddressDisplay; }
    public void setDispatchAddressDisplay(String dispatchAddressDisplay) { this.dispatchAddressDisplay = dispatchAddressDisplay; }

    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }

    public String getShippingAddressDisplay() { return shippingAddressDisplay; }
    public void setShippingAddressDisplay(String shippingAddressDisplay) { this.shippingAddressDisplay = shippingAddressDisplay; }

    public String getBillingAddress() { return billingAddress; }
    public void setBillingAddress(String billingAddress) { this.billingAddress = billingAddress; }

    public String getBillingAddressDisplay() { return billingAddressDisplay; }
    public void setBillingAddressDisplay(String billingAddressDisplay) { this.billingAddressDisplay = billingAddressDisplay; }

    public String getCustomer() { return customer; }
    public void setCustomer(String customer) { this.customer = customer; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerContactPerson() { return customerContactPerson; }
    public void setCustomerContactPerson(String customerContactPerson) { this.customerContactPerson = customerContactPerson; }

    public String getCustomerContactDisplay() { return customerContactDisplay; }
    public void setCustomerContactDisplay(String customerContactDisplay) { this.customerContactDisplay = customerContactDisplay; }

    public String getCustomerContactMobile() { return customerContactMobile; }
    public void setCustomerContactMobile(String customerContactMobile) { this.customerContactMobile = customerContactMobile; }

    public String getCustomerContactEmail() { return customerContactEmail; }
    public void setCustomerContactEmail(String customerContactEmail) { this.customerContactEmail = customerContactEmail; }

    public String getPaymentTermsTemplate() { return paymentTermsTemplate; }
    public void setPaymentTermsTemplate(String paymentTermsTemplate) { this.paymentTermsTemplate = paymentTermsTemplate; }

    public String getTcName() { return tcName; }
    public void setTcName(String tcName) { this.tcName = tcName; }

    public String getTerms() { return terms; }
    public void setTerms(String terms) { this.terms = terms; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Double getPerBilled() { return perBilled; }
    public void setPerBilled(Double perBilled) { this.perBilled = perBilled; }

    public Double getPerReceived() { return perReceived; }
    public void setPerReceived(Double perReceived) { this.perReceived = perReceived; }

    public String getLetterHead() { return letterHead; }
    public void setLetterHead(String letterHead) { this.letterHead = letterHead; }

    public Integer getGroupSameItems() { return groupSameItems; }
    public void setGroupSameItems(Integer groupSameItems) { this.groupSameItems = groupSameItems; }

    public String getSelectPrintHeading() { return selectPrintHeading; }
    public void setSelectPrintHeading(String selectPrintHeading) { this.selectPrintHeading = selectPrintHeading; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getFromDate() { return fromDate; }
    public void setFromDate(String fromDate) { this.fromDate = fromDate; }

    public String getToDate() { return toDate; }
    public void setToDate(String toDate) { this.toDate = toDate; }

    public String getAutoRepeat() { return autoRepeat; }
    public void setAutoRepeat(String autoRepeat) { this.autoRepeat = autoRepeat; }

    public Integer getIsInternalSupplier() { return isInternalSupplier; }
    public void setIsInternalSupplier(Integer isInternalSupplier) { this.isInternalSupplier = isInternalSupplier; }

    public String getRepresentsCompany() { return representsCompany; }
    public void setRepresentsCompany(String representsCompany) { this.representsCompany = representsCompany; }

    public String getRefSq() { return refSq; }
    public void setRefSq(String refSq) { this.refSq = refSq; }

    public String getPartyAccountCurrency() { return partyAccountCurrency; }
    public void setPartyAccountCurrency(String partyAccountCurrency) { this.partyAccountCurrency = partyAccountCurrency; }

    public String getInterCompanyOrderReference() { return interCompanyOrderReference; }
    public void setInterCompanyOrderReference(String interCompanyOrderReference) { this.interCompanyOrderReference = interCompanyOrderReference; }

    public Integer getIsOldSubcontractingFlow() { return isOldSubcontractingFlow; }
    public void setIsOldSubcontractingFlow(Integer isOldSubcontractingFlow) { this.isOldSubcontractingFlow = isOldSubcontractingFlow; }
}
