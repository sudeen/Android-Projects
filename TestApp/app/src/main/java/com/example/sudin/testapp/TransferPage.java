package com.example.sudin.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by SUNITA on 11/28/2016.
 */

public class TransferPage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transfer_amount);
        Log.e("Hello","Hi");
        String phoneNumber= getIntent().getStringExtra("Number");
        TextView tv= (TextView) findViewById(R.id.tvPhoneNumber);
        tv.setText(phoneNumber);
    }
}
