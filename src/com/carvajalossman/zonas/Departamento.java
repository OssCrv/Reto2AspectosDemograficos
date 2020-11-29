package com.carvajalossman.zonas;

import java.util.ArrayList;

public class Departamento extends ClasePadre{

    private ArrayList<Municipio> municipios;

    public Departamento(String nombre, ArrayList<Municipio> municipios) {
        super(nombre);
        this.municipios = municipios;
    }


    public ArrayList<Municipio> getMunicipios() {
        return municipios;
    }


}
