package pet.malouhov.careermanager.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pet.malouhov.careermanager.entity.Resume;
import pet.malouhov.careermanager.exception.PersistenceResumeNotFoundException;
import pet.malouhov.careermanager.repository.ResumeRepository;
import pet.malouhov.careermanager.service.ResumeService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DefaultResumeService implements ResumeService {

    private final ResumeRepository resumeRepository;


    /**
     * Создает объект резюме (Resume) для сохранения.
     *
     * @param resume - экземпляр класса резюме (Resume), который подлежит сохрению.
     * @return - сохраненный объект резюме (Resume).
     */
    @Override
    public Resume create(Resume resume) {
        return resumeRepository.save(resume);
    }

    /**
     * Изменяет сохраненный объект резюме (Resume).
     *
     * @param resume - экземпляр класса резюме (Resume), который подлежит изменению.
     * @return - измененный объект резюме (Resume).
     */
    @Override
    public Resume update(Resume resume) throws PersistenceResumeNotFoundException {
        Resume updatedResume = resumeRepository.findById(resume.getId())
                .orElseThrow(() -> new PersistenceResumeNotFoundException("Resume with {" + resume.getId() + "} not found."));
        updatedResume.setEducations(resume.getEducations());
        updatedResume.setExperiences(resume.getExperiences());
        updatedResume.setSkills(resume.getSkills());
        updatedResume.setCertifications(resume.getCertifications());
        updatedResume.setAwards(resume.getAwards());
        updatedResume.setStatus(resume.getStatus());
        return resumeRepository.save(updatedResume);
    }

    /**
     * Удаляет объект резюме (Resume) если он есть в базе дынных.
     *
     * @param id - идентификатор класса резюме (Resume), который подлежит удалению.
     */
    @Override
    public void delete(long id) {
        resumeRepository.deleteById(id);
    }

    /**
     * Возвращает объект резюме (Resume) по идентификатору.
     *
     * @param id - идентификатор класса резюме (Resume), который запрошен.
     * @return - объект класса резюме Optional<Resume> или Optional.empty.
     */
    @Override
    public Optional<Resume> getById(long id) {
        return resumeRepository.findById(id);
    }

    /**
     * Возвращает список всех объектов резюме (Resume).
     *
     * @return - список объектов резюме (Resume).
     */
    @Override
    public List<Resume> getAll() {
        return resumeRepository.findAll();
    }

    /**
     * Удаляет все объекты резюме (Resume).
     */
    @Override
    public void deleteAll() {
        resumeRepository.deleteAll();
    }

}
