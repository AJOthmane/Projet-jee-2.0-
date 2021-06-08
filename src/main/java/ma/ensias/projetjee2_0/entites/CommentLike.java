package ma.ensias.projetjee2_0.entites;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class CommentLike {
    @EmbeddedId
    private CommentLikeId id = new CommentLikeId();

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("commentId")
    private Comment comment;

    private boolean isLike;

    public CommentLike() { }

    public CommentLike(CommentLikeId id, User user, Comment comment,boolean isLike)
    {
        this.id = id;
        this.user = user;
        this.comment = comment;
        this.isLike = isLike;
    }

    public CommentLikeId getId() {
        return id;
    }

    public void setId(CommentLikeId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public boolean isLike()
    {
        return isLike;
    }

    public void setLike(boolean like)
    {
        isLike = like;
    }
}
