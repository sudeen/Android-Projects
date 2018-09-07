package com.example.sudin.goandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onRegisterButtonClick(View view) {
        Intent reg=new Intent(MainActivity.this,Register.class);
        startActivity(reg);
    }

    public void onLoginButtonClick(View view) {
        Intent log=new Intent(MainActivity.this,Login.class);
        startActivity(log);
    }

    public void onForgetPasswordButtonClick(View view) {
        Intent FP= new Intent(MainActivity.this, PasswordReset.class);
        startActivity(FP);
    }
}


