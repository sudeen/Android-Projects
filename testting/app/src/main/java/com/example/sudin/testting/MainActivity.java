package com.example.sudin.testting;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by SUNITA on 11/25/2016.
 */

public class MainActivity extends AppCompatActivity {





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);



        }

    public void onContactsClicks(View view) {
        Intent i = new Intent(MainActivity.this,ContactsList.class);
        startActivity(i);
    }
}