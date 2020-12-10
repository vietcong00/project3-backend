package project3.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project3.backend.domain.response.ChartIndexResponse;
import project3.backend.domain.response.ChartEmployeeResponse;
import project3.backend.service.ChartService;

@RestController
@RequestMapping("/chart")
public class RestChartController {

    @Autowired
    private ChartService chartService;

    @CrossOrigin(origins = "*")
    @PostMapping("/getDataForEmployeeChart/{idEmployee}")
    public ResponseEntity<ChartEmployeeResponse> getDataForChart(@RequestHeader("Authorization") String token, @PathVariable Integer idEmployee) {
        return ResponseEntity.ok(chartService.getDataForChart(token,idEmployee));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getDataForIndexChart")
    public ResponseEntity<ChartIndexResponse> getDataForIndexChart(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(chartService.getDataForIndexChart(token));
    }
}
