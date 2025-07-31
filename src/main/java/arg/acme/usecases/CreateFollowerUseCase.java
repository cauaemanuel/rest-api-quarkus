package arg.acme.usecases;

import arg.acme.model.Follower;
import arg.acme.repository.FollowerRepository;
import arg.acme.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@ApplicationScoped
public class CreateFollowerUseCase {

    @Inject
    private UserRepository userRepository;

    @Inject
    private FollowerRepository followerRepository;


    @Transactional
    public void execute(UUID userId, UUID followerId) {

        if (userId.equals(followerId)){
            throw new WebApplicationException(
                "User cannot follow themselves",
                Response.Status.CONFLICT
            );
        }

        var user = userRepository.findById(userId);
        if(user == null){
            throw new WebApplicationException(
                "User not found",
                Response.Status.NOT_FOUND
            );
        }

        var follower = userRepository.findById(followerId);
        boolean followers = followerRepository.followExists(follower, user);

        if(followers){
            throw new WebApplicationException(
                "Follower already exists",
                Response.Status.BAD_REQUEST
            );
        }

        var entity = new Follower();
        entity.setUser(user);
        entity.setFollower(follower);

        followerRepository.persist(entity);

    }
}
