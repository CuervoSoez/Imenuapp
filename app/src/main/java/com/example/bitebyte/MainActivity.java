package com.example.bitebyte;


import com.google.firebase.FirebaseApp;
import android.os.Bundle;
import android.util.Log;
import com.example.bitebyte.GestionUsuarios;
import com.example.bitebyte.GestionOrdenes;
import com.google.firebase.database.FirebaseDatabase;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {

    private GestionUsuarios gestorUsuarios;
    private GestionOrdenes gestorOrdenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseApp.initializeApp(this);

        FirebaseDatabase.getInstance()
                .getReference("prueba")
                .setValue("Hola Firebase");

        setContentView(R.layout.activity_main);

        gestorUsuarios = new GestionUsuarios();
        gestorOrdenes = new GestionOrdenes();

        gestorUsuarios.agregarUsuario(new Usuario("1", "Ana", "mesero"));
        Usuario usuario = gestorUsuarios.obtenerUsuario("1");

        Orden orden = new Orden("o1", usuario.getId());
        orden.agregarPlato(new Plato("Pizza", "Queso y tomate", 9.99));
        gestorOrdenes.agregarOrden(orden);

        gestorOrdenes.actualizarEstado("o1", EstadoOrden.EN_PREPARACION);

        Log.d("MainActivity", "Usuario: " + usuario.getNombre());
        Log.d("MainActivity", "Estado de orden o1: " + gestorOrdenes.obtenerOrden("o1").getEstado());
    }
}