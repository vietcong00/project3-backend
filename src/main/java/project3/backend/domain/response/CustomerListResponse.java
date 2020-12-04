package project3.backend.domain.response;



import project3.backend.model.Customer;

import java.util.List;

public class CustomerListResponse extends BaseResponse {
    List<Customer> customerList ;

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
