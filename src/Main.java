
import prode.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            Ronda ronda = new Ronda();
            Persona persona = new Persona("Alfredo", "Rios");
            List<Partido> partidos = new ArrayList<>();
            List<Equipo> equipos = new ArrayList<>();
            List<Pronostico> pronosticos = new ArrayList<>();

            List<String> archivoPronostico = Files.readAllLines(Paths.get("src\\archivos\\Pronostico.csv"));
            List<String> archivoResultado = Files.readAllLines(Paths.get("src\\archivos\\Resultado.csv"));

            // Leyendo el archivo de Resultados
            for(int i=1; i<archivoResultado.size(); i++){ //Me salto el encabezado
                String[] aux = archivoResultado.get(i).split(";");

                equipos.add(new Equipo(aux[0]));
                equipos.add(new Equipo(aux[3]));

                int indice = equipos.size()-1;// -1 porque la posicion es tamaño-1
                partidos.add( new Partido( equipos.get(indice-1), equipos.get(indice), Integer.parseInt(aux[1]), Integer.parseInt(aux[2]) ) );
            }
            // Agrego los partidos a la ronda
            ronda.setNro("Ronda Uno");
            ronda.setPartidos(partidos);

            int puntos = 0;
            // Leyendo el archivo de Pronosticos
            for(int i=1; i<archivoPronostico.size(); i++){// Me salto el encabezado
                String[] aux = archivoPronostico.get(i).split(";");
                Pronostico pronostico = null;

                if(aux[1].equals("X")) // Resto uno (i-1) porque i empieza en 1 y la primera posicion de una lista es 0
                    pronostico = new Pronostico(new Equipo(aux[0]), partidos.get(i-1), ResultadoEnum.GANADOR);
                else if(aux[2].equals("X"))
                    pronostico = new Pronostico(new Equipo(aux[0]), partidos.get(i-1), ResultadoEnum.EMPATE);
                else if(aux[3].equals("X"))
                    pronostico = new Pronostico(new Equipo(aux[0]), partidos.get(i-1), ResultadoEnum.PERDEDOR);

                pronosticos.add(pronostico);

                puntos += pronosticos.get(i-1).puntos();
                // Agrego el pronostico y los puntos obtenidos a la clase Persona
                persona.setPronostico(pronostico);
                persona.setCantPuntos(puntos);
            }
            System.out.printf("El puntaje es: %d", puntos);

        }catch (Exception e){
            System.out.println("Ha ocurrido un error.");
        }
    }
}