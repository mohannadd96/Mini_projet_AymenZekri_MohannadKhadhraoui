package com.example.resto;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities={Images.class},version = 1)

@TypeConverters({ImageBitmapString.class}) // This will convert Bitmap to String and vice-versa;
public abstract class DatabaseProviderImg extends RoomDatabase

{
    public abstract ImageDao imageDao();
    private static DatabaseProviderImg databaseProvider=null;

    public static DatabaseProviderImg getDbConnection(Context context) {
        if (databaseProvider == null) {
            databaseProvider = Room.databaseBuilder(context.getApplicationContext(), DatabaseProviderImg.class, "newdb")
                    .allowMainThreadQueries()
                    .build();
        }

        return databaseProvider;
    }}
