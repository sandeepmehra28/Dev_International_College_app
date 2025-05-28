package com.example.devinternationalcollege.BCACourse;

import android.os.Bundle;
import android.view.View;
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

public class DeleteDataActivity extends AppCompatActivity {

    EditText etNameToDelete;
    Button btnDelete;

    interface DeleteApiInterface {
        @FormUrlEncoded
        @POST("students_delete_data.php") // Make sure this matches your PHP file
        Call<String> deleteUser(@Field("FIRST-NAME") String fname);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete_data);

        etNameToDelete = findViewById(R.id.etNameToDelete);
        btnDelete = findViewById(R.id.btnDelete);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.29.110/DevInterCollProject/") // Match insertData base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DeleteApiInterface deleteApi = retrofit.create(DeleteApiInterface.class);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etNameToDelete.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(DeleteDataActivity.this, "Enter first name to delete", Toast.LENGTH_SHORT).show();
                    return;
                }

                Call<String> call = deleteApi.deleteUser(name);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(DeleteDataActivity.this, "Deleted successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(DeleteDataActivity.this, "Deletion failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(DeleteDataActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
