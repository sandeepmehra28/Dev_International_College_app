package com.example.devinternationalcollege.BAPackage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.devinternationalcollege.R;

public class BASemesterSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_basemester_second);
        setupButton(R.id.geoSem2Btn, "bageosem1and2.pdf");
        setupButton(R.id.geoHons2Btn, "bageohon1and2.pdf");
        setupButton(R.id.historySem2Btn, "bahistory1and2.pdf");
        setupButton(R.id.homeSciSub2Btn, "bahomescisem1and2.pdf");
        setupButton(R.id.hindiSem2Btn, "bahindi1and2.pdf");
        setupButton(R.id.musicSitarSem2Btn, "bamusic1and2sitar.pdf");
        setupButton(R.id.musicVocalsSem2Btn, "bamusic1and2vocal.pdf");
        setupButton(R.id.ecoSem2Btn, "baeco1234.pdf");
        setupButton(R.id.PolSciSem2Btn, "bapoliticalscience1and2.pdf");
        setupButton(R.id.phyEduSem2Btn, "baphysicaleducation1and2.pdf");
        setupButton(R.id.englishSem2Btn, "baenglish2.pdf");
        setupButton(R.id.drawandpaintSem2Btn, "badrawingandpainting1and2.pdf");
        Button backBtn2 = findViewById(R.id.backBtn2Subjects);
        backBtn2.setOnClickListener(view -> {
            Intent intent =new Intent(BASemesterSecondActivity.this, BASemesterActivity.class);
            startActivity(intent);
            finish();
        });
    }
    private void setupButton(int buttonId, String pdfFileName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(BASemesterSecondActivity.this, BASEMSECONDPDFViewActivity.class);
            intent.putExtra("pdf_file", pdfFileName);  // Pass PDF file name
            startActivity(intent);
        });
    }
}