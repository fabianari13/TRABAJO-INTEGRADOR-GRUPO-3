package prode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Pronostico {
    private Equipo equipo;
    private @Getter Partido partido;
    private @Getter ResultadoEnum resultado;


    public int puntos(){

        if(partido.resultado()==resultado && resultado != ResultadoEnum.EMPATE)//Si acierta
            return 1;
        else // Si no acierta
            return 0;
    }
}
