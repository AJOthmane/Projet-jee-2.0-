package ma.ensias.projetjee2_0.entites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Member implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId")
    @Id
    private User userId;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "topicId")
    @Id
    private Topic topicId;
    private boolean isModerator;

    public Member() {}

    public Member(User userId, Topic topicId, boolean isModerator) {
        this.userId = userId;
        this.topicId = topicId;
        this.isModerator = isModerator;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Topic getTopicId() {
        return topicId;
    }

    public void setTopicId(Topic topicId) {
        this.topicId = topicId;
    }

    public boolean isModerator() {
        return isModerator;
    }

    public void setModerator(boolean moderator) {
        isModerator = moderator;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Member that = (Member) o;
        return Objects.equals(this.userId, that.userId) &&
                Objects.equals(this.topicId, that.topicId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, topicId);
    }
}
