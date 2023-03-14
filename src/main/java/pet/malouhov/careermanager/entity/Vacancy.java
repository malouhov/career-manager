package pet.malouhov.careermanager.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vacancies")
public class Vacancy {

    /*
    long id;
    Company company;
    Industry industry;
    String title;
    int requiredSeniority;
    List<Requirement> requirements;
    List<Skill> skills;
    Optional<Double> minSalary;
    Optional<Double> maxSalary;
    LocalDateTime created;
    LocalDateTime updated;
    Optional<List<Resume>> receivedResumes;
     */

    @Id
    @GeneratedValue
    long id;

    @NonNull
    @Column(nullable = false)
    String company;

    @NonNull
    @Column(nullable = false)
    String industry;

    @NonNull
    @Column(nullable = false)
    String title;

    @Column(nullable = false)

    int requiredSeniority;
    @NonNull
    @Column(nullable = false)
    String requirements;

    @NonNull
    @Column(nullable = false)
    String skills;

    @Column(nullable = false)
    double minSalary;

    @Column(nullable = false)
    double maxSalary;

    @Column(nullable = false)
    private LocalDateTime created = LocalDateTime.now();

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updated = LocalDateTime.now();

    String receivedResumes;


//    @Builder
//    public Vacancy() {
//
//    }

}
