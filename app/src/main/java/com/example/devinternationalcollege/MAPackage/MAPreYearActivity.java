package com.example.devinternationalcollege.MAPackage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.devinternationalcollege.R;

public class MAPreYearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mapre_year);
        setupButton(R.id.geoPreYearBtn, "mageopre.pdf");
        setupButton(R.id.polSciPreYearBtn, "mapolscipre.pdf");
        setupButton(R.id.engPreYearBtn, "maenglishpre.pdf");
        setupButton(R.id.hindiPreYearBtn, "mahindipre.pdf");
        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MAPreYearActivity.this, MAYearActivity.class);
            startActivity(intent);
            finish();
        });
    }
    private void setupButton(int buttonId, String pdfFileName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MAPreYearActivity.this, MAPreYearPDFActivity.class);
            intent.putExtra("pdf_file", pdfFileName);  // Pass PDF file name
            startActivity(intent);
        });
    }
}