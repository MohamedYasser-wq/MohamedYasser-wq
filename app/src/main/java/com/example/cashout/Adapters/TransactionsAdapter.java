package com.example.cashout.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cashout.R;
import com.example.cashout.databinding.TransactionBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TransactionsAdapter extends ListAdapter<Transaction, TransactionsAdapter.TransactionVH> {

    private final TransactionClick transactionClick;

    public TransactionsAdapter(TransactionClick transactionClick) {
        super(DIFF_CALLBACK);
        this.transactionClick = transactionClick;
    }

    public static class TransactionVH extends RecyclerView.ViewHolder {
        private final TransactionBinding bind;

        public TransactionVH(TransactionBinding bind) {
            super(bind.getRoot());
            this.bind = bind;
        }

        public void bind(Transaction transaction, TransactionClick transactionClick) {
            if(transaction.getType().equals("Cash Out")){
                bind.transactionIcon.setImageResource(R.drawable.cashout_transaction_icon);
            }else{
                bind.transactionIcon.setImageResource(R.drawable.transfer_transaction_icon);
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
            String dateFormatted = formatter.format(transaction.getDate());
            bind.date.setText(dateFormatted);
            bind.transactionType.setText(transaction.getType() +" - " + transaction.getId());
            bind.amount.setText(transaction.getAmount() + " EGP");
            bind.getRoot().setOnClickListener(v -> transactionClick.onClick(transaction));
        }

        public static TransactionVH from(ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            TransactionBinding binding = TransactionBinding.inflate(layoutInflater, parent, false);
            return new TransactionVH(binding);
        }
    }

    private static final DiffUtil.ItemCallback<Transaction> DIFF_CALLBACK = new DiffUtil.ItemCallback<Transaction>() {
        @Override
        public boolean areItemsTheSame(@NonNull Transaction oldItem, @NonNull Transaction newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Transaction oldItem, @NonNull Transaction newItem) {
            return (oldItem.getType().equals(newItem.getType()) && oldItem.getId().equals(newItem.getId()) && oldItem.getAmount() == newItem.getAmount());
        }
    };

    @NonNull
    @Override
    public TransactionVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TransactionVH.from(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionVH holder, int position) {
        holder.bind(getItem(position), transactionClick);
    }
}

