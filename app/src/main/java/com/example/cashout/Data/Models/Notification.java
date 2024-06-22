package com.example.cashout.Data.Models;

import java.util.Date;

public class Notification {
    private String id;
    private String type;
    private Date date;
    private double amount;
    private String note;
    private String title;

    public Notification(String id,String title ,Date date, double amount, String type, String note) {
        this.date = date;
        this.amount = amount;
        this.id = id;
        this.type = type;
        this.note = note;
        this.title = title;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



}
