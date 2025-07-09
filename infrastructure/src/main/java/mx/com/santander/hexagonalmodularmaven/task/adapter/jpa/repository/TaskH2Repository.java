package mx.com.santander.hexagonalmodularmaven.task.adapter.jpa.repository;

import jakarta.transaction.Transactional;
import mx.com.santander.hexagonalmodularmaven.task.adapter.jpa.TaskSpringJpaAdapterRepository;
import mx.com.santander.hexagonalmodularmaven.task.adapter.mapper.TaskDboMapper;
import mx.com.santander.hexagonalmodularmaven.task.model.entity.Task;
import mx.com.santander.hexagonalmodularmaven.task.port.repository.TaskRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class TaskH2Repository implements TaskRepository {

    private final TaskSpringJpaAdapterRepository taskSpringJpaAdapterRepository;
    private final TaskDboMapper taskDboMapper;

    public TaskH2Repository(TaskSpringJpaAdapterRepository taskSpringJpaAdapterRepository, TaskDboMapper taskDboMapper) {
        this.taskSpringJpaAdapterRepository = taskSpringJpaAdapterRepository;
        this.taskDboMapper = taskDboMapper;
    }

    @Override
    public Task create(Task task) {
        var taskToSave = taskDboMapper.toDboCreate(task);
        var taskSaved = taskSpringJpaAdapterRepository.save(taskToSave);
        return taskDboMapper.toDomain(taskSaved);
    }

    @Override
    public void deleteById(Long id) {
        taskSpringJpaAdapterRepository.deleteById(id);
    }
    @Override
    public Task update(Task task) {
        var taskToUpdate = taskDboMapper.toDbo(task);
        var taskUpdated = taskSpringJpaAdapterRepository.save(taskToUpdate);
        return taskDboMapper.toDomain(taskUpdated);
    }

}
