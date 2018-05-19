package com.example.toshiba_97.dataset;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by TOSHIBA-97 on 9/26/2017.
 */

public class RiwayatSekolahAdapter extends RecyclerView.Adapter<RiwayatSekolahAdapter.MyViewHolder>{
    List<RiwayatSekolah> listRiwayat;

    public RiwayatSekolahAdapter(List<RiwayatSekolah> listRiwayat) {
        this.listRiwayat = listRiwayat;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.riwayat_sekolah_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RiwayatSekolah riwayat = this.listRiwayat.get(position);
        holder.tingkatPendidikan.setText(riwayat.getTingkatPendidikan());
        holder.tahunLulus.setText(Integer.toString(riwayat.getTahunLulus()));
        holder.namaSekolah.setText(riwayat.getNamaSekolah());
    }

    @Override
    public int getItemCount() {
        return listRiwayat.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView namaSekolah,tahunLulus,tingkatPendidikan;
        public MyViewHolder(View itemView) {
            super(itemView);
            namaSekolah = (TextView) itemView.
                    findViewById(R.id.namaSekolah);
            tahunLulus = (TextView) itemView.
                    findViewById(R.id.tahunLulus);
            tingkatPendidikan = (TextView) itemView.
                    findViewById(R.id.tingkatPendidikan);
        }
    }
}
