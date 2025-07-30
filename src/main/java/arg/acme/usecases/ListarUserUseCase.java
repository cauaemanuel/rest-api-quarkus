package arg.acme.usecases;

import arg.acme.model.User;
import arg.acme.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ListarUserUseCase {

    @Inject
    private UserRepository userRepository;

    public List<User> listarPessoas() {
        return userRepository.listAll();
    }

    public User listarPessoaPorId(UUID id) {
        return userRepository.findById(id);
    }
}
