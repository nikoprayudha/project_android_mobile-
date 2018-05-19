package com.putraprima.ppmsqliteexamplefirst.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.putraprima.ppmsqliteexamplefirst.DaftarPenulis;
import com.putraprima.ppmsqliteexamplefirst.DetailPenulis;
import com.putraprima.ppmsqliteexamplefirst.R;
import com.putraprima.ppmsqliteexamplefirst.models.Penulis;

import java.util.List;

/**
 * Created by TOSHIBA-97 on 10/24/2017.
 */

public class PenulisAdapter extends RecyclerView.Adapter<PenulisAdapter.PenulisViewHolder> {
    private Context context;
    private List<Penulis> listPenulis;

    public PenulisAdapter(Context context, List<Penulis> listPenulis) {
        this.context = context;
        this.listPenulis = listPenulis;
    }

    @Override
    public PenulisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_penulis,parent,false);
        return new PenulisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PenulisViewHolder holder, int position) {
        final Penulis penulis = listPenulis.get(position);
        holder.namaPenulis.setText(penulis.getNama());
        holder.namaPenulis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),penulis.getId().toString(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(view.getContext(), DetailPenulis.class);
                i.putExtra("penulisId",penulis.getId());
                view.getContext().startActivity(i);
            }
        });

        holder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),penulis.getId().toString(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(view.getContext(), DaftarPenulis.class);
                i.putExtra("penulisId",penulis.getId());
                Long idPen = i.getLongExtra("penulisId",0L);
                Penulis deletePen = Penulis.findById(Penulis.class,idPen);
                deletePen.delete();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPenulis.size();
    }

    public class PenulisViewHolder extends RecyclerView.ViewHolder {
        public TextView namaPenulis;
        public Button btndelete, btnupdate;
        public PenulisViewHolder(View itemView) {
            super(itemView);
            namaPenulis=(TextView) itemView.findViewById(R.id.namaPenulis);
            btndelete = (Button) itemView.findViewById(R.id.button);
            btnupdate = (Button) itemView.findViewById(R.id.buttonUpdate);
        }
    }
}
