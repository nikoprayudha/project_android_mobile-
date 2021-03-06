package com.example.novia.semangat.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.novia.semangat.DetailWisata;
import com.example.novia.semangat.R;
import com.example.novia.semangat.model.ImageUploadInfoWis;

import java.util.List;

/**
 * Created by TOSHIBA-97 on 1/26/2018.
 */

public class RecyclerViewAdapterWis extends RecyclerView.Adapter<RecyclerViewAdapterWis.ViewHolder> {

    Context context;
    List<ImageUploadInfoWis> MainImageUploadInfoListWis;

    public RecyclerViewAdapterWis(Context context, List<ImageUploadInfoWis> TempList) {

        this.MainImageUploadInfoListWis = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items_wis, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterWis.ViewHolder holder, int position) {
        final ImageUploadInfoWis UploadInfo = MainImageUploadInfoListWis.get(position);

        holder.imageNameTextView.setText(UploadInfo.getImageName());
        //Loading image from Glide library.
        Glide.with(context).load(UploadInfo.getImageURL()).into(holder.imageView);
        holder.imageNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                openDetailActivity(UploadInfo.getImageName(),UploadInfo.getAlamat(), UploadInfo.getTelp(), UploadInfo.deskripsi );

            }




        });
    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoListWis.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView imageNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.btnWisata);

            imageNameTextView = (TextView) itemView.findViewById(R.id.ImageNameTextView);
        }
    }
    public void openDetailActivity(String...details){
        Intent i = new Intent(context, DetailWisata.class);
        i.putExtra("imageName",details[0]);
        i.putExtra("alamat", details[1]);
        i.putExtra("telp", details[2]);
        i.putExtra("deskripsi", details[3]);


        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

    }
}
