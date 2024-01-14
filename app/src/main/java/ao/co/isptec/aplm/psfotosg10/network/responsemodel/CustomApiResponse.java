package ao.co.isptec.aplm.psfotosg10.network.responsemodel;

import com.google.gson.annotations.SerializedName;

public class CustomApiResponse<T> {
    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private int status;

    @SerializedName("data")
    private T data;  // Alterado para tipo T

    public CustomApiResponse(String message, int status, T data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

}