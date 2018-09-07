package com.example.sudin.testapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

/**
 * Created by SUNITA on 11/25/2016.
 */

public class SimInfo extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siminfo);
        TextView imeinumber = (TextView) findViewById(R.id.tvImei);
        TextView pt = (TextView) findViewById(R.id.tvPhoneType);
        TextView sv = (TextView) findViewById(R.id.tvSoftVersion);
        TextView simserial = (TextView) findViewById(R.id.tvSimSerial);

        TelephonyManager tel = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        imeinumber.setText(tel.getDeviceId());
        pt.setText(tel.getSimOperatorName());
        sv.setText(tel.getSimCountryIso());
        simserial.setText(tel.getSimSerialNumber());
    }
}