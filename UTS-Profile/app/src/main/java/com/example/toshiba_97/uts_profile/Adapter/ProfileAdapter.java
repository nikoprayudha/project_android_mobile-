package com.example.toshiba_97.uts_profile.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.toshiba_97.uts_profile.DetailProfile;
import com.example.toshiba_97.uts_profile.Models.Profile;
import com.example.toshiba_97.uts_profile.R;

import java.util.List;

/**
 * Created by TOSHIBA-97 on 11/4/2017.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {
    private Context context;
    private List<Profile> listProfile;

    public ProfileAdapter(Context context, List<Profile> listProfile) {
        this.context = context;
        this.listProfile = listProfile;
    }

    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile,parent,false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileViewHolder holder, int position) {
        final Profile profile = listProfile.get(position);
        holder.namaProfile.setText(profile.getNama());
        holder.namaProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),profile.getId().toString(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(view.getContext(), DetailProfile.class);
                i.putExtra("profileId",profile.getId());
                view.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listProfile.size();
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder {
        public TextView namaProfile;

        public ProfileViewHolder(View itemView) {
            super(itemView);
            namaProfile=(TextView) itemView.findViewById(R.id.namaProfile);

        }
    }
}
