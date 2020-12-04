package project3.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project3.backend.model.Page;

public interface PageRepository extends JpaRepository<Page, Integer> {
    Page findByIdPage(int idPage);
    Page findByUrlPage(String urlPage);
}
