package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Constantes {
    public static final String CONSULTA_1 = "SELECT * FROM resultado_prode";
    public static final String CONSULTA_2 = "SELECT pronostico.* "
            +"FROM pronostico_x_resultado "
            +"JOIN pronostico ON pronostico_x_resultado.pronostico = pronostico.idPronostico ";
    public static final String CONSULTA_3 = "SELECT resultado.* "
            +"FROM pronostico_x_resultado "
            +"JOIN resultado ON pronostico_x_resultado.resultado = resultado.idResultado";

    // Consulta sql que obtiene los valores de registros de dos tablas a traves de una tercera
    public static final String CONSULTA_RESULTADO_PRODE = "SELECT pronostico.participante, pronostico.gana_1, pronostico.empata, pronostico.gana_2, " +
            "resultado.goles_equipo_1, resultado.goles_equipo_2, " +
            "pronostico_x_resultado.fase, pronostico_x_resultado.ronda "
            + "FROM pronostico_x_resultado "
            + "JOIN pronostico ON pronostico_x_resultado.pronostico = pronostico.idPronostico "
            + "JOIN resultado ON pronostico_x_resultado.resultado = resultado.idResultado";


    public static final ArrayList<String> TABLA_RESULTADO_PRODE = new ArrayList(Arrays.asList("ID", "Nombre", "Fase", "Ronda", "Puntos", "Puntos extras", "Aciertos"));
    public static final ArrayList<String> TABLA_PRONOSTICOS = new ArrayList<>(Arrays.asList("ID", "Nombre", "Gana-1", "Empate", "Gana-2"));
    public static final ArrayList<String> TABLA_RESULTADOS = new ArrayList(Arrays.asList("ID", "Equipo-1", "Goles-1", "Goles-2", "Equipo-2"));
    public static final ArrayList<String> TABLA_PRONOSTICO_DE_UNA_PERSONA = new ArrayList<>(Arrays.asList("ID", "Nombre", "Pronostico", "Fase", "Ronda", "Equipo-1", "Goles-1", "Goles-2", "Equipo-2"));
    public static final ArrayList<String> TABLA_RESULTADOS_DE_UN_EQUIPO = new ArrayList<>(Arrays.asList("ID", "Fase", "Ronda", "Equipo-1", "Goles-1", "Goles-2", "Equipo-2"));
    public static final ArrayList<String> TABLA_RESULTADOS_DE_UNA_FASE = new ArrayList<>(Arrays.asList("ID", "Fase", "Ronda", "Equipo-1", "Goles-1", "Goles-2", "Equipo-2"));

    public static final String ID_RESULTADO = "idResultado";
    public static final String ID_PRONOSTICO = "idPronostico";
    public static final String ID_PRONOSTICO_X_RESULTADO = "idPxR";
    public static final String PARTICIPANTE = "participante";
    public static final String GANA_1 = "gana_1";
    public static final String EMPATA = "empata";
    public static final String GANA_2 = "gana_2";
    public static final String FASE = "fase";
    public static final String RONDA = "ronda";
    public static final String EQUIPO_1 = "equipo_1";
    public static final String GOLES_EQUIPO_1 = "goles_equipo_1";
    public static final String GOLES_EQUIPO_2 = "goles_equipo_2";
    public static final String EQUIPO_2 = "equipo_2";
    public static final String PUNTOS = "puntos";
    public static final String PUNTOS_EXTRAS = "puntos_extras";
    public static final String ACIERTOS = "aciertos";

    public static String retornaConsulta_4(String participante){
        String sql = "SELECT pronostico.participante, pronostico.gana_1, pronostico.empata, pronostico.gana_2, "
                +"resultado.goles_equipo_1, resultado.goles_equipo_2, resultado.equipo_1, resultado.equipo_2, "
                +"pronostico_x_resultado.fase, pronostico_x_resultado.ronda "
                +"FROM pronostico_x_resultado "
                +"JOIN pronostico ON pronostico_x_resultado.pronostico = pronostico.idPronostico "
                +"JOIN resultado ON pronostico_x_resultado.resultado = resultado.idResultado "
                +"WHERE pronostico.participante = "+"'"+participante+"'";// Como es un string va entre comillas
        return sql;
    }
    public static String retornaConsulta_5(String equipo){
        String sql = "SELECT resultado.goles_equipo_1, resultado.goles_equipo_2, resultado.equipo_1, resultado.equipo_2, "
                +"pronostico_x_resultado.fase, pronostico_x_resultado.ronda "
                +"FROM pronostico_x_resultado "
                +"JOIN resultado ON pronostico_x_resultado.resultado = resultado.idResultado "
                +"WHERE resultado.equipo_1 = "+"'"+equipo+"'"+" OR resultado.equipo_2 = "+"'"+equipo+"'";// Como es string va entre comillas
        return sql;
    }

    public static String retornaConsulta_6(String fase){
        String sql = "SELECT resultado.goles_equipo_1, resultado.goles_equipo_2, resultado.equipo_1, resultado.equipo_2, "
                +"pronostico_x_resultado.fase, pronostico_x_resultado.ronda "
                +"FROM pronostico_x_resultado "
                +"JOIN pronostico ON pronostico_x_resultado.pronostico = pronostico.idPronostico "
                +"JOIN resultado ON pronostico_x_resultado.resultado = resultado.idResultado "
                +"WHERE pronostico_x_resultado.fase = "+"'"+fase+"'"; // Como es un string va entre comillas
        return sql;
    }

    public static String retornaConsulta_7(ArrayList lista){
        String sql = "INSERT INTO pronostico (participante, gana_1, empata, gana_2) " +
                "VALUES ('" + lista.get(0) + "', '" + lista.get(1) + "', '" + lista.get(2) + "', '" + lista.get(3) + "')";
        return sql;
    }

    public static String retornaConsulta_8(ArrayList lista){
        String sql = "INSERT INTO resultado (equipo_1, goles_equipo_1, goles_equipo_2, equipo_2) " +
                "VALUES ('" + lista.get(0) + "', '" + lista.get(1) + "', '" + lista.get(2) + "', '" + lista.get(3) + "')";
        return sql;
    }

    public static String retornaConsulta_9(String participante){
        String sql = "DELETE FROM pronostico WHERE participante = '" + participante + "'";
        return sql;
    }

    public static String retornaConsulta_10(Integer id){
        String sql = "DELETE FROM resultado WHERE idResultado = "+id;
        return sql;
    }

    public static String retornaConsulta_11(String tabla){
        String sql = "DELETE FROM "+ tabla;
        return sql;
    }


    public static String retornaConsultaProde(ArrayList lista){
        String sql = "INSERT INTO resultado_prode (participante, fase, ronda, puntos, puntos_extras, aciertos) " +
                "VALUES ('" + lista.get(0) + "', '" + lista.get(1) + "', " + lista.get(2) + ", " + lista.get(3) + ", " + lista.get(4) + ", " + lista.get(5) +")";
        return sql;
    }

}
