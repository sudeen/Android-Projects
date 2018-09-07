package com.example.sudin.testapp;

import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUNITA on 11/25/2016.
 */

public class ContactList extends ListActivity {

    private SimpleCursorAdapter listadaptor;
    @Override
    public long getSelectedItemId() {
        return super.getSelectedItemId();
    }

    @Override
    public int getSelectedItemPosition() {
        return super.getSelectedItemPosition();
    }

    ListView lv;
    Cursor cursor1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_list);
        //new
       String selection= String.format("%s > 0", ContactsContract.Contacts.HAS_PHONE_NUMBER);
       String[] selectionArgs = null;
        String sortOrder= String.format("UPPER(%s) ASC", ContactsContract.Contacts.DISPLAY_NAME);
        //new end

        cursor1 = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
               null, selection, selectionArgs, sortOrder);
        CustomAdapter adapter = new CustomAdapter(this, R.layout.customlist,getAllDetails(cursor1));
        lv = getListView();
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        //lv.setAdapter(new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_2, selection));
        lv.setAdapter(adapter);
        getContactDataFromList(lv);
    }

    public List<Person> getAllDetails(Cursor cur) {
        long startnow;
        long endnow;

        startnow = android.os.SystemClock.uptimeMillis();
        List<Person> personList = new ArrayList<>();
        if (cur.getCount() > 0) {

            int count = 0;
            while (cur.moveToNext()) {
                Person person = new Person();

                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                person.setName(name);

                if (cur.getInt(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",new String[]{id}, null);

                    while (pCur.moveToNext()) {

                        String phoneNo = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        person.setNumber(phoneNo);
                    }
                    pCur.close();
                }
                count++;
                personList.add(person);
            }
        }
        endnow = android.os.SystemClock.uptimeMillis();
        Log.d("END", "TimeForContacts " + (endnow - startnow) + " ms");
        return personList;
    }


    public void getContactDataFromList(final ListView listView){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ViewHolder holder  = (ViewHolder)view.getTag();
                String name= holder.name.getText().toString();
                String number = holder.number.getText().toString();

            }
        });
    }


     class ViewHolder{
        TextView name;
        TextView number;
    }


    public class CustomAdapter extends ArrayAdapter<Person>{


        private List<Person> data ;
        private Context context;
        private int resourceId;


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Log.d("data count", Integer.toString(data.size()));
            ViewHolder holder = new ViewHolder();
            Person currentPerson = data.get(position);
            Log.d("position",Integer.toString(position));

            //create a layout  for the list
                //Log.d("null", "null called");
                convertView = LayoutInflater.from(parent.getContext()).inflate(resourceId,parent,false);
                convertView.setTag(holder);
                holder.name = (TextView)convertView.findViewById(R.id.name);
                holder.number = (TextView)convertView.findViewById(R.id.number);
                holder.name.setText(currentPerson.getName());
                holder.number.setText(currentPerson.getNumber());

            return convertView;
        }

        public CustomAdapter(Context context, int ResourceId, @NonNull List<Person> data) {
            super(context, ResourceId, data);

            this.context = context;
            this.data = data;
            this.resourceId = ResourceId;

        }
        public void addAl(List<Person> moreData){
            this.data.addAll((this.data.size()-1),moreData);
            this.notifyDataSetChanged();
        }
    }


}