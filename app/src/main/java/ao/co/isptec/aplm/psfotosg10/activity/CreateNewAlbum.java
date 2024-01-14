package ao.co.isptec.aplm.psfotosg10.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ao.co.isptec.aplm.psfotosg10.R;
import ao.co.isptec.aplm.psfotosg10.network.service.UserService;

public class CreateNewAlbum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_album);

        UserService user = new UserService();
        user.createAlbum("teste4",5,"teste4");
    }
}