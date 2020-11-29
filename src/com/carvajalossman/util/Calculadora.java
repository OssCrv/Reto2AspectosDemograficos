package com.carvajalossman.util;

import com.carvajalossman.habitantes.Habitante;
import com.carvajalossman.zonas.Barrio;
import com.carvajalossman.zonas.Departamento;
import com.carvajalossman.zonas.Municipio;
import com.carvajalossman.zonas.Vereda;

import java.util.ArrayList;

public class Calculadora {

    public static void calcularTodo(Departamento departamento){
        System.out.print(new StringBuilder()
                .append("De un total de ")
                .append(getHabitantesFromDepartamento(departamento).size())
                .append(" habitantes ")
                .append(" ")
        );
        calcularPorcentajeHabitantesActualmenteTrabajando(departamento);
        calcularPorcentajeHabitantesConPostgrado(departamento);
        calcularPromedioIngresosPoblacionMayor(departamento);
        System.out.println("\n");
    }


    public static void calcularPorcentajeHabitantesActualmenteTrabajando(Departamento departamento){

        int habitantesTrabajando = 0;
        ArrayList<Habitante> habitantes = getHabitantesFromDepartamento(departamento);

        for(Habitante habitante:habitantes){
            if(habitante.estaTrabajando()){
                habitantesTrabajando++;
            }
        }
        System.out.println(new StringBuilder()
                .append("Se encuentran trabajando ")
                .append(habitantesTrabajando)
                .append(" que corresponde a un porcentaje de ")
                .append(String.format("%.0f",habitantesTrabajando*100f/habitantes.size()))
                .append("%")
        );
    }

    public static void calcularPorcentajeHabitantesConPostgrado(Departamento departamento){

        int habitantesPostgrado = 0;
        ArrayList<Habitante> habitantes = getHabitantesFromDepartamento(departamento);

        for(Habitante habitante:habitantes){
            if(habitante.getNivelEscolaridad().equals("Postgrado")){
                habitantesPostgrado++;
            }
        }
        System.out.println(new StringBuilder()
                .append("Tienen postgrado ")
                .append(habitantesPostgrado)
                .append(" que corresponde a un porcentaje de ")
                .append(String.format("%.0f",habitantesPostgrado*100f/habitantes.size()))
                .append("%")
        );
    }

    public static void calcularPromedioIngresosPoblacionMayor(Departamento departamento){

        int numeroHabitantesTerceraEdad = 0;
        float ingresosTotales = 0;
        ArrayList<Habitante> habitantes = getHabitantesFromDepartamento(departamento);

        for(Habitante habitante:habitantes){
            if(habitante.getEdad() >= 60){
                numeroHabitantesTerceraEdad++;
                ingresosTotales += habitante.getIngresos();
            }
        }
        System.out.println(new StringBuilder()
                .append(numeroHabitantesTerceraEdad)
                .append(" habitantes de tercera edad en ")
                .append(departamento.getNombre())
                .append(" cuyo promedio de ingresos es de ")
                .append(String.format("%.0f",ingresosTotales/numeroHabitantesTerceraEdad))
        );

    }

    public static ArrayList<Habitante> getHabitantesFromDepartamento(Departamento departamento){
        ArrayList<Habitante> habitantes = new ArrayList<>();
        ArrayList<Municipio> municipios = departamento.getMunicipios();

        for(Municipio municipio:municipios){
            ArrayList<Barrio> barrios = municipio.getBarrios();
            ArrayList<Vereda> veredas = municipio.getVeredas();

            for(Vereda vereda:veredas){
                habitantes.addAll(vereda.getHabitantes());
            }

            for(Barrio barrio:barrios){
                habitantes.addAll(barrio.getHabitantes());
            }
        }
        return habitantes;
    }

}
