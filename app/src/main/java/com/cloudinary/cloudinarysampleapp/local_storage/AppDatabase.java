package com.cloudinary.cloudinarysampleapp.local_storage;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.cloudinary.cloudinarysampleapp.local_storage.AssetModelEntity;

@Database(entities = {AssetModelEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract AssetModelDao assetModelDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "asset_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
