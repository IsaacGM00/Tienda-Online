package mx.com.santander.hexagonalmodularmaven.user.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.user.port.dao.UserDao;
import mx.com.santander.hexagonalmodularmaven.user.port.repository.UserRepository;

@RequiredArgsConstructor
public class UserDeleteService {

    private final UserDao userDao;
    private final UserRepository userRepository;

    public void execute(Long id){
        var user = userDao.getById(id);
        userRepository.deleteById(user.getId());
    }

}
