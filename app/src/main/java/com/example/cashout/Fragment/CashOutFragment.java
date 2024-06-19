package com.example.cashout.Fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cashout.databinding.FragmentCashOutBinding;
import com.example.cashout.databinding.FragmentSplashBinding;

public class CashOutFragment extends Fragment {

    private FragmentCashOutBinding binding;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCashOutBinding.inflate(inflater);
        navController = Navigation.findNavController(container);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.cashoutHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // navigate to home page
            }
        });

        binding.cashoutBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getOnBackPressedDispatcher().onBackPressed();

            }
        });

        binding.cashoutGenerateOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // navigate to OTP generator page if edit text isn't empty with amount value
                // Uncomment the following code after finishing OTP fragment, replace with proper names

                String inputText = binding.cashoutEditText.getText().toString().trim();
                if (!inputText.isEmpty()) {
//                    double amount = Double.parseDouble(inputText);
//                    OTPFragment otpFragment = OTPFragment.newInstance(amount);
//                    Bundle args = new Bundle();
//                    args.putDouble(ARG_DECIMAL_NUMBER, amount);
//                    navController.navigate(R.id.OTPFragment, args);
                } else {
                    Toast.makeText(requireContext(), "Please enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}