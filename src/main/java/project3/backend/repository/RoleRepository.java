package project3.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project3.backend.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
        Role findByIdRole( int idRole);
        Role findByNameRole(String nameRole);
}
