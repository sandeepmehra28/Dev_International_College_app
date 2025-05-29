package com.example.devinternationalcollege.BSCPackage;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devinternationalcollege.R;
import com.github.barteksc.pdfviewer.PDFView;

public class BSCFinalPDFActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bscfinal_pdfactivity);
        PDFView pdfView = findViewById(R.id.pdfViewfinalbsc);
        String pdfFile = getIntent().getStringExtra("pdf_file");

        if (pdfFile != null) {
            pdfView.fromAsset(pdfFile)
                    .enableSwipe(true)
                    .swipeHorizontal(false)
                    .enableDoubletap(true)
                    .load();
        }
    }
}