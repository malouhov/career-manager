package pet.malouhov.careermanager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "resumes")
public class Resume {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    @Column(nullable = false)
    private String company;

    @NonNull
    @Column(nullable = false)
    private String vacancy;

    @NonNull
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate sent = LocalDate.now();


}
