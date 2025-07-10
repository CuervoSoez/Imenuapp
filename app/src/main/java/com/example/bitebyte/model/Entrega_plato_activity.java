package com.example.imenuapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EntregaPlatoActivity extends AppCompatActivity {

    private TextView tvNombrePlato, tvEstado;
    private ImageView imgPlato;
    private Button btnEntregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrega_plato);

        tvNombrePlato = findViewById(R.id.tvNombrePlato);
        tvEstado = findViewById(R.id.tvEstado);
        imgPlato = findViewById(R.id.imgPlato);
        btnEntregar = findViewById(R.id.btnEntregar);

        btnEntregar.setOnClickListener(v -> {
            tvEstado.setText("Pedido entregado");
            btnEntregar.setEnabled(false);
        });
    }
} 
