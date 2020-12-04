package project3.backend.domain.response;


import project3.backend.model.Customer;

public class CustomerResponse extends BaseResponse{
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
