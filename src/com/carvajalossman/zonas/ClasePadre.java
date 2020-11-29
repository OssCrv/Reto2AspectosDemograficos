package com.carvajalossman.zonas;

public abstract class ClasePadre {
    protected String nombre;

    public ClasePadre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
