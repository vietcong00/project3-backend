package project3.backend.domain.response;

import project3.backend.model.Record;
import project3.backend.model.Mistake;
import project3.backend.model.RecordMistake;

import java.util.List;

public class RecordResponse extends BaseResponse {

    Record record;

    List<Mistake> mistakeList;

    List<RecordMistake> recordMistakeList;
    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public List<Mistake> getMistakeList() {
        return mistakeList;
    }

    public void setMistakeList(List<Mistake> mistakeList) {
        this.mistakeList = mistakeList;
    }

    public List<RecordMistake> getRecordMistakeList() {
        return recordMistakeList;
    }

    public void setRecordMistakeList(List<RecordMistake> recordMistakeList) {
        this.recordMistakeList = recordMistakeList;
    }
}
