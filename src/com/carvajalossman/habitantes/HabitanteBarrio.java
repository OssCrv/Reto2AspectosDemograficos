package com.carvajalossman.habitantes;

public class HabitanteBarrio extends Habitante{
    private Integer numeroSalidasNocturnasXSemana;

    public HabitanteBarrio(String nombre,
                           String cedula,
                           Integer edad,
                           String nivelEscolaridad,
                           boolean estaTrabajando,
                           Integer ingresos,
                           Integer numeroSalidasNocturnasXSemana)
    {
        super(nombre, cedula, edad, nivelEscolaridad, estaTrabajando, ingresos);
        this.numeroSalidasNocturnasXSemana = numeroSalidasNocturnasXSemana;
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
                .append(" y su número de salidas nocturas es de ").append(this.numeroSalidasNocturnasXSemana);


        return s.toString();
    }


    public Integer getNumeroSalidasNocturnasXSemana() {
        return numeroSalidasNocturnasXSemana;
    }

    public void setNumeroSalidasNocturnasXSemana(Integer numeroSalidasNocturnasXSemana) {
        this.numeroSalidasNocturnasXSemana = numeroSalidasNocturnasXSemana;
    }
}
