package com.example.cashout.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cashout.Adapters.Transaction;
import com.example.cashout.Adapters.TransactionClick;
import com.example.cashout.Adapters.TransactionsAdapter;
import com.example.cashout.R;
import com.example.cashout.databinding.FragmentHomeBinding;

import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

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
        TransactionClick transactionClick = new TransactionClick(new Consumer<Transaction>() {
            @Override
            public void accept(Transaction transaction) {
                Toast.makeText(requireContext(), transaction.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        TransactionsAdapter adapter = new TransactionsAdapter(transactionClick);

        binding.transactionsRecyclerView.setAdapter(adapter);
        adapter.submitList(List.of(new Transaction(new Date(),2000, "id1", "Transfer"),
                new Transaction(new Date(),2500, "id2", "Transfer"),
                new Transaction(new Date(),120, "id3", "Transfer"),
                new Transaction(new Date(),20000, "id4", "Receive"),
                new Transaction(new Date(),2000, "id5", "Transfer"),
                new Transaction(new Date(),2500, "id6", "Transfer"),
                new Transaction(new Date(),120, "id7", "Transfer"),
                new Transaction(new Date(),20000, "id8", "Receive")
        ));
        return binding.getRoot();
    }
}