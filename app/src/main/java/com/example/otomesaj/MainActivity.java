package com.example.otomesaj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        Intent intent = new Intent(MainActivity.this, Gruplarim.class);
        startActivity(intent);
        Toast.makeText(this, "tıklandım", Toast.LENGTH_SHORT).show();


    }

}
