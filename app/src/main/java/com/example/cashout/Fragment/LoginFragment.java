package com.example.cashout.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cashout.Data.SharedPrefrence;
import com.example.cashout.R;
import com.example.cashout.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    private NavController navController;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentLoginBinding.inflate(inflater);
        navController= Navigation.findNavController(container);
        if(SharedPrefrence.isFirstTime()){
            navController.navigate(R.id.action_loginFragment_to_splashFragment);
        }
        //مؤقتاً
        binding.loginButton.setOnClickListener(v->navController.navigate(R.id.action_loginFragment_to_homeFragment));
        binding.registerLink.setOnClickListener(v -> navController.navigate(R.id.action_loginFragment_to_registerFragment));


        return binding.getRoot();
    }
}