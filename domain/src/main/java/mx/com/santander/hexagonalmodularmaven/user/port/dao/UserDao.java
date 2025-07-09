package mx.com.santander.hexagonalmodularmaven.user.port.dao;


import mx.com.santander.hexagonalmodularmaven.user.model.entity.User;

import java.util.List;

public interface UserDao {

    User getById(Long id);
    List<User> getAll();
}
