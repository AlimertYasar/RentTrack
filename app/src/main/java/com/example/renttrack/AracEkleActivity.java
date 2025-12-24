package com.example.renttrack;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.renttrack.database.entity.Arac;
import com.example.renttrack.database.repository.AracRepository;

public class AracEkleActivity extends AppCompatActivity {

    private EditText etMarka, etModel, etPlaka, etDurum, etKiraci, etSure, etGecenSure;
    private Button btnAddCar;
    private AracRepository repository;
    private boolean isEditMode = false;
    private int aracId = -1; // Düzenleme modu için gerekli ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add_car);

        // View'ları bağla
        etMarka = findViewById(R.id.etCarBrand);
        etModel = findViewById(R.id.etCarModel);
        etPlaka = findViewById(R.id.etCarPlate);
        etDurum = findViewById(R.id.etCarStatus);
        etKiraci = findViewById(R.id.etCarRenter);
        etSure = findViewById(R.id.etCarPeriod);
        etGecenSure = findViewById(R.id.etCarElapsedTime);
        btnAddCar = findViewById(R.id.btnAddCar);

        repository = new AracRepository(getApplication());

        btnAddCar.setOnClickListener(v -> {
            String marka = etMarka.getText().toString();
            String model = etModel.getText().toString();
            String plaka = etPlaka.getText().toString();
            String durumText = etDurum.getText().toString().toLowerCase();
            boolean durum = durumText.equals("true") || durumText.equals("1");
            String kiraci = etKiraci.getText().toString();
            String sure = etSure.getText().toString();
            String gecenSure = etGecenSure.getText().toString();

            if (isEditMode) {
                Arac guncellenenArac = new Arac(aracId, marka, model, plaka, durum, kiraci, sure, gecenSure);
                repository.aracGuncelle(guncellenenArac);
            } else {
                Arac yeniArac = new Arac(marka, model, plaka);
                yeniArac.setDurum(durum);
                yeniArac.setKiraci(kiraci);
                yeniArac.setSure(sure);
                yeniArac.setGecenSure(gecenSure);
                repository.aracEkle(yeniArac);
            }
            finish();
        });
    }
}