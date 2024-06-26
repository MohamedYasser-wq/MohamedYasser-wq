package com.example.cashout.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cashout.R;
import com.example.cashout.databinding.FragmentNotificationDetailsBinding;

public class NotificationDetailsFragment extends Fragment {
    FragmentNotificationDetailsBinding binding;
    NavController navController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificationDetailsBinding.inflate(inflater);
        navController = Navigation.findNavController(container);
        binding.back.setOnClickListener(v -> navController.navigate(R.id.action_notificationDetailsFragment_to_notificationsFragment));
        return binding.getRoot();
    }
}