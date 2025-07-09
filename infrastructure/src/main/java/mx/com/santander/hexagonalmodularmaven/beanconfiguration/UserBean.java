package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import mx.com.santander.hexagonalmodularmaven.entry.service.EntryService;
import mx.com.santander.hexagonalmodularmaven.user.port.dao.UserDao;
import mx.com.santander.hexagonalmodularmaven.user.port.repository.UserRepository;
import mx.com.santander.hexagonalmodularmaven.task.port.dao.TaskDao;
import mx.com.santander.hexagonalmodularmaven.user.service.UserAllService;
import mx.com.santander.hexagonalmodularmaven.user.service.UserAssignTasksService;
import mx.com.santander.hexagonalmodularmaven.user.service.UserByIdService;
import mx.com.santander.hexagonalmodularmaven.user.service.UserCreateService;
import mx.com.santander.hexagonalmodularmaven.user.service.UserDeleteService;
import mx.com.santander.hexagonalmodularmaven.user.service.UserEditService;
import mx.com.santander.hexagonalmodularmaven.user.service.UserValidationAllowTasksAssignmentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBean {
    @Bean
    public UserAllService userAllService(UserDao userDao){
        return new UserAllService(userDao);
    }

    @Bean
    public UserAssignTasksService userAssignTasksService(UserDao userDao,
                                                         TaskDao taskDao,
                                                         UserRepository userRepository,
                                                         UserValidationAllowTasksAssignmentService userValidationAllowTasksAssignmentService){
        return new UserAssignTasksService(
                userDao,
                taskDao,
                userRepository,
                userValidationAllowTasksAssignmentService);
    }

    @Bean
    public UserByIdService userByIdService(UserDao userDao){
        return new UserByIdService(userDao);
    }

    @Bean
    public UserCreateService userCreateService(UserRepository userRepository, EntryService entryService){
        return new UserCreateService(userRepository,entryService);
    }

    @Bean
    public UserDeleteService userDeleteService(UserDao userDao,
                                               UserRepository userRepository){
        return new UserDeleteService(
                userDao,
                userRepository);
    }

    @Bean
    public UserEditService userEditService(UserDao userDao,
                                           UserRepository userRepository){
        return new UserEditService(userDao, userRepository);
    }

    @Bean
    public UserValidationAllowTasksAssignmentService userValidationAllowTasksAssignmentService(){
        return new UserValidationAllowTasksAssignmentService();
    }

}
