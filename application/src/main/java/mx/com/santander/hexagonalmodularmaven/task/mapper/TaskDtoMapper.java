package mx.com.santander.hexagonalmodularmaven.task.mapper;


import mx.com.santander.hexagonalmodularmaven.task.model.dto.TaskDto;
import mx.com.santander.hexagonalmodularmaven.task.model.entity.Task;
import org.springframework.stereotype.Component;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
@Component
public interface TaskDtoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "timeRequiredToComplete", target = "timeRequiredToComplete")
    TaskDto toDto(Task domain);

}
