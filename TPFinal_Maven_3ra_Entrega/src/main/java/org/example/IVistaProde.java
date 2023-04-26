package org.example;

import java.util.ArrayList;
import java.util.List;

public interface IVistaProde {
    void mostrarResultados(List<ArrayList> tabla);
    String entradaDatos();
    Integer entradaDatosNumericos();
    List<ArrayList> agregarPronostico();
    List<ArrayList> agregarResultado();
    void mostrarMensaje(String mensaje);
    Integer[] setearPuntos();
}
