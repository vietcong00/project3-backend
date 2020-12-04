package project3.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project3.backend.domain.response.CustomerListResponse;
import project3.backend.domain.response.CustomerResponse;
import project3.backend.helper.helper.Regex;
import project3.backend.model.Customer;
import project3.backend.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService extends CommonService {

    private final String thisPage = "customer.html";

    @Autowired
    CustomerRepository customerRepository;

    public CustomerListResponse getAll(String token) {
        CustomerListResponse customerListResponse = new CustomerListResponse();

        if (checkToken(token, thisPage, "read")) {
            List<Customer> customerList = customerRepository.findAll();
            if (customerList != null) {
                customerListResponse.setCode("200");
                customerListResponse.setMessage("success");
                customerListResponse.setCustomerList(customerList);
            } else {
                customerListResponse.setCode("201");
                customerListResponse.setMessage("error");
            }
        }
        return customerListResponse;
    }

    public CustomerResponse saveCustomer(String token, Customer customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        Customer customer1 = customerRepository.findByIdCustomer(customer.getIdCustomer());
       // System.out.println(customer.getIdCustomer());
        if (customer.getIdCustomer() == 0) {
            if (checkToken(token, thisPage, "add")) {
                if (!customer.getPhoneCustomer().matches(Regex.PHONE_REGREX)) {
                    customerResponse.setCode("202");
                    customerResponse.setMessage("Wrong format phone !");
                } else if (customerRepository.findByPhoneCustomer(customer.getPhoneCustomer()) != null) {
                    customerResponse.setCode("204");
                    customerResponse.setMessage("Phone already exists !");
                } else {
                    customerResponse.setCode("200");
                    customerResponse.setMessage("Insert Customer success");
                    customerResponse.setCustomer(customer);

                    customerRepository.save(customer);
                }
            }
        } else {
            if (checkToken(token, thisPage, "edit")) {
                if (!customer.getPhoneCustomer().matches(Regex.PHONE_REGREX)) {
                    customerResponse.setCode("202");
                    customerResponse.setMessage("Wrong format phone !");
                } else if (customerRepository.findByPhoneCustomer(customer.getPhoneCustomer()) != null &&
                        !customerRepository.findByPhoneCustomer(customer.getPhoneCustomer()).getPhoneCustomer().equals(customer1.getPhoneCustomer())) {
                    customerResponse.setCode("204");
                    customerResponse.setMessage("Phone already exists !");
                } else if (customer1 == null) {
                    customerResponse.setCode("205");
                    customerResponse.setMessage("Customer not exists !");
                } else {
                    customerResponse.setCode("200");
                    customerResponse.setMessage("Edit Customer success");
                    customerResponse.setCustomer(customer1);
                    customerRepository.save(customer);
                }
            }
        }
        return customerResponse;
    }
//
//    public BaseResponse deleteCustomer(String token, Integer id) {
//        BaseResponse baseResponse = new BaseResponse();
//        if (checkToken(token, thisPage, "delete")) {
//            Customer customer = customerRepository.findByIdCustomer(id);
//            if (customer != null) {
//                customerRepository.delete(customer);
//                baseResponse.setCode("300");
//                baseResponse.setMessage("Delete success !");
//            } else {
//                baseResponse.setCode("301");
//                baseResponse.setMessage("User Not Exist !");
//            }
//        }
//        return baseResponse;
//    }


//    public int getTotalCustomerInCurrentMonth(String token) {
//        Date date = new Date();
//        System.out.println(date);
//        List<Customer> customers = customerRepository.findAll();
//        int totalCustomerInCurrentMonth = 0;
//        if (checkBaseToken(token)) {
//            try {
//                for (Customer customer : customers) {
//                    if ((customer.getCreateTime().getMonth() == date.getMonth()) && (customer.getCreateTime().getYear() == date.getYear())) {
//                        totalCustomerInCurrentMonth++;
//                    }
//                }
//            } catch (NullPointerException nullPe) {
//                System.out.println(nullPe);
//            }
//        }
//        return totalCustomerInCurrentMonth;
//    }

//    public BaseResponse getCustomerByIdForEdit(String token, int idCustomer) {
//        BaseResponse baseResponse = new BaseResponse();
//        if (checkToken(token, thisPage, "edit")) {
//            if (customerRepository.findByIdCustomer(idCustomer) == null) {
//
//                baseResponse.setCode("101");
//                baseResponse.setMessage("Customer not Exist !");
//            } else {
//                baseResponse.setCode("102");
//                baseResponse.setMessage("Success !");
//            }
//        }
//
//        return baseResponse;
//    }
}
