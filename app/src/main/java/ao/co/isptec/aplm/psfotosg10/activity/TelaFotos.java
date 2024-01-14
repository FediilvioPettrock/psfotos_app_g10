package ao.co.isptec.aplm.psfotosg10.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;
import java.util.List;

import ao.co.isptec.aplm.psfotosg10.R;
import ao.co.isptec.aplm.psfotosg10.model.Fotos;
import ao.co.isptec.aplm.psfotosg10.network.service.ApiServiceGeneratorFotos;
import ao.co.isptec.aplm.psfotosg10.util.GridSpacingItemDecoration;
import ao.co.isptec.aplm.psfotosg10.util.PhotoAdapter;

public class TelaFotos extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    public final static String EXTRA_MESSAGE = "ao.co.isptec.aplm.outrorojecto.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_fotos);
        Intent intent = getIntent();
        String albumName= intent.getStringExtra(TelaFotos.EXTRA_MESSAGE);
        TextView albumcamp=(TextView) findViewById(R.id.textView4);
        albumcamp.setText(albumName);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        List<Fotos> photoList = new ArrayList<>();
        PhotoAdapter photoAdapter = new PhotoAdapter(photoList, this);
        ImageView plusbnt= (ImageView) findViewById(R.id.plus_bnt);


        // Configurar o RecyclerView com um GridLayoutManager
        int spanCount = 4; // 4 colunas na grade
        int spacing = 8; // Espaçamento em pixels
        boolean includeEdge = true; // Incluir espaçamento nas bordas

        recyclerView.setLayoutManager(new GridLayoutManager(this, spanCount));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        recyclerView.setAdapter(photoAdapter);

        ApiServiceGeneratorFotos showFotos= new ApiServiceGeneratorFotos(photoList, photoAdapter,recyclerView);

        plusbnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout fotoReview= (LinearLayout) findViewById(R.id.uploadFoto);
                ImageView imagePreview= (ImageView) findViewById(R.id.imagePreview);
                Button ok= (Button) findViewById(R.id.ok);
                Button cancel= (Button) findViewById(R.id.cancel);
                fotoReview.setVisibility(View.VISIBLE);
                openFileChooser();
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fotoReview.setVisibility(View.GONE);
                    }
                });

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        });
    }


    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*"); // Defina o tipo de arquivo que você deseja permitir (pode ser "image/*", "video/*", etc.)
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri fileUri = data.getData();
            // Aqui você pode lidar com o arquivo selecionado, como exibi-lo ou enviá-lo para um servidor
            displaySelectedFile(fileUri);
        }
    }

    private void displaySelectedFile(Uri fileUri) {
        ImageView imagePreview = findViewById(R.id.imagePreview);
        imagePreview.setImageURI(fileUri);
    }

}