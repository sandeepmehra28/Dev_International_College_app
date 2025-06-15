package com.example.devinternationalcollege.BSCPackage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.devinternationalcollege.R;
public class BSCSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bscsecond);
        //this is for all the buttons in the activity and their respective pdf files
        setupButton(R.id.bscMathSecondYearClick, "bscmathpart2.pdf");
        setupButton(R.id.bscChemSecondYearClick, "bscchemistrypart2.pdf");
        setupButton(R.id.bscPhysSecondYearClick, "bscphysicspart2.pdf");
        setupButton(R.id.bscBotSecondYearClick, "bscbotanypart2.pdf");
        setupButton(R.id.bscChem2SecondYearClick, "bscchemistrypart2.pdf");
        setupButton(R.id.bscZooSecondYearClick, "bsczoologypart2.pdf");
    }
    //when we click any set up button it will open the pdf file
    private void setupButton(int buttonId, String pdfFileName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(BSCSecondActivity.this, BSCSecondPDFActivity.class);
            intent.putExtra("pdf_file", pdfFileName);  // Pass PDF file name
            startActivity(intent);
        });
    }
}