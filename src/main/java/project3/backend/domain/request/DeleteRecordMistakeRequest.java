package project3.backend.domain.request;

import java.util.Date;

public class DeleteRecordMistakeRequest {
    int idRecordMistake;
    Date lastModify;
    int idSupervisor;

    public int getIdRecordMistake() {
        return idRecordMistake;
    }

    public void setIdRecordMistake(int idRecordMistake) {
        this.idRecordMistake = idRecordMistake;
    }

    public Date getLastModify() {
        return lastModify;
    }

    public void setLastModify(Date lastModify) {
        this.lastModify = lastModify;
    }

    public int getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(int idSupervisor) {
        this.idSupervisor = idSupervisor;
    }
}
