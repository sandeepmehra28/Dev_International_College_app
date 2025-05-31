package com.example.devinternationalcollege.BSCPackage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.example.devinternationalcollege.R;
import com.example.devinternationalcollege.StartingActivities.CoursesActivity;

public class BSCYearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bscyear);
        //we assign the id to their respective activities
        TextView firstYear = findViewById(R.id.bscFirstYearClick);
        TextView secondYear = findViewById(R.id.bscSecondYearClick);
        TextView finalYear = findViewById(R.id.bscFinalYearClick);
        Button backBtn = findViewById(R.id.backBtnClick);
        firstYear.setOnClickListener(view -> {
            Intent intent = new Intent(BSCYearActivity.this, BSCFirstActivity.class);
            startActivity(intent);
        });
        secondYear.setOnClickListener(view -> {
            Intent intent  =new Intent(BSCYearActivity.this, BSCSecondActivity.class);
            startActivity(intent);
        });
        finalYear.setOnClickListener(view -> {
            Intent intent =new Intent(BSCYearActivity.this, BSCFinalActivity.class);
            startActivity(intent);
        });
        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(BSCYearActivity.this, CoursesActivity.class);
            startActivity(intent);
            finish();
        });
    }
}