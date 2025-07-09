package mx.com.santander.hexagonalmodularmaven.task.adapter.mapper;

import mx.com.santander.hexagonalmodularmaven.task.adapter.entity.TaskEntity;
import mx.com.santander.hexagonalmodularmaven.user.adapter.entity.UserEntity;
import mx.com.santander.hexagonalmodularmaven.user.adapter.mapper.UserDboMapper;
import mx.com.santander.hexagonalmodularmaven.task.model.entity.Task;
import mx.com.santander.hexagonalmodularmaven.user.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TaskDboMapper {

    private final UserDboMapper userDboMapper;

    public TaskDboMapper(UserDboMapper userDboMapper) {
        this.userDboMapper = userDboMapper;
    }

    public TaskEntity toDbo(Task domain){
        if(domain == null){
            return null;
        }

        Set<UserEntity> userEntities = domain.getUsers().stream().map(userDboMapper::toDbo).collect(Collectors.toSet());

        return new TaskEntity(
                domain.getId(),
                domain.getName(),
                domain.getDescription(),
                domain.getCompleted(),
                domain.getDateOfCreation(),
                domain.getTimeRequiredToComplete(),
                userEntities);

    }

    public TaskEntity toDboCreate(Task domain){
        if(domain == null){
            return null;
        }
        return new TaskEntity(domain.getName(),domain.getDescription(),domain.getCompleted(),domain.getDateOfCreation(),domain.getTimeRequiredToComplete());
    }

    public Task toDomain(TaskEntity entity){
        if(entity == null){
            return null;
        }

        List<User> users = entity.getUserEntities().stream().map(userDboMapper::toDomainWithOutTask).collect(Collectors.toList());

        return new Task(entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.isCompleted(),
                entity.getDateOfCreation(),
                entity.getTimeRequiredToComplete(),
                users);
    }

    public Task toDomainWithOutUser(TaskEntity entity){
        if(entity == null){
            return null;
        }

        return new Task(entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.isCompleted(),
                entity.getDateOfCreation(),
                entity.getTimeRequiredToComplete());
    }

}
