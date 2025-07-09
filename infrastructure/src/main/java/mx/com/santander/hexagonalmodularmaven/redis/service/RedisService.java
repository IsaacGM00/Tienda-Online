package mx.com.santander.hexagonalmodularmaven.redis.service;

import org.springframework.stereotype.Service;

import mx.com.santander.hexagonalmodularmaven.redis.entity.RedisEntity;
import mx.com.santander.hexagonalmodularmaven.redis.port.RedisPort;
import mx.com.santander.hexagonalmodularmaven.redis.repository.RedisRepository;

@Service
public class RedisService implements RedisPort {
	
	private final RedisRepository redisRepository;
	
	RedisService(RedisRepository redisRepository){
		this.redisRepository = redisRepository;
	}

	@Override
	public String saveRedis() {
		final RedisEntity entity = new RedisEntity("id", "fieldTwo");
		redisRepository.save(entity);
		return entity.getId();
	}

}
