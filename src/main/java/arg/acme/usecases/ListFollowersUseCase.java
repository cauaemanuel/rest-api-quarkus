package arg.acme.usecases;

import arg.acme.controller.dto.FollowerResponse;
import arg.acme.controller.dto.FollowersPerUserResponse;
import arg.acme.repository.FollowerRepository;
import arg.acme.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped
public class ListFollowersUseCase {

    @Inject
    private FollowerRepository followerRepository;

    public FollowersPerUserResponse listarSeguidoresPorUsuario(UUID id) {

        var followers = followerRepository.findByUser(id);

        if (followers.isEmpty()) {
            return new FollowersPerUserResponse(0, null);
        }

        var followersResponse = followers.stream()
                .map(follower -> new FollowerResponse(follower.getId(), follower.getUser().nome))
                .toList();

        return new FollowersPerUserResponse(followers.size(), followersResponse);
    }
}
