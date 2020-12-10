package project3.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project3.backend.domain.response.ChartIndexResponse;
import project3.backend.domain.response.ChartEmployeeResponse;
import project3.backend.model.*;
import project3.backend.repository.*;

import java.util.*;

@Service
public class ChartService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RecordRepository recordRepository;

    @Autowired
    RecordMistakeRepository recordMistakeRepository;

    @Autowired
    EmployeeScoreRepository employeeScoreRepository;

    @Autowired
    MistakeRepository mistakeRepository;

    public ChartEmployeeResponse getDataForChart(String token, Integer idEmployee) {
        ChartEmployeeResponse chartEmployeeResponse = new ChartEmployeeResponse();
        Employee employee = employeeRepository.findByIdEmployee(idEmployee);
        Date date = new Date();
        int nowMonth = date.getMonth();
        int nowYear = date.getYear();
        int rank = 1;
        int bad = 0;
        int[] scoreMonth = new int[12];

        for (int i = 0; i < 12; i++) {
            scoreMonth[i] = 0;
        }

        for (int i = 0; i <= nowMonth; i++) {
            int idEmployeeScore = Integer.parseInt(Integer.toString(idEmployee) + i + nowYear);
            if (employeeScoreRepository.findByIdEmployeeScore(idEmployeeScore) != null) {
                scoreMonth[i] = employeeScoreRepository.findByIdEmployeeScore(idEmployeeScore).getScore();
            } else {
                scoreMonth[i] = 0;
            }
        }
        for (int i = nowMonth + 1; i < 12; i++) {
            scoreMonth[i] = 0;
        }
        chartEmployeeResponse.setScore(scoreMonth);

        List<Mistake> mistakeList = mistakeRepository.findAll();
        String[] mistakeName = new String[mistakeList.size()];
        int index = 0;
        for (Mistake mistake : mistakeList) {
            mistakeName[index] = mistake.getNameMistake();
            index++;
        }
        chartEmployeeResponse.setMistakeName(mistakeName);
        int[] mistakeCount = new int[mistakeList.size()];
        List<Record> recordList = recordRepository.findByIdEmployee(idEmployee);
        chartEmployeeResponse.setTotal(recordList.size());
        for (Record record : recordList) {
            if (record.getCreatDateRecord().getYear() == (nowYear) && record.getCreatDateRecord().getMonth() == (nowMonth)) {

                if (record.getScoreRecord() < 12) {
                    bad++;
                }
                List<RecordMistake> recordMistakeList = recordMistakeRepository.findByIdRecord(record.getIdRecord());
                for (RecordMistake recordMistake : recordMistakeList) {
                    int idMistake = recordMistake.getIdMistake();
                    mistakeCount[idMistake]++;
                }
            }
        }
        chartEmployeeResponse.setBad(bad);
        chartEmployeeResponse.setMistakeCount(mistakeCount);

        List<EmployeeScore> allRecordList = employeeScoreRepository.findAll();
        for (EmployeeScore employeeScore : allRecordList) {
            if (employeeScore.getYear() == (nowYear) && employeeScore.getMonth() == (nowMonth)) {
                if (employeeScore.getScore() > scoreMonth[nowMonth]) {
                    rank++;
                }
            }
        }
        chartEmployeeResponse.setRank(rank);

        return chartEmployeeResponse;
    }

    public ChartIndexResponse getDataForIndexChart(String token) {
        ChartIndexResponse chartIndexResponse = new ChartIndexResponse();
        Date date = new Date();
        int nowMonth = date.getMonth();
        int nowYear = date.getYear();
        List<Record> recordList = recordRepository.findAll();
        List<EmployeeScore> employeeScoreList = employeeScoreRepository.findAll();


        int[] countCustomerCare = new int[12];
        for (int i = 0; i < 11; i++) {
            countCustomerCare[i] = 0;
        }

        List<Mistake> mistakeList = mistakeRepository.findAll();
        String[] mistakeName = new String[mistakeList.size()];
        int[] countMistake = new int[mistakeList.size()];
        int index = 0;
        for (Mistake mistake : mistakeList) {
            mistakeName[index] = mistake.getNameMistake();
            countMistake[index] = 0;
            index++;
        }

        int[] countScore = {0, 0, 0, 0};
        String[] countScoreName = {"Dưới 0 điểm", "Từ 0->9 điểm", "Từ 10->19 điểm", "20 điểm"};
        for (Record record : recordList) {
            if (record.getCreatDateRecord().getYear() == nowYear) {
                countCustomerCare[record.getCreatDateRecord().getMonth()]++;
                if (record.getScoreRecord() < 0) {
                    countScore[0]++;
                } else if (record.getScoreRecord() < 10) {
                    countScore[1]++;
                } else if (record.getScoreRecord() < 20) {
                    countScore[2]++;
                } else {
                    countScore[3]++;
                }

                List<RecordMistake> recordMistakeList = recordMistakeRepository.findByIdRecord(record.getIdRecord());
                for (RecordMistake recordMistake : recordMistakeList) {
                    int idMistake = recordMistake.getIdMistake();
                    countMistake[idMistake]++;
                }
            }
        }
        sortDESC(countMistake,mistakeName);

        employeeScoreList.removeIf(employeeScore -> employeeScore.getYear() != nowYear || employeeScore.getMonth() != nowMonth);
        Collections.sort(employeeScoreList, new Comparator<EmployeeScore>() {
            @Override
            public int compare(EmployeeScore o1, EmployeeScore o2) {
                return o1.getScore() > o2.getScore() ? -1 : 1;
            }
        });
        for(EmployeeScore employeeScore:employeeScoreList){
            System.out.println(employeeScore.getIdEmployeeScore());
        }
        String[] nameEmployee = new String[employeeScoreList.size()];
        int[] scoreEmployee = new int[employeeScoreList.size()];
        int index1=0;
        for(EmployeeScore employeeScore:employeeScoreList){
            if(index1<10) {
                nameEmployee[index1] = employeeRepository.findByIdEmployee(employeeScore.getIdEmployee()).getNameEmployee();
                scoreEmployee[index1] = employeeScore.getScore();
                index1++;
            }else{
                break;
            }
        }

        chartIndexResponse.setNameEmployee(nameEmployee);
        chartIndexResponse.setScoreEmployee(scoreEmployee);
        chartIndexResponse.setCountCustomerCare(countCustomerCare);
        chartIndexResponse.setCountScore(countScore);
        chartIndexResponse.setCountScoreName(countScoreName);
        chartIndexResponse.setCountMistake(countMistake);
        chartIndexResponse.setMistakeName(mistakeName);

        return chartIndexResponse;
    }

    public static void sortDESC(int [] arr1, String [] arr2) {
        int temp1 = arr1[0];
        String temp2 = arr2[0];
        for (int i = 1 ; i < arr1.length - 1; i++) {
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[i] < arr1[j]) {
                    temp1 = arr1[j];
                    arr1[j] = arr1[i];
                    arr1[i] = temp1;
                    temp2 = arr2[j];
                    arr2[j] = arr2[i];
                    arr2[i] = temp2;
                }
            }
        }
    }
}
