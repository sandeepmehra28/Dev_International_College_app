package com.example.devinternationalcollege.StartingActivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.devinternationalcollege.R;

public class ImageActivity extends AppCompatActivity {
    private final int[] imageDrawables = {
            R.drawable.imf, R.drawable.cg9, R.drawable.cg11, R.drawable.cg12,
            R.drawable.cg8, R.drawable.imfo, R.drawable.imsi, R.drawable.imt, R.drawable.cg10
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image);
        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(ImageActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });

        RecyclerView recyclerView = findViewById(R.id.imageRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ImageAdapter(this, imageDrawables));

    }
    @Override
    public boolean onSupportNavigateUp() {
        finish(); // Go back to previous (Home) activity
        return true;
    }
}