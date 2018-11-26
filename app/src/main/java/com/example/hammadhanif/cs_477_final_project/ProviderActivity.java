package com.example.hammadhanif.cs_477_final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);
    }

    public void onClickContinueMap(View view) {
        Intent continueIntent = new Intent(this,CurrentLocationMap.class);
        startActivity(continueIntent);

    }
}
