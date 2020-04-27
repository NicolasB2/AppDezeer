package com.example.deezerapi.controller;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.deezerapi.R;
import com.example.deezerapi.model.Track;
import com.example.deezerapi.view.TrackActivity;

public class TrackController implements View.OnClickListener{

    private TrackActivity activity;
    private Track track;

    public TrackController(TrackActivity activity) {
        this.activity = activity;
        this.track = activity.getTrack();
        activity.getPlayBtn().setOnClickListener(this);
        loadView();
    }

    private void loadView() {

        try {
            activity.runOnUiThread(
                    ()->{
                        String x = track.getTitle();

                        if(x.length()>=15){
                            x = x.substring(0,15)+"...";
                        }

                        activity.getTrackNameTV().setText(x);
                        activity.getTrackArtistTV().setText(track.getArtist().getName());
                        activity.getTrackAlbumTV().setText(track.getAlbum().getTitle());
                        activity.getTrackDurationTV().setText("Time: "+track.getDuration()+" sec");

                        Glide.with(activity).load(track.getAlbum().getCover_big()).centerCrop().into(activity.getTrackImage());
                    }
            );
        }catch (Exception e){
            Log.e(">>>","error in TrackController loadView");
        }
    }

    @Override
    public void onClick(View view) {

        try {
            switch (view.getId()) {
                case R.id.playBtn:
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(track.getLink()));
                    activity.startActivity(i);
                    break;
            }
        }catch (Exception e){
            Log.e(">>>","error in TrackController onClick");
        }
    }
}
