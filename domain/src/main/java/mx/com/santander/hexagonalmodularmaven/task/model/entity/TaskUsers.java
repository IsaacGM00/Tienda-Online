package mx.com.santander.hexagonalmodularmaven.task.model.entity;

import mx.com.santander.hexagonalmodularmaven.user.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TaskUsers {

    List<User> users;

}
