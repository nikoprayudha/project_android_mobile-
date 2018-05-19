package com.example.toshiba_97.uts_profile.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.toshiba_97.uts_profile.DetailKeluarga;
import com.example.toshiba_97.uts_profile.Models.Keluarga;
import com.example.toshiba_97.uts_profile.R;

import java.util.List;

/**
 * Created by TOSHIBA-97 on 11/7/2017.
 */

public class KeluargaAdapter extends RecyclerView.Adapter<KeluargaAdapter.KeluargaViewHolder> {

    private Context context;
    private List<Keluarga> listKeluarga;

    public KeluargaAdapter(Context Context, List<Keluarga> listKeluarga) {
        this.context = context;
        this.listKeluarga = listKeluarga;
    }

    @Override
    public KeluargaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_keluarga,parent,false);
        return new KeluargaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KeluargaAdapter.KeluargaViewHolder holder, int position) {
        final Keluarga keluarga = listKeluarga.get(position);
        holder.namaKeluarga.setText(keluarga.getNamakeluarga());
        holder.namaKeluarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),keluarga.getId().toString(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(view.getContext(),DetailKeluarga.class);
                i.putExtra("keluargaId",keluarga.getId());
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listKeluarga.size();
    }

    public class KeluargaViewHolder extends RecyclerView.ViewHolder {
        public TextView namaKeluarga;
        public KeluargaViewHolder(View itemView) {
            super(itemView);
            namaKeluarga=(TextView) itemView.findViewById(R.id.namaKeluarga);
        }
    }
}
