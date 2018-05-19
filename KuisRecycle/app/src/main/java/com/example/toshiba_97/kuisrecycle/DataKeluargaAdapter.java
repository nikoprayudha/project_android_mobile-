package com.example.toshiba_97.kuisrecycle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by TOSHIBA-97 on 10/15/2017.
 */

public class DataKeluargaAdapter extends RecyclerView.Adapter<DataKeluargaAdapter.MyViewHolder>{
    List<DataKeluarga> riwayatKeluargas;

    public DataKeluargaAdapter( List <DataKeluarga> riwayatKeluargas){
        this.riwayatKeluargas = riwayatKeluargas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.keluarga_items,parent,false);
        return new DataKeluargaAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataKeluargaAdapter.MyViewHolder holder, int position) {
        DataKeluarga riwayat =this.riwayatKeluargas.get(position);
        holder.status.setText( riwayat.getStatus());
        holder.nama.setText(riwayat.getNama());
        holder.pekerjaan.setText(riwayat.getPekerjaan());
        holder.tahunlahir.setText(Integer.toString(riwayat.getTahunlahir()));
        holder.foto.setImageResource(riwayat.getImage());
    }

    @Override
    public int getItemCount() {
        return riwayatKeluargas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView status, nama, pekerjaan, tahunlahir;
        public ImageView foto;
        public MyViewHolder(View itemView) {
            super(itemView);
            nama = (TextView) itemView.findViewById(R.id.namakeluarga);
            status = (TextView) itemView.findViewById(R.id.status);
            tahunlahir  = (TextView) itemView.findViewById((R.id.tahunlahir));
            pekerjaan = (TextView) itemView.findViewById((R.id.pekerjaan));
            foto = (ImageView) itemView.findViewById((R.id.foto));
        }
    }
}
