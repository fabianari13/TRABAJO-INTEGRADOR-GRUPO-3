package org.example;

public class ExcepcionNoEsUnaCadena extends Exception{

    public ExcepcionNoEsUnaCadena(){
        super("[ERROR] - Debe ingresar una cadena de texto.");
    }
}
