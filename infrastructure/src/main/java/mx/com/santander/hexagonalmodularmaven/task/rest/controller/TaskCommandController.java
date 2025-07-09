package mx.com.santander.hexagonalmodularmaven.task.rest.controller;

import mx.com.santander.hexagonalmodularmaven.task.command.TaskCreateHandler;
import mx.com.santander.hexagonalmodularmaven.task.command.TaskDeleteHandler;
import mx.com.santander.hexagonalmodularmaven.task.command.TaskEditHandler;
import mx.com.santander.hexagonalmodularmaven.task.model.dto.TaskDto;
import mx.com.santander.hexagonalmodularmaven.task.model.dto.command.TaskCreateCommand;
import mx.com.santander.hexagonalmodularmaven.task.model.dto.command.TaskEditCommand;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskCommandController {
    private final TaskCreateHandler taskCreateHandler;
    private final TaskEditHandler taskEditHandler;
    private final TaskDeleteHandler taskDeleteHandler;

    public TaskCommandController(TaskCreateHandler taskCreateHandler, TaskEditHandler taskEditHandler, TaskDeleteHandler taskDeleteHandler) {
        this.taskCreateHandler = taskCreateHandler;
        this.taskEditHandler = taskEditHandler;
        this.taskDeleteHandler = taskDeleteHandler;
    }

    @PostMapping()
    public TaskDto create(@RequestBody TaskCreateCommand createCommand){
        return taskCreateHandler.execute(createCommand);
    }

    @PutMapping("/{id}")
    public TaskDto edit(@RequestBody TaskEditCommand taskEditCommand,
                        @PathVariable Long id){
        return taskEditHandler.execute(taskEditCommand, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        taskDeleteHandler.execute(id);
    }

}
