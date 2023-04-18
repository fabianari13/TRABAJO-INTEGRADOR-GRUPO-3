package prode;

public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;

    public Pronostico(Equipo equipo, Partido partido, ResultadoEnum resultado){
        this.equipo = equipo;
        this.partido = partido;
        this.resultado = resultado;
    }

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
