package com.eng.biet;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.annotation.Nullable;

public class Splash extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                getData();
            }
        }, 2000);

    }

    void getData(){
        SharedPreferences prefs = getSharedPreferences("BIET", MODE_PRIVATE);
        String name = prefs.getString("name", "");
        String password = prefs.getString("password", "");

        if(!name.isEmpty()){
            Intent intent = new Intent(Splash.this, HomePage.class);
            intent.putExtra("name", password);
            startActivity(intent);
        }else{
            startActivity(new Intent(Splash.this, SignUp.class));
        }

        finish();

    }

}
