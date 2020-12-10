package project3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project3.backend.model.EmployeeScore;

import java.util.List;

public interface EmployeeScoreRepository extends JpaRepository<EmployeeScore,Integer> {
    EmployeeScore findByIdEmployeeScore(int idEmployeeRecord);
    List<EmployeeScore> findByIdEmployee(int idEmployee);
    List<EmployeeScore> findAll();
}
