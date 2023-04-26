package org.example;

import java.util.ArrayList;
import java.util.List;

public class PresentadorProde {
    private IVistaProde vista;
    private ModeloProde modelo;

    public PresentadorProde(IVistaProde vista){
        this.vista = vista;
        this.modelo = new ModeloProde();
    }

    public void seleccionMenu(Integer seleccion){
        switch (seleccion){
            case 1: {
                Integer[] puntos = vista.setearPuntos();
                List<ArrayList> tabla = modelo.retornarTablaResultadoProde(puntos);
                vista.mostrarResultados(tabla);
                break;
            }
            case 2: {
                List< ArrayList> tabla = modelo.retornarTablaPronostico();
                vista.mostrarResultados(tabla);
                break;
            }
            case 3: {
                List< ArrayList> tabla = modelo.retornarTablaResultado();
                vista.mostrarResultados(tabla);
                break;
            }
            case 4:{
                vista.mostrarMensaje("Ingrese el nombre de la persona: ");
                String nombre = vista.entradaDatos();
                List<ArrayList> tabla = modelo.retornarPronosticoParticipante(nombre);
                vista.mostrarResultados(tabla);
                break;
            }
            case 5:{
                vista.mostrarMensaje("Ingrese el nombre del equipo: ");
                String equipo = vista.entradaDatos();
                List<ArrayList> tabla = modelo.retornarEquipo(equipo);
                vista.mostrarResultados(tabla);
                break;
            }
            case 6:{
                vista.mostrarMensaje("Ingrese el nombre de la fase: ");
                String fase = vista.entradaDatos();
                List<ArrayList> tabla = modelo.retornarFase(fase);
                vista.mostrarResultados(tabla);
                break;
            }
            case 7: {
                List<ArrayList> lista = vista.agregarPronostico();
                modelo.agregarPronostico(lista);
                vista.mostrarMensaje("Se agregó correctamente.\n");
                break;
            }
            case 8: {
                List<ArrayList> lista = vista.agregarResultado();
                modelo.agregarResultado(lista);
                vista.mostrarMensaje("Se agregó correctamente.\n");
                break;
            }
            case 9: {
                vista.mostrarMensaje("Ingrese el nombre del participante: ");
                String nombre = vista.entradaDatos();
                modelo.eliminarPronostico(nombre);
                vista.mostrarMensaje("Se ha eliminado el registro correctamente.\n");
                break;
            }
            case 10: {
                vista.mostrarMensaje("Ingrese el ID del registro: ");
                Integer numero = vista.entradaDatosNumericos();
                modelo.eliminarResultado(numero);
                vista.mostrarMensaje("Se ha eliminado el registro correctamente.\n");
                break;
            }
            case 11, 12: {
                vista.mostrarMensaje("Ingrese el nombre de la tabla: ");
                String nombre = vista.entradaDatos();
                modelo.vaciarTabla(nombre);
                vista.mostrarMensaje("Se realizó la operación correctamente.\n");
                break;
            }
            case 13: System.out.println("***** SALIENDO DEL PROGRAMA *****\n"); break;
            default: System.out.println("Ha seleccionado una opción incorrecta."); break;
        }
    }
}
