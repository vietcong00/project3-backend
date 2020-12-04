package project3.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project3.backend.model.RolePageAction;

import java.util.List;

public interface RolePageActionRepository extends JpaRepository<RolePageAction, Integer> {
    List<RolePageAction> findByIdRole(int idRole);
    RolePageAction findByIdRoleAndIdPageAndIdAction(int idRole, int idPage , int idAction);
}
