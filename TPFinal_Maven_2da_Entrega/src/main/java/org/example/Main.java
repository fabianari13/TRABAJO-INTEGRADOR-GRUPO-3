package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            List<Persona> personas = new ArrayList<>();
            List<Ronda> rondas = new ArrayList<>();

            List<String> archivoPronostico = Files.readAllLines(Paths.get("src\\main\\resources\\Pronostico.csv"));
            List<String> archivoResultado = Files.readAllLines(Paths.get("src\\main\\resources\\Resultado.csv"));



            Ronda ronda = null;
            // Transformo archivoResultado a una matriz
            List<ArrayList> matrizResultado = archivoAmatriz(archivoResultado);
            for(int i=1; i<matrizResultado.size(); i++){// Me salto el encabezado
                // Por si hay más de una ronda
                ronda = new Ronda();
                // Uso el operador ternario para evitar el error de acceder a una posicion no valida
                int j = (i==matrizResultado.size()-1) ? matrizResultado.size()-1 : i+1;//Si i es igual a la ultima posicion valida, j es igual a es posicion sino j=i+1
                //Comparo que i sea menor que el tamaño de matrizResultado y que el numero de ronda en posicion i sea igual al de posicion j
                while (i<matrizResultado.size() && matrizResultado.get(i).get(0).equals(matrizResultado.get(j).get(0))){
                    ronda.setNumero(matrizResultado.get(i).get(0).toString());
                    int cantGoles_1 = Integer.parseInt(matrizResultado.get(i).get(2).toString());
                    int cantGoles_2 = Integer.parseInt(matrizResultado.get(i).get(3).toString());
                    ronda.setPartido(new Partido(
                            matrizResultado.get(i).get(1).toString(),
                            matrizResultado.get(i).get(4).toString(),
                            cantGoles_1,
                            cantGoles_2,
                            ronda.getNumero()));
                    i++;
                }
                // Como la condicion del ciclo while no se cumple a i le resto uno
                i = i-1;// Genera un "salto", cuando vuelve al ciclo for se incrementa en uno
                rondas.add(ronda);
            }


            // Variable auxiliar
            String auxNombre = "";
            // Cabecera de archivo a crear con los resultados
            List<String> resultadoProde = new ArrayList<>(Arrays.asList("Nombre;Ronda;Puntos;Cant. Aciertos"));
            // Transformo archivoPronostico a una matriz
            List<ArrayList> matrizPronostico = archivoAmatriz(archivoPronostico);

            for (int i=1; i<matrizPronostico.size(); i++){// Me salto el encabezado
                Puntaje puntaje = null;
                // Asigno a partido el retorno del metodo getPartido(rondas, equipo1, equipo2)
                Partido partido = getPartido(rondas, matrizPronostico.get(i).get(1).toString(), matrizPronostico.get(i).get(5).toString());
                // Instanciando objeto puntaje segun el la opcion del pronostico
                if(matrizPronostico.get(i).get(2).equals("X")) // Gana 1
                    puntaje = new Puntaje(partido.getGolesEquipo1(), partido.getGolesEquipo2(), ResultadoEnum.GANADOR);
                else if(matrizPronostico.get(i).get(3).equals("X")) // Empate
                    puntaje = new Puntaje(partido.getGolesEquipo1(), partido.getGolesEquipo2(), ResultadoEnum.EMPATE);
                else if(matrizPronostico.get(i).get(4).equals("X")) // Gana 2
                    puntaje = new Puntaje(partido.getGolesEquipo1(), partido.getGolesEquipo2(), ResultadoEnum.PERDEDOR);

                // Creo un registro del archivo de resultados
                resultadoProde.add(matrizPronostico.get(i).get(0)+";"+partido.getNumeroRonda()+";"+puntaje.getPuntos()+";"+puntaje.getPuntos());

                if(!matrizPronostico.get(i).get(0).equals(auxNombre)){// Si nombre de la posicion i es igual a auxNombre
                    // Agrego la persona a la lista de personas
                    personas.add(new Persona((String) matrizPronostico.get(i).get(0)));
                }
                // Sumo los puntos que obtiene la ultima persona de la lista
                personas.get(personas.size()-1).sumarPuntaje(puntaje.getPuntos());
                // Sumo los aciertos que en este caso es igual a la cantidad de puntos
                personas.get(personas.size()-1).sumarAciertos(puntaje.getPuntos());
                // Asigno a auxNombre el nombre que esta en la posicion i
                auxNombre = (String) matrizPronostico.get(i).get(0);
            }


            List<String> archivoDepurado = depurarResultadoProde(resultadoProde);
            try{
                // Escribiendo archivo con los resultados
                Files.write(Paths.get("src\\main\\resources\\Resultado_prode.csv"), archivoDepurado);
            }catch (IOException e){
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Mostrando los resultados
        try{
            System.out.println("\n");
            List<String> archivoProde = Files.readAllLines(Paths.get("src\\main\\resources\\Resultado_prode.csv"));
            for(int i=0; i<archivoProde.size(); i++){
                String[] aux = archivoProde.get(i).split(";");
                System.out.println(Arrays.toString(aux));
            }
        }catch (Exception e){
            System.out.println("Ha ocurrido un error. "+e.getMessage());
        }

        System.out.println("########## FIN DEL PROGRAMA ##########");
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
    // Metodo para sumar los puntos obtenidos y pronosticos acertados
    public static List<String> depurarResultadoProde(List<String> prode){
        List<ArrayList> matrizProde = archivoAmatriz(prode);
        List<String> resultado = new ArrayList<>(Arrays.asList("Nombre;Ronda;Puntos;Cant. Aciertos"));

        for (int i = 1; i < matrizProde.size()-1; i++) {
            String nombre = matrizProde.get(i).get(0).toString();
            String ronda = matrizProde.get(i).get(1).toString();
            int puntosAcum = Integer.parseInt(matrizProde.get(i).get(2).toString());
            int cantAciertosAcum = Integer.parseInt(matrizProde.get(i).get(3).toString());
            // Creo una lista que sera una fila del archivo a crear
            List<String> filaResultado = new ArrayList<>();
            filaResultado.add(nombre);
            filaResultado.add(ronda);

            for (int j = i + 1; j < matrizProde.size(); j++) {
                // Comparo si el nombre en la posicion i es igual al de la posicion j, idem con ronda
                if (matrizProde.get(j).get(0).equals(nombre) && matrizProde.get(j).get(1).equals(ronda)) {
                    // Sumo los puntos y aciertos
                    puntosAcum += Integer.parseInt(matrizProde.get(j).get(2).toString());
                    cantAciertosAcum += Integer.parseInt(matrizProde.get(j).get(3).toString());
                    // Para cuando j es igual a la ultima posicion valida, sale de este ciclo y vuelve al principal e i se vuelve a
                    // incrementar uno mas y rompe ese ciclo y luego se retorna el resultado
                    i = j - 1;// i=matrizProde.size()-1
                } else {
                    // Para generar un "salto" en el ciclo principal porque ya se evaluaron los elementos en el ciclo interior
                    i = j - 1;
                    break;
                }
            }
            filaResultado.add(Integer.toString(puntosAcum));
            filaResultado.add(Integer.toString(cantAciertosAcum));
            // Creo un registro del archivo separado por ";"
            resultado.add(String.join(";", filaResultado));
        }
        return resultado;
    }

    // Metodo que retorna un objeto Partido dado los nombres de dos equipos y la lista de rondas
    public static Partido getPartido(List<Ronda> rondas, String equipo1, String equipo2){
        Partido partido = null;
        for(Ronda ronda : rondas){
            partido = ronda.retornaPartido(equipo1, equipo2);// Metodo que retorna un Partido dados dos equipos
            // Comparo que partido no sea null y si existe lo retorno
            if(partido != null && partido.getEquipo1().equals(equipo1) && partido.getEquipo2().equals(equipo2)){
                return partido;
            }
        }
        return partido;
    }
}