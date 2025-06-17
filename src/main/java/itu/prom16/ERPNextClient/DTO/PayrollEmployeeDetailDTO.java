package itu.prom16.ERPNextClient.DTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import itu.prom16.ERPNextClient.config.FlexibleLocalDateTimeDeserializer;

/**
 *
 * @author Fanou
 */
public class PayrollEmployeeDetailDTO {
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
    private Integer docstatus;

    @JsonProperty("idx")
    private Integer idx;

    @JsonProperty("employee")
    private String employee;

    @JsonProperty("employee_name")
    private String employeeName;

    @JsonProperty("is_salary_withheld")
    private Integer isSalaryWithheld;

    @JsonProperty("parent")
    private String parent;

    @JsonProperty("parentfield")
    private String parentfield;

    @JsonProperty("parenttype")
    private String parenttype;

    @JsonProperty("doctype")
    private String doctype;

    public PayrollEmployeeDetailDTO(String name, String owner, LocalDateTime creation, LocalDateTime modified,
            String modifiedBy, Integer docstatus, Integer idx, String employee, String employeeName,
            Integer isSalaryWithheld, String parent, String parentfield, String parenttype, String doctype) {
        this.name = name;
        this.owner = owner;
        this.creation = creation;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
        this.docstatus = docstatus;
        this.idx = idx;
        this.employee = employee;
        this.employeeName = employeeName;
        this.isSalaryWithheld = isSalaryWithheld;
        this.parent = parent;
        this.parentfield = parentfield;
        this.parenttype = parenttype;
        this.doctype = doctype;
    } 

    public PayrollEmployeeDetailDTO() {}

    public PayrollEmployeeDetailDTO(String employee) {
        this.employee = employee;
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

    public String getEmployee() { return employee; }
    public void setEmployee(String employee) { this.employee = employee; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public Integer getIsSalaryWithheld() { return isSalaryWithheld; }
    public void setIsSalaryWithheld(Integer isSalaryWithheld) { this.isSalaryWithheld = isSalaryWithheld; }

    public String getParent() { return parent; }
    public void setParent(String parent) { this.parent = parent; }

    public String getParentfield() { return parentfield; }
    public void setParentfield(String parentfield) { this.parentfield = parentfield; }

    public String getParenttype() { return parenttype; }
    public void setParenttype(String parenttype) { this.parenttype = parenttype; }

    public String getDoctype() { return doctype; }
    public void setDoctype(String doctype) { this.doctype = doctype; }
}
