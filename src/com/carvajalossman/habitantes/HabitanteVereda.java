package com.carvajalossman.habitantes;

import java.util.ArrayList;

public class HabitanteVereda extends Habitante {


    private ArrayList<String> cultivosQueAtiende;


    public HabitanteVereda(String nombre,
                           String cedula,
                           Integer edad,
                           String nivelEscolaridad,
                           boolean estaTrabajando,
                           Integer ingresos,
                           ArrayList<String> cultivosQueAtiende)
    {
        super(nombre, cedula, edad, nivelEscolaridad, estaTrabajando, ingresos);
        this.cultivosQueAtiende = cultivosQueAtiende;
    }


    public String toString(){
        StringBuilder s = new StringBuilder();

        s.append(this.nombre)
                .append(" con cédula ")
                .append(this.cedula)
                .append(" tiene ")
                .append(this.edad)
                .append(" años, su escolaridad es ")
                .append(this.nivelEscolaridad.toLowerCase());

        if(this.estaTrabajando)
            s.append(", se encuentra trabajando");
        else
            s.append(", se encuentra sin trabajo");

        s.append(", poseé unos ingresos de ").append(this.ingresos)
                .append(" y atiende cultivos de ");

        if(this.cultivosQueAtiende.size() == 1)
            s.append(this.cultivosQueAtiende.get(0).toLowerCase());

        else{
            for(int i = 0; i<=this.cultivosQueAtiende.size()-1;i++){
                if(i == this.cultivosQueAtiende.size()-1)
                    s.append(this.cultivosQueAtiende.get(i).toLowerCase()).append(".");

                else if(i == this.cultivosQueAtiende.size()-2)
                    s.append(this.cultivosQueAtiende.get(i).toLowerCase()).append(" y ");

                else
                    s.append(this.cultivosQueAtiende.get(i).toLowerCase()).append(", ");
            }
        }

        return s.toString();
    }


    public ArrayList<String> getCultivosQueAtiende() {
        return cultivosQueAtiende;
    }


    public void addCultivo(String cultivosQueAtiende) {
        this.cultivosQueAtiende.add(cultivosQueAtiende);
    }
}
