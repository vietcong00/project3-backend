package project3.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project3.backend.domain.request.DeleteRecordMistakeRequest;
import project3.backend.domain.response.BaseResponse;
import project3.backend.domain.response.CustomerResponse;
import project3.backend.domain.response.RecordListResponse;
import project3.backend.domain.response.RecordResponse;
import project3.backend.helper.helper.Regex;
import project3.backend.helper.helper.TimeHelper;
import project3.backend.model.*;
import project3.backend.repository.EmployeeScoreRepository;
import project3.backend.repository.MistakeRepository;
import project3.backend.repository.RecordMistakeRepository;
import project3.backend.repository.RecordRepository;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecordService extends CommonService {

    private final String thisPage = "record.html";

    @Autowired
    RecordRepository recordRepository;

    @Autowired
    MistakeRepository mistakeRepository;

    @Autowired
    RecordMistakeRepository recordMistakeRepository;

    @Autowired
    EmployeeScoreRepository employeeScoreRepository;

    public long checkTime(String token, int idRecord) {
        TimeHelper timeHelper = new TimeHelper();
        token = token.replace("Bearer ", "");
        Record record = recordRepository.findByIdRecord(idRecord);


        System.out.println(record.getLastIdSupervisor());
        System.out.println(employeeRepository.findByTokenEmployee(token).getIdEmployee());

        if (timeHelper.subTime(record.getLastTimeCommentRecord()) <= 300 &&
                record.getLastIdSupervisor() != employeeRepository.findByTokenEmployee(token).getIdEmployee()) {
            return (300 - timeHelper.subTime(record.getLastTimeCommentRecord()));
        } else return -1;
    }

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

    public RecordResponse getRecordDetail(String token, int idRecord) {
        RecordResponse recordResponse = new RecordResponse();
        if (checkToken(token, thisPage, "edit")) {
            if (recordRepository.findByIdRecord(idRecord) == null) {
                recordResponse.setCode("101");
                recordResponse.setMessage("Record not Exist !");
            } else {
                long checkTime = checkTime(token, idRecord);
                if (checkTime != -1) {
                    recordResponse.setCode("102");
                    recordResponse.setMessage("Cuộc gọi này đang được đánh giá! Vui lòng chờ trong " + checkTime + " giây nữa");
                } else {

                    Record record = recordRepository.findByIdRecord(idRecord);
                    recordResponse.setCode("000");
                    recordResponse.setMessage("Success !");
                    recordResponse.setRecord(record);
                    List<RecordMistake> recordMistakeList = recordMistakeRepository.findByIdRecord(idRecord);
                    recordResponse.setRecordMistakeList(recordMistakeList);
                    List<Mistake> mistakeList = new ArrayList<>();
                    for (RecordMistake recordMistake : recordMistakeList) {
                        mistakeList.add(mistakeRepository.findByIdMistake(recordMistake.getIdMistake()));
                    }
                    recordResponse.setMistakeList(mistakeList);
                }
            }
        }
        return recordResponse;
    }

    public RecordResponse getRecordDetailSidebar(String token, int idRecord) {
        RecordResponse recordResponse = new RecordResponse();
        if (checkToken(token, thisPage, "edit")) {
            if (recordRepository.findByIdRecord(idRecord) == null) {
                recordResponse.setCode("101");
                recordResponse.setMessage("Record not Exist !");
            } else {
                Record record = recordRepository.findByIdRecord(idRecord);
                recordResponse.setCode("000");
                recordResponse.setMessage("Success !");
                recordResponse.setRecord(record);
                List<RecordMistake> recordMistakeList = recordMistakeRepository.findByIdRecord(idRecord);
                recordResponse.setRecordMistakeList(recordMistakeList);
                List<Mistake> mistakeList = new ArrayList<>();
                for (RecordMistake recordMistake : recordMistakeList) {
                    mistakeList.add(mistakeRepository.findByIdMistake(recordMistake.getIdMistake()));
                }
                recordResponse.setMistakeList(mistakeList);

            }
        }
        return recordResponse;
    }

    public RecordResponse saveRecordMistake(String token, RecordMistake recordMistake) {
        RecordResponse recordResponse = new RecordResponse();

        if (checkToken(token, thisPage, "add")) {
            long checkTime = checkTime(token, recordMistake.getIdRecord());
            if (checkTime != -1) {
                recordResponse.setCode("102");
                recordResponse.setMessage("Cuộc gọi này đang được đánh giá! Vui lòng chờ trong " + checkTime + " giây nữa");
            } else {
                Record record = recordRepository.findByIdRecord(recordMistake.getIdRecord());
                record.setScoreRecord(record.getScoreRecord() - recordMistake.getMinus());
                record.setStatusRecord("Commented");
                record.setLastTimeCommentRecord(recordMistake.getCreateDate());
                record.setLastIdSupervisor(recordMistake.getIdSupervisor());

                Date date = new Date();
                int idEmployeeScore = Integer.parseInt(Integer.toString(record.getIdEmployee()) + date.getMonth() + date.getYear());
                System.out.println("ahihi"+record.getIdEmployee());

                if (employeeScoreRepository.findByIdEmployeeScore(idEmployeeScore) == null) {
                    EmployeeScore employeeScore=new EmployeeScore(idEmployeeScore, record.getIdEmployee(), date.getYear(), date.getMonth(), record.getScoreRecord(), 1);
                    employeeScore.setIdEmployeeScore(idEmployeeScore);
                    employeeScore.setIdEmployee(record.getIdEmployee());
                    employeeScoreRepository.save(employeeScore);
                } else {
                    EmployeeScore employeeScore = employeeScoreRepository.findByIdEmployeeScore(idEmployeeScore);
                    employeeScore.setScore(employeeScore.getScore() - recordMistake.getMinus());
                }
                recordMistakeRepository.save(recordMistake);
                recordResponse.setCode("200");
                recordResponse.setMessage("Insert Customer success");
                recordResponse.setRecord(record);
                List<RecordMistake> recordMistakeList = new ArrayList<>();
                recordMistakeList.add(recordMistake);
                recordResponse.setRecordMistakeList(recordMistakeList);
            }
        }

        return recordResponse;
    }

    public BaseResponse deleteRecordMistake(String token, DeleteRecordMistakeRequest deleteRecordMistakeRequest) {
        BaseResponse baseResponse = new BaseResponse();
        if (checkToken(token, thisPage, "delete")) {
            RecordMistake recordMistake = recordMistakeRepository.findByidRecordMistake(deleteRecordMistakeRequest.getIdRecordMistake());
            if (recordMistake == null) {
                baseResponse.setCode("301");
                baseResponse.setMessage("Mistake Not Exist !");

            } else {
                long checkTime = checkTime(token, recordMistake.getIdRecord());
                if (checkTime != -1) {
                    baseResponse.setCode("102");
                    baseResponse.setMessage("Cuộc gọi này đang được đánh giá! Vui lòng chờ trong " + checkTime + " giây nữa");
                } else {
                    Record record = recordRepository.findByIdRecord(recordMistake.getIdRecord());
                    record.setScoreRecord(record.getScoreRecord() + recordMistake.getMinus());
                    record.setStatusRecord("Commented");
                    record.setLastTimeCommentRecord(deleteRecordMistakeRequest.getLastModify());
                    record.setLastIdSupervisor(deleteRecordMistakeRequest.getIdSupervisor());

                    Date date = new Date();
                    int idEmployeeScore = Integer.parseInt(Integer.toString(record.getIdEmployee()) + date.getMonth() + date.getYear());
                    System.out.println("ahihi"+record.getIdEmployee());
                    if (employeeScoreRepository.findByIdEmployeeScore(idEmployeeScore) == null) {
                        employeeScoreRepository.save(new EmployeeScore(idEmployeeScore, record.getIdEmployee(), date.getYear(), date.getMonth(), record.getScoreRecord(), 1));
                    } else {
                        EmployeeScore employeeScore = employeeScoreRepository.findByIdEmployeeScore(idEmployeeScore);
                        employeeScore.setScore(employeeScore.getScore() + recordMistake.getMinus());
                    }

                    recordMistakeRepository.delete(recordMistake);
                    baseResponse.setCode("300");
                    baseResponse.setMessage("Delete success !");
                }
            }
        }
        return baseResponse;
    }
}
