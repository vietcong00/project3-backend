package project3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project3.backend.model.EmployeeRole;

import java.util.List;

public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole,Integer> {
        List<EmployeeRole> findByIdRole(int idRole);
        List<EmployeeRole> findByIdEmployee(int idEmployee);
        EmployeeRole findByIdEmployeeRole(int idEmployeeRole);

}
