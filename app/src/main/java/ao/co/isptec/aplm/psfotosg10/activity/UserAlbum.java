package ao.co.isptec.aplm.psfotosg10.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import ao.co.isptec.aplm.psfotosg10.R;
import ao.co.isptec.aplm.psfotosg10.activity.TelaPrincipal2;

public class UserAlbum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_album);
        Intent intent = getIntent();
        String message = intent.getStringExtra(TelaPrincipal2.EXTRA_MESSAGE);
        Log.d("useralbum",message);
    }
   /*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


  @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.log) {
            // Adicione a lógica para o item de logout aqui
            return true;
        } else if (itemId == R.id.setting) {
            // Adicione a lógica para o item de configuração aqui
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
    }
