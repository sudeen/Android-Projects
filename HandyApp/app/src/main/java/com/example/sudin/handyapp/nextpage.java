package com.example.sudin.handyapp;

import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


import static android.widget.AdapterView.*;


/**
 * Created by SUNITA on 11/16/2016.
 */

public class nextpage extends ListActivity {
    @Override
    public int getSelectedItemPosition() {
        return super.getSelectedItemPosition();
    }

    @Override
    public long getSelectedItemId() {

        return super.getSelectedItemId();
    }

    Button button;
    ListView lv;
    Cursor cursor1;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cursor1=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        startManagingCursor(cursor1);
        String [] from ={ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone._ID};
        int [] to = {android.R.id.text1, android.R.id.text2};
        SimpleCursorAdapter listadaptor = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor1,from, to);
        setListAdapter(listadaptor);
        lv= getListView();
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);


        }


    }




