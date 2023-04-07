package prode;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Pronostico {
    private Equipo equipo;
    private Partido partido;
    private ResultadoEnum resultado;


    public int puntos(){

        if(partido.resultado()==resultado)
        {
            System.out.println("¡Ganaste un punto!");
            return 1;
        }
        else if(partido.resultado()==resultado)
        {
            System.out.println("¡Empate!");
            return 0;
        }
        else
        {
            System.out.println("¡Perdiste un punto!");
            return -1;
        }
    }
}
