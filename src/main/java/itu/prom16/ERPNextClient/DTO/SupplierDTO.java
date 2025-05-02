package itu.prom16.ERPNextClient.DTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Fanou
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplierDTO {

    private String name;

    private String owner;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime creation;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime modified;

    @JsonProperty("modified_by")
    private String modifiedBy;

    private int docstatus;

    private int idx;

    @JsonProperty("naming_series")
    private String namingSeries;

    @JsonProperty("supplier_name")
    private String supplierName;

    private String country;

    @JsonProperty("supplier_group")
    private String supplierGroup;

    @JsonProperty("supplier_type")
    private String supplierType;

    @JsonProperty("is_transporter")
    private boolean isTransporter;

    private String image;

    @JsonProperty("default_currency")
    private String defaultCurrency;

    @JsonProperty("default_bank_account")
    private String defaultBankAccount;

    @JsonProperty("default_price_list")
    private String defaultPriceList;

    @JsonProperty("is_internal_supplier")
    private boolean isInternalSupplier;

    @JsonProperty("represents_company")
    private String representsCompany;

    @JsonProperty("supplier_details")
    private String supplierDetails;
    
    private String website;
    
    private String language;

    @JsonProperty("tax_id")
    private String taxId;

    @JsonProperty("tax_category")
    private String taxCategory;

    @JsonProperty("tax_withholding_category")
    private String taxWithholdingCategory;

    @JsonProperty("supplier_primary_address")
    private String supplierPrimaryAddress;

    @JsonProperty("primary_address")
    private String primaryAddress;

    @JsonProperty("supplier_primary_contact")
    private String supplierPrimaryContact;

    @JsonProperty("mobile_no")
    private String mobileNo;

    @JsonProperty("email_id")
    private String emailId;

    @JsonProperty("payment_terms")
    private String paymentTerms;

    @JsonProperty("allow_purchase_invoice_creation_without_purchase_order")
    private boolean allowPurchaseInvoiceCreationWithoutPurchaseOrder;

    @JsonProperty("allow_purchase_invoice_creation_without_purchase_receipt")
    private boolean allowPurchaseInvoiceCreationWithoutPurchaseReceipt;

    @JsonProperty("is_frozen")
    private boolean isFrozen;

    @JsonProperty("disabled")
    private boolean disabled;

    @JsonProperty("warn_rfqs")
    private boolean warnRfqs;

    @JsonProperty("warn_pos")
    private boolean warnPos;

    @JsonProperty("prevent_rfqs")
    private boolean preventRfqs;

    @JsonProperty("prevent_pos")
    private boolean preventPos;

    @JsonProperty("on_hold")
    private boolean onHold;

    @JsonProperty("hold_type")
    private String holdType;

    @JsonProperty("release_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime releaseDate;

    public SupplierDTO() {}

    public SupplierDTO(String name, String owner, LocalDateTime creation, LocalDateTime modified, String modifiedBy, int docstatus, int idx, String namingSeries, String supplierName, String country, String supplierGroup, String supplierType, boolean isTransporter, String image, String defaultCurrency, String defaultBankAccount, String defaultPriceList, boolean isInternalSupplier, String representsCompany, String supplierDetails, String website, String language, String taxId, String taxCategory, String taxWithholdingCategory, String supplierPrimaryAddress, String primaryAddress, String supplierPrimaryContact, String mobileNo, String emailId, String paymentTerms, boolean allowPurchaseInvoiceCreationWithoutPurchaseOrder, boolean allowPurchaseInvoiceCreationWithoutPurchaseReceipt, boolean isFrozen, boolean disabled, boolean warnRfqs, boolean warnPos, boolean preventRfqs, boolean preventPos, boolean onHold, String holdType, LocalDateTime releaseDate) {
        this.name = name;
        this.owner = owner;
        this.creation = creation;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
        this.docstatus = docstatus;
        this.idx = idx;
        this.namingSeries = namingSeries;
        this.supplierName = supplierName;
        this.country = country;
        this.supplierGroup = supplierGroup;
        this.supplierType = supplierType;
        this.isTransporter = isTransporter;
        this.image = image;
        this.defaultCurrency = defaultCurrency;
        this.defaultBankAccount = defaultBankAccount;
        this.defaultPriceList = defaultPriceList;
        this.isInternalSupplier = isInternalSupplier;
        this.representsCompany = representsCompany;
        this.supplierDetails = supplierDetails;
        this.website = website;
        this.language = language;
        this.taxId = taxId;
        this.taxCategory = taxCategory;
        this.taxWithholdingCategory = taxWithholdingCategory;
        this.supplierPrimaryAddress = supplierPrimaryAddress;
        this.primaryAddress = primaryAddress;
        this.supplierPrimaryContact = supplierPrimaryContact;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
        this.paymentTerms = paymentTerms;
        this.allowPurchaseInvoiceCreationWithoutPurchaseOrder = allowPurchaseInvoiceCreationWithoutPurchaseOrder;
        this.allowPurchaseInvoiceCreationWithoutPurchaseReceipt = allowPurchaseInvoiceCreationWithoutPurchaseReceipt;
        this.isFrozen = isFrozen;
        this.disabled = disabled;
        this.warnRfqs = warnRfqs;
        this.warnPos = warnPos;
        this.preventRfqs = preventRfqs;
        this.preventPos = preventPos;
        this.onHold = onHold;
        this.holdType = holdType;
        this.releaseDate = releaseDate;
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

    public String getNamingSeries() {
        return namingSeries;
    }

    public void setNamingSeries(String namingSeries) {
        this.namingSeries = namingSeries;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSupplierGroup() {
        return supplierGroup;
    }

    public void setSupplierGroup(String supplierGroup) {
        this.supplierGroup = supplierGroup;
    }

    public String getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(String supplierType) {
        this.supplierType = supplierType;
    }

    public boolean isIsTransporter() {
        return isTransporter;
    }

    public void setIsTransporter(boolean isTransporter) {
        this.isTransporter = isTransporter;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public String getDefaultBankAccount() {
        return defaultBankAccount;
    }

    public void setDefaultBankAccount(String defaultBankAccount) {
        this.defaultBankAccount = defaultBankAccount;
    }

    public String getDefaultPriceList() {
        return defaultPriceList;
    }

    public void setDefaultPriceList(String defaultPriceList) {
        this.defaultPriceList = defaultPriceList;
    }

    public boolean isIsInternalSupplier() {
        return isInternalSupplier;
    }

    public void setIsInternalSupplier(boolean isInternalSupplier) {
        this.isInternalSupplier = isInternalSupplier;
    }

    public String getRepresentsCompany() {
        return representsCompany;
    }

    public void setRepresentsCompany(String representsCompany) {
        this.representsCompany = representsCompany;
    }

    public String getSupplierDetails() {
        return supplierDetails;
    }

    public void setSupplierDetails(String supplierDetails) {
        this.supplierDetails = supplierDetails;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(String taxCategory) {
        this.taxCategory = taxCategory;
    }

    public String getTaxWithholdingCategory() {
        return taxWithholdingCategory;
    }

    public void setTaxWithholdingCategory(String taxWithholdingCategory) {
        this.taxWithholdingCategory = taxWithholdingCategory;
    }

    public String getSupplierPrimaryAddress() {
        return supplierPrimaryAddress;
    }

    public void setSupplierPrimaryAddress(String supplierPrimaryAddress) {
        this.supplierPrimaryAddress = supplierPrimaryAddress;
    }

    public String getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(String primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public String getSupplierPrimaryContact() {
        return supplierPrimaryContact;
    }

    public void setSupplierPrimaryContact(String supplierPrimaryContact) {
        this.supplierPrimaryContact = supplierPrimaryContact;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public boolean isAllowPurchaseInvoiceCreationWithoutPurchaseOrder() {
        return allowPurchaseInvoiceCreationWithoutPurchaseOrder;
    }

    public void setAllowPurchaseInvoiceCreationWithoutPurchaseOrder(boolean allowPurchaseInvoiceCreationWithoutPurchaseOrder) {
        this.allowPurchaseInvoiceCreationWithoutPurchaseOrder = allowPurchaseInvoiceCreationWithoutPurchaseOrder;
    }

    public boolean isAllowPurchaseInvoiceCreationWithoutPurchaseReceipt() {
        return allowPurchaseInvoiceCreationWithoutPurchaseReceipt;
    }

    public void setAllowPurchaseInvoiceCreationWithoutPurchaseReceipt(boolean allowPurchaseInvoiceCreationWithoutPurchaseReceipt) {
        this.allowPurchaseInvoiceCreationWithoutPurchaseReceipt = allowPurchaseInvoiceCreationWithoutPurchaseReceipt;
    }

    public boolean isIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(boolean isFrozen) {
        this.isFrozen = isFrozen;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isWarnRfqs() {
        return warnRfqs;
    }

    public void setWarnRfqs(boolean warnRfqs) {
        this.warnRfqs = warnRfqs;
    }

    public boolean isWarnPos() {
        return warnPos;
    }

    public void setWarnPos(boolean warnPos) {
        this.warnPos = warnPos;
    }

    public boolean isPreventRfqs() {
        return preventRfqs;
    }

    public void setPreventRfqs(boolean preventRfqs) {
        this.preventRfqs = preventRfqs;
    }

    public boolean isPreventPos() {
        return preventPos;
    }

    public void setPreventPos(boolean preventPos) {
        this.preventPos = preventPos;
    }

    public boolean isOnHold() {
        return onHold;
    }

    public void setOnHold(boolean onHold) {
        this.onHold = onHold;
    }

    public String getHoldType() {
        return holdType;
    }

    public void setHoldType(String holdType) {
        this.holdType = holdType;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

}