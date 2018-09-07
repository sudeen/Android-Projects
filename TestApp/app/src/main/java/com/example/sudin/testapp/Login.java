package com.example.sudin.testapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by SUNITA on 11/18/2016.
 */

public class Login extends MainActivity {
    //private Button Ntc;
//    private  Button Ncell;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //Extracting Respective Username From The Login Phase I
        String username= getIntent().getStringExtra("Username");
        TextView tv = (TextView) findViewById(R.id.tvNameOfUser);
        tv.setText(username);
    }

    //NTC Button
    public void onNtcButtonClick(View view) {
        String encodedHash = Uri.encode("#");
        String ussd = "*400" + encodedHash;
        startActivityForResult(new Intent("android.intent.action.CALL",
                Uri.parse("tel:" + ussd)), 1);

    }
@Override
public void onActivityResult(int requestCode, int resultCode, Intent intent){
    String balanceString;
    if(resultCode == 1)
       balanceString =  intent.getDataString().toString();
    }
    //NCELL Button
    public void onButtonNcellClick(View view) {
        String encodedHash = Uri.encode("#");
        String ussd = "*901" + encodedHash;
        startActivityForResult(new Intent("android.intent.action.CALL",
                Uri.parse("tel:" + ussd)), 1);
    }

    //Sim Information
    public void onSimInfoClick(View view) {
        Intent intent=new Intent(Login.this,SimInfo.class);
        startActivity(intent);
    }

    //Contact List
    public void onButtonContactListClick(View view) {
        Intent c= new Intent(Login.this, ContactList.class);
        startActivity(c);
    }

    //monitor phone call activities
    private class PhoneCallListener extends PhoneStateListener {

        private boolean isPhoneCalling = false;

        String LOG_TAG = "LOGGING 123";

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {

            if (TelephonyManager.CALL_STATE_RINGING == state) {
                // phone ringing
                Log.i(LOG_TAG, "RINGING, number: " + incomingNumber);
            }

            if (TelephonyManager.CALL_STATE_OFFHOOK == state) {
                // active
                Log.i(LOG_TAG, "OFFHOOK");

                isPhoneCalling = true;
            }

            if (TelephonyManager.CALL_STATE_IDLE == state) {
                // run when class initial and phone call ended,
                // need detect flag from CALL_STATE_OFFHOOK
                Log.i(LOG_TAG, "IDLE");

                if (isPhoneCalling) {

                    Log.i(LOG_TAG, "restart app");

                    // restart app
                    Intent i = getBaseContext().getPackageManager()
                            .getLaunchIntentForPackage(
                                    getBaseContext().getPackageName());
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);

                    isPhoneCalling = false;
                }

            }
        }
    }


}
