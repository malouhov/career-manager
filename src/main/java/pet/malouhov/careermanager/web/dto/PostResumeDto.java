package pet.malouhov.careermanager.web.dto;

import jakarta.validation.constraints.NotNull;

public record PostResumeDto(@NotNull String company,
                            @NotNull String vacancy,
                            @NotNull String description) {

}
