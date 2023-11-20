package ao.co.isptec.aplm.psfotosg10;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("album")
    Call<ApiResponse<List<Album>>> getAlbum();
}

