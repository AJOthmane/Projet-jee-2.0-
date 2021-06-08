package ma.ensias.projetjee2_0.Responses;

import java.util.ArrayList;

import ma.ensias.projetjee2_0.entites.Comment;
import ma.ensias.projetjee2_0.entites.Content;
import ma.ensias.projetjee2_0.entites.Post;

public class GetPostResponse {
    private  boolean success;
    private String errors;
    private Post post;
    ArrayList<Comment> comments;

    public GetPostResponse(boolean success, String errors) {
        this.success = success;
        this.errors = errors;
    }

    public GetPostResponse(boolean success, Post post, ArrayList<Comment> comments) {
        this.success = success;
        this.post = post;
        this.comments = comments;
    }

    public GetPostResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post){
        this.post = post;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
