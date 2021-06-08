package ma.ensias.projetjee2_0.Responses;

import java.util.ArrayList;

import ma.ensias.projetjee2_0.entites.Topic;

public class SearchResponse {

    private  boolean success;
    private String errors;
    private ArrayList<Topic> listOfTopics;

    public SearchResponse(boolean success, String errors) {
        this.success = success;
        this.errors = errors;
    }

    public SearchResponse() {
    }

    public SearchResponse(boolean success, ArrayList<Topic> listOfTopics) {
        this.success = success;
        this.listOfTopics = listOfTopics;
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

    public ArrayList<Topic> getlistOfTopics() {
        return listOfTopics;
    }

    public void setlistOfTopics(ArrayList<Topic> listOfTopics) {
        this.listOfTopics = listOfTopics;
    }
    
}
