package com.example.cashout.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cashout.Data.Models.Transaction;
import com.example.cashout.Adapters.TransactionClick;
import com.example.cashout.Adapters.TransactionsAdapter;
import com.example.cashout.R;
import com.example.cashout.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class HomeFragment extends Fragment {

   private FragmentHomeBinding binding;
   private NavController navController;
   private ArrayList<Transaction> transactions = new ArrayList<>();
   private List<Transaction> mockTransactions = List.of(new Transaction(new Date(),2000, "12445", "Transfer"),
           new Transaction(new Date(),2500, "12495", "Transfer"),
           new Transaction(new Date(),120, "13305", "Transfer"),
           new Transaction(new Date(),20000, "10524", "Cash Out"),
           new Transaction(new Date(),2000, "12415", "Transfer"),
           new Transaction(new Date(),2500, "12435", "Transfer"),
           new Transaction(new Date(),120, "12405", "Cash Out"),
           new Transaction(new Date(),20000, "12425", "Cash Out")
   );
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        navController = Navigation.findNavController(container);
        binding.cashoutBtn.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_cashOutFragment));
        binding.notificationsBtn.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_notificationsFragment));
        TransactionClick transactionClick = new TransactionClick(transaction -> {Toast.makeText(requireContext(), transaction.getId(), Toast.LENGTH_SHORT).show();});
        TransactionsAdapter adapter = new TransactionsAdapter(transactionClick);

        binding.transactionsRecyclerView.setAdapter(adapter);
        adapter.submitList(mockTransactions);
        binding.allTransactions.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                adapter.submitList(null);
                adapter.submitList(mockTransactions);
                binding.transactionsRecyclerView.scrollToPosition(0);
            }
        });
        binding.transferTransactions.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                adapter.submitList(mockTransactions.stream().filter(t -> t.getType().equals("Transfer")).collect(Collectors.toList()));
                binding.transactionsRecyclerView.scrollToPosition(0);
            }
        });
        binding.cashoutTransactions.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                adapter.submitList(mockTransactions.stream().filter(t -> t.getType().equals("Cash Out")).collect(Collectors.toList()));
                binding.transactionsRecyclerView.scrollToPosition(0);
            }
        });
        return binding.getRoot();
    }
}