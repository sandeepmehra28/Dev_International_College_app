package com.example.devinternationalcollege.BAPackage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.devinternationalcollege.R;

public class BASemesterFourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_basemester_fourth);
        //this is for all the buttons in the activity and their respective pdf files
        setupButton(R.id.hindiSem4Btn, "bahindisem4.pdf");
        setupButton(R.id.englishSem4Btn, "baengsem4.pdf");
        setupButton(R.id.geoSem4Btn, "bageosem3and4.pdf");
        setupButton(R.id.geoHonsSem4Btn, "bageosem3and4.pdf");
        setupButton(R.id.homeScisem4Btn, "bahomescisem4.pdf");
        setupButton(R.id.historySem4Btn, "bahistory3and4.pdf");
        setupButton(R.id.musicSitarSem4Btn, "bamusic3and4sitar.pdf");
        setupButton(R.id.musicVocalsSem4Btn, "bamusic3and4vocal.pdf");
        setupButton(R.id.ecoSem4Btn, "baeco1234.pdf");
        setupButton(R.id.PolSciSem4Btn, "bapoliticalscience3and4.pdf");
        setupButton(R.id.phyEduSem4Btn, "baphysicaleducation3and4.pdf");
        setupButton(R.id.drawandpaintSem4Btn, "badrawingandpainting3and4.pdf");
        Button backBtn4 = findViewById(R.id.backBtn4Subjects);
        backBtn4.setOnClickListener(view -> {
            Intent intent =new Intent(BASemesterFourthActivity.this, BASemesterActivity.class);
            startActivity(intent);
            finish();
        });
    }
    //when we click any set up button it will open the pdf file
    private void setupButton(int buttonId, String pdfFileName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(BASemesterFourthActivity.this, BASEMFOURTHPDFViewActivity.class);
            intent.putExtra("pdf_file", pdfFileName);  // Pass PDF file name
            startActivity(intent);
        });
    }
}