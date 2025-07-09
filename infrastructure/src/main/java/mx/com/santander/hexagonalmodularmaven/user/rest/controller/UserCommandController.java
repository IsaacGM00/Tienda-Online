package mx.com.santander.hexagonalmodularmaven.user.rest.controller;

import mx.com.santander.hexagonalmodularmaven.user.command.UserAssignTasksHandler;
import mx.com.santander.hexagonalmodularmaven.user.command.UserCreateHandler;
import mx.com.santander.hexagonalmodularmaven.user.command.UserDeleteHandler;
import mx.com.santander.hexagonalmodularmaven.user.command.UserEditHandler;
import mx.com.santander.hexagonalmodularmaven.user.model.dto.UserDto;
import mx.com.santander.hexagonalmodularmaven.user.model.dto.command.UserCreateCommand;
import mx.com.santander.hexagonalmodularmaven.user.model.dto.command.UserEditCommand;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserCommandController {

    private final UserCreateHandler userCreateHandler;
    private final UserEditHandler userEditHandler;
    private final UserDeleteHandler userDeleteHandler;
    private final UserAssignTasksHandler userAssignTasksHandler;

    public UserCommandController(UserCreateHandler userCreateHandler, UserEditHandler userEditHandler, UserDeleteHandler userDeleteHandler, UserAssignTasksHandler userAssignTasksHandler) {
        this.userCreateHandler = userCreateHandler;
        this.userEditHandler = userEditHandler;
        this.userDeleteHandler = userDeleteHandler;
        this.userAssignTasksHandler = userAssignTasksHandler;
    }

    @PostMapping()
    public UserDto create(@RequestBody UserCreateCommand userCreateCommand){
        return userCreateHandler.execute(userCreateCommand);
    }

    @PutMapping("/{id}")
    public UserDto userEdit(@RequestBody UserEditCommand userEditCommand,
                            @PathVariable Long id){
        return userEditHandler.execute(userEditCommand, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        userDeleteHandler.execute(id);
    }

    @PostMapping("/{id}/tasks")
    public void assignTasks(@PathVariable Long id , @RequestParam List<Long> tasksIds){
        userAssignTasksHandler.execute(id, tasksIds);
    }

}
