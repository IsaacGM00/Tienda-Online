package mx.com.santander.hexagonalmodularmaven.user.port.repository;


import mx.com.santander.hexagonalmodularmaven.user.model.entity.User;

public interface UserRepository {

    User create(User user);
    void deleteById(Long id);
    User update(User user);

}
