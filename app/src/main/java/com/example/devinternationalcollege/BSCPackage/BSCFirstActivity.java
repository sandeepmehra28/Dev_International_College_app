package com.example.devinternationalcollege.BSCPackage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devinternationalcollege.R;

public class BSCFirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bscfirst);
        //this is for all the buttons in the activity and their respective pdf files
        setupButton(R.id.bscMathFirstYearClick, "bscmathpart1.pdf");
        setupButton(R.id.bscChemFirstYearClick, "bscchemistrypart1.pdf");
        setupButton(R.id.bscPhysFirstYearClick, "bscphysicspart1.pdf");
        setupButton(R.id.bscBotFirstYearClick, "bscbotanypart1.pdf");
        setupButton(R.id.bscChem2FirstYearClick, "bscchemistrypart1.pdf");
        setupButton(R.id.bscZooFirstYearClick, "bsczoologypart1.pdf");
    }
    //when we click any set up button it will open the pdf file
    private void setupButton(int buttonId, String pdfFileName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(BSCFirstActivity.this, BSCFirstPDFActivity.class);
            intent.putExtra("pdf_file", pdfFileName);  // Pass PDF file name
            startActivity(intent);
        });
    }
}