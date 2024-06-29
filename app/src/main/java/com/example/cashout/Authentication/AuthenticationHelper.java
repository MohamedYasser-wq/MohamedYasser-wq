package com.example.cashout.Authentication;

import com.example.cashout.Api.RetroConnection;
import com.example.cashout.Data.RequestLogin;
import com.example.cashout.Data.RequestRegister;
import com.example.cashout.Data.ResponseLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthenticationHelper {

    public interface loginInterface{

        void Success(ResponseLogin response);
        void Failure(String error);

    }

    public interface RegisterInterface{

        void Success(String response);
        void Failure(String error);

    }




    public void login(RequestLogin requestLogin,loginInterface loginInterface){

        RetroConnection.getInst().Login(requestLogin).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {


           if (response.isSuccessful()){

               loginInterface.Success(response.body());

           }

            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {

                loginInterface.Failure(t.getMessage());
            }
        });





    }
    public void Register(RequestRegister requestRegister, RegisterInterface registerInterface){


        RetroConnection.getInst().Register(requestRegister).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful())
                {
                    registerInterface.Success(response.body());

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                registerInterface.Failure(t.getMessage());
            }
        });


    }


}
