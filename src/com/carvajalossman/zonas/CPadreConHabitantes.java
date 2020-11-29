package com.carvajalossman.zonas;

import com.carvajalossman.habitantes.Habitante;

import java.util.ArrayList;

public abstract class CPadreConHabitantes extends ClasePadre{

    protected ArrayList<Habitante> habitantes;

    public CPadreConHabitantes(String nombre, ArrayList<Habitante> habitantes) {
        super(nombre);
        this.habitantes = habitantes;
    }

    public void setHabitantes(ArrayList<Habitante> habitantes){
        this.habitantes = habitantes;
    }

    public ArrayList<Habitante> getHabitantes() {
        return habitantes;
    }

    public String toString(){
        return new StringBuilder().append(this.nombre)
                .append(" poseé ")
                .append(this.habitantes.size())
                .append(" habitantes").toString();
    }
}
