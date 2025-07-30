package arg.acme.usecases;

import arg.acme.model.User;
import arg.acme.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@ApplicationScoped
public class DeletarUserUseCase {


    @Inject
    private UserRepository userRepository;

    @Transactional
    public void deletarPessoa(UUID id) {

        var user = userRepository.findById(id);
        if (user == null) {
            throw new WebApplicationException(
                    Response.status(Response.Status.NOT_FOUND)
                            .entity("User not found with id: " + id)
                            .build()
            );
        }
        userRepository.deleteById(id);
    }
}
