import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) throws IOException {
        String archivo1 = "C:\\Users\\Notebook\\Desktop\\Partidos.csv";
        String archivo2 = "C:\\Users\\Notebook\\Desktop\\Resultados.csv";

        Object[] lineas1 = Files.readAllLines(Paths.get(archivo1)).toArray();
        Object[] lineas2 = Files.readAllLines(Paths.get(archivo2)).toArray();

        int partido = lineas1.length;

        int resultado = lineas2.length;

        //Datos Persona
        Personas personas = new Personas();
        personas.setNombre("Juan");
        personas.setApellido("Perez");
        personas.setFechaDeNacimiento(LocalDate.of(1990, 10, 2));
        System.out.println("Pronostico de " + personas.getNombre() + " " + personas.getApellido());
        System.out.println("");

        //Se imprime en consola los datos de los archivos
        for (int i = 0; i < partido; ++i) {
            Object lin1 = lineas1[i].toString();
            System.out.println(lin1);
        }
        System.out.println(" ");
        for (int z = 0; z < resultado; ++z) {
            Object linea2 = lineas2[z].toString();
            System.out.println(linea2);
        }
        System.out.println("");

        //Se leen los resultados de los partidos y se le asigna un entero para poder comparar
        for (int k = 1; k < lineas2.length; k++) {
            String[] lineaII = lineas2[k].toString().split(";");
            int a = Integer.parseInt(lineaII[1]);
            int b = Integer.parseInt(lineaII[2]);

            //Se leen las columnas de los pronosticos
            for (int j = 1; j < lineas1.length; j++) {
                String[] lineaI = lineas1[j].toString().split(";");

                String local = lineaI[1];
                String empate = lineaI[2];
                String visitante = lineaI[3];

                //Se establecen condiciones para determinar si hay acierto o no
                //Cada acierto vale 1 punto
                int t = 0;
                int s = 0;
                for (int y = 1; y < resultado; y++) {
                    if (local.contains("x") && a > b || empate.contains("x") && a == b || visitante.contains("x") && a < b) {
                        t++;
                        s = s+t;

                        if (s == 1) {
                                System.out.println("Obtuviste: " + s + " punto");
                        }
                        if (s > 1) {
                                System.out.println("Obtuviste: " + s + " puntos");
                        }

                    }



                    break;

                    }
                }

            }
        }
    }













