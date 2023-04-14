package prode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Persona {
    private @Getter String nombre;
    private @Getter @Setter Integer cantPuntos;
    private @Getter @Setter Pronostico pronostico;

    public Persona(String nombre){
        this.nombre = nombre;
    }
}
