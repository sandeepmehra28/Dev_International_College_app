package com.example.devinternationalcollege.BAPackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.devinternationalcollege.R;
import com.example.devinternationalcollege.StartingActivities.CoursesActivity;

public class BASemesterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_basemester);
        Button backBtn = findViewById(R.id.backBtn);
        TextView firstSem = findViewById(R.id.semfirst);
        TextView secSem = findViewById(R.id.semSecond);
        TextView thirdSem = findViewById(R.id.semThird);
        TextView fourthSem = findViewById(R.id.semfourth);
        firstSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(BASemesterActivity.this, BASemesterFirstActivity.class);
                startActivity(intent);
            }
        });
//        secSem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent =new Intent(BASemesterActivity.this, BASemesterSecondActivity.class);
//                startActivity(intent);
//            }
//        });
//        thirdSem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent =new Intent(BASemesterActivity.this, BASemesterThirdActivity.class);
//                startActivity(intent);
//            }
//        });
//        fourthSem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent =new Intent(BASemesterActivity.this, BASemesterFourthActivity.class);
//                startActivity(intent);
//            }
//        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BASemesterActivity.this, CoursesActivity.class);
                startActivity(intent);
            }
        });
    }
}