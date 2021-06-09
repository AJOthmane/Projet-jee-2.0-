package ma.ensias.projetjee2_0.Responses;

import ma.ensias.projetjee2_0.entites.Post;
import ma.ensias.projetjee2_0.entites.Topic;

import java.util.ArrayList;
import java.util.Map;

public class GetTopicResponse {
    private  boolean success;
    private Map<String,String> errors;

    public GetTopicResponse(boolean success, Map<String,String> errors) {
        this.success = success;
        this.errors = errors;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String,String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String,String> errors) {
        this.errors = errors;
    }

    private Topic topic;
    private boolean joined;
    private ArrayList<Post> posts;

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public void setJoined(boolean joined) {
        this.joined = joined;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public Topic getTopic() {
        return topic;
    }

    public boolean isJoined() {
        return joined;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public GetTopicResponse(Topic topic, ArrayList<Post> posts) {
        this.topic = topic;
        this.posts = posts;
    }

    public GetTopicResponse() {
    }

    public GetTopicResponse(boolean success, Topic topic) {
        this.success = success;
        this.topic = topic;
    }

    public GetTopicResponse(Boolean success, Topic topic, boolean joined, ArrayList<Post> posts) {
        this.topic = topic;
        this.joined = joined;
        this.posts = posts;
    }
}
