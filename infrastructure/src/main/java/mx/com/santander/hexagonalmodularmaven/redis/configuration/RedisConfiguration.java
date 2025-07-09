package mx.com.santander.hexagonalmodularmaven.redis.configuration;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import mx.com.santander.hexagonalmodularmaven.redis.entity.RedisEntity;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfiguration {
	
	@Bean
	public RedisTemplate<Long, RedisEntity> redisTemplate(RedisConnectionFactory connectionFactory) {
	    RedisTemplate<Long, RedisEntity> template = new RedisTemplate<>();
	    template.setConnectionFactory(connectionFactory);
	    return template;
	}

}
