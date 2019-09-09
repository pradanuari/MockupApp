package com.example.mockupapp;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {URLData.class}, version = 1, exportSchema = false)
public abstract class MyAppDatabase extends RoomDatabase {

    private static final String TAG = "AppDatabase";
    private static final Object LOCK = new Object();
    private static final String databaseName = "finalproject";
    private static MyAppDatabase sInstance;

    public static MyAppDatabase getInstance(Context context){
        if(sInstance==null){
            synchronized (LOCK){
                Log.d(TAG,"creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        MyAppDatabase.class,MyAppDatabase.databaseName)
                        .allowMainThreadQueries()
                        .build();
            }
        }
        Log.d(TAG,"Getting database instance");
        return sInstance;
    }

    public abstract MyDao myDao();
}
