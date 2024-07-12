package com.example.cashout.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cashout.R;
import com.example.cashout.databinding.FragmentLoadingBinding;

public class LoadingFragment extends Fragment {
    private FragmentLoadingBinding binding;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoadingBinding.inflate(inflater, container, false);
        navController = Navigation.findNavController(container);

        // Disable the Continue button initially
        binding.BtnContinue2.setEnabled(false);


        // Enable the Continue button after 20 seconds
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.BtnContinue2.setEnabled(true);
                binding.BtnContinue2.setBackgroundColor(Color.BLACK);
            }
        }, 11000);

        binding.BtnContinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_loadingFragment_to_extractedDataFragment);
            }
        });

        return binding.getRoot();
    }
}
