package ao.co.isptec.aplm.psfotosg10.network.responsemodel;
import com.google.gson.annotations.SerializedName;
//classe preparada para receber a resposta ao pedido de login
public class LoginResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private int status;

    @SerializedName("userID")
    private int userID;

    @SerializedName("token")
    private String token;

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }

    public int getUserID() {
        return userID;
    }
}
