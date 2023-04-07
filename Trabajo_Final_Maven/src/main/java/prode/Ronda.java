package prode;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private @Getter @Setter String nro;
    private @Getter @Setter List<Partido> partidos;

    public Ronda(){ partidos = new ArrayList<>(); }

    public int puntos(){
        return 0;
    } //FALTA HACER
}
