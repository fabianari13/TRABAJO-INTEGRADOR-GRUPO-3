package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Pronostico {
    private String equipo;
    private @Getter Partido partido;
    private @Getter Puntaje puntaje;

}
