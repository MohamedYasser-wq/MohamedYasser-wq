package com.example.cashout.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cashout.R;
import com.example.cashout.databinding.FragmentConfirmationBinding;


public class ConfirmationFragment extends Fragment {
    private FragmentConfirmationBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentConfirmationBinding.inflate(inflater);
        navController = Navigation.findNavController(container);
        double amount = getArguments().getDouble("amount",0.0);
        binding.amount.setText(String.valueOf(amount));
        binding.back.setOnClickListener(v -> navController.navigate(R.id.action_confirmationFragment_to_homeFragment));
        return binding.getRoot();
    }
}