package prode;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private String nro;
    private List<Partido> partidos;

    public Ronda(){ partidos = new ArrayList<>(); }

    public List<Partido> getPartidos(){return partidos;}
    public void setPartidos(List<Partido> partidos){this.partidos = partidos;}
    public void setNro(String nro){ this.nro = nro;}
    public String getNro(){ return nro; }
    public int puntos(){
        return 0;
    }
}
