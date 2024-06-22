package com.example.cashout.Adapters;

import com.example.cashout.Data.Models.Transaction;

import java.util.function.Consumer;

public class TransactionClick {
    private Consumer<Transaction> transaction;

    public TransactionClick(Consumer<Transaction> transaction) {    this.transaction = transaction;     }

    public void onClick(Transaction transaction) {
        this.transaction.accept(transaction);
    }
}
