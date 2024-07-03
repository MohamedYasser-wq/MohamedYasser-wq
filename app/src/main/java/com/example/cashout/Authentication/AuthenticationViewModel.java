package com.example.cashout.Authentication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cashout.Data.RequestLogin;
import com.example.cashout.Data.RequestRegister;
import com.example.cashout.Data.ResponseLogin;

public class AuthenticationViewModel extends ViewModel {

    public MutableLiveData<ResponseLogin>mutableLiveData1=new MutableLiveData<>();
    public MutableLiveData<String>mutableLiveDataError1=new MutableLiveData<>();
    public MutableLiveData<String>mutableLiveData2=new MutableLiveData<>();
    public MutableLiveData<String>mutableLiveDataError2=new MutableLiveData<>();
    private AuthenticationHelper authenticationHelper;

    public AuthenticationViewModel(){

        authenticationHelper=new AuthenticationHelper();

    }


    public void login(RequestLogin requestLogin){

        authenticationHelper.login(requestLogin, new AuthenticationHelper.loginInterface() {
            @Override
            public void Success(ResponseLogin response) {
                mutableLiveData1.setValue(response);

            }

            @Override
            public void Failure(String error) {
                mutableLiveDataError1.setValue(error);

            }
        });

    }

    public void Register(RequestRegister requestRegister){


        authenticationHelper.Register(requestRegister, new AuthenticationHelper.RegisterInterface() {
            @Override
            public void Success(String response) {
                mutableLiveData2.setValue(response);
            }

            @Override
            public void Failure(String error) {
                mutableLiveDataError2.setValue(error);

            }
        });

    }


}
