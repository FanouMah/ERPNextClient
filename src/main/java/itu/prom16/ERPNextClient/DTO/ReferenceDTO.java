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
    private Integer docstatus;
    @JsonProperty("idx")
    private Integer idx;
    @JsonProperty("reference_doctype")
    private String referenceDoctype;
    @JsonProperty("reference_name")
    private String referenceName;

    @JsonProperty("due_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @JsonProperty("payment_term_outstanding")
    private Double paymentTermOutstanding;
    @JsonProperty("total_amount")
    private Double totalAmount;
    @JsonProperty("outstanding_amount")
    private Double outstandingAmount;
    @JsonProperty("allocated_amount")
    private Double allocatedAmount;
    @JsonProperty("exchange_rate")
    private Double exchangeRate;
    @JsonProperty("exchange_gain_loss")
    private Double exchangeGainLoss;
    @JsonProperty("account")
    private String account;
    @JsonProperty("payment_request_outstanding")
    private Double paymentRequestOutstanding;
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
                        Integer docstatus, Integer idx, String referenceDoctype, String referenceName, LocalDate dueDate,
                        Double paymentTermOutstanding, Double totalAmount, Double outstandingAmount, Double allocatedAmount,
                        Double exchangeRate, Double exchangeGainLoss, String account, Double paymentRequestOutstanding,
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

    public Integer getDocstatus() { return docstatus; }
    public void setDocstatus(Integer docstatus) { this.docstatus = docstatus; }

    public Integer getIdx() { return idx; }
    public void setIdx(Integer idx) { this.idx = idx; }

    public String getReferenceDoctype() { return referenceDoctype; }
    public void setReferenceDoctype(String referenceDoctype) { this.referenceDoctype = referenceDoctype; }

    public String getReferenceName() { return referenceName; }
    public void setReferenceName(String referenceName) { this.referenceName = referenceName; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public Double getPaymentTermOutstanding() { return paymentTermOutstanding; }
    public void setPaymentTermOutstanding(Double paymentTermOutstanding) { this.paymentTermOutstanding = paymentTermOutstanding; }

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }

    public Double getOutstandingAmount() { return outstandingAmount; }
    public void setOutstandingAmount(Double outstandingAmount) { this.outstandingAmount = outstandingAmount; }

    public Double getAllocatedAmount() { return allocatedAmount; }
    public void setAllocatedAmount(Double allocatedAmount) { this.allocatedAmount = allocatedAmount; }

    public Double getExchangeRate() { return exchangeRate; }
    public void setExchangeRate(Double exchangeRate) { this.exchangeRate = exchangeRate; }

    public Double getExchangeGainLoss() { return exchangeGainLoss; }
    public void setExchangeGainLoss(Double exchangeGainLoss) { this.exchangeGainLoss = exchangeGainLoss; }

    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }

    public Double getPaymentRequestOutstanding() { return paymentRequestOutstanding; }
    public void setPaymentRequestOutstanding(Double paymentRequestOutstanding) { this.paymentRequestOutstanding = paymentRequestOutstanding; }

    public String getParent() { return parent; }
    public void setParent(String parent) { this.parent = parent; }

    public String getParentfield() { return parentfield; }
    public void setParentfield(String parentfield) { this.parentfield = parentfield; }

    public String getParenttype() { return parenttype; }
    public void setParenttype(String parenttype) { this.parenttype = parenttype; }

    public String getDoctype() { return doctype; }
    public void setDoctype(String doctype) { this.doctype = doctype; }
}
