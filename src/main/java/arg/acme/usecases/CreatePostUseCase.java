package arg.acme.usecases;

import arg.acme.controller.dto.Content;
import arg.acme.model.Post;
import arg.acme.repository.PostRepository;
import arg.acme.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class CreatePostUseCase {

    @Inject
    private PostRepository postRepository;

    @Inject
    private UserRepository userRepository;

    @Transactional
    public void execute(UUID userId, Content content) {
        var user = userRepository.findById(userId);
        if (user == null) {
            throw new WebApplicationException(
                    Response.status(Response.Status.NOT_FOUND)
                            .entity("User not found with id: " + userId)
                            .build()
            );
        }

        var post = new Post();
        post.setUser(user);
        post.setText(content.body());
        post.setDataTime(LocalDateTime.now());
        postRepository.persist(post);
    }
}
