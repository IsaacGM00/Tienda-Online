package mx.com.santander.hexagonalmodularmaven.task.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.task.model.dto.command.TaskEditCommand;
import mx.com.santander.hexagonalmodularmaven.task.model.entity.Task;
import mx.com.santander.hexagonalmodularmaven.task.port.dao.TaskDao;
import mx.com.santander.hexagonalmodularmaven.task.port.repository.TaskRepository;
@RequiredArgsConstructor
public class TaskEditService {

    private final TaskDao taskDao;
    private final TaskRepository taskRepository;
    public Task execute(TaskEditCommand taskEditCommand, Long id){

        var currentTask = taskDao.getById(id);

        var taskToUpdate = new Task(
                currentTask.getId(),
                taskEditCommand.getName(),
                taskEditCommand.getDescription(),
                currentTask.getCompleted(),
                currentTask.getDateOfCreation(),
                taskEditCommand.getTimeRequiredToComplete(),
                currentTask.getUsers());

        return taskRepository.update(taskToUpdate);

    }

}
