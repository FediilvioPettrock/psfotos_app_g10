package ao.co.isptec.aplm.psfotosg10.network.service;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ao.co.isptec.aplm.psfotosg10.model.Album;
import ao.co.isptec.aplm.psfotosg10.network.ApiService;
import ao.co.isptec.aplm.psfotosg10.network.responsemodel.ApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ApiServiceGenerator extends AppCompatActivity {

    public ApiServiceGenerator(ArrayList<String> list,ArrayAdapter<String> adapter,ListView listView,int id){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService=retrofit.create(ApiService.class);

        Call<ApiResponse<List<Album>>> call = apiService.getAlbum(id);
        call.enqueue(new Callback<ApiResponse<List<Album>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Album>>> call, Response<ApiResponse<List<Album>>> response) {

                if (response.isSuccessful()) {
                    ApiResponse<List<Album>> apiResponse = response.body();
                    if (apiResponse != null && apiResponse.getData() != null) {
                        List<Album> albums = apiResponse.getData();

                        for (Album album : albums) {
                            list.add(album.getName());
                            adapter.notifyDataSetChanged();
                        }
                    } else {
                        Log.d("GroupData", "Data is null in API response");
                    }
                } else {
                    Log.d("GroupData", "API request failed");
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Album>>> call, Throwable t) {
                Log.e("AlbumData", "Erro na chamada: " + t.getMessage());
            }
        });




    }


    private void appendTextToTextView(String text, TextView Textview, ScrollView scrollView) {
        Textview.append(text + "\n");
        // Rolar para a parte inferior do ScrollView quando o texto for atualizado
        scrollView.post(new Runnable() {
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }
}
