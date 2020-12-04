package project3.backend.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmployee;

    @Column(name = "name_employee")
    private String nameEmployee;

    @Column(name = "username_employee")
    private String usernameEmployee;

    @Column(name = "dateofbirth_employee")
    private Date dateofbirthEmployee;

    @Column(name = "email_employee")
    private String emailEmployee;

    @Column(name = "password_employee")
    private String passwordEmployee;

    @Column(name = "phone_employee")
    private String phoneEmployee;

    @Column(name = "address_employee")
    private String addressEmployee;

    @Column(name = "position_employee")
    private String positionEmployee;

    @Column(name = "token_employee")
    private String tokenEmployee;

    @Column(name = "status_employee")
    private String statusEmployee;

    public Employee() {
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getUsernameEmployee() {
        return usernameEmployee;
    }

    public void setUsernameEmployee(String usernameEmployee) {
        this.usernameEmployee = usernameEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public Date getDateofbirthEmployee() {
        return dateofbirthEmployee;
    }

    public void setDateofbirthEmployee(Date dateofbirthEmployee) {
        this.dateofbirthEmployee = dateofbirthEmployee;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public String getPasswordEmployee() {
        return passwordEmployee;
    }

    public void setPasswordEmployee(String passwordEmployee) {
        this.passwordEmployee = passwordEmployee;
    }

    public String getPhoneEmployee() {
        return phoneEmployee;
    }

    public void setPhoneEmployee(String phoneEmployee) {
        this.phoneEmployee = phoneEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressAmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    public String getPositionEmployee() {
        return positionEmployee;
    }

    public void setPositionEmployee(String positionEmployee) {
        this.positionEmployee = positionEmployee;
    }

    public String getTokenEmployee() {
        return tokenEmployee;
    }

    public void setTokenEmployee(String tokenEmployee) {
        this.tokenEmployee = tokenEmployee;
    }

    public String getStatusEmployee() {
        return statusEmployee;
    }

    public void setStatusEmployee(String statusEmployee) {
        this.statusEmployee = statusEmployee;
    }
}
