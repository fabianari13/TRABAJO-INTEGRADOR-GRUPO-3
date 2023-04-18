package prode;

import prode.Pronostico;

public class Persona {
    private String nombre, apellido;
    private Integer cantPuntos;
    private Pronostico pronostico;

    public Persona(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void setCantPuntos(int puntos){ cantPuntos = puntos;}
    public Integer getCantPuntos(){ return cantPuntos; }
    public void setPronostico(Pronostico pronostico){ this.pronostico = pronostico; }
    public Pronostico getPronostico(){ return pronostico; }
}
