package com.example.cashout.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cashout.R;
import com.example.cashout.databinding.FragmentOTPBinding;

public class OTPFragment extends Fragment {
    private FragmentOTPBinding binding;
    private NavController navController;
    private int amount;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOTPBinding.inflate(inflater);
        navController = Navigation.findNavController(container);
        Bundle bundle = new Bundle();
        bundle.putDouble("amount",getArguments().getDouble("amount",0.0));
        binding.confirmBtn.setOnClickListener(v -> navController.navigate(R.id.action_OTPFragment_to_confirmationFragment,bundle));
        binding.back.setOnClickListener(v -> navController.navigate(R.id.action_OTPFragment_to_cashOutFragment));
        return binding.getRoot();
    }
}