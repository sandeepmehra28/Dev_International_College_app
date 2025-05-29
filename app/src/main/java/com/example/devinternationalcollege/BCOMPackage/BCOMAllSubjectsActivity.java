package com.example.devinternationalcollege.BCOMPackage;

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

public class BCOMAllSubjectsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bcomall_subjects);
        TextView EAFMClick = findViewById(R.id.EAFMClick);
        TextView ABSTClick = findViewById(R.id.ABSTClick);
        TextView BADLClick = findViewById(R.id.BADLClick);
        Button backBtn = findViewById(R.id.backBtn);
        EAFMClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(BCOMAllSubjectsActivity.this, EAFMSemesterActivity.class);
                startActivity(intent);
                finish();
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BCOMAllSubjectsActivity.this, CoursesActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}