package com.example.cashout.Authentication;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cashout.Api.RetroConnection;
import com.example.cashout.Data.RequestLogin;
import com.example.cashout.Data.RequestRegister;
import com.example.cashout.Data.ResponseLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthenticationViewModel extends ViewModel {

    public MutableLiveData<ResponseLogin>mutableLiveDataLoginSuccess=new MutableLiveData<>();
    public MutableLiveData<String>mutableLiveDataLoginError=new MutableLiveData<>();
    public MutableLiveData<String>mutableLiveDataRegisterSuccess=new MutableLiveData<>();
    public MutableLiveData<String>mutableLiveDataRegisterError=new MutableLiveData<>();


    public void login(RequestLogin requestLogin) {

        RetroConnection.getInst().Login(requestLogin).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {


                if (response.isSuccessful()) {
              mutableLiveDataLoginSuccess.setValue(response.body());

                }

            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {

     mutableLiveDataLoginError.setValue(t.getMessage());
            }
        });


    }


    public void Register(RequestRegister requestRegister){


        RetroConnection.getInst().Register(requestRegister).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response)
            {
                if(response.isSuccessful())
                {

                    mutableLiveDataRegisterSuccess.setValue(response.body());
                    Log.e("TAG", "onResponse: ++++++++++++++++++++" );

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

               mutableLiveDataRegisterError.setValue(t.getMessage());
                Log.e("TAG", "onFailure: -----------------");
            }
        });


    }


}
