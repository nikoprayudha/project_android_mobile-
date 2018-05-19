package com.example.toshiba_97.uts_profile.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.toshiba_97.uts_profile.DetailKegiatan;
import com.example.toshiba_97.uts_profile.Models.Kegiatan;
import com.example.toshiba_97.uts_profile.R;

import java.util.List;

/**
 * Created by TOSHIBA-97 on 11/7/2017.
 */

public class KegiatanAdapter extends RecyclerView.Adapter<KegiatanAdapter.KegiatanViewHolder>{
    private Context context;
    private List<Kegiatan> listKegiatan;

    public KegiatanAdapter(Context context, List<Kegiatan> listKegiatan) {
        this.context = context;
        this.listKegiatan = listKegiatan;
    }

    @Override
    public KegiatanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kegiatan,parent,false);
        return new KegiatanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KegiatanAdapter.KegiatanViewHolder holder, int position) {
        final Kegiatan kegiatan = listKegiatan.get(position);
        holder.namaKegiatan.setText(kegiatan.getNamakegiatan());
        holder.namaKegiatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),kegiatan.getId().toString(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(view.getContext(),DetailKegiatan.class);
                i.putExtra("kegiatanId",kegiatan.getId());
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listKegiatan.size();
    }

    public class KegiatanViewHolder extends RecyclerView.ViewHolder {
        public TextView namaKegiatan;
        public KegiatanViewHolder(View itemView) {
            super(itemView);
            namaKegiatan=(TextView) itemView.findViewById(R.id.namaKegiatan);
        }
    }
}
