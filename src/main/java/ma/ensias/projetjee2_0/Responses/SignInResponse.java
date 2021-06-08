package ma.ensias.projetjee2_0.Responses;

public class SignInResponse {
    private boolean success;
    private String errors;
    private int id;

    public SignInResponse() {
    }

    public SignInResponse(boolean success, String errors) {
        this.success = success;
        this.errors = errors;
    }

    public SignInResponse(boolean success, int id) {
        this.success = success;
        this.id = id;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrors() {
        return errors;
    }

    public int getId() {
        return id;
    }
}
