package com.example.bitebyte;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String id;
    private String nombre;
    private String tipo;

    public Usuario() {
    }

    public Usuario(String id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }

    public void setId(String id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}