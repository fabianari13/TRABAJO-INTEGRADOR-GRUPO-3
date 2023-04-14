package org.example;

import prode.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            List<Ronda> rondas = new ArrayList<>();
            List<Persona> personas = new ArrayList<>();
            List<Equipo> equipos = new ArrayList<>();
            List<Pronostico> pronosticos = new ArrayList<>();

            List<String> archivoPronostico = Files.readAllLines(Paths.get("src\\main\\resources\\Pronostico.csv"));
            List<String> archivoResultado = Files.readAllLines(Paths.get("src\\main\\resources\\Resultado.csv"));



            int indice = 0;
            Ronda ronda = null;
            List<ArrayList> matrizArchivo = archivoAmatriz(archivoResultado);
            for(int i=1; i<matrizArchivo.size(); i++){// Me salto el encabezado
                // Uso el operador ternario para evitar el error de acceder a una posicion no valida
                int j = (i==matrizArchivo.size()-1) ? matrizArchivo.size()-1 : i+1;//Si i es igual a la ultima posicion valida, j es igual a es posicion sino j=i+1
                ronda = new Ronda();
                // Por si hay más de una ronda
                while (i<matrizArchivo.size() && matrizArchivo.get(i).get(0).equals(matrizArchivo.get(j).get(0))){
                    ronda.setNro(matrizArchivo.get(i).get(0).toString());
                    equipos.add(new Equipo(matrizArchivo.get(i).get(1).toString()));
                    equipos.add(new Equipo(matrizArchivo.get(i).get(4).toString()));
                    int cantGoles_1 = Integer.parseInt(matrizArchivo.get(i).get(2).toString());
                    int cantGoles_2 = Integer.parseInt(matrizArchivo.get(i).get(3).toString());
                    ronda.setPartidos(new Partido(equipos.get(indice), equipos.get(indice+1), cantGoles_1, cantGoles_2));
                    indice++;
                    i++;
                }
                rondas.add(ronda);
            }



            indice = 0;
            String auxNombre = "";
            List<ArrayList> matrizPronostico = archivoAmatriz(archivoPronostico);
            //***************** SOLO CONTEMPLA UNA RONDA *****************
            for (int i=1; i<matrizPronostico.size(); i++){// Me salto el encabezado
                Pronostico pronostico = null;

                if(matrizPronostico.get(i).get(2).equals("X")) // Gana 1
                    pronostico = new Pronostico(new Equipo((String) matrizPronostico.get(i).get(1)), rondas.get(0).getPartido(indice), ResultadoEnum.GANADOR);
                else if(matrizPronostico.get(i).get(3).equals("X")) // Empate
                    pronostico = new Pronostico(new Equipo((String) matrizPronostico.get(i).get(1)), rondas.get(0).getPartido(indice), ResultadoEnum.EMPATE);
                else if(matrizPronostico.get(i).get(4).equals("X")) // Gana 2
                    pronostico = new Pronostico(new Equipo((String) matrizPronostico.get(i).get(1)), rondas.get(0).getPartido(indice), ResultadoEnum.PERDEDOR);

                pronosticos.add(pronostico);
                if(!matrizPronostico.get(i).get(0).equals(auxNombre)){
                    // Agrego la persona a la lista de personas
                    personas.add(new Persona((String) matrizPronostico.get(i).get(0)));
                }
                // Como son 4 partidos, cada vez que i sea un número divisible por 4, indice vuelve a 0
                // porque ahora debe volver a evaluar partidos.get(indice) para otra persona
                // sino tenemos un error de indice fuera de rango
                indice = (i%rondas.get(0).getCantidadPartidos("1")==0)?0:indice+1;
                auxNombre = (String) matrizPronostico.get(i).get(0);
            }



            System.out.println("Cantidad de personas: "+personas.size());
            System.out.println("Cantidad de rondas: "+rondas.size());
            indice=0;
            for(int i=0; i<personas.size(); i++){
                int puntos=0;
                for(int j=0; j< rondas.get(0).getCantidadPartidos("1"); j++){
                    puntos += pronosticos.get(indice).puntos();// Sumando los puntos (solo obtinene puntos si al equipo que apostó gana)
                    indice++;
                }
                personas.get(i).setCantPuntos(puntos);
                // Mostrando los puntos de las personas
                System.out.printf("Los puntos de %s son: %d\n", personas.get(i).getNombre(), personas.get(i).getCantPuntos());
            }
        }catch (Exception e){
            System.out.println("Ha ocurrido un error: "+e.getMessage());
        }
    }


    // Metodo para convertir un archivo csv en una matriz
    public static List<ArrayList> archivoAmatriz(List<String> archivo){
        List<ArrayList> matriz = new ArrayList<>();
        for(int i=0; i<archivo.size(); i++){
            matriz.add(new ArrayList());
            String[] auxArchivo = archivo.get(i).split(";");
            for(int j=0; j<auxArchivo.length; j++){
                matriz.get(i).add(auxArchivo[j]);
            }
        }
        return matriz;
    }
}