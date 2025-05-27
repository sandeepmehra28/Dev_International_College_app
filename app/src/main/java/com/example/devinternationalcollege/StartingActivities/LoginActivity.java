package com.example.devinternationalcollege.StartingActivities;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.devinternationalcollege.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    Button logBtn,newRegister;
    TextView aboutBtn;
    EditText logemail,logpassword;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        newRegister = findViewById(R.id.textView3newUser);
        logemail=findViewById(R.id.LoginUsername);
        logpassword=findViewById(R.id.LoginPassword);
        logBtn=findViewById(R.id.buttonLogin);
        aboutBtn=findViewById(R.id.aboutClick);
        auth= FirebaseAuth.getInstance();
        newRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(LoginActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String txt_email = logemail.getText().toString();
//                String txt_pass = logpassword.getText().toString();
//                if (!isConnectedToInternet()) {
//                    Toast.makeText(LoginActivity.this, "Please connect your internet", Toast.LENGTH_SHORT).show();
//                    return;
//                } else if (txt_email.isEmpty() || txt_pass.isEmpty()) {
//                    Toast.makeText(LoginActivity.this,"Please fill all the fields",Toast.LENGTH_SHORT).show();
//                }else if(!isValidEmail(txt_email)){
//                    Toast.makeText(LoginActivity.this,"please enter a valid email!",Toast.LENGTH_SHORT).show();
//                } else if (txt_pass.length()<6) {
//                    Toast.makeText(LoginActivity.this,"password is too sort!",Toast.LENGTH_SHORT).show();
//                }else {
//                    loginUser(txt_email,txt_pass);
//                }
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void loginUser(String txtEmail, String txtPass) {
        auth.signInWithEmailAndPassword(txtEmail,txtPass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this,"Logged in!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean isValidEmail(String txtEmail) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return Pattern.matches(regex, txtEmail);
    }

    private boolean isConnectedToInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        // If the connectivity manager is not available, return false
        if (connectivityManager == null) return false;

        // For devices with API >= 23 (Android M)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Network network = connectivityManager.getActiveNetwork();
            if (network == null) return false;

            // Get the network capabilities and check if it has internet connectivity
            NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(network);
            return capabilities != null && (
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
            );
        } else {
            // For devices with API < 23 (older versions)
            android.net.NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        }
    }
}