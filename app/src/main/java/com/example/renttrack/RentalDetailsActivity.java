package com.example.renttrack;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RentalDetailsActivity extends AppCompatActivity {

    private EditText etFirstName, etLastName, etRentalDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_details);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etRentalDays = findViewById(R.id.etRentalDays);

        String carName = getIntent().getStringExtra("carName");
        setTitle("Kiralama - " + carName);

        Button btnRentCar = findViewById(R.id.btnRentCar);
        btnRentCar.setOnClickListener(v -> rentCar());
    }

    private void rentCar() {
        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();
        String rentalDays = etRentalDays.getText().toString();

        if (firstName.isEmpty() || lastName.isEmpty() || rentalDays.isEmpty()) {
            Toast.makeText(this, "Lütfen tüm bilgileri girin.", Toast.LENGTH_SHORT).show();
        } else {
            // Araç kiralama işlemi burada yapılabilir
            Toast.makeText(this, "Araç Kiralandı!", Toast.LENGTH_SHORT).show();
            finish(); // Ekranı kapat
        }
    }
}