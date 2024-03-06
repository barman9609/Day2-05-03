package com.eng.biet;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class HomePage extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        TextView txtName = findViewById(R.id.txtName);

        String password = getIntent().getStringExtra("name");

        txtName.setText(password);
    }

}
