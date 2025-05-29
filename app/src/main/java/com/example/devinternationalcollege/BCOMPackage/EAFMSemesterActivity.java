package com.example.devinternationalcollege.BCOMPackage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devinternationalcollege.R;

public class EAFMSemesterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eafmsemester);
        setupButton(R.id.EAFMFirstClick, "eafmsem1.pdf");
        setupButton(R.id.EAFMSecondClick, "eafmsem2.pdf");
        setupButton(R.id.EAFMThirdClick, "eafmsem3.pdf");
        setupButton(R.id.EAFMFourthClick, "eafmsem4.pdf");
        setupButton(R.id.EAFMFifthClick, "eafmsem5.pdf");
        setupButton(R.id.EAFMSixthClick, "eafmsem6.pdf");
        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(EAFMSemesterActivity.this, BCOMAllSubjectsActivity.class);
            startActivity(intent);
            finish();
        });
    }
    private void setupButton(int buttonId, String pdfFileName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(EAFMSemesterActivity.this, BCOM_EAFMPDFActivity.class);
            intent.putExtra("pdf_file", pdfFileName);  // Pass PDF file name
            startActivity(intent);
        });
    }
}