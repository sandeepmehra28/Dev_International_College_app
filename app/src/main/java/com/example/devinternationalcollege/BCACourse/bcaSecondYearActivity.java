package com.example.devinternationalcollege.BCACourse;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devinternationalcollege.R;

public class bcaSecondYearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bca_second_year);
        setupButton(R.id.BCAsecondYearClick, "secondyearsllaybus.pdf");
        setupButton(R.id.BCAsecondYearPracticalClick, "secondyearpractical.pdf");
        Button backBtn = findViewById(R.id.SecondYearBackBtn);
        backBtn.setOnClickListener(view -> {
            Intent intent =new Intent(bcaSecondYearActivity.this, bcaYearActivity.class);
            startActivity(intent);
            finish();
        });
    }
    private void setupButton(int buttonId, String pdfFileName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(bcaSecondYearActivity.this, bcaSecondPDFActivity.class);
            intent.putExtra("pdf_file", pdfFileName);  // Pass PDF file name
            startActivity(intent);
        });
    }
}