package com.example.sudin.testapp;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by SUNITA on 11/17/2016.
 */

public class SignUp extends Activity {
    EditText ContactName, ContactSecurity, ContactEmail;
    Context context=this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        ContactName= (EditText) findViewById(R.id.tvName);
        ContactSecurity= (EditText) findViewById(R.id.tvSecurity);
        ContactEmail= (EditText) findViewById(R.id.tvEmail);


        //creating database for the user credentials.
            userDbHelper = UserDbHelper.getInstance(this);
    }
public void onSignUpClick(View v){
    String email= ContactEmail.getText().toString();
    String name= ContactName.getText().toString();
    String security= ContactSecurity.getText().toString();

    sqLiteDatabase= userDbHelper.getWritableDatabase();
    userDbHelper.addInformations(name, security, email, sqLiteDatabase);
    Toast.makeText(getBaseContext(),"Data Inserted",Toast.LENGTH_LONG).show();
    userDbHelper.close();
    //if(v.getId()==R.id.bRegister){
       /* EditText name=(EditText) findViewById(R.id.signNameTedit);
        EditText email=(EditText) findViewById(R.id.editEmail);
        EditText security=(EditText) findViewById(R.id.signSkey);
        String namestr= name.getText().toString();
        String emailstr= email.getText().toString();
        String skeystr= security.getText().toString();*/

        //insert into database
        /**Contact c=new Contact();
        c.setName(namestr);
        c.setEmail(emailstr);
        c.setSecurity(skeystr);

        helper.insertContact(c);*/

    }


}


