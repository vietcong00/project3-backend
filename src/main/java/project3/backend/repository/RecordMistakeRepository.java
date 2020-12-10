package project3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project3.backend.model.Mistake;
import project3.backend.model.Record;
import project3.backend.model.RecordMistake;

import java.util.List;

public interface RecordMistakeRepository extends JpaRepository<RecordMistake,Integer> {
    RecordMistake findByidRecordMistake (int idRecordMistake);
    List<RecordMistake> findByIdRecord(int idRecord);
    List<RecordMistake> findByIdMistake(int idMistake);
}
