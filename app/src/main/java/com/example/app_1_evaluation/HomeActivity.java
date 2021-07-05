package com.example.app_1_evaluation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView mTvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTvName = findViewById(R.id.homeName);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mTvName.setText(name);
    }
}