package com.example.devinternationalcollege.BAPackage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devinternationalcollege.R;

public class BASemesterThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_basemester_third);
        setupButton(R.id.hindiSem3Btn, "bahindisem3.pdf");
        setupButton(R.id.englishSem3Btn, "baengsem3.pdf");
        setupButton(R.id.geoSem3Btn, "bageosem3and4.pdf");
        setupButton(R.id.geoHonsSem3Btn, "bageohon3and4.pdf");
        setupButton(R.id.homeScisem3Btn, "bahomescisem3.pdf");
        setupButton(R.id.historySem3Btn, "bahistory3and4.pdf");
        setupButton(R.id.musicSitarSem3Btn, "bamusic3and4sitar.pdf");
        setupButton(R.id.musicVocalsSem3Btn, "bamusic3and4vocal.pdf");
        setupButton(R.id.ecoSem3Btn, "baeco1234.pdf");
        setupButton(R.id.PolSciSem3Btn, "bapoliticalscience3and4.pdf");
        setupButton(R.id.phyEduSem3Btn, "baphysicaleducation3and4.pdf");
        setupButton(R.id.drawandpaintSem3Btn, "badrawingandpainting3and4.pdf");
        Button backBtn3 = findViewById(R.id.backBtn3Subjects);
        backBtn3.setOnClickListener(view -> {
            Intent intent =new Intent(BASemesterThirdActivity.this, BASemesterActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void setupButton(int buttonId, String pdfFileName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(BASemesterThirdActivity.this, BASEMTHIRDPDFViewActivity.class);
            intent.putExtra("pdf_file", pdfFileName);  // Pass PDF file name
            startActivity(intent);
        });
    }
}