package mx.com.santander.hexagonalmodularmaven.user.query;


import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.user.mapper.UserDtoMapper;
import mx.com.santander.hexagonalmodularmaven.user.model.dto.UserDto;
import mx.com.santander.hexagonalmodularmaven.user.service.UserAllService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class UserAllHandler {

    private final UserAllService userAllService;
    private final UserDtoMapper userDtoMapper;
    public List<UserDto> execute(){
        return userAllService.execute()
                .stream()
                .map(userDtoMapper::toDto)
                .collect(Collectors.toList());
    }

}
