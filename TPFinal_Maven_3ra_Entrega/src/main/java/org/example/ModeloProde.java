package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModeloProde {
    private Scanner lectura = new Scanner(System.in);
    private Consulta consulta;

    public ModeloProde(){
        consulta = new Consulta();
    }


    public List<ArrayList> retornarTablaResultadoProde(Integer[] puntos){
        List<ArrayList> tabla = consulta.retornaResultadosProde(puntos);
        consulta.cerrarConexion();
        return tabla;
    }

    public List<ArrayList> retornarTablaPronostico(){
        List<ArrayList> tabla = consulta.retornaPronosticos();
        consulta.cerrarConexion();
        return tabla;
    }

    public List<ArrayList> retornarTablaResultado(){
        List<ArrayList> tabla = consulta.retornaResultados();
        consulta.cerrarConexion();
        return tabla;
    }

    public List<ArrayList> retornarPronosticoParticipante(String participante){
        List<ArrayList> tabla = consulta.retornoPronosticosDeUnaPersona(participante);
        consulta.cerrarConexion();
        return tabla;
    }

    public List<ArrayList> retornarEquipo(String equipo){
        List<ArrayList> tabla = consulta.retornoResultadosDeUnEquipo(equipo);
        consulta.cerrarConexion();
        return tabla;
    }

    public List<ArrayList> retornarFase(String fase){
        List<ArrayList> tabla = consulta.retornoResultadosDeUnaFase(fase);
        consulta.cerrarConexion();
        return tabla;
    }

    public void agregarPronostico(List<ArrayList> lista){
        consulta.agregarUnPronostico(lista);
        consulta.cerrarConexion();
    }

    public void agregarResultado(List<ArrayList> lista){
        consulta.agregarUnResultado(lista);
        consulta.cerrarConexion();
    }

    public void eliminarPronostico(String participante){
        consulta.borrarPronostico(participante);
        consulta.cerrarConexion();
    }

    public void eliminarResultado(Integer id){
        consulta.borrarResultado(id);
        consulta.cerrarConexion();
    }

    public void vaciarTabla(String nombre){
        consulta.limpiarTabla(nombre);
        consulta.cerrarConexion();
    }
}
