package com.example.deezerapi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.deezerapi.R;
import com.example.deezerapi.adapter.ListAdapter;
import com.example.deezerapi.controller.FindListController;

public class FindListActivity extends AppCompatActivity {


    private ListAdapter adapter;
    private FindListController controller;

    private EditText findET;
    private ImageButton searchBtn;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_find_list);

        this.findET = findViewById(R.id.findET);
        this.searchBtn = findViewById(R.id.searchBtn);

        this.controller = new FindListController(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }

    public ListAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(ListAdapter adapter) {
        this.adapter = adapter;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public EditText getFindET() {
        return findET;
    }

    public ImageButton getSearchBtn() {
        return searchBtn;
    }

}
