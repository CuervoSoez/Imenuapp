package com.example.imenuapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrarPedidoActivity extends AppCompatActivity {

    private EditText etNombreCliente, etCantidad;
    private Spinner spinnerPlatos;
    private Button btnRegistrar;
    private TextView tvConfirmacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_pedido);

        etNombreCliente = findViewById(R.id.etNombreCliente);
        etCantidad = findViewById(R.id.etCantidad);
        spinnerPlatos = findViewById(R.id.spinnerPlatos);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        tvConfirmacion = findViewById(R.id.tvConfirmacion);

        String[] platos = {"Lasaña", "Pizza", "Ensalada"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, platos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlatos.setAdapter(adapter);

        btnRegistrar.setOnClickListener(v -> {
            String cliente = etNombreCliente.getText().toString();
            String plato = spinnerPlatos.getSelectedItem().toString();
            String cantidad = etCantidad.getText().toString();
            
            MenuItem item = (MenuItem) spinnerPlatos.getSelectedItem();
            int cantidad = Integer.parseInt(etCantidad.getText().toString());

            for (int i = 0; i < cantidad; i++) {
                CartManager.getInstance().addItem(item);
            }

            tvConfirmacion.setText("Pedido añadido. Total actual: $" + CartManager.getInstance().getTotal());
        });
    }
}
