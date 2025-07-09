package mx.com.santander.hexagonalmodularmaven.task.command;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.task.mapper.TaskDtoMapper;
import mx.com.santander.hexagonalmodularmaven.task.model.dto.TaskDto;
import mx.com.santander.hexagonalmodularmaven.task.model.dto.command.TaskCreateCommand;
import mx.com.santander.hexagonalmodularmaven.task.service.TaskCreateService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskCreateHandler {

    private final TaskCreateService taskCreateService;
    private final TaskDtoMapper taskDtoMapper;

    public TaskDto execute(TaskCreateCommand createCommand){
        return taskDtoMapper.toDto(taskCreateService.execute(createCommand));
    }

}
