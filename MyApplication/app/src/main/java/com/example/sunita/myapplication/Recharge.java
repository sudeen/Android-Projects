package com.example.sunita.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by SUNITA on 11/28/2016.
 */

public class Recharge extends Activity {
    EditText amount;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recharge);
        amount= (EditText) findViewById(R.id.editTextAmount);
        //TextView textView= (TextView) findViewById(R.id.editTextAmount);

    }

    public void onRechargeButtonClick(View view) {
        String pin= amount.getText().toString();
        String encodedHash= Uri.encode("#");
        String ussd= "*902*"+pin +  encodedHash;
        startActivityForResult(new Intent("android.intent.action.CALL", Uri.parse("tel:"+ ussd)),1);
    }
}
