package pet.malouhov.careermanager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "resumes")
public class Resume {

    /*
    long id;
    User employee;
    Optional<List<Education>> educations;
    Optional<List<Experience>> experiences;
    Optional<List<Skill>> skills;
    Optional<List<Certification>> certifications;
    Optional<List<Award>> awards;
    ResumeStatus status;
    LocalDateTime created;
    LocalDateTime updated;
     */

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    @Column(nullable = false)
    private String employee;

    @Column(nullable = false)
    private String educations;

    @Column(nullable = false)
    private String experiences;

    @Column(nullable = false)
    private String skills;

    @Column(nullable = false)
    private String certifications;

    @Column(nullable = false)
    private String awards;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private ResumeStatus status = ResumeStatus.RESUME_NEW;

    @Column(nullable = false)
    private LocalDateTime created = LocalDateTime.now();
    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updated = LocalDateTime.now();

    public enum ResumeStatus {
        RESUME_NEW,
        RESUME_HIDDEN,
        RESUME_ACTIVE,
        RESUME_DELETED

    }

}
