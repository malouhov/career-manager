package pet.malouhov.careermanager.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
//@Builder
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
    Optional<List<Vacancy>> respondedVacancies;
     */

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    @Column(nullable = false)
    private String employee;

    @NonNull
    @Column(nullable = false)
    private String educations;

    @NonNull
    @Column(nullable = false)
    private String experiences;

    @NonNull
    @Column(nullable = false)
    private String skills;

    @NonNull
    @Column(nullable = false)
    private String certifications;

    @NonNull
    @Column(nullable = false)
    private String awards;

    @NonNull
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private ResumeStatus status = ResumeStatus.RESUME_NEW;

    @Column(nullable = false)
    private LocalDateTime created = LocalDateTime.now();

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updated = LocalDateTime.now();

    @NonNull
    @Column(nullable = false)
    private String respondedVacancies;


    @Builder
    public Resume(@NonNull String employee,
                  @NonNull String educations,
                  @NonNull String experiences,
                  @NonNull String skills,
                  @NonNull String certifications,
                  @NonNull String awards,
                  @NonNull String respondedVacancies) {
        this.employee = employee;
        this.educations = educations;
        this.experiences = experiences;
        this.skills = skills;
        this.certifications = certifications;
        this.awards = awards;
        this.respondedVacancies = respondedVacancies;
    }

    public enum ResumeStatus {
        RESUME_NEW,
        RESUME_HIDDEN,
        RESUME_ACTIVE,
        RESUME_DELETED

    }


}
