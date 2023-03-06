package pet.malouhov.careermanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.malouhov.careermanager.entity.Resume;
import pet.malouhov.careermanager.service.ResumeService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ResumeRestController {

    ResumeService resumeService;

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

    @PostMapping("/resume")
    public ResponseEntity<Resume> createResume(@RequestBody Resume resume) {
        Resume savedResume = resumeService.create(resume);
        return new ResponseEntity<>(savedResume, HttpStatus.CREATED);
    }

    @PutMapping("/resume/{id}")
    public ResponseEntity<Resume> updateResume(@PathVariable("id") Long id,
                                               @RequestBody Resume resume) {
        resume.setId(id);
        Resume updatedResume = resumeService.update(resume);
        return new ResponseEntity<>(updatedResume, HttpStatus.OK);
    }

    @GetMapping("/resumes")
    public ResponseEntity<List<Resume>> getAllResumes() {
        List<Resume> resumes = resumeService.getAll();
        return new ResponseEntity<>(resumes, HttpStatus.OK);
    }

    @DeleteMapping("/resumes")
    public ResponseEntity<HttpStatus> deleteAllResumes() {
        resumeService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/resume/{id}")
    public ResponseEntity<Resume> getResumeById(@PathVariable("id") long id) {
        Optional<Resume> optionalResume = resumeService.getById(id);

        if (optionalResume.isPresent()) {
            return new ResponseEntity<>(optionalResume.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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
