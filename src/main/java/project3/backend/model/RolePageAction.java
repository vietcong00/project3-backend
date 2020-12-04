package project3.backend.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role_page_action")
public class RolePageAction implements Serializable {

    private static final long serialVersionUID = 8L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRolePageAction;

    @Column(name = "id_role")
    private int idRole;

    @Column(name = "id_page")
    private int idPage;

    @Column(name = "id_action")
    private int idAction;

    public RolePageAction() {
    }

    public RolePageAction(int idRole, int idPage, int idAction) {
        this.idRole = idRole;
        this.idPage = idPage;
        this.idAction = idAction;
    }

    public RolePageAction(int idRolePageAction, int idRole, int idPage, int idAction) {
        this.idRolePageAction = idRolePageAction;
        this.idRole = idRole;
        this.idPage = idPage;
        this.idAction = idAction;
    }

    public int getIdRolePageAction() {
        return idRolePageAction;
    }

    public void setIdRolePageAction(int idRolePageAction) {
        this.idRolePageAction = idRolePageAction;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public int getIdPage() {
        return idPage;
    }

    public void setIdPage(int idPage) {
        this.idPage = idPage;
    }

    public int getIdAction() {
        return idAction;
    }

    public void setIdAction(int idAction) {
        this.idAction = idAction;
    }
}


