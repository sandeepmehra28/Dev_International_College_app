package com.example.devinternationalcollege.StartingActivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.devinternationalcollege.R;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        Button fd = findViewById(R.id.findCourse);
        Button lo = findViewById(R.id.logout);
        Button img = findViewById(R.id.image);
        //this is find courses button and it will take you to courses activity
        fd.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, CoursesActivity.class);
            startActivity(intent);finish();});
        //this is logout button and it will take you to login activity
        lo.setOnClickListener(view -> {
            Toast.makeText(HomeActivity.this, "Logout", Toast.LENGTH_SHORT).show();
            Intent intent =new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);finish();});
        //this is image button and it will take you to image activity
        img.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, ImageActivity.class);
            startActivity(intent);finish();});
    }
}