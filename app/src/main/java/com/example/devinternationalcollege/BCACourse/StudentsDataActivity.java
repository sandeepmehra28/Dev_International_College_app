package com.example.devinternationalcollege.BCACourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    TextView textView;
    MyApiInterface api;
    public interface MyApiInterface {
        @GET("students_fetch_data.php")
        Call<List<UserData>> getData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_students_data);

        textView = findViewById(R.id.TextViewId);
        Button backBtn = findViewById(R.id.backToBCAActivity);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentsDataActivity.this,bcaFinalYearActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button deleteBtn = findViewById(R.id.DeleteDataBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentsDataActivity.this, DeleteDataActivity.class));
            }
        });

        Button insertDataBtn = findViewById(R.id.InsertDataBtn);
        insertDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentsDataActivity.this, InsertingDataActivity.class));
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.29.110/DevInterCollProject/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(MyApiInterface.class);
        fetchData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData(); // Refresh the data when returning
    }

    private void fetchData() {
        Call<List<UserData>> call = api.getData();

        call.enqueue(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                if (response.isSuccessful()) {
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
                    textView.setText(sb.toString());
                } else {
                    textView.setText("Response Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {
                textView.setText("Error: " + t.getMessage());
            }
        });
    }
}
