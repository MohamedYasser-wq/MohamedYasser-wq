package com.example.cashout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cashout.Data.SharedPrefrence;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPrefrence.init(this);



    }
}