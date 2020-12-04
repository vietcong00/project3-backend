package project3.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project3.backend.domain.response.CustomerListResponse;
import project3.backend.domain.response.CustomerResponse;
import project3.backend.model.Customer;
import project3.backend.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class RestCustomerController {

    @Autowired
    private CustomerService customerService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getAllCustomer")
    public ResponseEntity<CustomerListResponse> getAllCustomer(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(customerService.getAll(token));
    }

//    @CrossOrigin(origins = "*")
//    @PostMapping("/getCustomerByIdForEdit/{idCustomer}")
//    public ResponseEntity<BaseResponse> getCustomerByIdForEdit(@RequestHeader("Authorization") String token, @PathVariable int idCustomer) {
//        return ResponseEntity.ok(customerService.getCustomerByIdForEdit(token,idCustomer));
//    }
//
    @CrossOrigin(origins = "*")
    @PostMapping("/saveCustomer")
    public ResponseEntity<CustomerResponse> saveCustomer(@RequestHeader("Authorization") String token, @RequestBody Customer customer) {
        System.out.println(customer.getNameCustomer());

        System.out.println(customer.getPhoneCustomer());
        return ResponseEntity.ok(customerService.saveCustomer(token,customer));
    }
//
//    @CrossOrigin(origins = "*")
//    @DeleteMapping("/deleteCustomer/{id}")
//    public ResponseEntity<BaseResponse> deleteCustomer(@RequestHeader("Authorization") String token,@PathVariable Integer id) {
//        return ResponseEntity.ok(customerService.deleteCustomer(token,id));
//    }


}
