package com.example.devinternationalcollege.BCOMPackage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.devinternationalcollege.R;
import com.example.devinternationalcollege.StartingActivities.CoursesActivity;

public class BCOMAllSubjectsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bcomall_subjects);
        //this is for all the buttons in the activity and their respective pdf files
        TextView EAFMClick = findViewById(R.id.EAFMClick);
        TextView ABSTClick = findViewById(R.id.ABSTClick);
        TextView BADLClick = findViewById(R.id.BADLClick);
        EAFMClick.setOnClickListener(view -> {
            Intent intent =new Intent(BCOMAllSubjectsActivity.this, EAFMSemesterActivity.class);
            startActivity(intent);});
    }
}