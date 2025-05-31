package itu.prom16.ERPNextClient.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import itu.prom16.ERPNextClient.config.FlexibleLocalDateTimeDeserializer;

/**
 *
 * @author Fanou
 */
public class EmployeeDTO {
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

    @JsonProperty("employee")
    private String employee;

    @JsonProperty("naming_series")
    private String namingSeries;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("middle_name")
    private String middleName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("employee_name")
    private String employeeName;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("date_of_birth")
    @JsonFormat(pattern = "yyyy-MM-dd") 
    private LocalDate dateOfBirth;

    @JsonProperty("date_of_joining")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfJoining;

    @JsonProperty("status")
    private String status;

    @JsonProperty("create_user_permission")
    private int createUserPermission;

    @JsonProperty("company")
    private String company;

    @JsonProperty("notice_number_of_days")
    private int noticeNumberOfDays;

    @JsonProperty("date_of_retirement")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfRetirement;

    @JsonProperty("prefered_contact_email")
    private String preferedContactEmail;

    @JsonProperty("unsubscribed")
    private int unsubscribed;

    @JsonProperty("current_accommodation_type")
    private String currentAccommodationType;

    @JsonProperty("permanent_accommodation_type")
    private String permanentAccommodationType;

    @JsonProperty("ctc")
    private double ctc;

    @JsonProperty("salary_currency")
    private String salaryCurrency;

    @JsonProperty("salary_mode")
    private String salaryMode;

    @JsonProperty("marital_status")
    private String maritalStatus;

    @JsonProperty("blood_group")
    private String bloodGroup;

    @JsonProperty("leave_encashed")
    private String leaveEncashed;

    @JsonProperty("lft")
    private int lft;

    @JsonProperty("rgt")
    private int rgt;

    @JsonProperty("old_parent")
    private String oldParent;

    @JsonProperty("doctype")
    private String doctype;

    @JsonProperty("education")
    private java.util.List<Object> education;

    @JsonProperty("external_work_history")
    private java.util.List<Object> externalWorkHistory;

    @JsonProperty("internal_work_history")
    private java.util.List<Object> internalWorkHistory;

    public EmployeeDTO() {}

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

    public int getDocstatus() { return docstatus; }
    public void setDocstatus(int docstatus) { this.docstatus = docstatus; }

    public int getIdx() { return idx; }
    public void setIdx(int idx) { this.idx = idx; }

    public String getEmployee() { return employee; }
    public void setEmployee(String employee) { this.employee = employee; }

    public String getNamingSeries() { return namingSeries; }
    public void setNamingSeries(String namingSeries) { this.namingSeries = namingSeries; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public LocalDate getDateOfJoining() { return dateOfJoining; }
    public void setDateOfJoining(LocalDate dateOfJoining) { this.dateOfJoining = dateOfJoining; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getCreateUserPermission() { return createUserPermission; }
    public void setCreateUserPermission(int createUserPermission) { this.createUserPermission = createUserPermission; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public int getNoticeNumberOfDays() { return noticeNumberOfDays; }
    public void setNoticeNumberOfDays(int noticeNumberOfDays) { this.noticeNumberOfDays = noticeNumberOfDays; }

    public LocalDate getDateOfRetirement() { return dateOfRetirement; }
    public void setDateOfRetirement(LocalDate dateOfRetirement) { this.dateOfRetirement = dateOfRetirement; }

    public String getPreferedContactEmail() { return preferedContactEmail; }
    public void setPreferedContactEmail(String preferedContactEmail) { this.preferedContactEmail = preferedContactEmail; }

    public int getUnsubscribed() { return unsubscribed; }
    public void setUnsubscribed(int unsubscribed) { this.unsubscribed = unsubscribed; }

    public String getCurrentAccommodationType() { return currentAccommodationType; }
    public void setCurrentAccommodationType(String currentAccommodationType) { this.currentAccommodationType = currentAccommodationType; }

    public String getPermanentAccommodationType() { return permanentAccommodationType; }
    public void setPermanentAccommodationType(String permanentAccommodationType) { this.permanentAccommodationType = permanentAccommodationType; }

    public double getCtc() { return ctc; }
    public void setCtc(double ctc) { this.ctc = ctc; }

    public String getSalaryCurrency() { return salaryCurrency; }
    public void setSalaryCurrency(String salaryCurrency) { this.salaryCurrency = salaryCurrency; }

    public String getSalaryMode() { return salaryMode; }
    public void setSalaryMode(String salaryMode) { this.salaryMode = salaryMode; }

    public String getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public String getLeaveEncashed() { return leaveEncashed; }
    public void setLeaveEncashed(String leaveEncashed) { this.leaveEncashed = leaveEncashed; }

    public int getLft() { return lft; }
    public void setLft(int lft) { this.lft = lft; }

    public int getRgt() { return rgt; }
    public void setRgt(int rgt) { this.rgt = rgt; }

    public String getOldParent() { return oldParent; }
    public void setOldParent(String oldParent) { this.oldParent = oldParent; }

    public String getDoctype() { return doctype; }
    public void setDoctype(String doctype) { this.doctype = doctype; }

    public java.util.List<Object> getEducation() { return education; }
    public void setEducation(java.util.List<Object> education) { this.education = education; }

    public java.util.List<Object> getExternalWorkHistory() { return externalWorkHistory; }
    public void setExternalWorkHistory(java.util.List<Object> externalWorkHistory) { this.externalWorkHistory = externalWorkHistory; }

    public java.util.List<Object> getInternalWorkHistory() { return internalWorkHistory; }
    public void setInternalWorkHistory(java.util.List<Object> internalWorkHistory) { this.internalWorkHistory = internalWorkHistory; }
}
