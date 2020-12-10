package project3.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project3.backend.domain.response.MistakeListResponse;
import project3.backend.domain.response.RecordListResponse;
import project3.backend.model.Mistake;
import project3.backend.model.Record;
import project3.backend.repository.MistakeRepository;

import java.util.List;

@Service

public class MistakeService extends CommonService {

    @Autowired
    MistakeRepository mistakeRepository;

    public MistakeListResponse getAllMistake(String token) {
        MistakeListResponse mistakeListResponse = new MistakeListResponse();
//        if (checkToken(token, thisPage, "read")) {
        List<Mistake> mistakeList = mistakeRepository.findAll();
        if (mistakeList != null) {
            mistakeListResponse.setCode("200");
            mistakeListResponse.setMessage("success");
            mistakeListResponse.setMistakeList(mistakeList);
        } else {
            mistakeListResponse.setCode("201");
            mistakeListResponse.setMessage("List null !");
        }
//        }
        return mistakeListResponse;
    }

}
