package prode;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private @Getter @Setter String nro;
    private @Getter List<Partido> partidos;

    public Ronda(){ partidos = new ArrayList<>(); }

    public int puntos(){
        return 0;
    } //FALTA HACER. NO SÉ SI DEBERIA IR.

    public void setPartidos(Partido p){partidos.add(p);}
    public Partido getPartido(int indice){
        // Operador ternario, evalua si indice existe entonces devuelve el partido en esa posicion sino devuelve null
        return (indice<partidos.size()) ? partidos.get(indice) : null;
    }
    public Integer getCantidadPartidos(String numero){
        if(nro.equals(numero))
            return partidos.size();
        return partidos.size();
    }
}
