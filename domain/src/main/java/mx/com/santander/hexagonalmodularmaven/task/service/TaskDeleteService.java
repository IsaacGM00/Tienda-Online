package mx.com.santander.hexagonalmodularmaven.task.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.task.model.constant.TaskConstant;
import mx.com.santander.hexagonalmodularmaven.task.port.dao.TaskDao;
import mx.com.santander.hexagonalmodularmaven.task.port.repository.TaskRepository;
import mx.com.santander.hexagonalmodularmaven.user.model.exception.UserTaskAssignationException;
@RequiredArgsConstructor
public class TaskDeleteService {

    private final TaskRepository taskRepository;
    private final TaskDao taskDao;
    public void execute(Long id){

        var task = taskDao.getById(id);

        if(task.getUsers().size() > 0){
            throw new UserTaskAssignationException(
                    String.format(TaskConstant.CURRENT_TASK_NOT_ALLOW_TO_DELETE, task.getName()));
        }
        taskRepository.deleteById(id);
    }

}
