package com.example.devinternationalcollege.BSCPackage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devinternationalcollege.R;

public class BSCFinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bscfinal);
        //this is for all the buttons in the activity and their respective pdf files
        setupButton(R.id.bscMathFinalYearClick, "bscmathpart3.pdf");
        setupButton(R.id.bscChemFinalYearClick, "bscchemistrypart3.pdf");
        setupButton(R.id.bscPhysFinalYearClick, "bscphysicspart3.pdf");
        setupButton(R.id.bscBotFinalYearClick, "bscbotanypart3.pdf");
        setupButton(R.id.bscChem2FinalYearClick, "bscchemistrypart3.pdf");
        setupButton(R.id.bscZooFinalYearClick, "bsczoologypart3.pdf");
    }
    //when we click any set up button it will open the pdf file
    private void setupButton(int buttonId, String pdfFileName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(BSCFinalActivity.this, BSCFinalPDFActivity.class);
            intent.putExtra("pdf_file", pdfFileName);  // Pass PDF file name
            startActivity(intent);
        });
    }
}