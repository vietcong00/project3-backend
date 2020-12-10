package project3.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project3.backend.domain.request.DeleteRecordMistakeRequest;
import project3.backend.domain.response.BaseResponse;
import project3.backend.domain.response.CustomerResponse;
import project3.backend.domain.response.RecordListResponse;
import project3.backend.domain.response.RecordResponse;
import project3.backend.model.Customer;
import project3.backend.model.RecordMistake;
import project3.backend.service.RecordService;

@RestController
@RequestMapping("/record")
public class RestRecordController {

    @Autowired
    private RecordService recordService;
    
    @CrossOrigin(origins = "*")
    @GetMapping("/getAllRecord")
    public ResponseEntity<RecordListResponse> getAllRecord(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(recordService.getAllRecord(token));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getRecordDetail/{idRecord}")
    public ResponseEntity<RecordResponse> getRecordDetail(@RequestHeader("Authorization") String token, @PathVariable int idRecord) {
        return ResponseEntity.ok(recordService.getRecordDetail(token,idRecord));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getRecordDetailSidebar/{idRecord}")
    public ResponseEntity<RecordResponse> getRecordDetailSidebar(@RequestHeader("Authorization") String token, @PathVariable int idRecord) {
        return ResponseEntity.ok(recordService.getRecordDetailSidebar(token,idRecord));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/saveRecord")
    public ResponseEntity<RecordResponse> saveRecord(@RequestHeader("Authorization") String token, @RequestBody RecordMistake recordMistake) {
        System.out.println(recordMistake.getComment());

        return ResponseEntity.ok(recordService.saveRecordMistake(token,recordMistake));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/deleteRecordMistake")
    public ResponseEntity<BaseResponse> deleteRecordMistake(@RequestHeader("Authorization") String token, @RequestBody DeleteRecordMistakeRequest deleteRecordMistakeRequest) {
        return ResponseEntity.ok(recordService.deleteRecordMistake(token,deleteRecordMistakeRequest));
    }
}
