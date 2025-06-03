package com.example.devinternationalcollege.StartingActivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.devinternationalcollege.R;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about);
//        Button backBtn = findViewById(R.id.backToHome);
//        backBtn.setOnClickListener(view -> {
//            //this is Intent to go to Login Activity
//            Intent intent = new Intent(AboutActivity.this, LoginActivity.class);
//            startActivity(intent);finish();});
    }
}
//this is about-activity and can they show the logo and welcome message in your screen