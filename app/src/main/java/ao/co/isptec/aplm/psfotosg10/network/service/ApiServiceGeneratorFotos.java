package ao.co.isptec.aplm.psfotosg10.network.service;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ao.co.isptec.aplm.psfotosg10.model.Fotos;
import ao.co.isptec.aplm.psfotosg10.network.ApiService;
import ao.co.isptec.aplm.psfotosg10.network.responsemodel.ApiResponse;
import ao.co.isptec.aplm.psfotosg10.util.PhotoAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceGeneratorFotos {
    public ApiServiceGeneratorFotos(List<Fotos> list, PhotoAdapter photoAdapter, RecyclerView recyclerView){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService=retrofit.create(ApiService.class);

        Call<ApiResponse<List<Fotos>>> call = apiService.getFotos();
        call.enqueue(new Callback<ApiResponse<List<Fotos>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Fotos>>> call, Response<ApiResponse<List<Fotos>>> response) {

                if (response.isSuccessful()) {
                    ApiResponse<List<Fotos>> apiResponse = response.body();
                    if (apiResponse != null && apiResponse.getData() != null) {
                        List<Fotos> fotos = apiResponse.getData();

                        for (Fotos foto : fotos) {
                            list.add(foto);
                            Log.d("GroupData", "Name: " + list.get(0).getUrl());
                          //  Log.d("GroupData", "Owner: " + foto.getId_fatia());
                        }
                        photoAdapter.notifyDataSetChanged();
                    } else {
                        Log.d("GroupData", "Data is null in API response");
                    }
                } else {
                    Log.d("GroupData", "API request failed");
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Fotos>>> call, Throwable t) {
                Log.e("FotosData", "Erro na chamada: " + t.getMessage());
            }
        });




    }
}
