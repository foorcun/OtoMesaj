package com.example.otomesaj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class SecilenExampleAdapter extends RecyclerView.Adapter<SecilenExampleAdapter.ViewHolder> {

    private List<ModelClass> secilen = new ArrayList<>();

    /* public SecilenExampleAdapter(List<String> secilen) {
         this.secilen = secilen;
     }
 */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.secilen_item_example, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final ModelClass data = secilen.get(position);
        holder.textView.setText(data.isim);

    }

    @Override
    public int getItemCount() {
        return secilen.size();

    }

    public void setList(List<ModelClass> secilen) {
        this.secilen = secilen;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.texto);
        }
    }
}
