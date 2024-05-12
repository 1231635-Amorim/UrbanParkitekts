/**
 * The Collaborator class represents a collaborator in the system.
 * It contains information such as name, birth date, address, contact details, identification, job, and password.
 * Collaborators are associated with specific job positions.
 * They are used within the system to assign tasks and manage projects.
 *
 * @author [João Amorim]
 */

package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Date;

public class Collaborator {
    private String name;
    private Date birthDate;
    private Date admissionDate;
    private String address;
    private String mobile;
    private String email;
    private String taxpayerNumber;
    private String idDocType;
    private String idNumber;
    private Job job;
    private String password;

    /**
     * Constructs a Collaborator object with the specified information.
     *
     * @param name           The name of the collaborator.
     * @param birthDate      The birth date of the collaborator.
     * @param admissionDate  The admission date of the collaborator.
     * @param address        The address of the collaborator.
     * @param mobile         The mobile phone number of the collaborator.
     * @param email          The email address of the collaborator.
     * @param taxpayerNumber The taxpayer number of the collaborator.
     * @param idDocType      The type of identification document.
     * @param idNumber       The identification number.
     * @param job            The job position of the collaborator.
     * @param password       The password of the collaborator.
     */
    public Collaborator(String name, Date birthDate, Date admissionDate, String address, String mobile, String email,
                        String taxpayerNumber, String idDocType, String idNumber, Job job, String password) {
        this.name = name;
        this.birthDate = birthDate;
        this.admissionDate = admissionDate;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.taxpayerNumber = taxpayerNumber;
        this.idDocType = idDocType;
        this.idNumber = idNumber;
        this.job = job;
        this.password = password;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTaxpayerNumber() {
        return taxpayerNumber;
    }

    public void setTaxpayerNumber(String taxpayerNumber) {
        this.taxpayerNumber = taxpayerNumber;
    }

    public String getIdDocType() {
        return idDocType;
    }

    public void setIdDocType(String idDocType) {
        this.idDocType = idDocType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString method

    @Override
    public String toString() {
        return "Collaborator{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", admissionDate=" + admissionDate +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", taxpayerNumber='" + taxpayerNumber + '\'' +
                ", idDocType='" + idDocType + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", job=" + job +
                ", password='" + password + '\'' +
                '}';
    }
}
