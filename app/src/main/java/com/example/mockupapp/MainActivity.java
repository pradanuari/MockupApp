package com.example.mockupapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.MyAdapterClickHandler {
    private RecyclerView recyclerView;
    private List<kumpulanData> listUrl;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rec_view);
        //listUrl = populateFakeData();

        MyAppDatabase db = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class,
                "production")
                .allowMainThreadQueries()
                .build();

        List<URLData> urlData = db.myDao().getAllUser();

        myAdapter = new MyAdapter(this);
        myAdapter.setListURL(urlData);
        recyclerView.setAdapter(myAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);

        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), addActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(URLData urlData) {
        Intent intent = new Intent(this,detailActivity.class);
        intent.putExtra("name",urlData.getName());
        intent.putExtra("url",urlData.getUrl());
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public List<kumpulanData> populateFakeData(){
        List<kumpulanData> listUrl = new ArrayList<>();
        listUrl.add(new kumpulanData("Google","www.google.com"));
        listUrl.add(new kumpulanData("Gmail","www.gmail.com"));
        listUrl.add(new kumpulanData("Facebook","www.facebook.com"));
        listUrl.add(new kumpulanData("Yahoo","www.yahooo.com"));
        listUrl.add(new kumpulanData("Youtube","www.youtube.com"));
        return listUrl;
    }


}
