package ao.co.isptec.aplm.psfotosg10.activity;

import static ao.co.isptec.aplm.psfotosg10.activity.TelaPrincipal2.EXTRA_MESSAGE;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ao.co.isptec.aplm.psfotosg10.network.service.LoginResultListener;
import ao.co.isptec.aplm.psfotosg10.R;
import ao.co.isptec.aplm.psfotosg10.network.service.UserService;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = findViewById(R.id.button);
        TextView registroRedirection = (TextView) findViewById(R.id.textView8);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ação a ser executada quando o botão for clicado
                UserService userService= new UserService();
                EditText emailcamp=(EditText) findViewById(R.id.email);
                EditText passwordcamp= (EditText) findViewById(R.id.password);

                String email= emailcamp.getText().toString();
                String password=passwordcamp.getText().toString();

                userService.loginUser(email, password, new LoginResultListener() {
                    @Override
                    public void onLoginSuccess(int status, String token, int userID) {
                        // Lógica para lidar com o login bem-sucedido
                        String newuserID=Integer.toString(userID);
                        Log.d("LoginActivity", "Login bem-sucedido" +" Identidade " +newuserID);
                       Intent intent = new Intent(LoginActivity.this, TelaPrincipal2.class);
                        intent.putExtra(EXTRA_MESSAGE, newuserID);
                       startActivity(intent);
                       finish();
                    }

                    @Override
                    public void onLoginFailure(int errorCode) {
                        // Lógica para lidar com falha no login
                        Log.e("LoginActivity", "Falha no login. Código de erro: " + errorCode);
                        exibirMensagemAmigavel("Login falhou. Verifique seu email e senha.");
                    }
                });
            }
        });
    }

    private void exibirMensagemAmigavel(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}