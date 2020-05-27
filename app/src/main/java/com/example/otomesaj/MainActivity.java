package com.example.otomesaj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void mesajOlustur(View v) {
       Intent intent = new Intent(MainActivity.this, MesajGrupSec.class);
        startActivity(intent);
        Toast.makeText(this, "tıklandım", Toast.LENGTH_SHORT).show();
    }



    public void gruplarim(View v) {
        //buraya istediğin kodları gir

       int izinBool= getPerm();
        //permissin alındıysa openGruplarım()
        if (izinBool == 1) {
            openGruplarım();
        } else {
            Toast.makeText(this, "contact read izni verin.", Toast.LENGTH_SHORT).show();

        }



    }


    public void openGruplarım() {
        Intent intent = new Intent(MainActivity.this, Gruplarim.class);
        startActivity(intent);
        Toast.makeText(this, "tıklandım", Toast.LENGTH_SHORT).show();
    }



    public int getPerm() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            //            sendMessage();
            Toast.makeText(this, "contacts permission var ", Toast.LENGTH_SHORT).show();
            return 1;

        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 0);
            return 0;

        }
    }

}
