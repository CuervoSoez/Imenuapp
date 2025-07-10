package com.example.imenuapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnSignIn;
    private TextView tvSignUp, tvForgot;
    private ImageView btnFacebook, btnInstagram, btnTwitter, btnGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvSignUp = findViewById(R.id.tvSignUp);
        tvForgot = findViewById(R.id.tvForgot);

        btnFacebook = findViewById(R.id.btnFacebook);
        btnInstagram = findViewById(R.id.btnInstagram);
        btnTwitter = findViewById(R.id.btnTwitter);
        btnGoogle = findViewById(R.id.btnGoogle);

        btnSignIn.setOnClickListener(v -> {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Iniciando sesión con " + email, Toast.LENGTH_SHORT).show();
            }
        });

        tvSignUp.setOnClickListener(v -> {
            Toast.makeText(this, "Ir a registro", Toast.LENGTH_SHORT).show();
        });

        tvForgot.setOnClickListener(v -> {
            Toast.makeText(this, "Recuperar contraseña", Toast.LENGTH_SHORT).show();
        });

        btnFacebook.setOnClickListener(v -> Toast.makeText(this, "Login con Facebook", Toast.LENGTH_SHORT).show());
    }
}
