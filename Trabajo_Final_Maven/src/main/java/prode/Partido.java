package prode;

import lombok.Getter;
import lombok.Setter;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private @Getter @Setter int golesEquipo1;
    private @Getter @Setter int golesEquipo2;
    private static int nroPartido = 1;// contador de objetos de la clase Partido. Para saber cuántos objetos se crean.

    public Partido(Equipo e1, Equipo e2, int golesE1, int golesE2){
        this.equipo1 = e1;
        this.equipo2 = e2;
        this.golesEquipo1 = golesE1;
        this.golesEquipo2 = golesE2;
        nroPartido++;
    }

    public ResultadoEnum resultado(){

        if(getGolesEquipo1() > getGolesEquipo2())
            return ResultadoEnum.GANADOR;
        else if(getGolesEquipo1() == getGolesEquipo2())
            return ResultadoEnum.EMPATE;
        else
            return ResultadoEnum.PERDEDOR;
    }

    @Override //Este es de Java no de Lombok
    public String toString(){
        String cadena = nroPartido + ": " + equipo1.getNombre() + " vs " + equipo2.getNombre();
        return cadena;
    }
}
