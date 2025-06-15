package com.example.devinternationalcollege.BCACourse;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devinternationalcollege.R;
public class bcaYearActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bca_year);
        //we assign ids to the buttons and textviews
        TextView firstYear = findViewById(R.id.firstYearbtn);
        TextView secondYear = findViewById(R.id.secondYearbtn);
        TextView finalYear = findViewById(R.id.finalYearbtn);
        firstYear.setOnClickListener(view -> {
            Intent intent =new Intent(bcaYearActivity.this,bcaFirstYearActivity.class);
            startActivity(intent);
        });
        secondYear.setOnClickListener(view -> {
            Intent intent =new Intent(bcaYearActivity.this,bcaSecondYearActivity.class);
            startActivity(intent);
        });
        finalYear.setOnClickListener(view -> {
            Intent intent =new Intent(bcaYearActivity.this, bcaFinalYearActivity.class);
            startActivity(intent);
        });
    }
}