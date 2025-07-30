package arg.acme.usecases;

import arg.acme.model.User;
import arg.acme.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

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
        var user = userRepository.findById(id);
        if (user == null) {
            throw new WebApplicationException(
                    Response.status(Response.Status.NOT_FOUND)
                            .entity("User not found with id: " + id)
                            .build()
            );
        }
        return user;
    }
}
