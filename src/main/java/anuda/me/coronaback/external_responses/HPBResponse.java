package anuda.me.coronaback.external_responses;

public class HPBResponse {

    private String success;
    private String message;
    private HPBData data;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HPBData getData() {
        return data;
    }

    public void setData(HPBData data) {
        this.data = data;
    }
}
