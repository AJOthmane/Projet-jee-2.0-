package ma.ensias.projetjee2_0.entites;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
/*
    Cette classe est utilise pour l'inclusion
 */

@Embeddable
public class MemberId implements Serializable {

    private int userId;
    private int topicId;

    public MemberId(int userId, int topicId) {
        this.userId = userId;
        this.topicId = topicId;
    }
    public MemberId() {}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberId memberId = (MemberId) o;
        return userId == memberId.userId && topicId == memberId.topicId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, topicId);
    }
}
