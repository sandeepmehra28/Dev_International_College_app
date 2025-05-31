package com.example.devinternationalcollege.BAPackage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devinternationalcollege.R;
import com.example.devinternationalcollege.StartingActivities.CoursesActivity;

public class BASemesterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_basemester);

        //set id for buttons and textview
        Button backBtn = findViewById(R.id.backBtn);
        TextView firstSem = findViewById(R.id.semfirst);
        TextView secSem = findViewById(R.id.semSecond);
        TextView thirdSem = findViewById(R.id.semThird);
        TextView fourthSem = findViewById(R.id.semfourth);
        firstSem.setOnClickListener(view -> {
            Intent intent =new Intent(BASemesterActivity.this, BASemesterFirstActivity.class);
            startActivity(intent);
        });
        secSem.setOnClickListener(view -> {
            Intent intent =new Intent(BASemesterActivity.this, BASemesterSecondActivity.class);
            startActivity(intent);
        });
        thirdSem.setOnClickListener(view -> {
            Intent intent =new Intent(BASemesterActivity.this, BASemesterThirdActivity.class);
            startActivity(intent);
        });
        fourthSem.setOnClickListener(view -> {
            Intent intent =new Intent(BASemesterActivity.this, BASemesterFourthActivity.class);
            startActivity(intent);
        });
        //back button
        backBtn.setOnClickListener(view -> {
            Intent intent=new Intent(BASemesterActivity.this, CoursesActivity.class);
            startActivity(intent);finish();});
    }
}