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
import com.example.cashout.databinding.FragmentExtractedDataBinding;

import java.util.Date;

public class ExtractedDataFragment extends Fragment {
    private FragmentExtractedDataBinding binding;
    private NavController navController;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentExtractedDataBinding.inflate(inflater);
        navController = Navigation.findNavController(container);
        fillFields();

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_extractedDataFragment_to_completeRegisterFragment);
            }
        });

        binding.retryPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_extractedDataFragment_to_photoFragment);
            }
        });


        return binding.getRoot();
    }

    private void fillFields() {
        binding.firstName.setText(SharedPrefrence.getFirstName());
        binding.lastName.setText(SharedPrefrence.getSecondName());
        binding.address.setText(SharedPrefrence.getAddress());
        binding.NID.setText(SharedPrefrence.getNational_Id());
        binding.birthDate.setText(SharedPrefrence.getBirthDay());
        binding.gender.setText(SharedPrefrence.getGender());

    }


}
