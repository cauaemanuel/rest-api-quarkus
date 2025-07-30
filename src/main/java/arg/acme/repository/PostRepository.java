package arg.acme.repository;

import arg.acme.model.Post;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class PostRepository implements PanacheRepositoryBase<Post, UUID> {

    public List<Post> findByUserId(UUID userId) {
        return find("user.id", userId)
                .list();
    }
}
