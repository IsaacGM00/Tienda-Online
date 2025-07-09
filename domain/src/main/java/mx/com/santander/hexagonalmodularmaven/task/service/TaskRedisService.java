package mx.com.santander.hexagonalmodularmaven.task.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.redis.port.RedisPort;
@RequiredArgsConstructor
public class TaskRedisService {
	
	private final RedisPort redisPort;

	public String execute() {
		return redisPort.saveRedis();
	}

}
