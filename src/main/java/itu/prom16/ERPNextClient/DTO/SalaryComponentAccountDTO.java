package itu.prom16.ERPNextClient.DTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import itu.prom16.ERPNextClient.config.FlexibleLocalDateTimeDeserializer;

/**
 *
 * @author Fanou
 */
public class SalaryComponentAccountDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("owner")
    private String owner;

    @JsonProperty("creation")
    @JsonDeserialize(using = FlexibleLocalDateTimeDeserializer.class)
    private LocalDateTime creation;

    @JsonProperty("modified")
    @JsonDeserialize(using = FlexibleLocalDateTimeDeserializer.class)
    private LocalDateTime modified;

    @JsonProperty("modified_by")
    private String modifiedBy;

    @JsonProperty("docstatus")
    private int docstatus;

    @JsonProperty("idx")
    private int idx;

    @JsonProperty("company")
    private String company;

    @JsonProperty("account")
    private String account;


    @JsonProperty("parent")
    private String parent;

    @JsonProperty("parentfield")
    private String parentfield;

    @JsonProperty("parenttype")
    private String parenttype;

    @JsonProperty("doctype")
    private String doctype;

    public SalaryComponentAccountDTO() {}

    public SalaryComponentAccountDTO(String company, String account) {
        this.company = company;
        this.account = account;
    }

    public SalaryComponentAccountDTO(String name, String owner, LocalDateTime creation, LocalDateTime modified,
            String modifiedBy, int docstatus, int idx, String company, String account, String parent,
            String parentfield, String parenttype, String doctype) {
        this.name = name;
        this.owner = owner;
        this.creation = creation;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
        this.docstatus = docstatus;
        this.idx = idx;
        this.company = company;
        this.account = account;
        this.parent = parent;
        this.parentfield = parentfield;
        this.parenttype = parenttype;
        this.doctype = doctype;
    }


    public String getName() { return name;}
    public void setName(String name) { this.name = name; }

    public String getOwner() { return owner;}
    public void setOwner(String owner) { this.owner = owner; }

    public LocalDateTime getCreation() { return creation;}
    public void setCreation(LocalDateTime creation) { this.creation = creation; }

    public LocalDateTime getModified() { return modified;}
    public void setModified(LocalDateTime modified) { this.modified = modified; }

    public String getModifiedBy() { return modifiedBy;}
    public void setModifiedBy(String modifiedBy) { this.modifiedBy = modifiedBy; }

    public int getDocstatus() { return docstatus;}
    public void setDocstatus(int docstatus) { this.docstatus = docstatus; }

    public int getIdx() { return idx;}
    public void setIdx(int idx) { this.idx = idx; }

    public String getCompany() { return company;}
    public void setCompany(String company) { this.company = company; }

    public String getAccount() { return account;}
    public void setAccount(String account) { this.account = account; }

    public String getParent() { return parent;}
    public void setParent(String parent) { this.parent = parent; }

    public String getParentfield() { return parentfield;}
    public void setParentfield(String parentfield) { this.parentfield = parentfield; }

    public String getParenttype() { return parenttype;}
    public void setParenttype(String parenttype) { this.parenttype = parenttype; }

    public String getDoctype() { return doctype;}
    public void setDoctype(String doctype) { this.doctype = doctype; }
}
