package project3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project3.backend.model.Record;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Integer> {
    @Override
    List<Record> findAll();
}
