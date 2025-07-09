package mx.com.santander.hexagonalmodularmaven.user.command;


import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.user.service.UserDeleteService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDeleteHandler {

    private final UserDeleteService userDeleteService;

    public void execute(Long id){
        userDeleteService.execute(id);
    }

}
