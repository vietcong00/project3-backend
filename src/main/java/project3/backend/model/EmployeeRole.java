package project3.backend.model;


import javax.persistence.*;

@Entity
@Table(name = "employee_role")
public class EmployeeRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmployeeRole;

    @Column(name = "id_role")
    private int idRole;

    @Column(name = "id_employee")
    private int idEmployee;

    public EmployeeRole() {

    }

    public int getIdEmployeeRole() {
        return idEmployeeRole;
    }

    public void setIdEmployeeRole(int idEmployeeRole) {
        this.idEmployeeRole = idEmployeeRole;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public EmployeeRole(int idRole, int idEmployee) {
        this.idRole = idRole;
        this.idEmployee = idEmployee;
    }
}