package project3.backend.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecord;

    @Column(name = "id_employee")
    private int idEmployee;

    @Column(name = "phone_customer")
    private String phoneCustomer;

    @Column(name = "creatdate_record")
    private Date creatDateRecord;

    @Column(name = "createtime_record")
    private Date createTimeRecord;

    @Column(name = "endtime_record")
    private Date endTimeRecord;

    @Column(name = "score_record")
    private int scoreRecord;

    @Column(name = "lastid_supervisor")
    private int lastIdSupervisor;

    @Column(name = "description_record")
    private String descriptionRecord;

    @Column(name = "link_record")
    private String linkRecord;

    @Column(name = "lasttimecomment_record")
    private Date lastTimeCommentRecord;

    @Column(name = "status_record")
    private String statusRecord;

    public Record() {
    }


    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public int getScoreRecord() {
        return scoreRecord;
    }

    public void setScoreRecord(int scoreRecord) {
        this.scoreRecord = scoreRecord;
    }

    public String getDescriptionRecord() {
        return descriptionRecord;
    }

    public void setDescriptionRecord(String descriptionRecord) {
        this.descriptionRecord = descriptionRecord;
    }

    public String getLinkRecord() {
        return linkRecord;
    }

    public void setLinkRecord(String linkRecord) {
        this.linkRecord = linkRecord;
    }

    public Date getCreatDateRecord() {
        return creatDateRecord;
    }

    public void setCreatDateRecord(Date creatDateRecord) {
        this.creatDateRecord = creatDateRecord;
    }

    public Date getCreateTimeRecord() {
        return createTimeRecord;
    }

    public void setCreateTimeRecord(Date createTimeRecord) {
        this.createTimeRecord = createTimeRecord;
    }

    public Date getEndTimeRecord() {
        return endTimeRecord;
    }

    public void setEndTimeRecord(Date endTimeRecord) {
        this.endTimeRecord = endTimeRecord;
    }

    public int getLastIdSupervisor() {
        return lastIdSupervisor;
    }

    public void setLastIdSupervisor(int lastIdSupervisor) {
        this.lastIdSupervisor = lastIdSupervisor;
    }

    public Date getLastTimeCommentRecord() {
        return lastTimeCommentRecord;
    }

    public void setLastTimeCommentRecord(Date lastTimeCommentRecord) {
        this.lastTimeCommentRecord = lastTimeCommentRecord;
    }

    public String getStatusRecord() {
        return statusRecord;
    }

    public void setStatusRecord(String statusRecord) {
        this.statusRecord = statusRecord;
    }

    public Record(int idRecord, int idEmployee, String phoneCustomer, Date creatDateRecord, Date createTimeRecord, Date endTimeRecord, int scoreRecord, int lastIdSupervisor, String descriptionRecord, String linkRecord, Date lastTimeCommentRecord, String statusRecord) {
        this.idRecord = idRecord;
        this.idEmployee = idEmployee;
        this.phoneCustomer = phoneCustomer;
        this.creatDateRecord = creatDateRecord;
        this.createTimeRecord = createTimeRecord;
        this.endTimeRecord = endTimeRecord;
        this.scoreRecord = scoreRecord;
        this.lastIdSupervisor = lastIdSupervisor;
        this.descriptionRecord = descriptionRecord;
        this.linkRecord = linkRecord;
        this.lastTimeCommentRecord = lastTimeCommentRecord;
        this.statusRecord = statusRecord;
    }
}
