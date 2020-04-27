package com.example.deezerapi.controller;

import android.util.Log;
import android.view.View;

import com.example.deezerapi.R;
import com.example.deezerapi.adapter.ListAdapter;
import com.example.deezerapi.model.SearchList;
import com.example.deezerapi.util.Constants;
import com.example.deezerapi.util.HTTPSWebUtilDomi;
import com.example.deezerapi.view.FindListActivity;
import com.google.gson.Gson;


public class FindListController implements View.OnClickListener, HTTPSWebUtilDomi.OnResponseListener {

    private FindListActivity activity;
    private HTTPSWebUtilDomi utilDomi;
    private SearchList searchList;

    public FindListController(FindListActivity activity) {
        this.activity = activity;
        this.utilDomi = new HTTPSWebUtilDomi();
        this.utilDomi.setListener(this);
        activity.getSearchBtn().setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()){
                case R.id.searchBtn:

                    String nameList = activity.getFindET().getText().toString();

                    new Thread(
                            ()->{
                                utilDomi.GETrequest(Constants.SEARCH_CALLBACK,"https://api.deezer.com/search/playlist?q="+nameList);
                            }
                    ).start();

                    break;
            }
        }catch (Exception e){
            Log.e(">>>","error in FindListController onClick");
        }
    }

    @Override
    public void onResponse(int callbackID, String response) {
        try {
            switch (callbackID){
                case Constants.SEARCH_CALLBACK:
                    Gson gson = new Gson();
                    searchList = gson.fromJson(response, SearchList.class);

                    if(searchList.getData()!=null){
                        activity.runOnUiThread(
                                ()->{
                                    ListAdapter adapter = new ListAdapter(activity,searchList.getData());
                                    activity.setAdapter(adapter);
                                    activity.getRecyclerView().setAdapter(adapter);
                                }
                        );
                    }

                    break;
            }
        }catch (Exception e){
            Log.e(">>>","error in FindListController onResponse");
        }
    }
}
