package com.example.devinternationalcollege.BCACourse;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devinternationalcollege.R;

public class bcaFinalYearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bca_final_year);
        setupButton(R.id.BCAfinalYearClick, "finalyearsllaybus.pdf");
        setupButton(R.id.BCAfinalYearPracticalClick, "finalyearpractical.pdf");
        Button backBtn = findViewById(R.id.FinalYearBackBtn);
        backBtn.setOnClickListener(view -> {
            Intent intent =new Intent(bcaFinalYearActivity.this, bcaYearActivity.class);
            startActivity(intent);
            finish();
        });
        Button student_data = findViewById(R.id.BCAStudentsData);
        student_data.setOnClickListener(view -> {
            Intent intent =new Intent(bcaFinalYearActivity.this, StudentsDataActivity.class);
            startActivity(intent);
        });
    }
    private void setupButton(int buttonId, String pdfFileName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(bcaFinalYearActivity.this, bcaFinalPDFActivity.class);
            intent.putExtra("pdf_file", pdfFileName);  // Pass PDF file name
            startActivity(intent);
        });
    }
}