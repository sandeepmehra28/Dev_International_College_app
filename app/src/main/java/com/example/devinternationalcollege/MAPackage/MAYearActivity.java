package com.example.devinternationalcollege.MAPackage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.devinternationalcollege.R;
import com.example.devinternationalcollege.StartingActivities.CoursesActivity;

public class MAYearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mayear);
        TextView preYear = findViewById(R.id.PreYearClick);
        TextView finalYear = findViewById(R.id.FinalYearClick);
        preYear.setOnClickListener(view -> {
            Intent intent =new Intent(MAYearActivity.this, MAPreYearActivity.class);
            startActivity(intent);});
        finalYear.setOnClickListener(view -> {
            Intent intent = new Intent(MAYearActivity.this, MAFinalYearActivity.class);
            startActivity(intent);});
        Button backBtnClick = findViewById(R.id.backBtnClick);
        backBtnClick.setOnClickListener(view -> {
            Intent intent =new Intent(MAYearActivity.this, CoursesActivity.class);
            startActivity(intent);
            finish();
        });
    }
}