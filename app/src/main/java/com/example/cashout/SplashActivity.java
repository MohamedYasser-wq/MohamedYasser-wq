package com.example.cashout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cashout.Data.SharedPrefrence;
import com.example.cashout.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivitySplashBinding.inflate(getLayoutInflater());

        setContentView(bind.getRoot());
        SharedPrefrence.init(this);
        if(!SharedPrefrence.isFirstTime()){
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }else{
        Animation logoAnimation = AnimationUtils.loadAnimation(this, R.anim.logo_animation);
        bind.logo.startAnimation(logoAnimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.screen_animation_in, R.anim.screen_animation_out);
                finish();
            }
        }, 1400);
    }}

}