package org.example;

public class ExcepcionNoEsNumeroEntero extends Exception{

    public ExcepcionNoEsNumeroEntero(){
        super("[ERROR] - Debe ingresar un número entero positivo válido.");
    }
}
