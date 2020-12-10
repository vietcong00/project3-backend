package project3.backend.model;

import javax.persistence.*;
import java.util.Comparator;

@Entity
@Table(name = "employee_score")
public class EmployeeScore {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmployeeScore;

    @Column(name = "id_Employee")
    private int idEmployee;

    @Column(name = "year")
    private int year;

    @Column(name = "month")
    private int month;

    @Column(name = "score")
    private int score;

    @Column(name = "number_of_calls")
    private int numberOfCalls;

    public EmployeeScore() {
    }

    public EmployeeScore(int idEmployee, int year, int month, int score, int numberOfCalls) {
        this.idEmployee = idEmployee;
        this.year = year;
        this.month = month;
        this.score = score;
        this.numberOfCalls = numberOfCalls;
    }

    public EmployeeScore(int idEmployeeScore, int idEmployee, int year, int month, int score, int numberOfCalls) {
        this.idEmployeeScore = idEmployeeScore;
        this.idEmployeeScore = idEmployee;
        this.year = year;
        this.month = month;
        this.score = score;
        this.numberOfCalls = numberOfCalls;
    }

    public int getIdEmployeeScore() {
        return idEmployeeScore;
    }

    public void setIdEmployeeScore(int idEmployeeScore) {
        this.idEmployeeScore = idEmployeeScore;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumberOfCalls() {
        return numberOfCalls;
    }

    public void setNumberOfCalls(int numberOfCalls) {
        this.numberOfCalls = numberOfCalls;
    }

    //    @Override
//    public String toString() {
//        return "EmployeeScore@idEmployeeScore=" + idEmployeeScore + ",idEmployeeScore=" + idEmployeeScore
//                + ",year=" + year + ",month=" + month+ ",score=" + score+ ",numberOfCalls=" + numberOfCalls;
//    }
//
//    @Override
//    public int compareTo(EmployeeScore employeeScore) {
//        return this.getScore().compareTo(employeeScore.getScore());
//    }
//    @Override
//    public int compare(EmployeeScore o1, EmployeeScore o2) {
//        return o1.getScore() - o2.getScore();
//    }
}
