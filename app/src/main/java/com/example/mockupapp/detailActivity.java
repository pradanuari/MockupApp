package com.example.mockupapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class detailActivity extends AppCompatActivity {

    private EditText mName;
    private EditText mUrl;
    Button btnEdit;
    Button btnSearch;
    private MyAppDatabase  mDb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_screen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail");

        mDb = MyAppDatabase.getInstance(getApplicationContext());

        mName = findViewById(R.id.name_view);
        mUrl = findViewById(R.id.url_view);
        btnEdit = findViewById(R.id.button_edit);
        btnSearch = findViewById(R.id.button_search);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String url = intent.getStringExtra("url");

        mName.setText(name);
        mName.setEnabled(false);
        mUrl.setText(url);
        mUrl.setEnabled(false);
    }
}
