package com.example.deezerapi.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.deezerapi.R;
import com.example.deezerapi.model.PlayList;
import com.example.deezerapi.view.FindListActivity;
import com.example.deezerapi.view.PlayListActivity;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolderDatos> {

    private PlayList[] playLists;
    private FindListActivity activity;

    public  ListAdapter(FindListActivity findListActivity,PlayList[] playLists){
        this.activity = findListActivity;
        this.playLists = playLists;
    }

    public PlayList[] getPlayLists() {
        return playLists;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_row,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(playLists[position]);
    }

    @Override
    public int getItemCount() {
        return playLists.length;
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView listNameTV;
        TextView userNameTV;
        TextView numItemsTV;
        ImageView trackImage;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            listNameTV = itemView.findViewById(R.id.trackNameTV);
            userNameTV = itemView.findViewById(R.id.trackArtistTV);
            numItemsTV = itemView.findViewById(R.id.trackReleaseTV);
            trackImage = itemView.findViewById(R.id.trackImage);

        }

        public void asignarDatos(PlayList playList){

            try {
                String x = playList.getTitle();

                if(x.length()>=35){
                    x = x.substring(0,35)+"...";
                }

                listNameTV.setText(x);
                userNameTV.setText("User: "+playList.getUser().getName());
                numItemsTV.setText("Tracks: "+playList.getNb_tracks());

                Glide.with(itemView).load(playList.getPicture()).centerCrop().into(trackImage);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(activity, PlayListActivity.class);
                        i.putExtra("playList",playList);
                        activity.startActivity(i);
                    }
                });
            }catch (Exception e){
                Log.e(">>>","error in ListAdapter");
            }

        }
    }
}
