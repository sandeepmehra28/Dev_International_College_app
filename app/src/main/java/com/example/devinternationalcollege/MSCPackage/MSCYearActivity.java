package com.example.devinternationalcollege.MSCPackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.devinternationalcollege.R;
import com.example.devinternationalcollege.StartingActivities.CoursesActivity;

public class MSCYearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mscyear);
        setupButton(R.id.MSCPreYearClick, "mscchempre.pdf");
        setupButton(R.id.MSCFinalYearClick, "mscchemfinal.pdf");
        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MSCYearActivity.this, CoursesActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void setupButton(int buttonId, String pdfFileName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MSCYearActivity.this, MSCAllYearPDFActivity.class);
            intent.putExtra("pdf_file", pdfFileName);  // Pass PDF file name
            startActivity(intent);
        });
    }
}