package itu.prom16.ERPNextClient.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Fanou
 */
public class ReferenceDTO {
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
    @JsonProperty("reference_doctype")
    private String referenceDoctype;
    @JsonProperty("reference_name")
    private String referenceName;

    @JsonProperty("due_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @JsonProperty("payment_term_outstanding")
    private double paymentTermOutstanding;
    @JsonProperty("total_amount")
    private double totalAmount;
    @JsonProperty("outstanding_amount")
    private double outstandingAmount;
    @JsonProperty("allocated_amount")
    private double allocatedAmount;
    @JsonProperty("exchange_rate")
    private double exchangeRate;
    @JsonProperty("exchange_gain_loss")
    private double exchangeGainLoss;
    @JsonProperty("account")
    private String account;
    @JsonProperty("payment_request_outstanding")
    private double paymentRequestOutstanding;
    @JsonProperty("parent")
    private String parent;
    @JsonProperty("parentfield")
    private String parentfield;
    @JsonProperty("parenttype")
    private String parenttype;
    @JsonProperty("doctype")
    private String doctype;

    public ReferenceDTO() {
    }

    public ReferenceDTO(String name, String owner, LocalDateTime creation, LocalDateTime modified, String modifiedBy,
                        int docstatus, int idx, String referenceDoctype, String referenceName, LocalDate dueDate,
                        double paymentTermOutstanding, double totalAmount, double outstandingAmount, double allocatedAmount,
                        double exchangeRate, double exchangeGainLoss, String account, double paymentRequestOutstanding,
                        String parent, String parentfield, String parenttype, String doctype) { 
        this.name = name;
        this.owner = owner;
        this.creation = creation;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
        this.docstatus = docstatus;
        this.idx = idx;
        this.referenceDoctype = referenceDoctype;
        this.referenceName = referenceName;
        this.dueDate = dueDate;
        this.paymentTermOutstanding = paymentTermOutstanding;
        this.totalAmount = totalAmount;
        this.outstandingAmount = outstandingAmount;
        this.allocatedAmount = allocatedAmount;
        this.exchangeRate = exchangeRate;
        this.exchangeGainLoss = exchangeGainLoss;
        this.account = account;
        this.paymentRequestOutstanding = paymentRequestOutstanding;
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

    public String getReferenceDoctype() { return referenceDoctype; }
    public void setReferenceDoctype(String referenceDoctype) { this.referenceDoctype = referenceDoctype; }

    public String getReferenceName() { return referenceName; }
    public void setReferenceName(String referenceName) { this.referenceName = referenceName; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public double getPaymentTermOutstanding() { return paymentTermOutstanding; }
    public void setPaymentTermOutstanding(double paymentTermOutstanding) { this.paymentTermOutstanding = paymentTermOutstanding; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public double getOutstandingAmount() { return outstandingAmount; }
    public void setOutstandingAmount(double outstandingAmount) { this.outstandingAmount = outstandingAmount; }

    public double getAllocatedAmount() { return allocatedAmount; }
    public void setAllocatedAmount(double allocatedAmount) { this.allocatedAmount = allocatedAmount; }

    public double getExchangeRate() { return exchangeRate; }
    public void setExchangeRate(double exchangeRate) { this.exchangeRate = exchangeRate; }

    public double getExchangeGainLoss() { return exchangeGainLoss; }
    public void setExchangeGainLoss(double exchangeGainLoss) { this.exchangeGainLoss = exchangeGainLoss; }

    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }

    public double getPaymentRequestOutstanding() { return paymentRequestOutstanding; }
    public void setPaymentRequestOutstanding(double paymentRequestOutstanding) { this.paymentRequestOutstanding = paymentRequestOutstanding; }

    public String getParent() { return parent; }
    public void setParent(String parent) { this.parent = parent; }

    public String getParentfield() { return parentfield; }
    public void setParentfield(String parentfield) { this.parentfield = parentfield; }

    public String getParenttype() { return parenttype; }
    public void setParenttype(String parenttype) { this.parenttype = parenttype; }

    public String getDoctype() { return doctype; }
    public void setDoctype(String doctype) { this.doctype = doctype; }
}
