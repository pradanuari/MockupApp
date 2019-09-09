package com.example.mockupapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class addActivity extends AppCompatActivity {
    EditText name;
    EditText url;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_screen);

        name = findViewById(R.id.name);
        url = findViewById(R.id.url);
        button = findViewById(R.id.button_add);

        final MyAppDatabase db = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    URLData urlData = new URLData(name.getText().toString(),
                            url.getText().toString());
                    db.myDao().insertAll(urlData);


                startActivity(new Intent(addActivity.this, MainActivity.class));

            }
        });
    }
}
