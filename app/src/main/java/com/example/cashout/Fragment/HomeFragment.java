package com.example.cashout.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cashout.R;
import com.example.cashout.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

   private FragmentHomeBinding binding;
   private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        navController = Navigation.findNavController(container);
        binding.cashoutBtn.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_cashOutFragment));
        binding.notificationsBtn.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_notificationsFragment));
        return binding.getRoot();
    }
}