package itu.prom16.ERPNextClient.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @JsonProperty("salutation")
    private String salutation;

    @JsonProperty("image")
    private String image;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("department")
    private String department;

    @JsonProperty("employment_type")
    private String employmentType;

    @JsonProperty("employee_number")
    private String employeeNumber;

    @JsonProperty("designation")
    private String designation;

    @JsonProperty("reports_to")
    private String reportsTo;

    @JsonProperty("branch")
    private String branch;

    @JsonProperty("grade")
    private String grade;

    @JsonProperty("job_applicant")
    private String jobApplicant;

    @JsonProperty("scheduled_confirmation_date")
    private LocalDate scheduledConfirmationDate;

    @JsonProperty("final_confirmation_date")
    private LocalDate finalConfirmationDate;

    @JsonProperty("contract_end_date")
    private LocalDate contractEndDate;

    @JsonProperty("cell_number")
    private String cellNumber;

    @JsonProperty("personal_email")
    private String personalEmail;

    @JsonProperty("company_email")
    private String companyEmail;

    @JsonProperty("prefered_email")
    private String preferedEmail;

    @JsonProperty("current_address")
    private String currentAddress;

    @JsonProperty("permanent_address")
    private String permanentAddress;

    @JsonProperty("person_to_be_contacted")
    private String personToBeContacted;

    @JsonProperty("emergency_phone_number")
    private String emergencyPhoneNumber;

    @JsonProperty("relation")
    private String relation;

    @JsonProperty("attendance_device_id")
    private String attendanceDeviceId;

    @JsonProperty("holiday_list")
    private String holidayList;

    @JsonProperty("default_shift")
    private String defaultShift;

    @JsonProperty("expense_approver")
    private String expenseApprover;

    @JsonProperty("leave_approver")
    private String leaveApprover;

    @JsonProperty("shift_request_approver")
    private String shiftRequestApprover;

    @JsonProperty("payroll_cost_center")
    private String payrollCostCenter;

    @JsonProperty("bank_name")
    private String bankName;

    @JsonProperty("bank_ac_no")
    private String bankAcNo;

    @JsonProperty("iban")
    private String iban;

    @JsonProperty("family_background")
    private String familyBackground;

    @JsonProperty("health_details")
    private String healthDetails;

    @JsonProperty("health_insurance_provider")
    private String healthInsuranceProvider;

    @JsonProperty("health_insurance_no")
    private String healthInsuranceNo;

    @JsonProperty("passport_number")
    private String passportNumber;

    @JsonProperty("valid_upto")
    private LocalDate validUpto;

    @JsonProperty("date_of_issue")
    private LocalDate dateOfIssue;

    @JsonProperty("place_of_issue")
    private String placeOfIssue;

    @JsonProperty("bio")
    private String bio;

    @JsonProperty("resignation_letter_date")
    private LocalDate resignationLetterDate;

    @JsonProperty("relieving_date")
    private LocalDate relievingDate;

    @JsonProperty("held_on")
    private LocalDate heldOn;

    @JsonProperty("new_workplace")
    private String newWorkplace;

    @JsonProperty("encashment_date")
    private LocalDate encashmentDate;

    @JsonProperty("reason_for_leaving")
    private String reasonForLeaving;

    @JsonProperty("feedback")
    private String feedback;

    public EmployeeDTO() {}

    public EmployeeDTO(String name, String owner, LocalDateTime creation, LocalDateTime modified, String modifiedBy,
        int docstatus, int idx, String employee, String namingSeries, String firstName, String middleName,
        String lastName, String employeeName, String gender, LocalDate dateOfBirth, LocalDate dateOfJoining,
        String status, int createUserPermission, String company, int noticeNumberOfDays, LocalDate dateOfRetirement,
        String preferedContactEmail, int unsubscribed, String currentAccommodationType,
        String permanentAccommodationType, double ctc, String salaryCurrency, String salaryMode,
        String maritalStatus, String bloodGroup, String leaveEncashed, int lft, int rgt, String oldParent,
        String doctype, List<Object> education, List<Object> externalWorkHistory, List<Object> internalWorkHistory,
        String salutation, String image, String userId, String department, String employmentType,
        String employeeNumber, String designation, String reportsTo, String branch, String grade,
        String jobApplicant, LocalDate scheduledConfirmationDate, LocalDate finalConfirmationDate,
        LocalDate contractEndDate, String cellNumber, String personalEmail, String companyEmail,
        String preferedEmail, String currentAddress, String permanentAddress, String personToBeContacted,
        String emergencyPhoneNumber, String relation, String attendanceDeviceId, String holidayList,
        String defaultShift, String expenseApprover, String leaveApprover, String shiftRequestApprover,
        String payrollCostCenter, String bankName, String bankAcNo, String iban, String familyBackground,
        String healthDetails, String healthInsuranceProvider, String healthInsuranceNo, String passportNumber,
        LocalDate validUpto, LocalDate dateOfIssue, String placeOfIssue, String bio,
        LocalDate resignationLetterDate, LocalDate relievingDate, LocalDate heldOn, String newWorkplace,
        LocalDate encashmentDate, String reasonForLeaving, String feedback) {
    this.name = name;
    this.owner = owner;
    this.creation = creation;
    this.modified = modified;
    this.modifiedBy = modifiedBy;
    this.docstatus = docstatus;
    this.idx = idx;
    this.employee = employee;
    this.namingSeries = namingSeries;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.employeeName = employeeName;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.dateOfJoining = dateOfJoining;
    this.status = status;
    this.createUserPermission = createUserPermission;
    this.company = company;
    this.noticeNumberOfDays = noticeNumberOfDays;
    this.dateOfRetirement = dateOfRetirement;
    this.preferedContactEmail = preferedContactEmail;
    this.unsubscribed = unsubscribed;
    this.currentAccommodationType = currentAccommodationType;
    this.permanentAccommodationType = permanentAccommodationType;
    this.ctc = ctc;
    this.salaryCurrency = salaryCurrency;
    this.salaryMode = salaryMode;
    this.maritalStatus = maritalStatus;
    this.bloodGroup = bloodGroup;
    this.leaveEncashed = leaveEncashed;
    this.lft = lft;
    this.rgt = rgt;
    this.oldParent = oldParent;
    this.doctype = doctype;
    this.education = education;
    this.externalWorkHistory = externalWorkHistory;
    this.internalWorkHistory = internalWorkHistory;
    this.salutation = salutation;
    this.image = image;
    this.userId = userId;
    this.department = department;
    this.employmentType = employmentType;
    this.employeeNumber = employeeNumber;
    this.designation = designation;
    this.reportsTo = reportsTo;
    this.branch = branch;
    this.grade = grade;
    this.jobApplicant = jobApplicant;
    this.scheduledConfirmationDate = scheduledConfirmationDate;
    this.finalConfirmationDate = finalConfirmationDate;
    this.contractEndDate = contractEndDate;
    this.cellNumber = cellNumber;
    this.personalEmail = personalEmail;
    this.companyEmail = companyEmail;
    this.preferedEmail = preferedEmail;
    this.currentAddress = currentAddress;
    this.permanentAddress = permanentAddress;
    this.personToBeContacted = personToBeContacted;
    this.emergencyPhoneNumber = emergencyPhoneNumber;
    this.relation = relation;
    this.attendanceDeviceId = attendanceDeviceId;
    this.holidayList = holidayList;
    this.defaultShift = defaultShift;
    this.expenseApprover = expenseApprover;
    this.leaveApprover = leaveApprover;
    this.shiftRequestApprover = shiftRequestApprover;
    this.payrollCostCenter = payrollCostCenter;
    this.bankName = bankName;
    this.bankAcNo = bankAcNo;
    this.iban = iban;
    this.familyBackground = familyBackground;
    this.healthDetails = healthDetails;
    this.healthInsuranceProvider = healthInsuranceProvider;
    this.healthInsuranceNo = healthInsuranceNo;
    this.passportNumber = passportNumber;
    this.validUpto = validUpto;
    this.dateOfIssue = dateOfIssue;
    this.placeOfIssue = placeOfIssue;
    this.bio = bio;
    this.resignationLetterDate = resignationLetterDate;
    this.relievingDate = relievingDate;
    this.heldOn = heldOn;
    this.newWorkplace = newWorkplace;
    this.encashmentDate = encashmentDate;
    this.reasonForLeaving = reasonForLeaving;
    this.feedback = feedback;
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

    public String getSalutation() { return salutation; }
    public void setSalutation(String salutation) { this.salutation = salutation; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getEmploymentType() { return employmentType; }
    public void setEmploymentType(String employmentType) { this.employmentType = employmentType; }

    public String getEmployeeNumber() { return employeeNumber; }
    public void setEmployeeNumber(String employeeNumber) { this.employeeNumber = employeeNumber; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public String getReportsTo() { return reportsTo; }
    public void setReportsTo(String reportsTo) { this.reportsTo = reportsTo; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getJobApplicant() { return jobApplicant; }
    public void setJobApplicant(String jobApplicant) { this.jobApplicant = jobApplicant; }

    public LocalDate getScheduledConfirmationDate() { return scheduledConfirmationDate; }
    public void setScheduledConfirmationDate(LocalDate scheduledConfirmationDate) { this.scheduledConfirmationDate = scheduledConfirmationDate; }

    public LocalDate getFinalConfirmationDate() { return finalConfirmationDate; }
    public void setFinalConfirmationDate(LocalDate finalConfirmationDate) { this.finalConfirmationDate = finalConfirmationDate; }

    public LocalDate getContractEndDate() { return contractEndDate; }
    public void setContractEndDate(LocalDate contractEndDate) { this.contractEndDate = contractEndDate; }

    public String getCellNumber() { return cellNumber; }
    public void setCellNumber(String cellNumber) { this.cellNumber = cellNumber; }

    public String getPersonalEmail() { return personalEmail; }
    public void setPersonalEmail(String personalEmail) { this.personalEmail = personalEmail; }

    public String getCompanyEmail() { return companyEmail; }
    public void setCompanyEmail(String companyEmail) { this.companyEmail = companyEmail; }

    public String getPreferedEmail() { return preferedEmail; }
    public void setPreferedEmail(String preferedEmail) { this.preferedEmail = preferedEmail; }

    public String getCurrentAddress() { return currentAddress; }
    public void setCurrentAddress(String currentAddress) { this.currentAddress = currentAddress; }

    public String getPermanentAddress() { return permanentAddress; }
    public void setPermanentAddress(String permanentAddress) { this.permanentAddress = permanentAddress; }

    public String getPersonToBeContacted() { return personToBeContacted; }
    public void setPersonToBeContacted(String personToBeContacted) { this.personToBeContacted = personToBeContacted; }

    public String getEmergencyPhoneNumber() { return emergencyPhoneNumber; }
    public void setEmergencyPhoneNumber(String emergencyPhoneNumber) { this.emergencyPhoneNumber = emergencyPhoneNumber; }

    public String getRelation() { return relation; }
    public void setRelation(String relation) { this.relation = relation; }

    public String getAttendanceDeviceId() { return attendanceDeviceId; }
    public void setAttendanceDeviceId(String attendanceDeviceId) { this.attendanceDeviceId = attendanceDeviceId; }

    public String getHolidayList() { return holidayList; }
    public void setHolidayList(String holidayList) { this.holidayList = holidayList; }

    public String getDefaultShift() { return defaultShift; }
    public void setDefaultShift(String defaultShift) { this.defaultShift = defaultShift; }

    public String getExpenseApprover() { return expenseApprover; }
    public void setExpenseApprover(String expenseApprover) { this.expenseApprover = expenseApprover; }

    public String getLeaveApprover() { return leaveApprover; }
    public void setLeaveApprover(String leaveApprover) { this.leaveApprover = leaveApprover; }

    public String getShiftRequestApprover() { return shiftRequestApprover; }
    public void setShiftRequestApprover(String shiftRequestApprover) { this.shiftRequestApprover = shiftRequestApprover; }

    public String getPayrollCostCenter() { return payrollCostCenter; }
    public void setPayrollCostCenter(String payrollCostCenter) { this.payrollCostCenter = payrollCostCenter; }

    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }

    public String getBankAcNo() { return bankAcNo; }
    public void setBankAcNo(String bankAcNo) { this.bankAcNo = bankAcNo; }

    public String getIban() { return iban; }
    public void setIban(String iban) { this.iban = iban; }

    public String getFamilyBackground() { return familyBackground; }
    public void setFamilyBackground(String familyBackground) { this.familyBackground = familyBackground; }

    public String getHealthDetails() { return healthDetails; }
    public void setHealthDetails(String healthDetails) { this.healthDetails = healthDetails; }

    public String getHealthInsuranceProvider() { return healthInsuranceProvider; }
    public void setHealthInsuranceProvider(String healthInsuranceProvider) { this.healthInsuranceProvider = healthInsuranceProvider; }

    public String getHealthInsuranceNo() { return healthInsuranceNo; }
    public void setHealthInsuranceNo(String healthInsuranceNo) { this.healthInsuranceNo = healthInsuranceNo; }

    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }

    public LocalDate getValidUpto() { return validUpto; }
    public void setValidUpto(LocalDate validUpto) { this.validUpto = validUpto; }

    public LocalDate getDateOfIssue() { return dateOfIssue; }
    public void setDateOfIssue(LocalDate dateOfIssue) { this.dateOfIssue = dateOfIssue; }

    public String getPlaceOfIssue() { return placeOfIssue; }
    public void setPlaceOfIssue(String placeOfIssue) { this.placeOfIssue = placeOfIssue; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public LocalDate getResignationLetterDate() { return resignationLetterDate; }
    public void setResignationLetterDate(LocalDate resignationLetterDate) { this.resignationLetterDate = resignationLetterDate; }

    public LocalDate getRelievingDate() { return relievingDate; }
    public void setRelievingDate(LocalDate relievingDate) { this.relievingDate = relievingDate; }

    public LocalDate getHeldOn() { return heldOn; }
    public void setHeldOn(LocalDate heldOn) { this.heldOn = heldOn; }

    public String getNewWorkplace() { return newWorkplace; }
    public void setNewWorkplace(String newWorkplace) { this.newWorkplace = newWorkplace; }

    public LocalDate getEncashmentDate() { return encashmentDate; }
    public void setEncashmentDate(LocalDate encashmentDate) { this.encashmentDate = encashmentDate; }

    public String getReasonForLeaving() { return reasonForLeaving; }
    public void setReasonForLeaving(String reasonForLeaving) { this.reasonForLeaving = reasonForLeaving; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    
}
