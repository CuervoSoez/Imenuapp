package com.example.bitebyte;

import java.io.Serializable;
import java.util.ArrayList;

public class Orden implements Serializable {

    private String idOrden;
    private String idUsuario;
    private ArrayList<Plato> platosSeleccionados;
    private EstadoOrden estado;

    public Orden() {
    }

    public Orden(String idOrden, String idUsuario) {
        this.idOrden = idOrden;
        this.idUsuario = idUsuario;
        this.platosSeleccionados = new ArrayList<>();
        this.estado = EstadoOrden.PENDIENTE;
    }

    public void agregarPlato(Plato plato) {
        platosSeleccionados.add(plato);
    }

    public void cambiarEstado(EstadoOrden nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public String getIdOrden() { return idOrden; }
    public String getIdUsuario() { return idUsuario; }
    public ArrayList<Plato> getPlatosSeleccionados() { return platosSeleccionados; }
    public EstadoOrden getEstado() { return estado; }

    public void setIdOrden(String idOrden) { this.idOrden = idOrden; }
    public void setIdUsuario(String idUsuario) { this.idUsuario = idUsuario; }
    public void setPlatosSeleccionados(ArrayList<Plato> platosSeleccionados) { this.platosSeleccionados = platosSeleccionados; }
    public void setEstado(EstadoOrden estado) { this.estado = estado; }
}