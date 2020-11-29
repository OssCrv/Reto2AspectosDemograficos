package com.carvajalossman.util;

import com.carvajalossman.habitantes.Habitante;
import com.carvajalossman.habitantes.HabitanteBarrio;
import com.carvajalossman.habitantes.HabitanteVereda;
import com.carvajalossman.zonas.Barrio;
import com.carvajalossman.zonas.Vereda;

import java.util.ArrayList;

public class GeneradorAleatorio {


    public static Barrio generarBarrioAleatorio(){
        int numeroHabiantes = generarIntAleatorio(0,647);
        ArrayList<Habitante> habitantes = new ArrayList<>();
        for(int i = 0; i < numeroHabiantes;i++){
            Habitante habitante = generarHabitanteBarrioAleatorio();
            habitantes.add(habitante);
        }

        return new Barrio(generarSilabasAleatorio(), habitantes);

    }


    public static Vereda generarVeredaAleatoria(){
        int numeroHabiantes = generarIntAleatorio(0,647);
        ArrayList<Habitante> habitantes = new ArrayList<>();
        for(int i = 0; i<numeroHabiantes;i++){
            Habitante habitante = generarHabitanteVeredaAleatorio();
            habitantes.add(habitante);
        }
        return new Vereda(generarSilabasAleatorio(), habitantes);
    }


    public static HabitanteVereda generarHabitanteVeredaAleatorio(){
        return new HabitanteVereda(
                generarNombreAleatorio(),
                generarCedulaAleatoria(1_000_000_000d,9_999_999_999d),
                generarIntAleatorio(18, 120),
                generarEscolaridadAleatoria(),
                generarBooleanAleatorio(),
                generarIntAleatorio(219_450, 3_511_212),
                generarCultivosAleatorios());
    }


    public static HabitanteBarrio generarHabitanteBarrioAleatorio(){
        return new HabitanteBarrio(
                generarNombreAleatorio(),
                generarCedulaAleatoria(1_000_000_000d,9_999_999_999d),
                generarIntAleatorio(18, 120),
                generarEscolaridadAleatoria(),
                generarBooleanAleatorio(),
                generarIntAleatorio(219_450, 3_511_212),
                generarIntAleatorio(10));
    }


    public static String generarNombreAleatorio() {
        String nombreAleatorio;

        String[] nombresFemeninos = { "Andrea", "Luciana", "Isabella", "Salomé", "Antonella", "Mariana", "Gabriela",
                "Mariangel", "Celeste", "Samantha", "Victoria", "Sofía", "Dulce", "María", "Maria", "Sara", "Fernanda",
                "Valentina", "Luz", "Dary", "Luisa", "Daniela", "Tatiana"};

        String[] nombresMasculinos = {"Juan", "José", "Miguel", "Ángel", "Sebastian", "Samuel", "David", "Pablo",
                "Angel", "Esteban", "Felipe", "Santiago", "Emiliano", "Emmanuel", "Mathias", "Martín"};

        String[] apellidos = { "Sánchez", "Guerrero", "Cardenas", "Rodríguez", "Cardona", "Gonzalez", "Martínez",
                "García", "Pérez", "López", "Castro", "Hernández", "Gómez", "Díaz", "Alvarez", "Rojas", "Mejía"};

        if(Math.random()>0.5){
            nombreAleatorio = nombresFemeninos[generarIntAleatorio((nombresFemeninos.length-1))] + " " +
                    nombresFemeninos[generarIntAleatorio((nombresFemeninos.length-1))];
        }else{
            nombreAleatorio = nombresMasculinos[generarIntAleatorio((nombresMasculinos.length-1))] + " " +
                    nombresMasculinos[generarIntAleatorio((nombresMasculinos.length-1))];
        }
        nombreAleatorio += " " + apellidos[generarIntAleatorio((apellidos.length-1))] +
                " " + apellidos[generarIntAleatorio(apellidos.length-1)];

        return nombreAleatorio;
    }


    public static String generarEscolaridadAleatoria(){
        String[] escolaridades = {"Ninguna", "Educación básica primaria", "Educación básica secundaria",
                "Educación media", "Educación técnica profesional", "Educación técnica tecnológica",
                "Educación universitaria", "Postgrado" };

        return escolaridades[(generarIntAleatorio(escolaridades.length - 1))];
    }


    public static ArrayList<String> generarCultivosAleatorios(){
        ArrayList<String> cultivos = new ArrayList<>();

        String[] listaCultivos = {"Plátano", "Yuca", "Papa", "Arroz", "Maíz amarrillo", "Maíz blanco", "Trigo", "Cebada",
                "Frijol", "Arveja", "Hortalizas de fruto", "Hortalizas de hoja", "Cebolla rama", "Cebolla bulbo",
                "Zanahoria", "Tomate"};

        for(int i = 0;i< generarIntAleatorio(1,5);i++){
            cultivos.add(listaCultivos[generarIntAleatorio(listaCultivos.length - 1)]);
        }
        return cultivos;
    }


    public static String generarSilabasAleatorio(){
        StringBuilder nombre = new StringBuilder();
        int len = ListaStrings.getLenght();

        for(int i =0; i < generarIntAleatorio(1,3);i++)
            nombre.append(ListaStrings.getSilaba(generarIntAleatorio(0,len-1)));

        return nombre.toString();
    }


    public static String generarCedulaAleatoria(Double min, Double max) {
        double range = max - min + 1;
        return String.format("%.0f",Math.random() * range + min);
    }


    public static int generarIntAleatorio(int min, int max) {
        int range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }


    public static int generarIntAleatorio(int max) {
        int range = max + 1;
        return (int)(Math.random() * range);
    }


    public static boolean generarBooleanAleatorio(){
        return Math.random() > 0.5;
    }
}