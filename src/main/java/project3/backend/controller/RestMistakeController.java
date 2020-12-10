package project3.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project3.backend.domain.response.MistakeListResponse;
import project3.backend.domain.response.RecordListResponse;
import project3.backend.repository.MistakeRepository;
import project3.backend.service.MistakeService;
import project3.backend.service.RecordService;

@RestController
@RequestMapping("/mistake")
public class RestMistakeController {

    @Autowired
    private MistakeService mistakeService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getAllMistake")
    public ResponseEntity<MistakeListResponse> getAllMistake(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(mistakeService.getAllMistake(token));
    }
}
