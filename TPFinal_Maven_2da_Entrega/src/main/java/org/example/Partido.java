package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Partido {
    private @Getter String equipo1;
    private @Getter String equipo2;
    private @Getter Integer golesEquipo1;
    private @Getter Integer golesEquipo2;
    private @Getter String numeroRonda;


    @Override
    public String toString(){
        return equipo1+": "+golesEquipo1+" vs. "+equipo2+": "+golesEquipo2;
    }
}
