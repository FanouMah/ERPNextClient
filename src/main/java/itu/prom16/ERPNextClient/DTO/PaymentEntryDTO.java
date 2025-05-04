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
    private int docstatus;
    @JsonProperty("idx")
    private int idx;
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
    private int bookAdvancePaymentsInSeparatePartyAccount;
    @JsonProperty("reconcile_on_advance_payment_date")
    private int reconcileOnAdvancePaymentDate;
    @JsonProperty("advance_reconciliation_takes_effect_on")
    private String advanceReconciliationTakesEffectOn;
    @JsonProperty("party_balance")
    private double partyBalance;
    @JsonProperty("paid_from")
    private String paidFrom;
    @JsonProperty("paid_from_account_type")
    private String paidFromAccountType;
    @JsonProperty("paid_from_account_currency")
    private String paidFromAccountCurrency;
    @JsonProperty("paid_from_account_balance")
    private double paidFromAccountBalance;
    @JsonProperty("paid_to")
    private String paidTo;
    @JsonProperty("paid_to_account_type")
    private String paidToAccountType;
    @JsonProperty("paid_to_account_currency")
    private String paidToAccountCurrency;
    @JsonProperty("paid_to_account_balance")
    private double paidToAccountBalance;
    @JsonProperty("paid_amount")
    private double paidAmount;
    @JsonProperty("paid_amount_after_tax")
    private double paidAmountAfterTax;
    @JsonProperty("source_exchange_rate")
    private double sourceExchangeRate;
    @JsonProperty("base_paid_amount")
    private double basePaidAmount;
    @JsonProperty("base_paid_amount_after_tax")
    private double basePaidAmountAfterTax;
    @JsonProperty("received_amount")
    private double receivedAmount;
    @JsonProperty("received_amount_after_tax")
    private double receivedAmountAfterTax;
    @JsonProperty("target_exchange_rate")
    private double targetExchangeRate;
    @JsonProperty("base_received_amount")
    private double baseReceivedAmount;
    @JsonProperty("base_received_amount_after_tax")
    private double baseReceivedAmountAfterTax;
    @JsonProperty("total_allocated_amount")
    private double totalAllocatedAmount;
    @JsonProperty("base_total_allocated_amount")
    private double baseTotalAllocatedAmount;
    @JsonProperty("unallocated_amount")
    private double unallocatedAmount;
    @JsonProperty("difference_amount")
    private double differenceAmount;
    @JsonProperty("apply_tax_withholding_amount")
    private int applyTaxWithholdingAmount;
    @JsonProperty("base_total_taxes_and_charges")
    private double baseTotalTaxesAndCharges;
    @JsonProperty("total_taxes_and_charges")
    private double totalTaxesAndCharges;
    @JsonProperty("reference_no")
    private String referenceNo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("reference_date")
    private LocalDate referenceDate;
    
    @JsonProperty("status")
    private String status;
    @JsonProperty("custom_remarks")
    private int customRemarks;
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
    
        public PaymentEntryDTO( String name, String owner, LocalDateTime creation, LocalDateTime modified, String modifiedBy, int docstatus,
                                int idx, String namingSeries, String paymentType, String paymentOrderStatus, LocalDate postingDate, String modeOfPayment,
                                String company, String partyType, String party, String partyName, int bookAdvancePaymentsInSeparatePartyAccount,
                                int reconcileOnAdvancePaymentDate, String advanceReconciliationTakesEffectOn, double partyBalance,
                                String paidFrom, String paidFromAccountType, String paidFromAccountCurrency, double paidFromAccountBalance,
                                String paidTo, String paidToAccountType, String paidToAccountCurrency, double paidToAccountBalance, double paidAmount,
                                double paidAmountAfterTax, double sourceExchangeRate, double basePaidAmount, double basePaidAmountAfterTax,
                                double receivedAmount, double receivedAmountAfterTax, double targetExchangeRate, double baseReceivedAmount,
                                double baseReceivedAmountAfterTax, double totalAllocatedAmount, double baseTotalAllocatedAmount, double unallocatedAmount,
                                double differenceAmount, int applyTaxWithholdingAmount, double baseTotalTaxesAndCharges, double totalTaxesAndCharges,
                                String referenceNo, LocalDate referenceDate, String status, int customRemarks, String remarks, String baseInWords,
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

        public int getDocstatus() { return docstatus; }
        public void setDocstatus(int docstatus) { this.docstatus = docstatus; }

        public int getIdx() { return idx; }
        public void setIdx(int idx) { this.idx = idx; }

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

        public int getBookAdvancePaymentsInSeparatePartyAccount() { return bookAdvancePaymentsInSeparatePartyAccount; }
        public void setBookAdvancePaymentsInSeparatePartyAccount(int bookAdvancePaymentsInSeparatePartyAccount) { this.bookAdvancePaymentsInSeparatePartyAccount = bookAdvancePaymentsInSeparatePartyAccount; }

        public int getReconcileOnAdvancePaymentDate() { return reconcileOnAdvancePaymentDate; }
        public void setReconcileOnAdvancePaymentDate(int reconcileOnAdvancePaymentDate) { this.reconcileOnAdvancePaymentDate = reconcileOnAdvancePaymentDate; }

        public String getAdvanceReconciliationTakesEffectOn() { return advanceReconciliationTakesEffectOn; }
        public void setAdvanceReconciliationTakesEffectOn(String advanceReconciliationTakesEffectOn) { this.advanceReconciliationTakesEffectOn = advanceReconciliationTakesEffectOn; }

        public double getPartyBalance() { return partyBalance; }
        public void setPartyBalance(double partyBalance) { this.partyBalance = partyBalance; }

        public String getPaidFrom() { return paidFrom; }
        public void setPaidFrom(String paidFrom) { this.paidFrom = paidFrom; }

        public String getPaidFromAccountType() { return paidFromAccountType; }
        public void setPaidFromAccountType(String paidFromAccountType) { this.paidFromAccountType = paidFromAccountType; }

        public String getPaidFromAccountCurrency() { return paidFromAccountCurrency; }
        public void setPaidFromAccountCurrency(String paidFromAccountCurrency) { this.paidFromAccountCurrency = paidFromAccountCurrency; }

        public double getPaidFromAccountBalance() { return paidFromAccountBalance; }
        public void setPaidFromAccountBalance(double paidFromAccountBalance) { this.paidFromAccountBalance = paidFromAccountBalance; }

        public String getPaidTo() { return paidTo; }
        public void setPaidTo(String paidTo) { this.paidTo = paidTo; }

        public String getPaidToAccountType() { return paidToAccountType; }
        public void setPaidToAccountType(String paidToAccountType) { this.paidToAccountType = paidToAccountType; }

        public String getPaidToAccountCurrency() { return paidToAccountCurrency; }
        public void setPaidToAccountCurrency(String paidToAccountCurrency) { this.paidToAccountCurrency = paidToAccountCurrency; }

        public double getPaidToAccountBalance() { return paidToAccountBalance; }
        public void setPaidToAccountBalance(double paidToAccountBalance) { this.paidToAccountBalance = paidToAccountBalance; }

        public double getPaidAmount() { return paidAmount; }
        public void setPaidAmount(double paidAmount) { this.paidAmount = paidAmount; }

        public double getPaidAmountAfterTax() { return paidAmountAfterTax; }
        public void setPaidAmountAfterTax(double paidAmountAfterTax) { this.paidAmountAfterTax = paidAmountAfterTax; }

        public double getSourceExchangeRate() { return sourceExchangeRate; }
        public void setSourceExchangeRate(double sourceExchangeRate) { this.sourceExchangeRate = sourceExchangeRate; }

        public double getBasePaidAmount() { return basePaidAmount; }
        public void setBasePaidAmount(double basePaidAmount) { this.basePaidAmount = basePaidAmount; }

        public double getBasePaidAmountAfterTax() { return basePaidAmountAfterTax; }
        public void setBasePaidAmountAfterTax(double basePaidAmountAfterTax) { this.basePaidAmountAfterTax = basePaidAmountAfterTax; }

        public double getReceivedAmount() { return receivedAmount; }
        public void setReceivedAmount(double receivedAmount) { this.receivedAmount = receivedAmount; }

        public double getReceivedAmountAfterTax() { return receivedAmountAfterTax; }
        public void setReceivedAmountAfterTax(double receivedAmountAfterTax) { this.receivedAmountAfterTax = receivedAmountAfterTax; }

        public double getTargetExchangeRate() { return targetExchangeRate; }
        public void setTargetExchangeRate(double targetExchangeRate) { this.targetExchangeRate = targetExchangeRate; }

        public double getBaseReceivedAmount() { return baseReceivedAmount; }
        public void setBaseReceivedAmount(double baseReceivedAmount) { this.baseReceivedAmount = baseReceivedAmount; }

        public double getBaseReceivedAmountAfterTax() { return baseReceivedAmountAfterTax; }
        public void setBaseReceivedAmountAfterTax(double baseReceivedAmountAfterTax) { this.baseReceivedAmountAfterTax = baseReceivedAmountAfterTax; }

        public double getTotalAllocatedAmount() { return totalAllocatedAmount; }
        public void setTotalAllocatedAmount(double totalAllocatedAmount) { this.totalAllocatedAmount = totalAllocatedAmount; }

        public double getBaseTotalAllocatedAmount() { return baseTotalAllocatedAmount; }
        public void setBaseTotalAllocatedAmount(double baseTotalAllocatedAmount) { this.baseTotalAllocatedAmount = baseTotalAllocatedAmount; }

        public double getUnallocatedAmount() { return unallocatedAmount; }
        public void setUnallocatedAmount(double unallocatedAmount) { this.unallocatedAmount = unallocatedAmount; }

        public double getDifferenceAmount() { return differenceAmount; }
        public void setDifferenceAmount(double differenceAmount) { this.differenceAmount = differenceAmount; }

        public int getApplyTaxWithholdingAmount() { return applyTaxWithholdingAmount; }
        public void setApplyTaxWithholdingAmount(int applyTaxWithholdingAmount) { this.applyTaxWithholdingAmount = applyTaxWithholdingAmount; }

        public double getBaseTotalTaxesAndCharges() { return baseTotalTaxesAndCharges; }
        public void setBaseTotalTaxesAndCharges(double baseTotalTaxesAndCharges) { this.baseTotalTaxesAndCharges = baseTotalTaxesAndCharges; }

        public double getTotalTaxesAndCharges() { return totalTaxesAndCharges; }
        public void setTotalTaxesAndCharges(double totalTaxesAndCharges) { this.totalTaxesAndCharges = totalTaxesAndCharges; }

        public String getReferenceNo() { return referenceNo; }
        public void setReferenceNo(String referenceNo) { this.referenceNo = referenceNo; }

        public LocalDate getReferenceDate() { return referenceDate; }
        public void setReferenceDate(LocalDate referenceDate) { this.referenceDate = referenceDate; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public int getCustomRemarks() { return customRemarks; }
        public void setCustomRemarks(int customRemarks) { this.customRemarks = customRemarks; }

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
