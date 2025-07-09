package mx.com.santander.hexagonalmodularmaven.user.adapter.jpa;


import mx.com.santander.hexagonalmodularmaven.user.adapter.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSpringJpaAdapterRepository extends JpaRepository<UserEntity, Long> {

}