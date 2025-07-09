package mx.com.santander.hexagonalmodularmaven.user.adapter.jpa.repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.user.adapter.jpa.UserSpringJpaAdapterRepository;
import mx.com.santander.hexagonalmodularmaven.user.adapter.mapper.UserDboMapper;
import mx.com.santander.hexagonalmodularmaven.user.model.entity.User;
import mx.com.santander.hexagonalmodularmaven.user.port.repository.UserRepository;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
@Transactional
public class UserH2Repository implements UserRepository {

    private final UserSpringJpaAdapterRepository userSpringJpaAdapterRepository;
    private final UserDboMapper userDboMapper;


    @Override
    public User create(User user) {
        var userToSave = userDboMapper.toDboCreate(user);
        var userSaved = userSpringJpaAdapterRepository.save(userToSave);
        return userDboMapper.toDomain(userSaved);
    }

    @Override
    public void deleteById(Long id) {
        userSpringJpaAdapterRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
        var userToUpdate = userDboMapper.toDbo(user);
        var userUpdated = userSpringJpaAdapterRepository.save(userToUpdate);
        return userDboMapper.toDomain(userUpdated);
    }

}
