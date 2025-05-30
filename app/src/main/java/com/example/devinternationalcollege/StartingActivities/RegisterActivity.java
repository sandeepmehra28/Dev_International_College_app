package com.example.devinternationalcollege.StartingActivities;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.devinternationalcollege.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    EditText email,password;
    TextView exUser;
    Button register,back;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        email=findViewById(R.id.editTextRegEmail);
        password=findViewById(R.id.editTextRegPassword);
        register=findViewById(R.id.buttonRegister);
        exUser=findViewById(R.id.textViewExistingUser);
        back=findViewById(R.id.buttonBack);
        auth=FirebaseAuth.getInstance();
        register.setOnClickListener(view -> {
            String txt_email =email.getText().toString();
            String txt_password =password.getText().toString();
            if (!isConnectedToInternet()) {
                Toast.makeText(RegisterActivity.this, "Please connect your internet", Toast.LENGTH_SHORT).show();
            }
            else if(TextUtils.isEmpty(txt_email)||TextUtils.isEmpty(txt_password)){
                Toast.makeText(RegisterActivity.this,"Please fill all the fields",Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(txt_email)) {
                Toast.makeText(RegisterActivity.this,"Please enter email",Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(txt_password)) {
                Toast.makeText(RegisterActivity.this,"Please enter password",Toast.LENGTH_SHORT).show();
            } else if (!isValidEmail(txt_email)) {
                Toast.makeText(RegisterActivity.this,"please enter a valid email!",Toast.LENGTH_SHORT).show();
            } else if (txt_password.length()<6) {
                Toast.makeText(RegisterActivity.this, "password is too sort!", Toast.LENGTH_SHORT).show();
            }
            else {registerUser(txt_email,txt_password);}
        });
        exUser.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);finish();});
        back.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);finish();});
    }
    private boolean isConnectedToInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        if (connectivityManager == null) return false;
        Network network = connectivityManager.getActiveNetwork();
        if (network == null) return false;
        NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(network);
        return capabilities != null && (
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
        );
    }
    private void registerUser(String txtEmail, String txtPassword) {
        auth.createUserWithEmailAndPassword(txtEmail,txtPassword).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Toast.makeText(RegisterActivity.this,"Register created",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }else{
                Exception e = task.getException();
                if (e instanceof FirebaseAuthUserCollisionException) {
                    Toast.makeText(RegisterActivity.this, "User already exists with this email", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "Registration failed: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private boolean isValidEmail(String txtEmail) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return Pattern.matches(regex, txtEmail);
    }
}