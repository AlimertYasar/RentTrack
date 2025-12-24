package com.example.renttrack.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.renttrack.database.entity.Arac;
import com.example.renttrack.database.repository.AracRepository;

import java.util.List;

public class AracViewModel extends AndroidViewModel {
    private AracRepository repository;
    private LiveData<List<Arac>> tumAraclar;

    public AracViewModel(@NonNull Application application) {
        super(application);
        repository = new AracRepository(application);
        tumAraclar = repository.getAllCars();
    }

    public LiveData<List<Arac>> getTumAraclar() {
        return tumAraclar;
    }

    public void aracEkle(Arac arac) {
        repository.aracEkle(arac);
    }

    public void aracGuncelle(Arac arac) {
        repository.aracGuncelle(arac);
    }

    public void aracSil(Arac arac) {
        repository.aracSil(arac);
    }
}
