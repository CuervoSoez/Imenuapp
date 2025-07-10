package com.example.bitebyte.model;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bitebyte.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrarUsuarioActivity extends AppCompatActivity {

    private EditText editUsername, editNickname, editPassword;
    private Spinner spinnerRol;
    private Button btnRegistrar;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference refUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_usuario);

        editUsername = findViewById(R.id.ruUsername);
        editNickname = findViewById(R.id.ruNickname);
        editPassword = findViewById(R.id.ruPassword);
        spinnerRol = findViewById(R.id.ruRol);
        btnRegistrar = findViewById(R.id.ruRegistrar);

        firebaseAuth = FirebaseAuth.getInstance();
        refUsuarios = FirebaseDatabase.getInstance().getReference("usuarios");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.roles_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRol.setAdapter(adapter);

        btnRegistrar.setOnClickListener(v -> registrarUsuario());
    }

    private void registrarUsuario() {
        String username = editUsername.getText().toString().trim();
        String nickname = editNickname.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        String rol = spinnerRol.getSelectedItem().toString();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(nickname) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        String userId = firebaseAuth.getCurrentUser().getUid();
                        Usuario nuevoUsuario = new Usuario(username, nickname, rol);
                        refUsuarios.child(userId).setValue(nuevoUsuario);
                        Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        String mensajeError = task.getException() != null ? task.getException().getMessage() : "Error desconocido";
                        Toast.makeText(this, "Error: " + mensajeError, Toast.LENGTH_LONG).show();
                    }
                });
    }

    public static class Usuario {
        public String username;
        public String nickname;
        public String rol;

        public Usuario() {}

        public Usuario(String username, String nickname, String rol) {
            this.username = username;
            this.nickname = nickname;
            this.rol = rol;
        }
    }
}