package com.example.renttrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View; // Bu satır eklendi
import android.widget.Button;
import android.widget.EditText; // Bu satır eklendi
import android.widget.Toast;
import android.graphics.Color;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.renttrack.database.entity.Arac;
import com.example.renttrack.database.repository.AracRepository;

import java.util.List;

public class MyCarsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCars;
    private Button btnAddNewCar;
    private Button btnBack;
    private AracRepository repository;
    private AracAdapter aracAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cars);

        // View'ları bağla
        recyclerViewCars = findViewById(R.id.recyclerView);
        btnAddNewCar = findViewById(R.id.btnAddNewCar);
        btnBack = findViewById(R.id.btnBack);

        repository = new AracRepository(getApplication());

        // RecyclerView ayarları
        recyclerViewCars.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCars.setHasFixedSize(true);

        // Araç listesini gözlemle
        repository.getAllCars().observe(this, araclar -> {
            if (aracAdapter == null) {
                aracAdapter = new AracAdapter(MyCarsActivity.this, araclar, new AracAdapter.OnCarItemClickListener() {
                    @Override
                    public void onEditClick(Arac arac) {
                        // BU METODUN İÇİ BOŞ OLMAMALI
                        showEditCarDialog(arac);
                    }

                    @Override
                    public void onDeleteClick(Arac arac) {
                        // BU METODUN İÇİ BOŞ OLMAMALI
                        showDeleteConfirmationDialog(arac);
                    }
                });
                recyclerViewCars.setAdapter(aracAdapter);
            } else {
                aracAdapter.updateCarList(araclar);
            }
        });

        // Buton click listener'ları
        btnAddNewCar.setOnClickListener(v -> {
            startActivity(new Intent(MyCarsActivity.this, AracEkleActivity.class));
        });

        btnBack.setOnClickListener(v -> {
            finish();
        });
    }

    private void showDeleteConfirmationDialog(Arac arac) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Araç Silme")
                .setMessage("Bu aracı silmek istediğinize emin misiniz?")
                .setPositiveButton("Sil", (d, which) -> {
                    repository.aracSil(arac);
                    Toast.makeText(this, "Araç silindi", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("İptal", (d, which) -> d.dismiss())
                .create();

        dialog.setOnShowListener(d -> {
            // Sil butonunu kırmızı yap
            Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            positiveButton.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));

            // İptal butonunu mavi yap
            Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
            negativeButton.setTextColor(ContextCompat.getColor(this, android.R.color.holo_blue_dark));
        });

        dialog.show();
    }

    private void showEditCarDialog(Arac arac) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_edit_car, null);
        builder.setView(view);

        // View'ları bağla
        EditText etMarka = view.findViewById(R.id.etCarName);
        EditText etPlaka = view.findViewById(R.id.etPlate);
        EditText etDurum = view.findViewById(R.id.etStatus);
        EditText etKiraci = view.findViewById(R.id.etRenter);
        EditText etSure = view.findViewById(R.id.etDuration);
        EditText etGecenSure = view.findViewById(R.id.etTimeElapsed);
        Button btnKaydet = view.findViewById(R.id.btnSave);

        // Mevcut bilgileri doldur
        etMarka.setText(arac.getMarka());
        etPlaka.setText(arac.getPlaka());
        etDurum.setText(String.valueOf(arac.isDurum()));
        etKiraci.setText(arac.getKiraci());
        etSure.setText(arac.getSure());
        etGecenSure.setText(arac.getGecenSure());

        AlertDialog dialog = builder.create();

        btnKaydet.setOnClickListener(v -> {
            // Yeni bilgileri al
            arac.setMarka(etMarka.getText().toString());
            arac.setPlaka(etPlaka.getText().toString());
            arac.setDurum(Boolean.parseBoolean(etDurum.getText().toString()));
            arac.setKiraci(etKiraci.getText().toString());
            arac.setSure(etSure.getText().toString());
            arac.setGecenSure(etGecenSure.getText().toString());

            // Veritabanını güncelle
            repository.aracGuncelle(arac);
            Toast.makeText(MyCarsActivity.this, "Araç güncellendi", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        dialog.show();
    }
}