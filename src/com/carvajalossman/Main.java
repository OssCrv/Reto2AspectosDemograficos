package com.carvajalossman;

import com.carvajalossman.util.Calculadora;
import com.carvajalossman.util.GeneradorAleatorio;
import com.carvajalossman.zonas.Barrio;
import com.carvajalossman.zonas.Departamento;
import com.carvajalossman.zonas.Municipio;
import com.carvajalossman.zonas.Vereda;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        StringBuilder json = new StringBuilder();
        Gson gson = new Gson();

        try(BufferedReader br = new BufferedReader(new FileReader("departamentos_con_municipios.json"))) {
            String linea;
            while ((linea = br.readLine()) != null){
                json.append(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Departamento[] departamentos = gson.fromJson(json.toString(), (Type) Departamento[].class);

        for(Departamento departamento:departamentos){
            System.out.println(new StringBuilder()
                    .append("\n")
                    .append("El departamento de ")
                    .append(departamento.getNombre())
                    .append(" el cual tiene ")
                    .append(departamento.getMunicipios().size())
                    .append(" municipios")
            );

            for(Municipio municipio:departamento.getMunicipios()){
                ArrayList<Barrio> barrios = new ArrayList<>();
                ArrayList<Vereda> veredas = new ArrayList<>();

                for(int i=0; i < GeneradorAleatorio.generarIntAleatorio(1,20);i++){
                    Vereda vereda = GeneradorAleatorio.generarVeredaAleatoria();
                    veredas.add(vereda);
                }
                municipio.setVeredas(veredas);

                for(int i=0; i < GeneradorAleatorio.generarIntAleatorio(1,20);i++){
                    Barrio barrio = GeneradorAleatorio.generarBarrioAleatorio();
                    barrios.add(barrio);
                }
                municipio.setBarrios(barrios);

                /*
                System.out.println(new StringBuilder()
                        .append("El municipio ")
                        .append(municipio.getNombre())
                        .append(" poseé ")
                        .append(municipio.getBarrios().size())
                        .append(" barrios y ")
                        .append(municipio.getVeredas().size())
                        .append(" veredas.")
                );

                 */
            }
            Calculadora.calcularTodo(departamento);
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("salida.json"))) {
            bw.write(gson.toJson(departamentos));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
