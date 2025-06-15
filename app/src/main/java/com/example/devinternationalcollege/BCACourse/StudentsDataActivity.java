package com.example.devinternationalcollege.BCACourse;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.devinternationalcollege.R;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class StudentsDataActivity extends AppCompatActivity {
    // Declare TextView to display user data
    TextView textView;
    // Declare the API interface
    MyApiInterface api;
    // Retrofit interface for GET request to fetch student data
    public interface MyApiInterface {
        @GET("students_fetch_data.php")// Endpoint of the PHP file
        Call<List<UserData>> getData();// Expected to return a list of UserData
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_students_data);
        textView = findViewById(R.id.TextViewId);
        // "Back" button click to navigate back to final year activity
        Button backBtn = findViewById(R.id.backToBCAActivity);
        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(StudentsDataActivity.this,bcaFinalYearActivity.class);
            startActivity(intent);
            finish();});
        // DeleteDataActivity when "Delete" button is clicked
        Button deleteBtn = findViewById(R.id.DeleteDataBtn);
        deleteBtn.setOnClickListener(view -> startActivity
                (new Intent(StudentsDataActivity.this, DeleteDataActivity.class)));
        //InsertingDataActivity when "Insert" button is clicked
        Button insertDataBtn = findViewById(R.id.InsertDataBtn);
        insertDataBtn.setOnClickListener(view -> startActivity
                (new Intent(StudentsDataActivity.this, InsertingDataActivity.class)));
        // Initialize Retrofit for network communication
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.29.110/DevInterCollProject/")// Base URL of the API
                .addConverterFactory(GsonConverterFactory.create())// Use Gson to convert JSON
                .build();
        // Create API interface using Retrofit
        api = retrofit.create(MyApiInterface.class);
        fetchData();   // Fetch student data initially when activity is created
    }
    @Override
    protected void onResume() {
        super.onResume();
        fetchData(); // Refresh the data when returning
    }
    // Method to fetch student data using Retrofit
    private void fetchData() {
        // Make asynchronous network call
        Call<List<UserData>> call = api.getData();
        call.enqueue(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                if (response.isSuccessful()) {
                    // Get list of users from response
                    List<UserData> data = response.body();
                    StringBuilder sb = new StringBuilder();
                    for (UserData user : data) {
                        sb.append("ID: ").append(user.getId()).append("\n")
                                .append("First Name: ").append(user.getFname()).append("\n")
                                .append("Last Name: ").append(user.getLname()).append("\n")
                                .append("Email: ").append(user.getEmail()).append("\n")
                                .append("Mobile Number: ").append(user.getMnumber()).append("\n")
                                .append("Address: ").append(user.getAddress()).append("\n")
                                .append("Skills: ").append(user.getSkills()).append("\n\n");
                    }
                    // Display user data in the TextView
                    textView.setText(sb.toString());
                } else {textView.setText("Response Code: " + response.code());}
            }
            // Show error message in case of failure
            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t){textView.setText("Error: " + t.getMessage());}
        });
    }
}
