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
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Gruplarim extends AppCompatActivity {


    private RecyclerView recyclerView;
    List<ModelClass> modelClassList;
    Adapter adapter;


    private RecyclerView recyclerview_secilen_gruplarim;
    List<ModelClass> modelClassListSecilen;
    Secilen_Adapter secilen_adapter;


    // example recyler
    public static List<ModelClass> Secilen;
    public static RecyclerView recyclerView1;
    public static SecilenExampleAdapter adapter1;




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
     /*   modelClassList.add(new ModelClass("isim1", "no 1"));
        modelClassList.add(new ModelClass("isim2", "no 2"));
        modelClassList.add(new ModelClass("isim3", "no 3"));
        modelClassList.add(new ModelClass("isim4", "no 4"));
*/

        loadContacts();
        showContact();

        adapter = new Adapter(this,(Button)findViewById(R.id.button),modelClassList);
        recyclerView.setAdapter(adapter);



        //ikinci recycler

        recyclerview_secilen_gruplarim = findViewById(R.id.recyclerview_secilen_gruplarim);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);

        modelClassListSecilen = new ArrayList<>();
        modelClassListSecilen.add(new ModelClass("isim1", "no 1"));
        modelClassListSecilen.add(new ModelClass("isim2", "no 2"));
        modelClassListSecilen.add(new ModelClass("isim3", "no 3"));
        modelClassListSecilen.add(new ModelClass("isim4", "no 4"));

        secilen_adapter = new Secilen_Adapter(modelClassListSecilen);
        recyclerview_secilen_gruplarim.setAdapter(secilen_adapter);




        //example recycler

        recyclerView1 = findViewById(R.id.recyclerview_secilen_gruplarim);

        //ikinci aşama
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(manager);

        //6. aşama asıl datamız
        Secilen = new ArrayList<>();
        Secilen.add(new ModelClass("isim1", "no 1"));
        Secilen.add(new ModelClass("isim2", "no 2"));
        Secilen.add(new ModelClass("isim3", "no 3"));
        Secilen.add(new ModelClass("isim4", "no 4"));


    /*    Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 1");
        Secilen.add("DAta 2");
*/
        //6. aşama asıl datamız son


        //7. aşama adaptere verileri vermek
        //adapter olşuturduk
        adapter1 = new SecilenExampleAdapter();
        adapter1.setList(Secilen); // data input func
        //adapter olşuturduk


        //8. aşama recyclerımıza adapteri vermek
        recyclerView1.setAdapter(adapter1);





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


    public void kendinGizle(View v) {
        v.setVisibility(View.GONE);

    }
}
