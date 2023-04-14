package prode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Equipo {
    private @Getter @Setter String nombre;
    private @Getter @Setter String descripcion;

    public Equipo(String nombre){
        this.nombre = nombre;
    } // Segundo constructor

}
