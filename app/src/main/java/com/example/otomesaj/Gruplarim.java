package com.example.otomesaj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
        //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);



        modelClassList = new ArrayList<>();
        modelClassList.add(new ModelClass("isim1", "no 1"));
        modelClassList.add(new ModelClass("isim2", "no 2"));
        modelClassList.add(new ModelClass("isim3", "no 3"));
        modelClassList.add(new ModelClass("isim4", "no 4"));


        adapter = new Adapter(modelClassList);
        recyclerView.setAdapter(adapter);



    }
}
