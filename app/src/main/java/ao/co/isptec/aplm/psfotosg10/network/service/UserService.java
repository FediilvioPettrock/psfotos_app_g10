package ao.co.isptec.aplm.psfotosg10.network.service;

import ao.co.isptec.aplm.psfotosg10.model.User;
import ao.co.isptec.aplm.psfotosg10.network.ApiService;
import ao.co.isptec.aplm.psfotosg10.network.requestmodel.AlbumRequestModel;
import ao.co.isptec.aplm.psfotosg10.network.requestmodel.LoginRequest;
import ao.co.isptec.aplm.psfotosg10.network.responsemodel.CreateAlbumResponse;
import ao.co.isptec.aplm.psfotosg10.network.responsemodel.CustomApiResponse;
import ao.co.isptec.aplm.psfotosg10.network.responsemodel.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.util.Log;

public class UserService {

    public void createUser(User user) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        // Criar um objeto UserData com os dados do usuário


        Call<Void> call = apiService.createUser(user);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // A solicitação foi bem-sucedida
                    Log.d("UserService", "Usuário criado com sucesso!");
                } else {
                    // A solicitação falhou
                    Log.e("UserService", "Erro ao criar usuário. Código: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Tratar falhas na chamada
                Log.e("UserService", "Erro na chamada POST", t);
            }
        });
    }

   /* public void getUser(int userId) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/api/")  // Atualize para a URL correta
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<CustomApiResponse<UserResponseModel[]>> call = apiService.getUser(userId);

        call.enqueue(new Callback<CustomApiResponse<UserResponseModel[]>>() {
            @Override
            public void onResponse(Call<CustomApiResponse<UserResponseModel[]>> call, Response<CustomApiResponse<UserResponseModel[]>> response) {
                if (response.isSuccessful()) {
                    CustomApiResponse<UserResponseModel[]> apiResponse = response.body();
                    if (apiResponse != null && apiResponse.getStatus() == 200) {
                        // A resposta foi bem-sucedida, e você pode acessar os dados
                        UserResponseModel[] users = apiResponse.getData();
                        // Faça algo com os dados dos usuários...
                        UserResponseModel user = apiResponse.getData()[0];

                        Log.d("UserService", "ID: " + user.getId());
                        Log.d("UserService", "First Name: " + user.getFirstName());
                        Log.d("UserService", "Last Name: " + user.getLastName());
                        Log.d("UserService", "Email: " + user.getEmail());
                        Log.d("UserService", "Created At: " + user.getCreatedAt());
                        Log.d("UserService", "Updated At: " + user.getUpdatedAt());
                    } else {
                        Log.d("UserService", "Usuário não encontrado");
                    }
                } else {
                    Log.e("UserService", "Erro na chamada GET: Código " + response.code());
                }
            }

            @Override
            public void onFailure(Call<CustomApiResponse<UserResponseModel[]>> call, Throwable t) {
                Log.e("UserService", "Erro na chamada GET", t);
            }
        });
    }*/


        //consumir para login
        public void loginUser(String email, String password, LoginResultListener listener) {
            int resul;
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8000/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiService apiService = retrofit.create(ApiService.class);
            LoginRequest request = new LoginRequest(email, password);


            Call<LoginResponse> call = apiService.login(request);
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.isSuccessful()) {
                        LoginResponse loginResponse = response.body();
                        int status = loginResponse.getStatus();
                        String token = loginResponse.getToken();
                        int userID = loginResponse.getUserID();
                        //notificar o sucesso
                        Log.d("Teste", Integer.toString(userID));
                        listener.onLoginSuccess(status, token, userID);
                    } else {
                        // Tratar erros de requisição não bem-sucedida
                        int errorCode = response.code();
                        Log.e("UserService", "Erro na tentativa chamada GET: Código " + response.code());
                        listener.onLoginFailure(-1);
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    // Tratar falha na requisição
                    Log.e("UserService", "Erro na chamada GET", t);

                    // Notifique sobre a falha
                    listener.onLoginFailure(-1); // Código de erro fictício
                }
            });
        }


    public void createAlbum(String nome, int id, String caminho) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        AlbumRequestModel albumData = new AlbumRequestModel(nome, id, caminho);

        Call<CreateAlbumResponse> call = apiService.createAlbum(albumData);

        call.enqueue(new Callback<CreateAlbumResponse>() {
            @Override
            public void onResponse(Call<CreateAlbumResponse> call, Response<CreateAlbumResponse> response) {
                if (response.isSuccessful()) {
                    CreateAlbumResponse apiResponse = response.body();
                    if (apiResponse != null && apiResponse.getStatus() == 200) {
                        // Álbum criado com sucesso
                        // Faça algo aqui, se necessário
                        Log.d("userservice","sucesso");
                    } else {
                        // Trate a resposta não bem-sucedida
                    }
                } else {
                    Log.e("UserService", "Erro na tentativa chamada GET: Código " + response.code());
                }
            }

            @Override
            public void onFailure(Call<CreateAlbumResponse> call, Throwable t) {
                Log.e("UserService", "Erro na chamada GET", t);
            }
        });
    }

    public void UpLoadFoto(String directoriodropbox, String directorioimagem, String id_fatia){

    }
}
