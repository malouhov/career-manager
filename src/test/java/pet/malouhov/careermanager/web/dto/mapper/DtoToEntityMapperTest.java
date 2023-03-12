package pet.malouhov.careermanager.web.dto.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import pet.malouhov.careermanager.entity.Resume;
import pet.malouhov.careermanager.web.dto.GetResumeDto;
import pet.malouhov.careermanager.web.dto.PostResumeDto;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DtoToEntityMapperTest {

    private final DtoToEntityMapper mapper = Mappers.getMapper(DtoToEntityMapper.class);

    private Resume testResume = Resume.builder().
            employee("Ignat").
            educations("ITMO").
            experiences("Sber").
            skills("Java developer").
            certifications("Oracle OCA").
            awards("None").
            respondedVacancies("Sber").
            build();

    private final LocalDateTime testCreatedDateTime = testResume.getCreated();
    private final LocalDateTime testUpdatedDateTime = testResume.getUpdated();

    private final PostResumeDto testPostResumeDto = new PostResumeDto(
            "Ignat",
            "ITMO",
            "Sber",
            "Java developer",
            "Oracle OCA",
            "None");

    private final GetResumeDto testGetResumeDto = new GetResumeDto(
            "Ignat",
            "ITMO",
            "Sber",
            "Java developer",
            "Oracle OCA",
            "None",
            Resume.ResumeStatus.RESUME_NEW,
            testCreatedDateTime,
            testUpdatedDateTime,
            "Sber");

    @Test
    @DisplayName("Resume Entity to the PostResumeDto successful test")
    void entityToPostDtoTest() {
        PostResumeDto actualPostResumeDto = mapper.entityToPostDto(testResume);
        assertEquals(testPostResumeDto, actualPostResumeDto);
    }


    @Test
    @DisplayName("PostResumeDto to the Resume Entity successful test")
    void postDtoToEntity() {
    }

    @Test
    @DisplayName("Resume Entity to the GetResumeDto successful test")
    void entityToGetDto() {
    }

    @Test
    void getDtoToEntity() {
    }

    @Test
    void entityToUpdateDto() {
    }

    @Test
    void entityDtoToResume() {
    }
}