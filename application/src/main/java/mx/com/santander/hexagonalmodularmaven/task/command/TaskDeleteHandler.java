package mx.com.santander.hexagonalmodularmaven.task.command;


import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.task.service.TaskDeleteService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskDeleteHandler {

    private final TaskDeleteService taskDeleteService;

    public void execute(Long id){
        taskDeleteService.execute(id);
    }

}
