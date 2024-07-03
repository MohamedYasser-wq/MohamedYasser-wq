package com.example.cashout.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cashout.Authentication.AuthenticationViewModel;
import com.example.cashout.Data.RequestRegister;
import com.example.cashout.Data.SharedPrefrence;
import com.example.cashout.R;
import com.example.cashout.databinding.FragmentCompleteRegisterBinding;

public class CompleteRegisterFragment extends Fragment {
    private FragmentCompleteRegisterBinding binding;
    private NavController navController;
    public AuthenticationViewModel authenticationViewModel;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentCompleteRegisterBinding.inflate(inflater);
        navController= Navigation.findNavController(container);
        authenticationViewModel= new ViewModelProvider(this).get(AuthenticationViewModel.class);



        binding.BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=binding.phoneNumber.getText().toString();
                String pass=binding.password.getText().toString();
                String confirmPass=binding.ConfirmPassword.getText().toString();
                validation(phone,pass,confirmPass);

            }
        });


        return binding.getRoot();
    }

    public void validation(String phone,String pass,String confirmPass){
        if(pass.equalsIgnoreCase("")||confirmPass.equalsIgnoreCase("")||phone.equalsIgnoreCase("")){
            Toast.makeText(getContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();

        }
        else {
            if (!pass.equalsIgnoreCase(confirmPass)) {
                Toast.makeText(getContext(), "Password and confirm Password didnt match", Toast.LENGTH_SHORT).show();
            }
            if (!(phone.length()==11)){
                Toast.makeText(getContext(), "phone should be 11 number", Toast.LENGTH_SHORT).show();

            }
            RequestRegister requestRegister=new RequestRegister();
            requestRegister.setGender(SharedPrefrence.getGender());
            requestRegister.setMobileNumber(phone);
            requestRegister.setUsername(SharedPrefrence.getFirstName()+SharedPrefrence.getSecondName());
            requestRegister.setPassword(pass);
            requestRegister.setNationalId(SharedPrefrence.getNational_Id());
            requestRegister.setImageUrl(SharedPrefrence.getImageUri());


            Register(requestRegister);
        }


    }

    private void Register(RequestRegister requestRegister) {

        authenticationViewModel.Register(requestRegister);
        authenticationViewModel.mutableLiveData2.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

                navController.navigate(R.id.action_completeRegisterFragment_to_homeFragment);

            }
        });

        authenticationViewModel.mutableLiveDataError2.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }

        });
    }


}