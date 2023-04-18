package org.example;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Puntaje {
    private int golesEquipo1;
    private int golesEquipo2;
    private ResultadoEnum resultado;

    public int getPuntos() {
        int puntos = 0;
        if(golesEquipo1>golesEquipo2 && resultado==ResultadoEnum.GANADOR)
            puntos += 1;
        else if(golesEquipo1<golesEquipo2 && resultado==ResultadoEnum.PERDEDOR)
            puntos += 1;
        else if(golesEquipo1==golesEquipo2 && resultado==ResultadoEnum.EMPATE)
            puntos += 1;
        return puntos;
    }
}
