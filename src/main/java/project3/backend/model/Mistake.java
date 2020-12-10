package project3.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "mistake")
public class Mistake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMistake;

    @Column(name = "name_mistake")
    private String nameMistake;

    @Column(name = "minus_mistake")
    private int minusMistake;

    public Mistake() {
    }

    public int getIdMistake() {
        return idMistake;
    }

    public void setIdMistake(int idMistake) {
        this.idMistake = idMistake;
    }

    public String getNameMistake() {
        return nameMistake;
    }

    public void setNameMistake(String nameMistake) {
        this.nameMistake = nameMistake;
    }

    public int getMinusMistake() {
        return minusMistake;
    }

    public void setMinusMistake(int minusMistake) {
        this.minusMistake = minusMistake;
    }

    public Mistake(int idMistake, String nameMistake, int minusMistake) {
        this.idMistake = idMistake;
        this.nameMistake = nameMistake;
        this.minusMistake = minusMistake;
    }
}
