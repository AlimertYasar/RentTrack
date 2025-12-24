package com.example.renttrack.database.repository;

import android.content.Context;

import com.example.renttrack.database.AppDatabase;
import com.example.renttrack.database.entity.Arac;
import androidx.lifecycle.LiveData;
import java.util.List;

public class AracRepository {
    private final AppDatabase database;

    public AracRepository(Context context) {
        database = AppDatabase.getDatabase(context);
    }

    // Get all cars as LiveData
    public LiveData<List<Arac>> getAllCars() {
        return database.aracDao().getAllCars();
    }

    public void aracEkle(Arac arac) {
        new Thread(() -> database.aracDao().insert(arac)).start();
    }

    public void aracGuncelle(Arac arac) {
        new Thread(() -> database.aracDao().update(arac)).start();
    }

    public void aracSil(Arac arac) {
        new Thread(() -> database.aracDao().delete(arac)).start();
    }

}
