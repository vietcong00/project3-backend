package project3.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project3.backend.domain.response.RecordListResponse;
import project3.backend.service.RecordService;

@RestController
@RequestMapping("/record")
public class RestRecordController {

    @Autowired
    private RecordService recordService;
    
    @CrossOrigin(origins = "*")
    @GetMapping("/getAllRecord")
    public ResponseEntity<RecordListResponse> getAllUser(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(recordService.getAllRecord(token));
    }
}
