package ao.co.isptec.aplm.psfotosg10.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ao.co.isptec.aplm.psfotosg10.R;
import ao.co.isptec.aplm.psfotosg10.network.service.UserService;
import ao.co.isptec.aplm.psfotosg10.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   /* Button resgistar=(Button) findViewById(R.id.button);
        User novoUser;

      //  UserService user=new UserService();
       // user.getUser(500);
        resgistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nome= (EditText) findViewById(R.id.name);
                EditText apelido=(EditText) findViewById(R.id.nickname);
                EditText email=(EditText) findViewById(R.id.email);
                EditText palavraPasse=(EditText) findViewById(R.id.Password);

                User novoUser = new User(nome.getText().toString(),apelido.getText().toString(),
                        email.getText().toString(),palavraPasse.getText().toString());

                UserService user=new UserService();
                user.createUser(novoUser);

                Intent intent = new Intent(MainActivity.this, TelaPrincipal.class);
                startActivity(intent);
            }
        }); */

         Intent intent = new Intent(MainActivity.this, LoginActivity.class);
         startActivity(intent);
         finish();
    }
}