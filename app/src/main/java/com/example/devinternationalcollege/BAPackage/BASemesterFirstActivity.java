package com.example.devinternationalcollege.BAPackage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.devinternationalcollege.R;

public class BASemesterFirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_basemester_first);
        //this is for all the buttons in the activity and their respective pdf files
        setupButton(R.id.geoSemBtn, "bageosem1and2.pdf");
        setupButton(R.id.geoHonsBtn, "bageohon1and2.pdf");
        setupButton(R.id.historySemBtn, "bahistory1and2.pdf");
        setupButton(R.id.homeSciSemBtn, "bahomescisem1and2.pdf");
        setupButton(R.id.hindiSemBtn, "bahindi1and2.pdf");
        setupButton(R.id.musicSitarSemBtn, "bamusic1and2sitar.pdf");
        setupButton(R.id.musicVocalsSemBtn, "bamusic1and2vocal.pdf");
        setupButton(R.id.ecoSemBtn, "baeco1234.pdf");
        setupButton(R.id.PolSciSemBtn, "bapoliticalscience1and2.pdf");
        setupButton(R.id.phyEduSemBtn, "baphysicaleducation1and2.pdf");
        setupButton(R.id.englishSemBtn, "baenglish1.pdf");
        //this is back button to go to previous activity
        Button backBtn = findViewById(R.id.backBtn1Subjects);
        backBtn.setOnClickListener(view -> {
            Intent intent =new Intent(BASemesterFirstActivity.this, BASemesterActivity.class);
            startActivity(intent);finish();});
    }
    private void setupButton(int buttonId, String pdfFileName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(BASemesterFirstActivity.this, BASEMFIRSTPDFViewActivity.class);
            intent.putExtra("pdf_file", pdfFileName);startActivity(intent);});
    }
}