package com.example.sudin.handyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class Main extends AppCompatActivity {
    Button button;
    //final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //addListnerOnButton();

    }

    public void onContactsClick(View view) {
        Intent intent = new Intent(Main.this, nextpage.class);
        startActivity(intent);
    }

 /*   public void addListnerOnButton(){
        final Context context = this;
        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, nextpage.class);
                    startActivity(intent);
            }
        });
    }*/

}
