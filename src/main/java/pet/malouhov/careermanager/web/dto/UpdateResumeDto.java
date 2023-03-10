package pet.malouhov.careermanager.web.dto;

import jakarta.validation.constraints.NotNull;
import pet.malouhov.careermanager.entity.Resume.ResumeStatus;

public record UpdateResumeDto(@NotNull String company,
                              @NotNull String vacancy,
                              @NotNull String description,
                              @NotNull ResumeStatus resumeStatus) {

}