package project3.backend.domain.response;

import project3.backend.model.Record;

import java.util.List;

public class RecordListResponse extends BaseResponse{
    private List<Record> recordList;

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }
}
