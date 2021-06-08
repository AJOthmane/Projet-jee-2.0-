package ma.ensias.projetjee2_0.Responses;

import java.util.Map;

public class CreationResponse {

    private boolean success;
    private Map<String,String> errors;

    public CreationResponse() { }

    public CreationResponse(boolean success,Map<String,String> errors)
    {
        this.success = success;
        this.errors = errors;
    }

    public CreationResponse(boolean success) {
        this.success = success;
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
}
