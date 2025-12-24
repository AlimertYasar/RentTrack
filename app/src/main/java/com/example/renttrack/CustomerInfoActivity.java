package com.example.renttrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info); // XML dosyan

        // Butonu XML'den bağla
        Button btnBackToHome = findViewById(R.id.btnBackToHome);

        // Butona tıklanınca MainActivity'e dön
        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ana sayfaya git
                Intent intent = new Intent(CustomerInfoActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish(); // Bu aktiviteyi kapat (geri tuşunda tekrar buraya dönmesin)
            }
        });
    }
}
