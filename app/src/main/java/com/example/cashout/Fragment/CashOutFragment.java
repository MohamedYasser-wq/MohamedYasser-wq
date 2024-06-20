package com.example.cashout.Fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cashout.R;
import com.example.cashout.databinding.FragmentCashOutBinding;

public class CashOutFragment extends Fragment {

    private FragmentCashOutBinding binding;
    private NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCashOutBinding.inflate(inflater);
        navController = Navigation.findNavController(container);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showKeyboard(binding.cashoutEditText);
        binding.cashoutHomeBtn.setOnClickListener(view1 -> navController.navigate(R.id.action_cashOutFragment_to_homeFragment));

        binding.cashoutBackBtn.setOnClickListener(view12 -> navController.navigate(R.id.action_cashOutFragment_to_homeFragment));

        binding.cashoutGenerateOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // navigate to OTP generator page if edit text isn't empty with amount value
                // Uncomment the following code after finishing OTP fragment, replace with proper names

                String inputText = binding.cashoutEditText.getText().toString().trim();
                if (!inputText.isEmpty()) {
                    double amount = Double.parseDouble(inputText);
                    Bundle bundle = new Bundle();
                    bundle.putDouble("amount", amount);
                    navController.navigate(R.id.action_cashOutFragment_to_OTPFragment,bundle);
                } else {
                    Toast.makeText(requireContext(), "Please enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void showKeyboard(EditText e){
        e.requestFocus();
        InputMethodManager imm = (InputMethodManager) e.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(e,InputMethodManager.SHOW_IMPLICIT);
    }

}