package org.example;

import lombok.Getter;

import java.util.Dictionary;
import java.util.Hashtable;

public class Persona {
    private @Getter String nombre;
    private @Getter int puntaje;
    private @Getter int aciertos;


    public Persona(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.aciertos = 0;
    }

    public void sumarPuntaje(int puntos){ this.puntaje += puntos; }
    public void sumarAciertos(int aciertos){ this.aciertos += aciertos; }
}
