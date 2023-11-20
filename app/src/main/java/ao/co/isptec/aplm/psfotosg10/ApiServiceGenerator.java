package ao.co.isptec.aplm.psfotosg10;
import android.util.Log;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.widget.ScrollView;
import android.widget.TextView;
public class ApiServiceGenerator {

    public ApiServiceGenerator(TextView Textview, ScrollView scrollView){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService=retrofit.create(ApiService.class);

        Call<ApiResponse<List<Album>>> call = apiService.getAlbum();
        call.enqueue(new Callback<ApiResponse<List<Album>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Album>>> call, Response<ApiResponse<List<Album>>> response) {
                if (response.isSuccessful()) {
                    ApiResponse<List<Album>> apiResponse = response.body();
                    if (apiResponse != null && apiResponse.getData() != null) {
                        List<Album> albums = apiResponse.getData();

                        for (Album album : albums) {
                            appendTextToTextView("Name: " + album.getName(), Textview, scrollView);
                            appendTextToTextView("Owner: " + album.getOwner(), Textview, scrollView);
                            appendTextToTextView("Number Of Photos: " + album.getNumberOfPhotos(), Textview, scrollView);
                            appendTextToTextView("Number of Members: " + album.getNumberOfMembers(), Textview, scrollView);
                            appendTextToTextView("---------------------------------", Textview, scrollView);
                            Log.d("GroupData", "Name: " + album.getName());
                            Log.d("GroupData", "Owner: " + album.getOwner());
                            Log.d("GroupData", "Number of Photos: " + album.getNumberOfPhotos());
                            Log.d("GroupData", "Number of Members: " + album.getNumberOfMembers());
                            Log.d("GroupData", "---------------------------------");
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
