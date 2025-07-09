package mx.com.santander.hexagonalmodularmaven.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.redis.entity.RedisEntity;

@Repository
public interface RedisRepository extends CrudRepository<RedisEntity, String> {

}
