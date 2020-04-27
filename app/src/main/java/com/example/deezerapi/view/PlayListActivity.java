package com.example.deezerapi.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.deezerapi.R;
import com.example.deezerapi.adapter.trackAdapter;
import com.example.deezerapi.controller.PlayListController;
import com.example.deezerapi.model.PlayList;

public class PlayListActivity extends AppCompatActivity {

    private PlayListController controller;
    private trackAdapter adapter;

    private PlayList playList;
    private ListView listTable2;
    private ImageView banner;
    private TextView playListNameTv;
    private TextView playListDescriptionTv;
    private TextView numTracksTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_play_list);

        this.playList = (PlayList) getIntent().getExtras().getSerializable("playList");

        this.listTable2 = findViewById(R.id.listTable2);
        this.banner =  findViewById(R.id.banner);
        this.playListNameTv =  findViewById(R.id.playListNameTv);
        this.playListDescriptionTv =  findViewById(R.id.playListDescriptionTv);
        this.numTracksTV =  findViewById(R.id.numTracksTV);

        this.controller = new PlayListController(this);
        this.adapter = new trackAdapter(this);
        this.listTable2.setAdapter(adapter);

    }

    public ImageView getBanner() {
        return banner;
    }

    public TextView getPlayListNameTv() {
        return playListNameTv;
    }

    public TextView getPlayListDescriptionTv() {
        return playListDescriptionTv;
    }

    public TextView getNumTracksTV() {
        return numTracksTV;
    }

    public PlayList getPlayList() {
        return playList;
    }

    public trackAdapter getAdapter() {
        return adapter;
    }
}
