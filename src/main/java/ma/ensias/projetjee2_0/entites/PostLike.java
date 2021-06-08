package ma.ensias.projetjee2_0.entites;

import javax.persistence.*;

@Entity
public class PostLike  {

    @EmbeddedId
    private PostLikeId id = new PostLikeId();

    @ManyToOne
    @MapsId("userId")
    private User user;


    @ManyToOne
    @MapsId("postId")
    private Post post;

    private boolean isLike;

    public PostLike(PostLikeId id, User user, Post post, boolean isLike) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.isLike = isLike;
    }

    public PostLike() {}

    public PostLikeId getId() {
        return id;
    }

    public void setId(PostLikeId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}
