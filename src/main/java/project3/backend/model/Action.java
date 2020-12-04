package project3.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "action")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAction;

    @Column(name = "name_action")
    private String nameAction;

    public Action() {

    }

    public Action(int idAction, String nameAction) {
        this.idAction = idAction;
        this.nameAction = nameAction;
    }

    public int getIdAction() {
        return idAction;
    }

    public void setIdAction(int idAction) {
        this.idAction = idAction;
    }

    public String getNameAction() {
        return nameAction;
    }

    public void setNameAction(String nameAction) {
        this.nameAction = nameAction;
    }
}


