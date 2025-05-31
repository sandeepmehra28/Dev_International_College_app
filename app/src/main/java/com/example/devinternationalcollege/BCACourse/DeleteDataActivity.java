package com.example.devinternationalcollege.BCACourse;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devinternationalcollege.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class DeleteDataActivity extends AppCompatActivity {

    EditText etNameToDelete;
    Button btnDelete;
    DeleteApiInterface deleteApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);
       //we assign ids to the buttons and textviews
        etNameToDelete = findViewById(R.id.etNameToDelete);
        btnDelete = findViewById(R.id.btnDelete);
       //create a retrofit instance and set the base url
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.29.110/DevInterCollProject/")
                .addConverterFactory(ScalarsConverterFactory.create()) // Scalars for plain text
                .build();
        //create an instance of the DeleteApiInterface using the retrofit instance
        deleteApi = retrofit.create(DeleteApiInterface.class);
        btnDelete.setOnClickListener(v -> {
            String name = etNameToDelete.getText().toString().trim().toUpperCase(); // Convert to uppercase

            if (name.isEmpty()) {
                Toast.makeText(this, "Enter name to delete", Toast.LENGTH_SHORT).show();
                return;
            }

            // 🔒 Confirmation dialog
            new AlertDialog.Builder(DeleteDataActivity.this)
                    .setTitle("Confirm Deletion")
                    .setMessage("Are you sure you want to delete \"" + name + "\"?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        // 🔁 Proceed with deletion
                        deleteApi.deleteUser(name).enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                if (response.isSuccessful() && response.body() != null) {
                                    Toast.makeText(DeleteDataActivity.this, response.body(), Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(DeleteDataActivity.this, "Deletion failed. Please try again.", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Toast.makeText(DeleteDataActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    })
                    .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                    .show();
        });
    }
}
