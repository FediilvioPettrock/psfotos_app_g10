package ao.co.isptec.aplm.psfotosg10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;
public class TelaPrincipal2 extends AppCompatActivity {
    ScrollView scrollView;
    TextView textViewOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_tela_principal2);

        scrollView = findViewById(R.id.scrollView);
        textViewOutput = findViewById(R.id.textViewOutput);


        ApiServiceGenerator api= new ApiServiceGenerator(textViewOutput, scrollView);

    }
}