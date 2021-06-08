package ma.ensias.projetjee2_0.Responses;

import java.util.ArrayList;

import ma.ensias.projetjee2_0.entites.Post;

public class GetHomeResponse {
    private  boolean success;
    ArrayList<Post> listOfPosts = new ArrayList<>(); 

    public GetHomeResponse(){
    }

    public GetHomeResponse(boolean success, ArrayList<Post> listOfPosts){
        this.success = success;
        this.listOfPosts = listOfPosts;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<Post> getListOfPosts() {
        return this.listOfPosts;
    }

    public void setListOfPosts(ArrayList<Post> listOfPosts) {
        this.listOfPosts = listOfPosts;
    }
}
