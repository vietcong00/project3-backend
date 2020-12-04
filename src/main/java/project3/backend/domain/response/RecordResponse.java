package project3.backend.domain.response;

import project3.backend.model.Record;
import project3.backend.model.PageAction;

import java.util.List;

public class RecordResponse extends BaseResponse {
    Record record;

    List<PageAction> pageActionList;


    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public List<PageAction> getPageActionList() {
        return pageActionList;
    }

    public void setPageActionList(List<PageAction> pageActionList) {
        this.pageActionList = pageActionList;
    }
}
