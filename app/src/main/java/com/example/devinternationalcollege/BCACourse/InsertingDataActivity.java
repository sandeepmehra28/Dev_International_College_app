package com.example.devinternationalcollege.BCACourse;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devinternationalcollege.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class InsertingDataActivity extends AppCompatActivity {
 //declare variables and button.
    EditText fname, lname, email, mnumber, address, skills;
    Button btnInsert;

    // Define API interface
    interface InsertApi {
        @FormUrlEncoded
        @POST("students_insert_data.php") // Make sure this matches your PHP filename
        Call<String> insertUser(
                @Field("FIRST-NAME") String fname,
                @Field("LAST-NAME") String lname,
                @Field("EMAIL") String email,
                @Field("MOBILE-NUMBER") String mnumber,
                @Field("ADDRESS") String address,
                @Field("SKILLS") String skills
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inserting_data);

        // Match your EditText fields with layout IDs
        fname = findViewById(R.id.etFname);
        lname = findViewById(R.id.etLname);
        email = findViewById(R.id.etEmail);
        mnumber = findViewById(R.id.etMnumber);
        address = findViewById(R.id.etAddress);
        skills = findViewById(R.id.etSkills);
        btnInsert = findViewById(R.id.btnInsert);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.29.110/DevInterCollProject/") // match your PHP server path
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InsertApi insertApi = retrofit.create(InsertApi.class);

        btnInsert.setOnClickListener(view -> {
            // Read input from form
            String f = fname.getText().toString();
            String l = lname.getText().toString();
            String e = email.getText().toString();
            String m = mnumber.getText().toString();
            String a = address.getText().toString();
            String s = skills.getText().toString();

            // Call API
            Call<String> call = insertApi.insertUser(f, l, e, m, a, s);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(InsertingDataActivity.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(InsertingDataActivity.this, "Insert failed", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(InsertingDataActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        });
    }
}
