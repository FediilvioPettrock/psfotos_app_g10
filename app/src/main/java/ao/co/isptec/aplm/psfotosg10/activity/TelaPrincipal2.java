package ao.co.isptec.aplm.psfotosg10.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import ao.co.isptec.aplm.psfotosg10.network.service.ApiServiceGenerator;
import ao.co.isptec.aplm.psfotosg10.R;
import ao.co.isptec.aplm.psfotosg10.network.service.UserService;

public class TelaPrincipal2 extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "ao.co.isptec.aplm.outrorojecto.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_tela_principal2);



        Intent intent = getIntent();
        String newuserID = intent.getStringExtra(TelaPrincipal2.EXTRA_MESSAGE);
        if (newuserID != null) {
            Log.d("AlgumaTag", newuserID);
        } else {
            Log.d("AlgumaTag", "A variável é null");
        }

       ArrayList<String> messagesList;
        messagesList = new ArrayList<>();
        ArrayAdapter<String> adapter;
        ListView listView = findViewById(R.id.lista);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, messagesList);
        listView.setAdapter(adapter);

        ImageView plusbnt= (ImageView) findViewById(R.id.plus);
        LinearLayout newalbum =(LinearLayout) findViewById(R.id.newalbum);
        Button criaralbum = (Button) findViewById(R.id.criaralbum);
        newalbum.setVisibility(View.GONE);
        ApiServiceGenerator api= new ApiServiceGenerator(messagesList,adapter,listView,Integer.parseInt(newuserID));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem= messagesList.get(position);
                Log.d("Telaprincipal", selectedItem);
                String message= selectedItem;
                Intent intent = new Intent(TelaPrincipal2.this, TelaFotos.class);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });

        plusbnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setVisibility(View.GONE);
                plusbnt.setVisibility(View.GONE);
                newalbum.setVisibility(View.VISIBLE);
            }
        });

        criaralbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText newalbumcamp = (EditText) findViewById(R.id.newalbumcamp);
                String newalbum = newalbumcamp.getText().toString();
               UserService teste = new UserService();
               teste.createAlbum(newalbum,Integer.parseInt(newuserID),newalbum);
            }
        });
    }
}