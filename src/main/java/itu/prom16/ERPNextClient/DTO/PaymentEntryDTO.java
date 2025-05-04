package itu.prom16.ERPNextClient.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Fanou
 */
public class PaymentEntryDTO {
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
    private Integer docstatus;
    @JsonProperty("idx")
    private Integer idx;
    @JsonProperty("naming_series")
    private String namingSeries;
    @JsonProperty("payment_type")
    private String paymentType;
    @JsonProperty("payment_order_status")
    private String paymentOrderStatus;

    @JsonProperty("posting_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate postingDate;

    @JsonProperty("mode_of_payment")
    private String modeOfPayment;
    @JsonProperty("company")
    private String company;
    @JsonProperty("party_type")
    private String partyType;
    @JsonProperty("party")
    private String party;
    @JsonProperty("party_name")
    private String partyName;
    @JsonProperty("book_advance_payments_in_separate_party_account")
    private Integer bookAdvancePaymentsInSeparatePartyAccount;
    @JsonProperty("reconcile_on_advance_payment_date")
    private Integer reconcileOnAdvancePaymentDate;
    @JsonProperty("advance_reconciliation_takes_effect_on")
    private String advanceReconciliationTakesEffectOn;
    @JsonProperty("party_balance")
    private Double partyBalance;
    @JsonProperty("paid_from")
    private String paidFrom;
    @JsonProperty("paid_from_account_type")
    private String paidFromAccountType;
    @JsonProperty("paid_from_account_currency")
    private String paidFromAccountCurrency;
    @JsonProperty("paid_from_account_balance")
    private Double paidFromAccountBalance;
    @JsonProperty("paid_to")
    private String paidTo;
    @JsonProperty("paid_to_account_type")
    private String paidToAccountType;
    @JsonProperty("paid_to_account_currency")
    private String paidToAccountCurrency;
    @JsonProperty("paid_to_account_balance")
    private Double paidToAccountBalance;
    @JsonProperty("paid_amount")
    private Double paidAmount;
    @JsonProperty("paid_amount_after_tax")
    private Double paidAmountAfterTax;
    @JsonProperty("source_exchange_rate")
    private Double sourceExchangeRate;
    @JsonProperty("base_paid_amount")
    private Double basePaidAmount;
    @JsonProperty("base_paid_amount_after_tax")
    private Double basePaidAmountAfterTax;
    @JsonProperty("received_amount")
    private Double receivedAmount;
    @JsonProperty("received_amount_after_tax")
    private Double receivedAmountAfterTax;
    @JsonProperty("target_exchange_rate")
    private Double targetExchangeRate;
    @JsonProperty("base_received_amount")
    private Double baseReceivedAmount;
    @JsonProperty("base_received_amount_after_tax")
    private Double baseReceivedAmountAfterTax;
    @JsonProperty("total_allocated_amount")
    private Double totalAllocatedAmount;
    @JsonProperty("base_total_allocated_amount")
    private Double baseTotalAllocatedAmount;
    @JsonProperty("unallocated_amount")
    private Double unallocatedAmount;
    @JsonProperty("difference_amount")
    private Double differenceAmount;
    @JsonProperty("apply_tax_withholding_amount")
    private Integer applyTaxWithholdingAmount;
    @JsonProperty("base_total_taxes_and_charges")
    private Double baseTotalTaxesAndCharges;
    @JsonProperty("total_taxes_and_charges")
    private Double totalTaxesAndCharges;
    @JsonProperty("reference_no")
    private String referenceNo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("reference_date")
    private LocalDate referenceDate;
    
    @JsonProperty("status")
    private String status;
    @JsonProperty("custom_remarks")
    private Integer customRemarks;
    @JsonProperty("remarks")
    private String remarks;
    @JsonProperty("base_in_words")
    private String baseInWords;
    @JsonProperty("is_opening")
    private String isOpening;
    @JsonProperty("in_words")
    private String inWords;
    @JsonProperty("title")
    private String title;
    @JsonProperty("doctype")
    private String doctype;

    @JsonProperty("references")
    private List<ReferenceDTO> references;

    @JsonProperty("deductions")
    private List<Object> deductions;

    @JsonProperty("taxes")
    private List<Object> taxes;

    public PaymentEntryDTO() {}
    
        public PaymentEntryDTO( String name, String owner, LocalDateTime creation, LocalDateTime modified, String modifiedBy, Integer docstatus,
                                Integer idx, String namingSeries, String paymentType, String paymentOrderStatus, LocalDate postingDate, String modeOfPayment,
                                String company, String partyType, String party, String partyName, Integer bookAdvancePaymentsInSeparatePartyAccount,
                                Integer reconcileOnAdvancePaymentDate, String advanceReconciliationTakesEffectOn, Double partyBalance,
                                String paidFrom, String paidFromAccountType, String paidFromAccountCurrency, Double paidFromAccountBalance,
                                String paidTo, String paidToAccountType, String paidToAccountCurrency, Double paidToAccountBalance, Double paidAmount,
                                Double paidAmountAfterTax, Double sourceExchangeRate, Double basePaidAmount, Double basePaidAmountAfterTax,
                                Double receivedAmount, Double receivedAmountAfterTax, Double targetExchangeRate, Double baseReceivedAmount,
                                Double baseReceivedAmountAfterTax, Double totalAllocatedAmount, Double baseTotalAllocatedAmount, Double unallocatedAmount,
                                Double differenceAmount, Integer applyTaxWithholdingAmount, Double baseTotalTaxesAndCharges, Double totalTaxesAndCharges,
                                String referenceNo, LocalDate referenceDate, String status, Integer customRemarks, String remarks, String baseInWords,
                                String isOpening, String inWords, String title, String doctype, List<ReferenceDTO> references, List<Object> deductions,
                                List<Object> taxes) {
            this.name = name;
            this.owner = owner;
            this.creation = creation;
            this.modified = modified;
            this.modifiedBy = modifiedBy;
            this.docstatus = docstatus;
            this.idx = idx;
            this.namingSeries = namingSeries;
            this.paymentType = paymentType;
            this.paymentOrderStatus = paymentOrderStatus;
            this.postingDate = postingDate;
            this.modeOfPayment = modeOfPayment;
            this.company = company;
            this.partyType = partyType;
            this.party = party;
            this.partyName = partyName;
            this.bookAdvancePaymentsInSeparatePartyAccount = bookAdvancePaymentsInSeparatePartyAccount;
            this.reconcileOnAdvancePaymentDate = reconcileOnAdvancePaymentDate;
            this.advanceReconciliationTakesEffectOn = advanceReconciliationTakesEffectOn;
            this.partyBalance = partyBalance;
            this.paidFrom = paidFrom;
            this.paidFromAccountType = paidFromAccountType;
            this.paidFromAccountCurrency = paidFromAccountCurrency;
            this.paidFromAccountBalance = paidFromAccountBalance;
            this.paidTo = paidTo;
            this.paidToAccountType = paidToAccountType;
            this.paidToAccountCurrency = paidToAccountCurrency;
            this.paidToAccountBalance = paidToAccountBalance;
            this.paidAmount = paidAmount;
            this.paidAmountAfterTax = paidAmountAfterTax;
            this.sourceExchangeRate = sourceExchangeRate;
            this.basePaidAmount = basePaidAmount;
            this.basePaidAmountAfterTax = basePaidAmountAfterTax;
            this.receivedAmount = receivedAmount;
            this.receivedAmountAfterTax = receivedAmountAfterTax;
            this.targetExchangeRate = targetExchangeRate;
            this.baseReceivedAmount = baseReceivedAmount;
            this.baseReceivedAmountAfterTax = baseReceivedAmountAfterTax;
            this.totalAllocatedAmount = totalAllocatedAmount;
            this.baseTotalAllocatedAmount = baseTotalAllocatedAmount;
            this.unallocatedAmount = unallocatedAmount;
            this.differenceAmount = differenceAmount;
            this.applyTaxWithholdingAmount = applyTaxWithholdingAmount;
            this.baseTotalTaxesAndCharges = baseTotalTaxesAndCharges;
            this.totalTaxesAndCharges = totalTaxesAndCharges;
            this.referenceNo = referenceNo;
            this.referenceDate = referenceDate;
            this.status = status;
            this.customRemarks = customRemarks;
            this.remarks = remarks;
            this.baseInWords = baseInWords;
            this.isOpening = isOpening;
            this.inWords = inWords;
            this.title = title;
            this.doctype = doctype;
            this.references = references;
            this.deductions = deductions;
            this.taxes = taxes;
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

        public Integer getDocstatus() { return docstatus; }
        public void setDocstatus(Integer docstatus) { this.docstatus = docstatus; }

        public Integer getIdx() { return idx; }
        public void setIdx(Integer idx) { this.idx = idx; }

        public String getNamingSeries() { return namingSeries; }
        public void setNamingSeries(String namingSeries) { this.namingSeries = namingSeries; }

        public String getPaymentType() { return paymentType; }
        public void setPaymentType(String paymentType) { this.paymentType = paymentType; }

        public String getPaymentOrderStatus() { return paymentOrderStatus; }
        public void setPaymentOrderStatus(String paymentOrderStatus) { this.paymentOrderStatus = paymentOrderStatus; }

        public String getModeOfPayment() { return modeOfPayment; }
        public void setModeOfPayment(String modeOfPayment) { this.modeOfPayment = modeOfPayment; }  

        public LocalDate getPostingDate() { return postingDate; }
        public void setPostingDate(LocalDate postingDate) { this.postingDate = postingDate; }

        public String getCompany() { return company; }
        public void setCompany(String company) { this.company = company; }

        public String getPartyType() { return partyType; }
        public void setPartyType(String partyType) { this.partyType = partyType; }

        public String getParty() { return party; }
        public void setParty(String party) { this.party = party; }

        public String getPartyName() { return partyName; }
        public void setPartyName(String partyName) { this.partyName = partyName; }

        public Integer getBookAdvancePaymentsInSeparatePartyAccount() { return bookAdvancePaymentsInSeparatePartyAccount; }
        public void setBookAdvancePaymentsInSeparatePartyAccount(Integer bookAdvancePaymentsInSeparatePartyAccount) { this.bookAdvancePaymentsInSeparatePartyAccount = bookAdvancePaymentsInSeparatePartyAccount; }

        public Integer getReconcileOnAdvancePaymentDate() { return reconcileOnAdvancePaymentDate; }
        public void setReconcileOnAdvancePaymentDate(Integer reconcileOnAdvancePaymentDate) { this.reconcileOnAdvancePaymentDate = reconcileOnAdvancePaymentDate; }

        public String getAdvanceReconciliationTakesEffectOn() { return advanceReconciliationTakesEffectOn; }
        public void setAdvanceReconciliationTakesEffectOn(String advanceReconciliationTakesEffectOn) { this.advanceReconciliationTakesEffectOn = advanceReconciliationTakesEffectOn; }

        public Double getPartyBalance() { return partyBalance; }
        public void setPartyBalance(Double partyBalance) { this.partyBalance = partyBalance; }

        public String getPaidFrom() { return paidFrom; }
        public void setPaidFrom(String paidFrom) { this.paidFrom = paidFrom; }

        public String getPaidFromAccountType() { return paidFromAccountType; }
        public void setPaidFromAccountType(String paidFromAccountType) { this.paidFromAccountType = paidFromAccountType; }

        public String getPaidFromAccountCurrency() { return paidFromAccountCurrency; }
        public void setPaidFromAccountCurrency(String paidFromAccountCurrency) { this.paidFromAccountCurrency = paidFromAccountCurrency; }

        public Double getPaidFromAccountBalance() { return paidFromAccountBalance; }
        public void setPaidFromAccountBalance(Double paidFromAccountBalance) { this.paidFromAccountBalance = paidFromAccountBalance; }

        public String getPaidTo() { return paidTo; }
        public void setPaidTo(String paidTo) { this.paidTo = paidTo; }

        public String getPaidToAccountType() { return paidToAccountType; }
        public void setPaidToAccountType(String paidToAccountType) { this.paidToAccountType = paidToAccountType; }

        public String getPaidToAccountCurrency() { return paidToAccountCurrency; }
        public void setPaidToAccountCurrency(String paidToAccountCurrency) { this.paidToAccountCurrency = paidToAccountCurrency; }

        public Double getPaidToAccountBalance() { return paidToAccountBalance; }
        public void setPaidToAccountBalance(Double paidToAccountBalance) { this.paidToAccountBalance = paidToAccountBalance; }

        public Double getPaidAmount() { return paidAmount; }
        public void setPaidAmount(Double paidAmount) { this.paidAmount = paidAmount; }

        public Double getPaidAmountAfterTax() { return paidAmountAfterTax; }
        public void setPaidAmountAfterTax(Double paidAmountAfterTax) { this.paidAmountAfterTax = paidAmountAfterTax; }

        public Double getSourceExchangeRate() { return sourceExchangeRate; }
        public void setSourceExchangeRate(Double sourceExchangeRate) { this.sourceExchangeRate = sourceExchangeRate; }

        public Double getBasePaidAmount() { return basePaidAmount; }
        public void setBasePaidAmount(Double basePaidAmount) { this.basePaidAmount = basePaidAmount; }

        public Double getBasePaidAmountAfterTax() { return basePaidAmountAfterTax; }
        public void setBasePaidAmountAfterTax(Double basePaidAmountAfterTax) { this.basePaidAmountAfterTax = basePaidAmountAfterTax; }

        public Double getReceivedAmount() { return receivedAmount; }
        public void setReceivedAmount(Double receivedAmount) { this.receivedAmount = receivedAmount; }

        public Double getReceivedAmountAfterTax() { return receivedAmountAfterTax; }
        public void setReceivedAmountAfterTax(Double receivedAmountAfterTax) { this.receivedAmountAfterTax = receivedAmountAfterTax; }

        public Double getTargetExchangeRate() { return targetExchangeRate; }
        public void setTargetExchangeRate(Double targetExchangeRate) { this.targetExchangeRate = targetExchangeRate; }

        public Double getBaseReceivedAmount() { return baseReceivedAmount; }
        public void setBaseReceivedAmount(Double baseReceivedAmount) { this.baseReceivedAmount = baseReceivedAmount; }

        public Double getBaseReceivedAmountAfterTax() { return baseReceivedAmountAfterTax; }
        public void setBaseReceivedAmountAfterTax(Double baseReceivedAmountAfterTax) { this.baseReceivedAmountAfterTax = baseReceivedAmountAfterTax; }

        public Double getTotalAllocatedAmount() { return totalAllocatedAmount; }
        public void setTotalAllocatedAmount(Double totalAllocatedAmount) { this.totalAllocatedAmount = totalAllocatedAmount; }

        public Double getBaseTotalAllocatedAmount() { return baseTotalAllocatedAmount; }
        public void setBaseTotalAllocatedAmount(Double baseTotalAllocatedAmount) { this.baseTotalAllocatedAmount = baseTotalAllocatedAmount; }

        public Double getUnallocatedAmount() { return unallocatedAmount; }
        public void setUnallocatedAmount(Double unallocatedAmount) { this.unallocatedAmount = unallocatedAmount; }

        public Double getDifferenceAmount() { return differenceAmount; }
        public void setDifferenceAmount(Double differenceAmount) { this.differenceAmount = differenceAmount; }

        public Integer getApplyTaxWithholdingAmount() { return applyTaxWithholdingAmount; }
        public void setApplyTaxWithholdingAmount(Integer applyTaxWithholdingAmount) { this.applyTaxWithholdingAmount = applyTaxWithholdingAmount; }

        public Double getBaseTotalTaxesAndCharges() { return baseTotalTaxesAndCharges; }
        public void setBaseTotalTaxesAndCharges(Double baseTotalTaxesAndCharges) { this.baseTotalTaxesAndCharges = baseTotalTaxesAndCharges; }

        public Double getTotalTaxesAndCharges() { return totalTaxesAndCharges; }
        public void setTotalTaxesAndCharges(Double totalTaxesAndCharges) { this.totalTaxesAndCharges = totalTaxesAndCharges; }

        public String getReferenceNo() { return referenceNo; }
        public void setReferenceNo(String referenceNo) { this.referenceNo = referenceNo; }

        public LocalDate getReferenceDate() { return referenceDate; }
        public void setReferenceDate(LocalDate referenceDate) { this.referenceDate = referenceDate; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public Integer getCustomRemarks() { return customRemarks; }
        public void setCustomRemarks(Integer customRemarks) { this.customRemarks = customRemarks; }

        public String getRemarks() { return remarks; }
        public void setRemarks(String remarks) { this.remarks = remarks; }

        public String getBaseInWords() { return baseInWords; }
        public void setBaseInWords(String baseInWords) { this.baseInWords = baseInWords; }

        public String getIsOpening() { return isOpening; }
        public void setIsOpening(String isOpening) { this.isOpening = isOpening; }

        public String getInWords() { return inWords; }
        public void setInWords(String inWords) { this.inWords = inWords; }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getDoctype() { return doctype; }
        public void setDoctype(String doctype) { this.doctype = doctype; }

        public List<ReferenceDTO> getReferences() { return references; }
        public void setReferences(List<ReferenceDTO> references) { this.references = references; }

        public List<Object> getDeductions() { return deductions; }
        public void setDeductions(List<Object> deductions) { this.deductions = deductions; }

        public List<Object> getTaxes() { return taxes; }
        public void setTaxes(List<Object> taxes) { this.taxes = taxes; }
}
