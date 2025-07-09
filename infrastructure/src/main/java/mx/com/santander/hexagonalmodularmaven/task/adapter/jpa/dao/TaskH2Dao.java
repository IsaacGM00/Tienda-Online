package mx.com.santander.hexagonalmodularmaven.task.adapter.jpa.dao;

import mx.com.santander.hexagonalmodularmaven.task.adapter.jpa.TaskSpringJpaAdapterRepository;
import mx.com.santander.hexagonalmodularmaven.task.adapter.mapper.TaskDboMapper;
import mx.com.santander.hexagonalmodularmaven.task.model.constant.TaskConstant;
import mx.com.santander.hexagonalmodularmaven.task.model.entity.Task;
import mx.com.santander.hexagonalmodularmaven.task.model.exception.TaskException;
import mx.com.santander.hexagonalmodularmaven.task.port.dao.TaskDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
@Repository
public class TaskH2Dao implements TaskDao {

    private final TaskSpringJpaAdapterRepository taskSpringJpaAdapterRepository;
    private final TaskDboMapper taskDboMapper;

    public TaskH2Dao(TaskSpringJpaAdapterRepository taskSpringJpaAdapterRepository, TaskDboMapper taskDboMapper) {
        this.taskSpringJpaAdapterRepository = taskSpringJpaAdapterRepository;
        this.taskDboMapper = taskDboMapper;
    }

    @Override
    public Task getById(Long id) {
        var optionalTask = taskSpringJpaAdapterRepository.findById(id);

        if (optionalTask.isEmpty()){
            throw new TaskException(String.format(TaskConstant.TASK_NOT_FOUND_MESSAGE_ERROR, id));
        }

        return taskDboMapper.toDomain(optionalTask.get());
    }

    @Override
    public List<Task> getAll() {
        return taskSpringJpaAdapterRepository.findAll()
                .stream()
                .map(taskDboMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> getByIds(List<Long> tasksIds) {

        return taskSpringJpaAdapterRepository.findByIdIn(tasksIds)
                .stream()
                .map(taskDboMapper::toDomain)
                .collect(Collectors.toList());
    }
}
