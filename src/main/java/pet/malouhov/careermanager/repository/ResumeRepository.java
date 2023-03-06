package pet.malouhov.careermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.malouhov.careermanager.entity.Resume;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    List<Resume> findByCompanyContaining(String company);
}
