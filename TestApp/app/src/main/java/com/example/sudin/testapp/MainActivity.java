package com.example.sudin.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    UserDbHelper helper = new UserDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSignup:
                Intent i = new Intent(MainActivity.this, SignUp.class);
                startActivity(i);
                break;
            case R.id.bLogin:
                EditText a = (EditText) findViewById(R.id.tvName);
                //view.findViewById(R.id.tvName);
                String str = a.getText().toString();
               /* EditText b=(EditText)findViewById(R.id.tvSecurity);
                String str1= b.getText().toString();
                String password= helper.searchPass();
                if(str1.equals(password)){*/
                Intent intent = new Intent(MainActivity.this, Login.class);
                intent.putExtra("Username", str);
                startActivity(intent);
                break;
        }
               /* }
                else{
                    Toast.makeText(MainActivity.this, "UserName and Security Key didn't match", Toast.LENGTH_SHORT).show();
                }*/
                //Log.d("name", str);

                    //Toast temp = Toast.makeText(MainActivity.this, "UserName and Security Key didn't match",Toast.LENGTH_SHORT);
                    //temp.show();

               /** } else {
                    Toast.makeText(MainActivity.this, "UserName and Security Key didn't match", Toast.LENGTH_SHORT).show();*/

        }
    }

