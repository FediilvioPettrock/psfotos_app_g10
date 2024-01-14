package ao.co.isptec.aplm.psfotosg10.network;
import java.util.List;

import ao.co.isptec.aplm.psfotosg10.network.requestmodel.AlbumRequestModel;
import ao.co.isptec.aplm.psfotosg10.network.requestmodel.UpLoadFotoRequestModel;
import ao.co.isptec.aplm.psfotosg10.network.responsemodel.ApiResponse;
import ao.co.isptec.aplm.psfotosg10.network.responsemodel.CreateAlbumResponse;
import ao.co.isptec.aplm.psfotosg10.network.requestmodel.LoginRequest;
import ao.co.isptec.aplm.psfotosg10.network.responsemodel.LoginResponse;
import ao.co.isptec.aplm.psfotosg10.model.Album;
import ao.co.isptec.aplm.psfotosg10.model.Fotos;
import ao.co.isptec.aplm.psfotosg10.model.User;
import retrofit2.http.Body;
import retrofit2.http.POST;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("album/{id}")
    Call<ApiResponse<List<Album>>> getAlbum(@Path("id") int id);

    @POST("user")
    Call<Void> createUser(@Body User userData);

    //@GET("user/{id}")
    //Call<CustomApiResponse<UserResponseModel[]>> getUser(@Path("id") int userId);

    @GET("foto")
    Call<ApiResponse<List<Fotos>>> getFotos();


        @POST("login")
        Call<LoginResponse> login(@Body LoginRequest request);
        //
    @POST("album")
    Call<CreateAlbumResponse> createAlbum(@Body AlbumRequestModel albumData);

    @POST("foto")
    Call<UpLoadFotoResponseModel> UpLoadFoto(@Body UpLoadFotoRequestModel request);

}

