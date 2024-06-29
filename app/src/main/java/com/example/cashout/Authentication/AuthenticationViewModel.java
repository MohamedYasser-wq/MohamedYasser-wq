package com.example.cashout.Authentication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cashout.Data.RequestLogin;
import com.example.cashout.Data.RequestRegister;
import com.example.cashout.Data.ResponseLogin;

public class AuthenticationViewModel extends ViewModel {

    public MutableLiveData<ResponseLogin>mutableLiveDataLogin=new MutableLiveData<>();
    public MutableLiveData<String>mutableLiveDataLoginError=new MutableLiveData<>();
    public MutableLiveData<String>mutableLiveDataRegister=new MutableLiveData<>();
    public MutableLiveData<String>mutableLiveDataRegisterError=new MutableLiveData<>();
    private final AuthenticationHelper authenticationHelper;

    public AuthenticationViewModel(){

        authenticationHelper=new AuthenticationHelper();

    }


    public void login(RequestLogin requestLogin){

       authenticationHelper.login(requestLogin, new AuthenticationHelper.loginInterface() {
           @Override
           public void Success(ResponseLogin response) {
               mutableLiveDataLogin.setValue(response);

           }

           @Override
           public void Failure(String error) {
               mutableLiveDataLoginError.setValue(error);

           }
       });

    }

    public void Register(RequestRegister requestRegister){


        authenticationHelper.Register(requestRegister, new AuthenticationHelper.RegisterInterface() {
            @Override
            public void Success(String response) {
                mutableLiveDataRegister.setValue(response);
            }

            @Override
            public void Failure(String error)
            {
                mutableLiveDataRegisterError.setValue(error);

            }
        });

    }


}
