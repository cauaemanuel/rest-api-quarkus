package arg.acme.usecases;

import arg.acme.model.Post;
import arg.acme.repository.FollowerRepository;
import arg.acme.repository.PostRepository;
import arg.acme.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ListPostUseCase
{

    @Inject
    private PostRepository postRepository;
    @Inject
    private FollowerRepository followerRepository;
    @Inject
    private UserRepository userRepository;

    public List<Post> execute(UUID id, UUID followerId) {

        var user = userRepository.findById(id);
        var follower = userRepository.findById(followerId);
        var follows = followerRepository.followExists(follower, user);
        if (!follows){
            throw new WebApplicationException(
                "You must follow the user to see their posts",
                Response.Status.FORBIDDEN
            );
        }

        return postRepository.findByUserId(id);
    }
}
