package prode;

public class Equipo {
    private String nombre;
    private String descripcion;

    public Equipo(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public Equipo(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){return nombre;}
    public String getDescripcion(){return descripcion;}
}
