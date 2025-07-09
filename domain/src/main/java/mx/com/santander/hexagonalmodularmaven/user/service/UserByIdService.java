package mx.com.santander.hexagonalmodularmaven.user.service;


import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.user.model.entity.User;
import mx.com.santander.hexagonalmodularmaven.user.port.dao.UserDao;
@RequiredArgsConstructor
public class UserByIdService {
    private final UserDao userDao;
    public User execute(Long id){
        return userDao.getById(id);
    }

}
