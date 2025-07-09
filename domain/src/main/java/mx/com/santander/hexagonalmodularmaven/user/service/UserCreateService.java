package mx.com.santander.hexagonalmodularmaven.user.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.entry.service.EntryService;
import mx.com.santander.hexagonalmodularmaven.user.model.dto.command.UserCreateCommand;
import mx.com.santander.hexagonalmodularmaven.user.model.entity.User;
import mx.com.santander.hexagonalmodularmaven.user.port.repository.UserRepository;
@RequiredArgsConstructor
public class UserCreateService {

    private final UserRepository userRepository;

    private final EntryService entryService;
    public User execute(UserCreateCommand userCreateCommand){
        var userToCreate = new User()
                .requestToCreate(userCreateCommand);

        var createdEntry = entryService.createEntry(userToCreate);
        return userRepository.create(userToCreate);

    }

}
