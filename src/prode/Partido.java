package prode;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private static Integer nroPartido = 1;

    public Partido(Equipo e1, Equipo e2, int golesE1, int golesE2){
        this.equipo1 = e1;
        this.equipo2 = e2;
        this.golesEquipo1 = golesE1;
        this.golesEquipo2 = golesE2;
        nroPartido++;
    }

    public int getGolesEquipo1(){return golesEquipo1;}
    public int getGolesEquipo2(){return golesEquipo2;}

    public ResultadoEnum resultado(){

        if(getGolesEquipo1() > getGolesEquipo2())
            return ResultadoEnum.GANADOR;
        else if(getGolesEquipo1() == getGolesEquipo2())
            return ResultadoEnum.EMPATE;
        else
            return ResultadoEnum.PERDEDOR;
    }
    public String toString(){
        String cadena = nroPartido.toString()+ equipo1.getNombre() + "vs" + equipo2.getNombre();
        return cadena;
    }
}
