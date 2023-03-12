package pet.malouhov.careermanager.web.dto;

import jakarta.validation.constraints.NotNull;
import pet.malouhov.careermanager.entity.Resume.ResumeStatus;

public record UpdateResumeDto(@NotNull String employee,
                              @NotNull String educations,
                              @NotNull String experiences,
                              @NotNull String skills,
                              @NotNull String certifications,
                              @NotNull String awards,
                              @NotNull ResumeStatus status,
                              @NotNull String respondedVacancies) {

}