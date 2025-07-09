package mx.com.santander.hexagonalmodularmaven.task.port.dao;

import mx.com.santander.hexagonalmodularmaven.task.model.entity.Task;

import java.util.List;

public interface TaskDao {

    Task getById(Long id);

    List<Task> getAll();

    List<Task> getByIds(List<Long> tasksIds);

}
