package com.example.cashout.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cashout.Authentication.AuthenticationViewModel;
import com.example.cashout.Data.RequestLogin;
import com.example.cashout.Data.ResponseLogin;
import com.example.cashout.Data.SharedPrefrence;
import com.example.cashout.R;
import com.example.cashout.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    private NavController navController;

    private AuthenticationViewModel authenticationViewModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentLoginBinding.inflate(inflater);
        navController= Navigation.findNavController(container);
        authenticationViewModel=new ViewModelProvider(this).get(AuthenticationViewModel.class);

     binding.loginButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String nationalId=binding.NationalId.getText().toString();
             String pass=binding.password.getText().toString();
             Validate(nationalId,pass);

         }
     });



        binding.registerLink.setOnClickListener(v -> navController.navigate(R.id.action_loginFragment_to_registerFragment));


        return binding.getRoot();
    }

    public void Validate(String nationalId, String Password) {

        if (nationalId.equalsIgnoreCase(""))
        {
            Toast.makeText(getActivity(), "Please Enter National Id", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (nationalId.length() != 14)
            {
                Toast.makeText(getActivity(), "Please Enter 14 digits for National Id", Toast.LENGTH_SHORT).show();
            }
            else
            {
                if (Password.equalsIgnoreCase(""))
                {
                    Toast.makeText(getActivity(), "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RequestLogin request = new RequestLogin(nationalId, Password);
                    Login(request);
                }
            }
        }
    }


    private void Login(RequestLogin request)
    {
        authenticationViewModel.login(request);
        authenticationViewModel.mutableLiveData1.observe(this, new Observer<ResponseLogin>() {
            @Override
            public void onChanged(ResponseLogin responseLogin) {
                Log.e("TAG", "onChanged: Done ");

            }
        });
        authenticationViewModel.mutableLiveDataError1.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("TAG", "onChanged: Error ");
            }
        });



    }


}