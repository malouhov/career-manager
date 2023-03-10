package pet.malouhov.careermanager.web.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.malouhov.careermanager.entity.Resume;
import pet.malouhov.careermanager.service.ResumeService;
import pet.malouhov.careermanager.web.dto.GetResumeDto;
import pet.malouhov.careermanager.web.dto.PostResumeDto;
import pet.malouhov.careermanager.web.dto.UpdateResumeDto;
import pet.malouhov.careermanager.web.dto.mapper.DtoToEntityMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ResumeRestController {

    private final ResumeService resumeService;

    private final DtoToEntityMapper mapper;

    /*
    POST        /api/v1/resume          create new Resume
    UPDATE      /api/v1/resume/id       update Resume by {id}
    GET         /api/v1/resumes         retrieve all Resumes
    DELETE      /api/v1/resumes         delete all Resumes
    GET         /api/v1/resume/id       retrieve a Resume by {id}
    DELETE      /api/v1/resume/id       delete a Resume by {id}
    */

    @GetMapping("/test")
    public String test() {
        return "Api is alive";
    }

    /**
     * Отправляет запрос на сохранение нового объекта резюме (Resume).
     *
     * @param postResumeDto - Data Transfer Object, содержащий поля для создания объекта резюме (Resume).
     * @return - Data Transfer Object объекта резюме (Resume).
     */
    @PostMapping("/resume")
    public ResponseEntity<PostResumeDto> createResume(@Valid @RequestBody PostResumeDto postResumeDto) {
        Resume savedResume = resumeService.create(mapper.postDtoToEntity(postResumeDto));
        return new ResponseEntity<>(postResumeDto, HttpStatus.CREATED);
    }

    /**
     * Отправляет запрос на изменение объекта резюме (Resume) с заданным id.
     *
     * @param id - идентификатор изменяемого объекта резюме (Resume).
     * @param updateResumeDto - Data Transfer Object, содержащий поля для изменения объекта резюме (Resume).
     * @return - Data Transfer Object объекта резюме (Resume).
     */
    @PutMapping("/resume/{id}")
    public ResponseEntity<UpdateResumeDto> updateResume(@PathVariable("id") long id,
                                                        @Valid @RequestBody UpdateResumeDto updateResumeDto) {
        Resume updatedResume = mapper.entityDtoToResume(updateResumeDto);
        updatedResume.setId(id);
        resumeService.update(updatedResume);
        return new ResponseEntity<>(updateResumeDto, HttpStatus.OK);
    }


    /**
     * Отправляет запрос на получения списка всех объектов резюме (Resume).
     *
     * @return - список объектов GetResumeDto с информацией о всех резюме.
     */
    @GetMapping("/resumes")
    public ResponseEntity<List<GetResumeDto>> getAllResumes() {
        List<GetResumeDto> getResumeDtoList = resumeService.getAll().
                stream().
                map(mapper::entityToGetDto).
                collect(Collectors.toList());
        return new ResponseEntity<>(getResumeDtoList, HttpStatus.OK);
    }

    /**
     * Отправляет запрос на удаление всех объектов резюме (Resume).
     *
     * @return - статус выполнения запроса.
     */
    @DeleteMapping("/resumes")
    public ResponseEntity<HttpStatus> deleteAllResumes() {
        resumeService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Отправляет запрос на получение объекта резюме (Resume) по id.
     *
     * @param id - id объекта резюме (Resume).
     * @return - Data Transfer Object объекта резюме (Resume).
     */
    @GetMapping("/resume/{id}")
    public ResponseEntity<GetResumeDto> getResumeById(@PathVariable("id") long id) {
        Optional<Resume> optionalResume = resumeService.getById(id);

        if (optionalResume.isPresent()) {
            return new ResponseEntity<>(mapper.entityToGetDto(optionalResume.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Отправляет запрос на удаление объекта резюме (Resume) по id.
     *
     * @param id - id удаляемого объекта резюме (Resume).
     * @return - статус выполнения запроса.
     */
    @DeleteMapping("/resume/{id}")
    public ResponseEntity<HttpStatus> deleteResume(@PathVariable("id") long id) {
        try {
            resumeService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
