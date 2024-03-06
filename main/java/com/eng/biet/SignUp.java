package com.eng.biet;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SignUp extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity);

        EditText etUserName = findViewById(R.id.etUserName);
        EditText etPassword = findViewById(R.id.etPassword);


        getData();

        findViewById(R.id.btnSubmit).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                    finish();
                return false;
            }
        });

        findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUserName.getText().toString().equals("Adrita")  && etPassword.getText().toString().equals("BIET")){
                    Toast.makeText(SignUp.this, "Welcome "+etUserName.getText().toString(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(SignUp.this, HomePage.class);
                    intent.putExtra("name", etPassword.getText().toString());

                    setData(etUserName.getText().toString(), etPassword.getText().toString());

                    startActivity(intent);
                }else {
                    Toast.makeText(SignUp.this, "Wrong credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Toast.makeText(SignUp.this, "On Create", Toast.LENGTH_SHORT).show();
    }

    void setData(String name, String pass){
        SharedPreferences.Editor editor = getSharedPreferences("BIET", MODE_PRIVATE).edit();
        editor.putString("name", name);
        editor.putString("password", pass);
        editor.apply();
    }

    void getData(){
        SharedPreferences prefs = getSharedPreferences("BIET", MODE_PRIVATE);
        String name = prefs.getString("name", "");
        String password = prefs.getString("password", "");


        if(!name.isEmpty()){

            Intent intent = new Intent(SignUp.this, HomePage.class);
            intent.putExtra("name", password);

            startActivity(intent);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(SignUp.this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(SignUp.this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(SignUp.this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(SignUp.this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(SignUp.this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
}
