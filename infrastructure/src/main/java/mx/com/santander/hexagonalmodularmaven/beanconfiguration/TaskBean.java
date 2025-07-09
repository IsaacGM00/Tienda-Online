package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import mx.com.santander.hexagonalmodularmaven.task.service.TaskCreateService;
import mx.com.santander.hexagonalmodularmaven.task.service.TaskDeleteService;
import mx.com.santander.hexagonalmodularmaven.task.service.TaskEditService;
import mx.com.santander.hexagonalmodularmaven.task.service.TaskRedisService;
import mx.com.santander.hexagonalmodularmaven.task.service.TaskSuperComplexService;
import mx.com.santander.hexagonalmodularmaven.redis.port.RedisPort;
import mx.com.santander.hexagonalmodularmaven.task.port.dao.TaskDao;
import mx.com.santander.hexagonalmodularmaven.task.port.repository.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskBean {

    @Bean
    public TaskCreateService taskCreateService(TaskRepository taskRepository, TaskSuperComplexService taskSuperComplexService, TaskRedisService taskRedisService){
        return new TaskCreateService(taskRepository, taskSuperComplexService, taskRedisService);
    }

    @Bean
    public TaskDeleteService taskDeleteService(TaskRepository taskRepository,
                                               TaskDao taskDao){
        return new TaskDeleteService(taskRepository, taskDao);
    }

    @Bean
    public TaskEditService taskEditService(TaskDao taskDao,
                                           TaskRepository taskRepository){
        return new TaskEditService(taskDao, taskRepository);
    }

    @Bean
    public TaskSuperComplexService taskSuperComplexService(){
        return new TaskSuperComplexService();
    }

    @Bean
    public TaskRedisService taskRedisService(RedisPort redisPort) {
    	return new TaskRedisService(redisPort);
    }

}
