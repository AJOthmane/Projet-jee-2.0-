package ma.ensias.projetjee2_0.Responses;

import ma.ensias.projetjee2_0.entites.Post;
import ma.ensias.projetjee2_0.entites.User;

import java.util.List;

public class UserResponse {
    public User user;
    public List<Post> listOfPosts;
    public boolean success;

    public UserResponse(boolean success) {
        this.success = success;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Post> getListOfPosts() {
        return listOfPosts;
    }

    public void setListOfPosts(List<Post> listOfPosts) {
        this.listOfPosts = listOfPosts;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public UserResponse() {
    }

    public UserResponse(User user, List<Post> listOfPosts, boolean success) {
        this.user = user;
        this.listOfPosts = listOfPosts;
        this.success = success;
    }
}
