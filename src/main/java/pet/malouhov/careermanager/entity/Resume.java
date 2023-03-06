package pet.malouhov.careermanager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "resumes")
public class Resume {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String vacancy;

    @Column(nullable = false)
    private String description;

    private LocalDate sent = LocalDate.now();


}
