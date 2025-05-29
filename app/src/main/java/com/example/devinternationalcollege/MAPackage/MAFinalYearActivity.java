package com.example.devinternationalcollege.MAPackage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.devinternationalcollege.R;

public class MAFinalYearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mafinal_year);
        setupButton(R.id.geoFinalYearBtn, "mageofinal.pdf");
        setupButton(R.id.polSciFinalYearBtn, "mapolscifinal.pdf");
        setupButton(R.id.engFinalYearBtn, "maenglishfinal.pdf");
        setupButton(R.id.hindiFinalYearBtn, "mahindifinal.pdf");
        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MAFinalYearActivity.this, MAYearActivity.class);
            startActivity(intent);
            finish();
        });
    }
    private void setupButton(int buttonId, String pdfFileName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MAFinalYearActivity.this, MAFinalYearPDFActivity.class);
            intent.putExtra("pdf_file", pdfFileName);  // Pass PDF file name
            startActivity(intent);
        });
    }
}