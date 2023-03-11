package pet.malouhov.careermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.malouhov.careermanager.entity.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

}
