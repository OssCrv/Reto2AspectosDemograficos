package com.carvajalossman.zonas;


import java.util.ArrayList;

public class Municipio extends ClasePadre{

    protected ArrayList<Barrio> barrios;
    protected ArrayList<Vereda> veredas;


    public Municipio(String nombre, ArrayList<Barrio> barrios, ArrayList<Vereda> veredas) {
        super(nombre);
        this.barrios = barrios;
        this.veredas = veredas;
    }

    public ArrayList<Barrio> getBarrios() {
        return barrios;
    }

    public ArrayList<Vereda> getVeredas() {
        return veredas;
    }

    public void setBarrios(ArrayList<Barrio> barrios) {
        this.barrios = barrios;
    }

    public void setVeredas(ArrayList<Vereda> veredas) {
        this.veredas = veredas;
    }
}
