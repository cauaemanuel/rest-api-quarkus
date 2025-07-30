package arg.acme.usecases;

import arg.acme.controller.dto.CreateUserRequestDto;
import arg.acme.model.User;
import arg.acme.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

@ApplicationScoped
public class SaveUserUseCase {

    @Inject
    private UserRepository userRepository;

    @Transactional
    public void execute(CreateUserRequestDto createUserRequestDto) {
        User user = new User(createUserRequestDto.nome(),
                                    createUserRequestDto.age());
        userRepository.persist(user);
    }
}
