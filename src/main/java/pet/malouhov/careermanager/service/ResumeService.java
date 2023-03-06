package pet.malouhov.careermanager.service;

import pet.malouhov.careermanager.entity.Resume;

import java.util.List;
import java.util.Optional;

public interface ResumeService {

    /**
     * Создает объект резюме (Resume) для сохранения.
     *
     * @param resume - экземпляр класса резюме (Resume), который подлежит сохрению.
     * @return - сохраненный объект резюме (Resume).
     */
    Resume create(Resume resume);

    /**
     * Изменяет сохраненный объект резюме (Resume).
     *
     * @param resume - экземпляр класса резюме (Resume), который подлежит изменению.
     * @return - измененный объект резюме (Resume).
     */
    Resume update(Resume resume);

    /**
     * Удаляет объект резюме (Resume) если он есть в базе дынных.
     *
     * @param id - идентификатор класса резюме (Resume), который подлежит удалению.
     */
    void delete(long id);

    /**
     * Возвращает объект резюме (Resume) по идентификатору.
     *
     * @param id - идентификатор класса резюме (Resume), который запрошен.
     * @return - объект класса резюме Optional<Resume> или Optional.empty.
     */
    Optional<Resume> getById(long id);

    /**
     * Возвращает список всех объектов резюме (Resume).
     *
     * @return - список объектов резюме (Resume).
     */
    List<Resume> getAll();

    /**
     * Удаляет все объекты резюме (Resume).
     */
    void deleteAll();

    /**
     * Поск подходящях для запроса объектов резюме (Resume).
     * Поиск ведется по поляю.
     * Строчные и прописные символы игнорируются.
     *
     * @param keyword - фрагмент, котрый искользуется как ключевое слово.
     * @return - список объектов резюме (Resume), подходящих под критерии поиска.
     */
    List<Resume> search(String keyword);

}
