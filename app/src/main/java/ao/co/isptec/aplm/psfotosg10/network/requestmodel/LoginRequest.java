package ao.co.isptec.aplm.psfotosg10.network.requestmodel;
import com.google.gson.annotations.SerializedName;
//classe que contem os dados para fazer a requisicao de login
public class LoginRequest {
    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
