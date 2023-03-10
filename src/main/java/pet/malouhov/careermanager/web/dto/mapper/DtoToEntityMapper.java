package pet.malouhov.careermanager.web.dto.mapper;

import org.mapstruct.Mapper;
import pet.malouhov.careermanager.entity.Resume;
import pet.malouhov.careermanager.web.dto.GetResumeDto;
import pet.malouhov.careermanager.web.dto.PostResumeDto;
import pet.malouhov.careermanager.web.dto.UpdateResumeDto;

@Mapper(componentModel = "spring")
public interface DtoToEntityMapper {

    PostResumeDto entityToPostDto(Resume resume);

    Resume postDtoToEntity(PostResumeDto postResumeDto);

    GetResumeDto entityToGetDto(Resume resume);

    Resume getDtoToEntity(GetResumeDto getResumeDto);

    UpdateResumeDto entityToUpdateDto(Resume resume);

    Resume entityDtoToResume(UpdateResumeDto postResumeDto);

}
