package pet.malouhov.careermanager.web.dto;

import pet.malouhov.careermanager.entity.Resume.ResumeStatus;

import java.time.LocalDate;

public record GetResumeDto(String company,
                           String vacancy,
                           String description,
                           ResumeStatus resumeStatus,
                           LocalDate sent) {

}
