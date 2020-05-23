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

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {


    private List<ModelClass> modelClassList;

    public Adapter(List<ModelClass> modelClassList) {
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        String resource = modelClassList.get(position).getIsim();
        final String title = modelClassList.get(position).getNo();

        holder.setData(resource, title);


        // 3
        holder.itemLayout.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //Toast.makeText( context, title, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();

    }

    class Viewholder extends RecyclerView.ViewHolder {

        private TextView isim;
        private TextView no;
        //1
        ConstraintLayout itemLayout;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            isim = itemView.findViewById(R.id.isim);
            no = itemView.findViewById(R.id.no);
            //2
            itemLayout = itemView.findViewById(R.id.itemLayout);

        }

        private void setData(String isimm, String titleText) {

            isim.setText(isimm);
            no.setText(titleText);
        }
    }




}
