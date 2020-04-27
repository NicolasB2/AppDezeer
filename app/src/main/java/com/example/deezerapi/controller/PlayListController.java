package com.example.deezerapi.controller;


import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.deezerapi.model.PlayList;
import com.example.deezerapi.model.Track;
import com.example.deezerapi.util.Constants;
import com.example.deezerapi.util.HTTPSWebUtilDomi;
import com.example.deezerapi.view.PlayListActivity;
import com.google.gson.Gson;

public class PlayListController implements HTTPSWebUtilDomi.OnResponseListener {

    private PlayListActivity activity;
    private HTTPSWebUtilDomi utilDomi;
    private PlayList playList;
    private Track[] tracks;
    private int free;

    public PlayListController(PlayListActivity activity) {
        this.activity = activity;
        this.utilDomi = new HTTPSWebUtilDomi();
        this.utilDomi.setListener(this);

        loadPlayList(activity.getPlayList().getId());
    }

    @Override
    public void onResponse(int callbackID, String response) {

        try {
            switch (callbackID){
                case Constants.PLAYLIST_CALLBACK:
                    Gson gson = new Gson();
                    this.playList = gson.fromJson(response, PlayList.class);
                    loadView();
                    loadAllTracks(playList.getTracks().getData());
                    break;

                case Constants.TRACKS_CALLBACK:
                    Gson gson2 = new Gson();
                    Track track = gson2.fromJson(response, Track.class);

                    if(track.getId()==null){
                        break;
                    }

                    tracks[free]= track;
                    free++;

                    activity.runOnUiThread(
                            ()->{
                                activity.getAdapter().addTrack(track);
                            }
                    );

                    break;
            }
        }catch (Exception e){
            Log.e(">>>","error in PlayListcontroller onResponse");
        }
    }

    public void loadPlayList(long id){
        new Thread(
                ()->{
                    utilDomi.GETrequest(Constants.PLAYLIST_CALLBACK,"https://api.deezer.com/playlist/"+id);
                }
        ).start();
    }

    public void loadTrack(long id){
        new Thread(
                ()->{
                    utilDomi.GETrequest(Constants.TRACKS_CALLBACK,"https://api.deezer.com/track/"+id);
                }
        ).start();
    }

    public void loadAllTracks(Track[] data){

        this.tracks = new Track[data.length];
        free = 0;

        for (int i=0;i<data.length;i++){
            if(data[i]!=null){
                loadTrack(data[i].getId());
            }
        }
    }

    public void loadView(){
        try {
            activity.runOnUiThread(
                    ()->{

                        String x = playList.getTitle();

                        if(x.length()>=35){
                            x = x.substring(0,35)+"...";
                        }

                        activity.getPlayListNameTv().setText(x);
                        activity.getNumTracksTV().setText("Tracks: "+playList.getNb_tracks());
                        Glide.with(activity).load(playList.getPicture_big()).centerCrop().into(activity.getBanner());

                        if(playList.getDescription().equals("")){
                            activity.getPlayListDescriptionTv().setText("Non Description");
                        }if(playList.getDescription().length()>=60){
                            activity.getPlayListDescriptionTv().setText(playList.getDescription().substring(0,60)+"...");
                        }else{
                            activity.getPlayListDescriptionTv().setText(playList.getDescription());
                        }
                    }
            );
        }catch (Exception e){
            Log.e(">>>","error in PlayListcontroller loadView");
        }
    }

}
