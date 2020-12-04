package project3.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project3.backend.model.Action;

public interface ActionRepository extends JpaRepository<Action, Integer> {
    Action findByIdAction(int actionId);
    Action findByNameAction(String nameAction);
}
