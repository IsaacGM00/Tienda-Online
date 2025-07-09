package mx.com.santander.hexagonalmodularmaven.user.service;

import mx.com.santander.hexagonalmodularmaven.task.model.entity.Task;
import mx.com.santander.hexagonalmodularmaven.user.model.constant.UserConstant;
import mx.com.santander.hexagonalmodularmaven.user.model.exception.UserTaskAssignationException;

import java.util.List;

public class UserValidationAllowTasksAssignmentService {

    public void execute(List<Task> currentTasks, List<Task> tasksToDo) {

        int totalTimeInTasks = getRequirementTimeToDo(currentTasks,tasksToDo);

        var isNotAllow = totalTimeInTasks > 8;

        if (isNotAllow){
            throw new UserTaskAssignationException(
                    String.format(UserConstant.CURRENT_USER_NOT_ALLOW_TO_DO_TASKS, totalTimeInTasks));
        }

    }

    private int getRequirementTimeToDo(List<Task> currentTasks, List<Task> tasksToDo) {

        var timeInCurrentTasks = currentTasks.stream()
                .mapToInt(Task::getTimeRequiredToComplete)
                .sum();

        var timeInTasksToDo = tasksToDo.stream()
                .mapToInt(Task::getTimeRequiredToComplete)
                .sum();

        return timeInCurrentTasks + timeInTasksToDo;
    }

}
