package com.example.cashout.Fragment;

import static com.example.cashout.helpers.DateUtils.isToday;
import static java.util.stream.Collectors.toList;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cashout.Adapters.NotificationClick;
import com.example.cashout.Adapters.NotificationsAdapter;
import com.example.cashout.Data.Models.Notification;
import com.example.cashout.R;
import com.example.cashout.databinding.FragmentNotificationsBinding;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private NavController navController;
    private List<Notification> notifications = List.of(
            new Notification("126","Psychology book 15% more sales",new Date(),0.0,"announcement",""),
            new Notification("127","PROMO CODE - 15 EGP in Careem",new Date(),0.0,"promo","valid till Wed"),
            new Notification("123","Receive Transaction",new Date(),0.0,"transaction",""),
            new Notification("122","Receive Transaction",new Date(124,5,21,22,14),0.0,"promo",""),
            new Notification("121","Receive Transaction",new Date(124,5,21,16,52),0.0,"promo",""),
            new Notification("120","PROMO CODE - 20% OFF in Mongini's",new Date(124,5,10),0.0,"promo","this promo code is available for 2 days!"),
            new Notification("129","PROMO CODE - 40 EGP OFF in Al Abd",new Date(124,5,7),0.0,"promo","this promo code is available for 2 days!"),
            new Notification("128","Announcement",new Date(124,4,25),0.0,"promo","this promo code is available for 2 days!")
            );

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater);
        navController = Navigation.findNavController(container);
        binding.back.setOnClickListener(v -> navController.navigate(R.id.action_notificationsFragment_to_homeFragment));
        NotificationsAdapter newNotsAdapter = new NotificationsAdapter(new NotificationClick(notification -> {
            Toast.makeText(requireContext(), notification.getId(), Toast.LENGTH_SHORT).show();
        }));
        NotificationsAdapter oldNotsAdapter = new NotificationsAdapter(new NotificationClick(notification -> {
            Toast.makeText(requireContext(), notification.getId(), Toast.LENGTH_SHORT).show();
        }));
        binding.newNotificationsRecycler.setAdapter(newNotsAdapter);
        binding.oldNotificationsRecycler.setAdapter(oldNotsAdapter);

        newNotsAdapter.submitList(notifications.stream().filter(n -> isToday(n.getDate())).collect(toList()));
        oldNotsAdapter.submitList(notifications.stream().filter(n -> !isToday(n.getDate())).collect(toList()));

        return binding.getRoot();
    }

}