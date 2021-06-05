package ma.ensias.projetjee2_0.Responses;

public class CreationResponse {

    private boolean success;
    private String errors;

    public CreationResponse() {
    }

    public CreationResponse(boolean success, String errors) {
        this.success = success;
        this.errors = errors;
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
}
