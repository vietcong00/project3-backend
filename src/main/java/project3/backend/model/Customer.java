package project3.backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCustomer;

    @Column(name = "name_customer")
    private String nameCustomer;

    @Column(name = "dateofbirth_customer")
    private Date dateofbirthCustomer;

    @Column(name = "phone_customer")
    private String phoneCustomer;

    @Column(name = "peopleid_customer")
    private String peopleidCustomer;

    @Column(name = "daterange_customer")
    private Date daterangeCustomer;

    @Column(name = "issuedby_customer")
    private String issuedbyCustomer;

    @Column(name = "address_customer")
    private String addressCustomer;

    @Column(name = "nationality_customer")
    private String nationalityCustomer;

    @Column(name = "activationdate_customer")
    private Date activationdateCustomer;

    @Column(name = "activationplace_customer")
    private String activationplaceCustomer;

    @Column(name = "note_customer")
    private String noteCustomer;

    @Column(name = "status_customer")
    private String statusCustomer;

    public Customer() {
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Date getDateofbirthCustomer() {
        return dateofbirthCustomer;
    }

    public void setDateofbirthCustomer(Date dateofbirthCustomer) {
        this.dateofbirthCustomer = dateofbirthCustomer;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public String getPeopleidCustomer() {
        return peopleidCustomer;
    }

    public void setPeopleidCustomer(String peopleidCustomer) {
        this.peopleidCustomer = peopleidCustomer;
    }

    public Date getDaterangeCustomer() {
        return daterangeCustomer;
    }

    public void setDaterangeCustomer(Date daterangeCustomer) {
        this.daterangeCustomer = daterangeCustomer;
    }

    public String getIssuedbyCustomer() {
        return issuedbyCustomer;
    }

    public void setIssuedbyCustomer(String issuedbyCustomer) {
        this.issuedbyCustomer = issuedbyCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public String getNationalityCustomer() {
        return nationalityCustomer;
    }

    public void setNationalityCustomer(String nationalityCustomer) {
        this.nationalityCustomer = nationalityCustomer;
    }

    public Date getActivationdateCustomer() {
        return activationdateCustomer;
    }

    public void setActivationdateCustomer(Date activationdateCustomer) {
        this.activationdateCustomer = activationdateCustomer;
    }

    public String getActivationplaceCustomer() {
        return activationplaceCustomer;
    }

    public void setActivationplaceCustomer(String activationplaceCustomer) {
        this.activationplaceCustomer = activationplaceCustomer;
    }

    public String getNoteCustomer() {
        return noteCustomer;
    }

    public void setNoteCustomer(String noteCustomer) {
        this.noteCustomer = noteCustomer;
    }

    public String getStatusCustomer() {
        return statusCustomer;
    }

    public void setStatusCustomer(String statusCustomer) {
        this.statusCustomer = statusCustomer;
    }
}
