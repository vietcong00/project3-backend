package project3.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.backend.model.Customer;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findAll();
    Customer findByIdCustomer(int idCustomer);
    Customer findByPhoneCustomer(String phoneCustomer);
}

