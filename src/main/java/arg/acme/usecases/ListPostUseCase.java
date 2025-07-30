package arg.acme.usecases;

import arg.acme.model.Post;
import arg.acme.repository.PostRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ListPostUseCase
{

    @Inject
    private PostRepository postRepository;

    public List<Post> execute(UUID id) {
        return postRepository.findByUserId(id);
    }
}
