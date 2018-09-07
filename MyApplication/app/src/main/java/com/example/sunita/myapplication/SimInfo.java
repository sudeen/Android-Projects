package com.example.sunita.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.widget.TextView;

import java.sql.SQLOutput;

/**
 * Created by SUNITA on 11/22/2016.
 */

public class SimInfo extends Activity {
    //private String TVimeiNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siminfo);
        TextView imeinumber = (TextView) findViewById(R.id.tvImei);
        TextView pt= (TextView) findViewById(R.id.tvPhoneType);
        TextView sv=(TextView) findViewById(R.id.tvSoftVersion);
        TextView simserial=(TextView) findViewById(R.id.tvSimSerial);

      TelephonyManager tel = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        imeinumber.setText(tel.getDeviceId());
        pt.setText(tel.getSimOperatorName());
        sv.setText(tel.getSimCountryIso());
        simserial.setText(tel.getSimSerialNumber());

        /*int SIMState=tel.getSimState();
        switch(SIMState)
        {
            case TelephonyManager.SIM_STATE_ABSENT :

                System.out.println(SIMState);
                break;
            case TelephonyManager.SIM_STATE_NETWORK_LOCKED :
                System.out.println(SIMState);
                break;
            case TelephonyManager.SIM_STATE_PIN_REQUIRED :
                System.out.println(SIMState);
                break;
            case TelephonyManager.SIM_STATE_PUK_REQUIRED :

                break;
            case TelephonyManager.SIM_STATE_READY :
                //TextView simstate= (TextView) findViewById(R.id.tvSimState);
                //simstate.setText(tel.getSimState());
                System.out.println(SIMState);
                break;
            case TelephonyManager.SIM_STATE_UNKNOWN :
                // your code
                break;

        }*/



       /* int phoneType=tel.getPhoneType();

        switch (phoneType)
        {
            case (TelephonyManager.PHONE_TYPE_CDMA):

                break;
            case (TelephonyManager.PHONE_TYPE_GSM):
                // your code
                break;
            case (TelephonyManager.PHONE_TYPE_NONE):
                // your code
                break;
        }*/


//        String networkOperator = tel.getNetworkOperator();
//
//        if (!TextUtils.isEmpty(networkOperator)) {
//            int mcc = Integer.parseInt(networkOperator.substring(0, 3));
//            int mnc = Integer.parseInt(networkOperator.substring(3));
//        }

//        TelephonyManager telephonyManager = (TelephonyManager) this
//                .getSystemService(Context.TELEPHONY_SERVICE);
//        TVimeiNumber= getIntent().getStringExtra(telephonyManager.getDeviceId());
    }
}
