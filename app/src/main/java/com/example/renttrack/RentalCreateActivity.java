package com.example.renttrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.app.AlertDialog; // Bu import'u ekleyin
import android.content.DialogInterface; // Bu import'u ekleyin

import androidx.appcompat.app.AppCompatActivity;

public class RentalCreateActivity extends AppCompatActivity {

    ImageButton btnCar1, btnCar2, btnCar3;
    Button btnBack; // Ana menüye dön butonu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_create);

        btnCar1 = findViewById(R.id.btnCar1);
        btnCar2 = findViewById(R.id.btnCar2);
        btnCar3 = findViewById(R.id.btnCar3);

        // Ana menüye dön butonunu bağla
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(RentalCreateActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Bu activity'i sonlandırarak geri dönüş yap
        });

        btnCar1.setOnClickListener(v -> showRentalDialog("BMW 3 Serisi - 2022"));
        btnCar2.setOnClickListener(v -> showRentalDialog("Audi A4 - 2021"));
        btnCar3.setOnClickListener(v -> showRentalDialog("Mercedes-Benz C-Class"));
    }

    private void showRentalDialog(String carModel) {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_rental_form, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        builder.setTitle(carModel);

        EditText etName = dialogView.findViewById(R.id.etCustomerName);
        EditText etSurname = dialogView.findViewById(R.id.etCustomerSurname);
        EditText etDays = dialogView.findViewById(R.id.etRentalDays);
        Button btnRent = dialogView.findViewById(R.id.btnRent);

        AlertDialog dialog = builder.create(); // Dialog nesnesi oluşturuluyor

        btnRent.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String surname = etSurname.getText().toString().trim();
            String days = etDays.getText().toString().trim();

            if (name.isEmpty() || surname.isEmpty() || days.isEmpty()) {
                Toast.makeText(this, "Lütfen tüm alanları doldurun.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Araç kiralandı: " + carModel, Toast.LENGTH_SHORT).show();
                dialog.dismiss(); // Dialog'u kapatıyoruz
            }
        });

        dialog.show(); // Dialog'u gösteriyoruz
    }
}
