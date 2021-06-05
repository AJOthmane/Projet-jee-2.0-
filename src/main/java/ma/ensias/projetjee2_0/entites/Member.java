package ma.ensias.projetjee2_0.entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Member  {

    @EmbeddedId
    private MemberId id = new MemberId();

    @ManyToOne
    @MapsId("userId")
    private User user;


    @ManyToOne
    @MapsId("topicId")
    private Topic topic;


    private boolean isModerator;

    public Member() {}

    public Member(User User, Topic topic, boolean isModerator) {
        this.user = User;
        this.topic = topic;
        this.isModerator = isModerator;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopicId() {
        return topic;
    }

    public void setTopicId(Topic topicId) {
        this.topic = topicId;
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
        return Objects.equals(this.user, that.user) &&
                Objects.equals(this.topic, that.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, topic);
    }
}
