package project3.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project3.backend.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByIdEmployee(int idEmployee);
    Employee findByEmailEmployee(String emailEmployee);
    Employee findByTokenEmployee(String tokenEmployee);
    Employee findByNameEmployee(String nameEmployee);
    Employee findByPhoneEmployee(String phoneEmployee);
    List<Employee> findAll();
}
