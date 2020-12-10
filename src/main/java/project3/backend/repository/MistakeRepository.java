package project3.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project3.backend.model.Mistake;

public interface MistakeRepository extends JpaRepository<Mistake,Integer> {
    Mistake findByIdMistake(int idMistake);
}
