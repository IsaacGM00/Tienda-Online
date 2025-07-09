package mx.com.santander.hexagonalmodularmaven.user.command;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.user.mapper.UserDtoMapper;
import mx.com.santander.hexagonalmodularmaven.user.model.dto.UserDto;
import mx.com.santander.hexagonalmodularmaven.user.model.dto.command.UserEditCommand;
import mx.com.santander.hexagonalmodularmaven.user.service.UserEditService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEditHandler {

    private final UserEditService userEditService;
    private final UserDtoMapper userDtoMapper;

    public UserDto execute(UserEditCommand userEditCommand, Long id){
        return userDtoMapper
                .toDto(userEditService.execute(userEditCommand, id)) ;
    }

}
