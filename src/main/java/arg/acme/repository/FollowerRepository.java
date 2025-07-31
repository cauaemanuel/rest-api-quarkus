package arg.acme.repository;

import arg.acme.model.Follower;
import arg.acme.model.User;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
public class FollowerRepository implements PanacheRepositoryBase<Follower, UUID> {

    public boolean followExists(User follower, User user) {
        var params = Parameters.with("follower", follower)
                .and("user", user);
        PanacheQuery<Follower> query =  find("follower =:follower and user =:user",params);
        return query.firstResultOptional().isPresent();
    }

    public List<Follower> findByUser(UUID id){
        return find("user.id", id).list();
    }

    public void deleteByFollowerAndUser(UUID followerId, UUID userId){
        delete("follower.id =: followerId and user.id =: userId",
                Parameters.with("followerId", followerId)
                        .and("userId", userId));

    }

}
