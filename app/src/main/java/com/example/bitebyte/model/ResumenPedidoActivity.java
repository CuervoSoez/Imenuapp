package com.example.imenuapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResumenPedidoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MenuItemAdapter adapter;
    private TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_pedido);

        recyclerView = findViewById(R.id.recyclerViewResumen);
        tvTotal = findViewById(R.id.tvTotal);

        // Obtener items del carrito
        List<MenuItem> pedidos = CartManager.getInstance().getItems();

        // Configurar RecyclerView
        adapter = new MenuItemAdapter(pedidos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Mostrar total
        double total = CartManager.getInstance().getTotal();
        tvTotal.setText("Total: $" + total);
    }
}
