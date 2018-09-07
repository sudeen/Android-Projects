package com.example.sunita.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    final Context context = this;
    private Button button;
    private Button button2;
    private Button button3;
    String mycontact="";



   // ListView lv;
   // Cursor cursor1;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_enquiry);




        button = (Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);
        // add PhoneStateListener
        PhoneCallListener phoneListener = new PhoneCallListener();
        TelephonyManager telephonyManager = (TelephonyManager) this
                .getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.listen(phoneListener,PhoneStateListener.LISTEN_CALL_STATE);

        // add button listener
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {


                String encodedHash = Uri.encode("#");
                String ussd = "*400" + encodedHash;
                startActivityForResult(new Intent("android.intent.action.CALL",
                        Uri.parse("tel:" + ussd)), 1);
                //Intent callIntent = new Intent(Intent.ACTION_CALL);
               // callIntent.setData(Uri.parse("tel:*400#"));
                //startActivity(callIntent);

            }

        });

        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String encodedHash = Uri.encode("#");
                String ussd = "*901" + encodedHash;
                startActivityForResult(new Intent("android.intent.action.CALL",
                        Uri.parse("tel:" + ussd)), 1);

            }
        });


    }

    public void onButtonClick(View view) {
        //EditText a=(EditText) findViewById(R.id.TVimeiNumber);
        //String str=a.getText().toString();
        Intent intent=new Intent(MainActivity.this,SimInfo.class);
        //intent.putExtra("Imei",str);
        startActivity(intent);
    }

    public void onRechargeButtonClick(View view) {
        Intent i= new Intent(MainActivity.this, Recharge.class);
        startActivity(i);
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
