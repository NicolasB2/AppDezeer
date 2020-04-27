package com.example.deezerapi.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.deezerapi.R;
import com.example.deezerapi.model.Track;
import com.example.deezerapi.view.PlayListActivity;
import com.example.deezerapi.view.TrackActivity;

import java.util.ArrayList;

public class trackAdapter extends BaseAdapter {

    private PlayListActivity activity;
    private ArrayList<Track> tracks;

    public trackAdapter(PlayListActivity activity) {
        this.activity = activity;
        tracks = new ArrayList<>();
    }

    public void addTrack(Track track){
        tracks.add(track);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return tracks.size();
    }

    @Override
    public Object getItem(int position) {
        return tracks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.tracks_row,null,false);

        try {
            TextView trackNameTV = row.findViewById(R.id.trackNameTV);
            TextView trackArtistTV = row.findViewById(R.id.trackArtistTV);
            TextView trackReleaseTV = row.findViewById(R.id.trackReleaseTV);
            ImageView trackImage = row.findViewById(R.id.trackImage);


            String x = tracks.get(position).getTitle();

            if(x.length()>=35){
                x = x.substring(0,35)+"...";
            }

            trackNameTV.setText(x);
            trackArtistTV.setText(tracks.get(position).getArtist().getName());
            trackReleaseTV.setText(tracks.get(position).getRelease_date());

            Glide.with(row).load(tracks.get(position).getAlbum().getCover()).centerCrop().into(trackImage);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(activity, TrackActivity.class);
                    i.putExtra("track",tracks.get(position));
                    activity.startActivity(i);
                }
            });
        }catch (Exception e){
            Log.e(">>>","error in trackAdapter");
        }

        return row;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

}
