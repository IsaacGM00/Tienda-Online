package mx.com.santander.hexagonalmodularmaven.user.model.entity;

import mx.com.santander.hexagonalmodularmaven.task.model.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserTasks {

    private List<Task> tasks;

}
