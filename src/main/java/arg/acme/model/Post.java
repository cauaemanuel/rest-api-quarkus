package arg.acme.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_posts")
@AllArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "post_text")
    private String text;

    @Column(name = "dateTime")
    private LocalDateTime dataTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post(){
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}