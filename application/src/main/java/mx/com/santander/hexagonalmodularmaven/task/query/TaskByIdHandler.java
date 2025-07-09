package mx.com.santander.hexagonalmodularmaven.task.query;


import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.task.mapper.TaskDtoMapper;
import mx.com.santander.hexagonalmodularmaven.task.model.dto.TaskDto;
import mx.com.santander.hexagonalmodularmaven.task.port.dao.TaskDao;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskByIdHandler {
    private final TaskDao taskDao;
    private final TaskDtoMapper taskDtoMapper;
    public TaskDto execute(Long id){
        return taskDtoMapper.toDto(taskDao.getById(id));
    }

}
