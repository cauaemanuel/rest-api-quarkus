package arg.acme.usecases;

import arg.acme.repository.FollowerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;

import java.util.UUID;

@ApplicationScoped
public class UnFollowerUseCase {

    @Inject
    private FollowerRepository followerRepository;

    @Transactional
    public void unfollowUser(UUID userId, UUID followerId) {
        if (userId.equals(followerId)){
            throw new WebApplicationException(
                "User cannot unfollow themselves",
                jakarta.ws.rs.core.Response.Status.CONFLICT
            );
        }

        followerRepository.deleteByFollowerAndUser(followerId, userId);
    }
}
