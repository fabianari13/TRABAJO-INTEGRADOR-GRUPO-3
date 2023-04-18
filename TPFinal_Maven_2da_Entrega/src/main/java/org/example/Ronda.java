package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Ronda {
    private @Getter String numero;
    private List<Partido> partidos;

    public Ronda() {
        this.partidos = new ArrayList<>();
    }

    public void setNumero(String numero){ this.numero = numero; }
    public void setPartido(Partido partido){ this.partidos.add(partido); }
    public Partido retornaPartido(String equipo1, String equipo2){
        for (Partido partido : this.partidos) {
            if (partido.getEquipo1().equals(equipo1) && partido.getEquipo2().equals(equipo2))
                return partido;
        }
        return null;
    }
    public Integer getCantidadPartidos(){return this.partidos.size();}

    @Override
    public String toString(){
        return "Ronda: "+numero +"\n"+ Arrays.toString(partidos.toArray())+"\n";
    }
}
