package mx.com.santander.hexagonalmodularmaven.user.query;


import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.user.mapper.UserDtoMapper;
import mx.com.santander.hexagonalmodularmaven.user.model.dto.UserDto;
import mx.com.santander.hexagonalmodularmaven.user.service.UserByIdService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserByIdHandler {

    private final UserByIdService userByIdService;
    private final UserDtoMapper userDtoMapper;
    public UserDto execute(Long id){
        return userDtoMapper
                .toDto(userByIdService.execute(id));
    }

}
