package project3.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project3.backend.domain.response.BaseResponse;
import project3.backend.domain.response.EmployeeListResponse;
import project3.backend.domain.response.EmployeeResponse;
import project3.backend.model.Employee;
import project3.backend.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class RestEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @CrossOrigin(origins = "*")
    @GetMapping("/checkTokenWeb")
    public ResponseEntity<BaseResponse> checkToken(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(employeeService.checkTokenWeb(token));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<EmployeeResponse> checkLogin(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.checkLogin(employee));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/logout")
    public ResponseEntity<EmployeeResponse> logOut(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(employeeService.logOut(token));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getAllEmployee")
    public ResponseEntity<EmployeeListResponse> getAllUser(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(employeeService.getAllEmployee(token));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/saveEmployee")
    public ResponseEntity<EmployeeResponse> saveUser(@RequestHeader("Authorization") String token,@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.saveEmployee(token,employee));
    }
}
