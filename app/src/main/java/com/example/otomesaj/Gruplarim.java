package com.example.otomesaj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Gruplarim extends AppCompatActivity {


    private RecyclerView recyclerView;
    List<ModelClass> modelClassList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gruplarim);


        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);


        modelClassList = new ArrayList<>();
      /*  modelClassList.add(new ModelClass("isim1", "no 1"));
        modelClassList.add(new ModelClass("isim2", "no 2"));
        modelClassList.add(new ModelClass("isim3", "no 3"));
        modelClassList.add(new ModelClass("isim4", "no 4"));*/


        loadContacts();
        showContact();

        adapter = new Adapter(modelClassList);
        recyclerView.setAdapter(adapter);


    }


    private void loadContacts() {
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null);
        //           null, null, null, ContactsContract.CommonDataKinds.Phone.NUMBER);

        while (cursor.moveToNext()) {

            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            modelClassList.add(new ModelClass(name, number));


        }


    }


    public void showContact() {

        loadContacts();
        //String bisi = oneContact.get(0).toString();
        String bisi = String.valueOf(modelClassList.size());


        if (modelClassList.size() == 0) {

            Toast.makeText(this, "you have zero contact.", Toast.LENGTH_SHORT).show();
        } else {
            //Toast.makeText(this, modelClassList.get(0), Toast.LENGTH_SHORT).show();

            Toast.makeText(this, bisi, Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, "asdf", Toast.LENGTH_SHORT).show();


        }


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        switch (requestCode) {
            case 0:
                if (grantResults.length >= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    loadContacts();
                } else {

                    Toast.makeText(this, "need contact permission", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
