package com.example.devinternationalcollege.BCACourse;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devinternationalcollege.R;

public class bcaFirstYearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bca_first_year);
        setupButton(R.id.BCAfirstYearClick, "firstyearsllaybus.pdf");
        setupButton(R.id.BCAfirstYearPracticalClick, "firstyearsllaypractical.pdf");
        Button backBtn = findViewById(R.id.FirstYearBackBtn);
        backBtn.setOnClickListener(view -> {
            Intent intent =new Intent(bcaFirstYearActivity.this, bcaYearActivity.class);
            startActivity(intent);
            finish();
        });
    }
    private void setupButton(int buttonId, String pdfFileName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(bcaFirstYearActivity.this, bcaFirstPDFActivity.class);
            intent.putExtra("pdf_file", pdfFileName);  // Pass PDF file name
            startActivity(intent);
        });
    }
}