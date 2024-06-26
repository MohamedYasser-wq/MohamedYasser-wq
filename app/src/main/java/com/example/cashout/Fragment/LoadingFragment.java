package com.example.cashout.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cashout.databinding.FragmentLoadingBinding;


public class LoadingFragment extends Fragment {
    private FragmentLoadingBinding binding;
    private NavController navController;
    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentLoadingBinding.inflate(inflater);
        navController = Navigation.findNavController(container);

        return binding.getRoot();
    }
}