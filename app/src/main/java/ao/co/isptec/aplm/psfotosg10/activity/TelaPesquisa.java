package ao.co.isptec.aplm.psfotosg10.activity;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ao.co.isptec.aplm.psfotosg10.R;

public class TelaPesquisa extends AppCompatActivity {
    ScrollView scrollView;
    TextView textViewOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pesquisa);



    }
}