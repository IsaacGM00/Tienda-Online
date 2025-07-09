package mx.com.santander.hexagonalmodularmaven.task.port.repository;

import mx.com.santander.hexagonalmodularmaven.task.model.entity.Task;


public interface TaskRepository {

    Task create(Task request);
    void deleteById(Long id);
    Task update(Task request);

}
