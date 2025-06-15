package com.example.devinternationalcollege.StartingActivities;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.devinternationalcollege.BAPackage.BASemesterActivity;
import com.example.devinternationalcollege.BCACourse.bcaYearActivity;
import com.example.devinternationalcollege.BCOMPackage.BCOMAllSubjectsActivity;
import com.example.devinternationalcollege.BSCPackage.BSCYearActivity;
import com.example.devinternationalcollege.MAPackage.MAYearActivity;
import com.example.devinternationalcollege.MSCPackage.MSCYearActivity;
import com.example.devinternationalcollege.R;

public class CoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_courses);
        //card view for all the courses
        //this is B.A subject card
        CardView BAClick = findViewById(R.id.cardFC_BA);
        BAClick.setOnClickListener(view -> {
            Intent intent=new Intent(CoursesActivity.this, BASemesterActivity.class);
            startActivity(intent);});
        //this is BCA subject card
        CardView BCAClick = findViewById(R.id.card_BCA);
        BCAClick.setOnClickListener(view -> {
            Intent intent=new Intent(CoursesActivity.this, bcaYearActivity.class);
            startActivity(intent);});
        //this is MA subject card
        CardView MAClick = findViewById(R.id.cardFC_MA);
        MAClick.setOnClickListener(view -> {
            Intent intent =new Intent(CoursesActivity.this, MAYearActivity.class);
            startActivity(intent);});
        //this is BSC subject card
        CardView BSCClick = findViewById(R.id.cardFC_BSC);
        BSCClick.setOnClickListener(view -> {
            Intent intent =new Intent(CoursesActivity.this, BSCYearActivity.class);
            startActivity(intent);});
        //this is MSC subject card
        CardView MSCClick = findViewById(R.id.cardFC_MSE);
        MSCClick.setOnClickListener(view -> {
            Intent intent = new Intent(CoursesActivity.this, MSCYearActivity.class);
            startActivity(intent);});
        //this is BCOM subject card
        CardView BCOMClick = findViewById(R.id.cardFC_BCOM);
        BCOMClick.setOnClickListener(view -> {
            Intent intent = new Intent(CoursesActivity.this, BCOMAllSubjectsActivity.class);
            startActivity(intent);});
    }
}