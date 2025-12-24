package com.example.renttrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnMyCars;
    Button btnCustomerInfo;

    Button btnCreateRental;

    TextView tvRented, tvAvailable;

    private ArrayList<Car> carList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRented = findViewById(R.id.tvRentedCars);
        tvAvailable = findViewById(R.id.tvAvailableCars);
        btnMyCars = findViewById(R.id.btnMyCars);
        btnCustomerInfo = findViewById(R.id.btnMusteriBilgileri); // müşteri butonunu bağladık

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // 2. Sayıları güncelle
        tvRented.setText(String.valueOf(getRentedCarsCount()));
        tvAvailable.setText(String.valueOf(getAvailableCarsCount()));

        // 3. "Araçlarım" butonuna tıklayınca araba listesini yolla
        btnMyCars.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MyCarsActivity.class);
            intent.putExtra("carList", carList); // Serializable kullanıyoruz!
            startActivity(intent);
        });

        // 4. "Müşteri Bilgileri" butonuna tıklayınca müşteri bilgisi ekranına geç
        btnCustomerInfo.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CustomerInfoActivity.class);
            startActivity(intent);
        });

        btnCreateRental = findViewById(R.id.btnKiralamaOlustur);
        btnCreateRental.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RentalCreateActivity.class);
            startActivity(intent);
        });
    }

    private int getRentedCarsCount() {
        int count = 0;
        for (Car car : carList) {
            if ("Kirada".equals(car.status)) count++;
        }
        return count;
    }

    private int getAvailableCarsCount() {
        int count = 0;
        for (Car car : carList) {
            if ("Uygun".equals(car.status)) count++;
        }
        return count;
    }
}
