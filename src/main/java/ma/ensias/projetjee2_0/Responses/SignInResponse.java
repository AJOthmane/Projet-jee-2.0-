package ma.ensias.projetjee2_0.Responses;

import java.util.HashMap;
import java.util.Map;

public class SignInResponse {
    private boolean success;
    private Map<String,String> errors;
    private int id;

    public SignInResponse() {
    }

    public SignInResponse(boolean success, String errors) {
        this.success = success;
        this.errors = new HashMap<String,String>();
        this.errors.put("fields",errors);
    }

    public SignInResponse(boolean success, int id) {
        this.success = success;
        this.id = id;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public void setId(int id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public int getId() {
        return id;
    }
}
