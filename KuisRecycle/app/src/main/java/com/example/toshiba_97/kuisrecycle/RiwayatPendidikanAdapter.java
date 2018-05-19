package com.example.toshiba_97.kuisrecycle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by TOSHIBA-97 on 10/15/2017.
 */

public class RiwayatPendidikanAdapter extends RecyclerView.Adapter<RiwayatPendidikanAdapter.MyViewHolder>{
    List<RiwayatPendidikan> listPendidikan;

    public RiwayatPendidikanAdapter(List<RiwayatPendidikan> listPendidikan){
        this.listPendidikan = listPendidikan;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.pendidikan_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RiwayatPendidikanAdapter.MyViewHolder holder, int position) {
        RiwayatPendidikan riwayat = this.listPendidikan.get(position);
        holder.alamat.setText(riwayat.getAlamat());
        holder.tahun.setText(Integer.toString(riwayat.getTahun()));
        holder.namaSekolah.setText(riwayat.getNamaSekolah());
    }

    @Override
    public int getItemCount() {
        return listPendidikan.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView namaSekolah,tahun,alamat;
        public MyViewHolder(View itemView) {
            super(itemView);
            namaSekolah = (TextView) itemView.
                    findViewById(R.id.namaSekolah);
            tahun = (TextView) itemView.
                    findViewById(R.id.TahunSklh);
            alamat = (TextView) itemView.
                    findViewById(R.id.Alamat);
        }
    }
}
