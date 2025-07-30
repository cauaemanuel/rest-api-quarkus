package arg.acme.usecases;

import arg.acme.model.User;
import arg.acme.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
public class DeletarUserUseCase {


    @Inject
    private UserRepository userRepository;

    @Transactional
    public void deletarPessoa(UUID id) {
        userRepository.deleteById(id);
    }
}
