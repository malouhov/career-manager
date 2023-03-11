package pet.malouhov.careermanager.web.dto;

import jakarta.validation.constraints.NotNull;

public record PostResumeDto(@NotNull String employee,
                            @NotNull String educations,
                            @NotNull String experiences,
                            @NotNull String skills,
                            @NotNull String certifications,
                            @NotNull String awards) {

}
