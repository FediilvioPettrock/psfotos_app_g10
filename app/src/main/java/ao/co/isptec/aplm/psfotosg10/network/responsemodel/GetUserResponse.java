package ao.co.isptec.aplm.psfotosg10.network.responsemodel;

import com.google.gson.annotations.SerializedName;

public class GetUserResponse<T> {
    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private int status;

    @SerializedName("data")
    private T data;

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

