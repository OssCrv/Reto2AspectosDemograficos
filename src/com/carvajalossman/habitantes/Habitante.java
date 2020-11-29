package com.carvajalossman.habitantes;

public abstract class  Habitante {

    protected String nombre;
    protected String cedula;
    protected Integer edad;
    protected String nivelEscolaridad;
    protected boolean estaTrabajando;
    protected Integer ingresos;


    public Habitante(String nombre,
                     String cedula,
                     Integer edad,
                     String nivelEscolaridad,
                     boolean estaTrabajando,
                     Integer ingresos)
    {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.nivelEscolaridad = nivelEscolaridad;
        this.estaTrabajando = estaTrabajando;
        this.ingresos = ingresos;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCedula() {
        return cedula;
    }


    public void setCedula(Double cedula) {
        this.cedula = cedula.toString();
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


    public Integer getEdad() {
        return edad;
    }


    public void setEdad(Integer edad) {
        this.edad = edad;
    }


    public String getNivelEscolaridad() {
        return nivelEscolaridad;
    }


    public void setNivelEscolaridad(String nivelEscolaridad) {
        this.nivelEscolaridad = nivelEscolaridad;
    }


    public boolean estaTrabajando() {
        return estaTrabajando;
    }


    public void setEstaTrabajando(boolean estaTrabajando) {
        this.estaTrabajando = estaTrabajando;
    }


    public Integer getIngresos() {
        return ingresos;
    }


    public void setIngresos(Integer ingresos) {
        this.ingresos = ingresos;
    }
}
