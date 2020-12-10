package project3.backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "record_mistake")
public class RecordMistake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecordMistake;

    @Column(name = "id_record")
    private int idRecord;

    @Column(name = "id_mistake")
    private int idMistake;

    @Column(name = "timeline_record")
    private float timelineRecord;

    @Column(name = "minus")
    private int minus;

    @Column(name = "comment")
    private String comment;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "id_supervisor")
    private int idSupervisor;

    public RecordMistake() {
    }

    public int getIdRecordMistake() {
        return idRecordMistake;
    }

    public void setIdRecordMistake(int idRecordMistake) {
        this.idRecordMistake = idRecordMistake;
    }

    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public int getIdMistake() {
        return idMistake;
    }

    public void setIdMistake(int idMistake) {
        this.idMistake = idMistake;
    }

    public float getTimelineRecord() {
        return timelineRecord;
    }

    public void setTimelineRecord(float timelineRecord) {
        this.timelineRecord = timelineRecord;
    }

    public int getMinus() {
        return minus;
    }

    public void setMinus(int minus) {
        this.minus = minus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(int idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public RecordMistake(int idRecordMistake, int idRecord, int idMistake, float timelineRecord, int minus, String comment, Date createDate, int idSupervisor) {
        this.idRecordMistake = idRecordMistake;
        this.idRecord = idRecord;
        this.idMistake = idMistake;
        this.timelineRecord = timelineRecord;
        this.minus = minus;
        this.comment = comment;
        this.createDate = createDate;
        this.idSupervisor = idSupervisor;
    }
}
