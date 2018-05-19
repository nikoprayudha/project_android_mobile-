package com.example.toshiba_97.uts_profile.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toshiba_97.uts_profile.DetailPendidikan;
import com.example.toshiba_97.uts_profile.Models.Pendidikan;
import com.example.toshiba_97.uts_profile.R;

import java.util.List;

/**
 * Created by TOSHIBA-97 on 11/6/2017.
 */

public class PendidikanAdapter extends RecyclerView.Adapter<PendidikanAdapter.PendidikanViewHolder>{
    private Context context;
    private List<Pendidikan> listPendidikan;

    public PendidikanAdapter(Context context, List<Pendidikan> listPendidikan) {
        this.context = context;
        this.listPendidikan = listPendidikan;
    }

    @Override
    public PendidikanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pendidikan,parent,false);
        return new PendidikanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PendidikanAdapter.PendidikanViewHolder holder, int position) {
        final Pendidikan pendidikan = listPendidikan.get(position);
        holder.namaPendidikan.setText(pendidikan.getNamapendidikan());
        holder.namaPendidikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),pendidikan.getId().toString(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(view.getContext(),DetailPendidikan.class);
                i.putExtra("pendidikanId",pendidikan.getId());
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPendidikan.size();
    }

    public class PendidikanViewHolder extends RecyclerView.ViewHolder {
        public TextView namaPendidikan;

        public PendidikanViewHolder(View itemView) {
            super(itemView);
            namaPendidikan=(TextView) itemView.findViewById(R.id.namaPendidikan);
        }
    }
}
