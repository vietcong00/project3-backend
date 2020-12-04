package project3.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project3.backend.domain.response.RecordListResponse;
import project3.backend.model.Record;
import project3.backend.repository.RecordRepository;

import java.util.List;

@Service
public class RecordService extends CommonService{

    private final String thisPage = "record.html";

    @Autowired
    RecordRepository recordRepository;

    public RecordListResponse getAllRecord(String token) {
        RecordListResponse recordListResponse = new RecordListResponse();
        if (checkToken(token, thisPage, "read")) {
            List<Record> recordList = recordRepository.findAll();
            if (recordList != null) {
                recordListResponse.setCode("200");
                recordListResponse.setMessage("success");
                recordListResponse.setRecordList(recordList);
            } else {
                recordListResponse.setCode("201");
                recordListResponse.setMessage("List null !");
            }
        }
        return recordListResponse;
    }
}
