package com.example.cashout.Api;

import com.example.cashout.Data.RequestLogin;
import com.example.cashout.Data.RequestRegister;
import com.example.cashout.Data.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api_Interface {

    @POST("auth/login")
    public Call<ResponseLogin>Login(@Body RequestLogin request);

    @POST("auth/register")
    public Call<String>Register(@Body RequestRegister request);




}
