package pet.malouhov.careermanager.web.dto;

import jakarta.validation.constraints.NotNull;
import pet.malouhov.careermanager.entity.Resume.ResumeStatus;

import java.time.LocalDateTime;

public record GetResumeDto(@NotNull String employee,
                           @NotNull String educations,
                           @NotNull String experiences,
                           @NotNull String skills,
                           @NotNull String certifications,
                           @NotNull String awards,
                           @NotNull ResumeStatus status,
                           @NotNull LocalDateTime created,
                           @NotNull LocalDateTime updated) {

}
