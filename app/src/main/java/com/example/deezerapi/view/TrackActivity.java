package com.example.deezerapi.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deezerapi.R;
import com.example.deezerapi.controller.TrackController;
import com.example.deezerapi.model.Track;

public class TrackActivity extends AppCompatActivity {

    private Track track;
    private TrackController controller;

    private ImageView trackImage;
    private TextView trackNameTV;
    private TextView trackArtistTV;
    private TextView trackAlbumTV;
    private TextView trackDurationTV;
    private Button playBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_track);

        track = (Track) getIntent().getExtras().getSerializable("track");

        this.trackImage =  findViewById(R.id.trackImage);
        this.trackNameTV =  findViewById(R.id.trackNameTV);
        this.trackArtistTV =  findViewById(R.id.trackArtistTV);
        this.trackAlbumTV =  findViewById(R.id.trackAlbumTV);
        this.trackDurationTV =  findViewById(R.id.trackDurationTV);
        this.playBtn = findViewById(R.id.playBtn);

        this.controller = new TrackController(this);
    }

    public Track getTrack() {
        return track;
    }

    public ImageView getTrackImage() {
        return trackImage;
    }

    public TextView getTrackNameTV() {
        return trackNameTV;
    }

    public TextView getTrackArtistTV() {
        return trackArtistTV;
    }

    public TextView getTrackAlbumTV() {
        return trackAlbumTV;
    }

    public TextView getTrackDurationTV() {
        return trackDurationTV;
    }

    public Button getPlayBtn() {
        return playBtn;
    }
}
