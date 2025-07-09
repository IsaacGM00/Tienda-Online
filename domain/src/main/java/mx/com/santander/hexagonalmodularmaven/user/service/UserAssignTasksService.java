package mx.com.santander.hexagonalmodularmaven.user.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.user.model.entity.User;
import mx.com.santander.hexagonalmodularmaven.user.port.dao.UserDao;
import mx.com.santander.hexagonalmodularmaven.user.port.repository.UserRepository;
import mx.com.santander.hexagonalmodularmaven.task.port.dao.TaskDao;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
public class UserAssignTasksService {
    private final UserDao userDao;
    private final TaskDao taskDao;
    private final UserRepository userRepository;
    private final UserValidationAllowTasksAssignmentService userValidationAllowTasksAssignmentService;
    public User execute(Long id, List<Long> tasksIds){

        var user = userDao.getById(id);

        var tasksToDo = taskDao.getByIds(tasksIds);

        userValidationAllowTasksAssignmentService
                .execute(new ArrayList<>(user.getTasks()), tasksToDo);

        user.getTasks().addAll(tasksToDo);

       return userRepository.update(user);
    }

}
