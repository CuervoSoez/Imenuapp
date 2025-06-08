package com.example.bitebyte;

import android.util.Log;

import com.google.firebase.database.*;
import com.example.bitebyte.Orden;

import java.util.TreeMap;

public class GestionOrdenes {

    private TreeMap<String, Orden> ordenes = new TreeMap<>();
    private DatabaseReference refOrdenes = FirebaseDatabase.getInstance().getReference("ordenes");

    public GestionOrdenes() {
        escucharCambiosOrdenes();
    }

    public void agregarOrden(Orden orden) {
        refOrdenes.child(orden.getIdOrden()).setValue(orden);
    }

    public void borrarOrden(String idOrden) {
        refOrdenes.child(idOrden).removeValue();
    }

    public Orden obtenerOrden(String idOrden) {
        return ordenes.get(idOrden);
    }

    public void actualizarEstado(String idOrden, EstadoOrden nuevoEstado) {
        refOrdenes.child(idOrden).child("estado").setValue(nuevoEstado);
    }

    private void escucharCambiosOrdenes() {
        refOrdenes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                ordenes.clear();
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Orden orden = ds.getValue(Orden.class);
                    if (orden != null) {
                        ordenes.put(orden.getIdOrden(), orden);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.e("GestionOrdenes", "Error al leer órdenes: " + error.getMessage());
            }
        });
    }
}