package com.example.devinternationalcollege.StartingActivities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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
            startActivity(intent);});
        //this is logout button and it will take you to login activity
        lo.setOnClickListener(view -> {
            Toast.makeText(HomeActivity.this, "Logout", Toast.LENGTH_SHORT).show();
            Intent intent =new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);finish();});
        //this is image button and it will take you to image activity
        img.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, ImageActivity.class);
            startActivity(intent);});
    }
    public void openMapLink(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/14eyytwiWSB9hy5B9"));
        startActivity(intent);
    }
    public void openUniversityLink(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.univindia.org/ALWARUNIV/"));
        startActivity(intent);
    }

    public void openPaperLink(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uoronline.com/bca.html#google_vignette"));
        startActivity(intent);
    }
}