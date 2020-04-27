package com.example.deezerapi.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import com.example.deezerapi.R;

public class MainActivity extends AppCompatActivity {

    private Button continueBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        continueBtn = findViewById(R.id.continueBtn);

        continueBtn.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this,FindListActivity.class);
                    startActivity(i);
                }

        );
    }
}
