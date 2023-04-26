package org.example;

import java.util.Scanner;
// GRUPO 3: ALFREDO RIOS, ANDRES RIVALTA Y FABIAN ALBERTINI
//GITHUB: https://github.com/fabianari13/TRABAJO-INTEGRADOR-GRUPO-3/tree/3ra_entrega
public class Main{// FALTA ARREGLAR LO ASIGNACION DE PUNTOS EXTRAS
    public static void main(String[] args) {
        String op = "";
        Scanner lectura = new Scanner(System.in);
        do{
            try{
                // Limpia la consola antes de imprimir la vista
                // Imprime varias líneas en blanco para "limpiar" la consola
                System.out.print("\033[H\033[2J");
                System.out.flush();

                new VistaProde();

                System.out.print("Desea continuar? S/N: ");
                op = lectura.next();
                if(!op.matches("[a-zA-Z]+"))// Si ingrese al menos un caracter que no sea una letra arroja la excepcion
                    throw new ExcepcionNoEsUnaCadena();
                if(op.equalsIgnoreCase("n"))
                    break;
            }catch (ExcepcionNoEsUnaCadena e){
                System.out.println(e.getMessage());
            }
        }while (!op.equalsIgnoreCase("s") || !op.equalsIgnoreCase("n"));
        System.out.println("***** FIN DEL PROGRAMA *****");

    }
}