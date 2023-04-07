package prode;

import lombok.Getter;
import lombok.Setter;

public class Persona {
    private String nombre, apellido;
    private @Getter
    @Setter Integer cantPuntos;
    private @Getter
    @Setter Pronostico pronostico;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
