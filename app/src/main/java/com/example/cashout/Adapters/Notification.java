package com.example.cashout.Adapters;

import java.util.Date;

public class Notification {
    private String id;
    private String type;
    private Date date;
    private double amount;
    public Notification(Date date, double amount, String id, String type) {
        this.date = date;
        this.amount = amount;
        this.id = id;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
