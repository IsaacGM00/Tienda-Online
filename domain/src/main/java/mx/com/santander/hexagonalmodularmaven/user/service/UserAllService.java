package mx.com.santander.hexagonalmodularmaven.user.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.user.model.entity.User;
import mx.com.santander.hexagonalmodularmaven.user.port.dao.UserDao;

import java.util.List;
@RequiredArgsConstructor
public class UserAllService {
    private final UserDao userDao;
    public List<User> execute(){
        return userDao.getAll();
    }

}
