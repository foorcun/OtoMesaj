package com.example.otomesaj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Secilen_Adapter extends RecyclerView.Adapter<Secilen_Adapter.Viewholder> {

    private List<ModelClass> modelClassListSecilen; //1 List<ModelClass> for Field attribute

    public Secilen_Adapter(List<ModelClass> modelClassListSecilen) {
        this.modelClassListSecilen = modelClassListSecilen;
    }

    @NonNull
    @Override
    public Secilen_Adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // ConstraintLayout secilen_item_layout;

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.secilen_item_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Secilen_Adapter.Viewholder holder, int position) {
        String name = modelClassListSecilen.get(position).getIsim();

        holder.setData(name);

    }

    @Override
    public int getItemCount() {
        return modelClassListSecilen.size();

    }






    class Viewholder extends RecyclerView.ViewHolder {


        //private ImageView imageView;  // Field attribute olarak item view daki viewlarımızı boş variable olarak oluştuyorz
        private TextView isim;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            //imageView = itemView.findViewById(R.id.imageView); // Field attribute taki view ları find ediyorz
            isim = itemView.findViewById(R.id.textView_secilen_name_secilen_item_layout);

        }

        private void setData(String isimm) {

            //imageView.setImageResource(imageResource); // view larımıza data girişi yaparak element ekliyorz
            isim.setText(isimm);
        }

    }





}
