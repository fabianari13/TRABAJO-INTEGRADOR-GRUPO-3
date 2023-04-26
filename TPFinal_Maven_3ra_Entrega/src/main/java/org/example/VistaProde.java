package org.example;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VistaProde implements IVistaProde {
    private PresentadorProde presentador;
    private Scanner lectura = new Scanner(System.in);

    public VistaProde(){
        presentador = new PresentadorProde(this);

        Boolean bandera = false;
        Integer seleccion = 0;
        do{
            try{
                System.out.println("1. Ver todos los resultados del Pronostico Deportivo.");
                System.out.println("2. Mostrar todos los pronosticos.");
                System.out.println("3. Mostrar todos los resultados.");
                System.out.println("4. Mostrar los pronosticos de una persona en particular.");
                System.out.println("5. Mostrar los resultados de un equipo.");
                System.out.println("6. Mostrar los resultados de una fase.");
                System.out.println("7. Agregar pronostico a la tabla pronosticos.");
                System.out.println("8. Agregar resultado a la tabla resultados.");
                System.out.println("9. Borrar uno o varios pronosticos.");
                System.out.println("10. Borrar uno o varios resultados.");
                System.out.println("11. Vaciar la tabla de pronosticos.");
                System.out.println("12. Vaciar la tabla de resultados.");
                System.out.println("13. SALIR.");

                System.out.print("\nIngrese su elección: ");
                String input = lectura.next();

                if(!input.matches("\\d+"))// Si contiene al menos un caracter que no sea un numero entero
                    throw new ExcepcionNoEsNumeroEntero();
                seleccion = Integer.parseInt(input);
                bandera = true;

            }catch (ExcepcionNoEsNumeroEntero e){
                System.out.println(e.getMessage());
            }
        }while (!bandera || (seleccion<1 || seleccion>13));// Itera mientras haya algun error

        presentador.seleccionMenu(seleccion);
    }

    @Override
    public List<ArrayList> agregarPronostico(){
        List<ArrayList> registro = new ArrayList();
        Integer seleccion = 0;
        Boolean bandera = false;
        do{
            try{
                System.out.print("Ingrese el nombre del participante: ");
                String nombre = lectura.next();
                if(!nombre.matches("[a-zA-Z]+"))// Si la entrada por consola tiene otros caracteres que no sean letras
                    throw new ExcepcionNoEsUnaCadena();// Arrojo la excepcion

                System.out.println("\t1. Gana equipo 1");
                System.out.println("\t2. Empate");
                System.out.println("\t3. Gana equipo 2");
                System.out.print("\nIngrese su selección: ");

                String input = lectura.next();
                if(!input.matches("\\d+"))// Si contiene al menos un caracter que no sea un numero entero
                    throw new ExcepcionNoEsNumeroEntero();

                seleccion = Integer.parseInt(input);
                switch (seleccion){
                    case 1: registro.add(new ArrayList(Arrays.asList(nombre, "X", "--", "--"))); break;
                    case 2: registro.add(new ArrayList(Arrays.asList(nombre, "--", "X", "--"))); break;
                    case 3: registro.add(new ArrayList(Arrays.asList(nombre, "--", "--", "X"))); break;
                    default: System.out.println("OPCION INCORRECTA."); break;
                }
                bandera = true;
            }catch (ExcepcionNoEsUnaCadena | ExcepcionNoEsNumeroEntero e){
                System.out.println(e.getMessage());
            }
        }while (!bandera || (seleccion<1 || seleccion>3));
        return registro;
    }

    @Override
    public List<ArrayList> agregarResultado(){
        List<ArrayList> registro = new ArrayList<>();
        Boolean bandera = false;
        Integer numero, goles_1=0, goles_2=0;
        String equipo_1="", equipo_2="";
        do{
            try{
                System.out.print("Cuantos resultados desea agregar: ");
                String input = lectura.next();
                if(!input.matches("\\d+"))
                    throw new ExcepcionNoEsNumeroEntero();
                numero = Integer.parseInt(input);

                for(int i=0; i<numero; i++){
                    System.out.print("Ingrese el nombre del equipo 1: ");
                    equipo_1 = lectura.next();
                    System.out.print("Ingrese la cantidad de goles del equipo 1: ");
                    input = lectura.next();
                    if(!input.matches("\\d+"))
                        throw new ExcepcionNoEsNumeroEntero();
                    System.out.print("Ingrese la cantidad de goles del equipo 2: ");
                    input = lectura.next();
                    if(!input.matches("\\d+"))
                        throw new ExcepcionNoEsNumeroEntero();
                    System.out.print("Ingrese el nombre del equipo 2: ");
                    equipo_2 = lectura.next();

                    if(!equipo_1.matches("[a-zA-Z]+") || !equipo_2.matches("[a-zA-Z]+"))
                        throw new ExcepcionNoEsUnaCadena();
                }
                registro.add(new ArrayList(Arrays.asList(equipo_1, goles_1, goles_2, equipo_2)));
                bandera = true;
            }catch (ExcepcionNoEsNumeroEntero | ExcepcionNoEsUnaCadena e){
                System.out.println(e.getMessage());
            }
        }while (!bandera);
        return registro;
    }

    public Integer entradaDatosNumericos(){
        Boolean bandera = false;
        Integer numero = 0;
        do{
            try{
                String input = lectura.next();

                if(!input.matches("\\d+"))
                    throw new ExcepcionNoEsNumeroEntero();
                numero = Integer.parseInt(input);
                bandera = true;

            }catch (ExcepcionNoEsNumeroEntero e){
                System.out.println(e.getMessage());
            }
        }while (!bandera);
        return numero;
    }

    @Override
    public void mostrarResultados(List<ArrayList> tabla) {
        if(tabla.size()<=1)// La tabla si o si tiene cabecera asi que si solo tiene eso no hay nada para mostrar
            System.out.println("No hay nada para mostrar");
        else{
            for(int i=0; i<tabla.size(); i++){
                for (int j=0; j<tabla.get(0).size(); j++){
                    // ESTO ES SOLO ESTETICA, PARA QUE CUANDO MUESTRE INFORMACION
                    // Ronda, ID, Goles-1, Goles-2 solo poseen numeros asi que agrego 10 espacios vacios a sus izquierdas
                    if(tabla.get(0).get(j).equals("Ronda") || tabla.get(0).get(j).equals("ID") || tabla.get(0).get(j).equals("Goles-1") || tabla.get(0).get(j).equals("Goles-2"))
                        System.out.print(String.format("%-10s", tabla.get(i).get(j)));// Este formato hace que todas estas columnas tengan el mismo espaciado
                    else if(((String)tabla.get(0).get(j)).equals("Fase"))// Como fase contiene a los Strings de mayor longitud le doy un espaciado de 30
                        System.out.print(String.format("%-30s", tabla.get(i).get(j)));
                    else
                        System.out.print(String.format("%-18s", tabla.get(i).get(j)));
                }
                System.out.println();
            }
        }
    }

    @Override
    public String entradaDatos() {
        Boolean bandera = false;
        String nombre = "";
        do{
            try{
                nombre = lectura.next();

                if(!nombre.matches("[a-zA-Z]+"))// Si la entrada por consola tiene otros caracteres que no sean letras
                    throw new ExcepcionNoEsUnaCadena();// Arrojo la excepcion
                bandera = true;

            }catch (ExcepcionNoEsUnaCadena e){
                System.out.println(e.getMessage());
            }
        }while (!bandera);// Si hay un error seguira iterando sino termina el ciclo y continua el flujo del codigo
        return nombre;
    }

    @Override
    public void mostrarMensaje(String mensaje){
        System.out.print(mensaje);
    }

    public Integer[] setearPuntos(){
        Integer[] puntos = {1, 1};// Por defecto va a otorgarse un punto por acierto y un punto extra por acertar resultados de una ronda
        Boolean bandera = false;
        do{
            try{
                System.out.print("Desea cambiar la asignación de puntos o dejar como está? S/N: ");
                String input = lectura.next();
                Integer numero = 0;

                if(!input.matches("[a-zA-Z]+"))//Si ingresa la menos un caracter que no sea letra
                    throw new ExcepcionNoEsUnaCadena();

                else if(input.equalsIgnoreCase("s")){
                    do{
                        try{
                            System.out.print("Ingrese la nueva asignación de puntos: ");
                            input = lectura.next();
                            if(!input.matches("\\d+"))//Si ingresa al menos un caracter que no sea un numero
                                throw new ExcepcionNoEsNumeroEntero();
                            numero = Integer.parseInt(input);
                            puntos[0] = numero;

                            System.out.print("Ingrese la nueva asignación de puntos extras: ");
                            input = lectura.next();
                            if(!input.matches("\\d+"))
                                throw new ExcepcionNoEsNumeroEntero();
                            numero = Integer.parseInt(input);
                            puntos[1] = numero;
                        }catch (ExcepcionNoEsNumeroEntero e){
                            System.out.println(e.getMessage());
                        }
                    }while (!bandera);
                }
                bandera = true;
            }catch (ExcepcionNoEsUnaCadena e){
                System.out.println(e.getMessage());
            }
        }while (!bandera);

        return puntos;
    }
}
