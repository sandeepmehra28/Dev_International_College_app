package com.example.devinternationalcollege.StartingActivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.devinternationalcollege.BAPackage.BASemesterActivity;
import com.example.devinternationalcollege.BCACourse.bcaYearActivity;
import com.example.devinternationalcollege.BCOMPackage.BCOMAllSubjectsActivity;
import com.example.devinternationalcollege.R;

public class CoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_courses);
        CardView BAClick = findViewById(R.id.cardFC_BA);
        BAClick.setOnClickListener(view -> {
            Intent intent=new Intent(CoursesActivity.this, BASemesterActivity.class);
            startActivity(intent);
        });
        CardView BCAClick = findViewById(R.id.card_BCA);
        BCAClick.setOnClickListener(view -> {
            Intent intent=new Intent(CoursesActivity.this, bcaYearActivity.class);
            startActivity(intent);
        });
//        CardView MAClick = findViewById(R.id.cardFC_MA);
//        MAClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent =new Intent(CoursesActivity.this, MAYearActivity.class);
//                startActivity(intent);
//            }
//        });
//        CardView BSCClick = findViewById(R.id.cardFC_BSC);
//        BSCClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent =new Intent(CoursesActivity.this, BSCYearActivity.class);
//                startActivity(intent);
//            }
//        });
//        CardView MSCClick = findViewById(R.id.cardFC_MSE);
//        MSCClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(CoursesActivity.this, MSCYearActivity.class);
//                startActivity(intent);
//            }
//        });
        CardView BCOMClick = findViewById(R.id.cardFC_BCOM);
        BCOMClick.setOnClickListener(view -> {
            Intent intent = new Intent(CoursesActivity.this, BCOMAllSubjectsActivity.class);
            startActivity(intent);
            finish();
        });
        Button backBtn = findViewById(R.id.buttonBackintopcourses);
        backBtn.setOnClickListener(view -> {
            Intent intent =new Intent(CoursesActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });
    }
}