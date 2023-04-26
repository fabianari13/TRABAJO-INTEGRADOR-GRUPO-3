package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Consulta {
    private ResultSet resultSet;
    private Statement statement;
    private Connection connection;

    public Consulta(){
        String url = "jdbc:mysql://localhost:3306/prode";
        String username = "root";
        String password = "Riosalf*6";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<ArrayList> retornaResultadosProde(Integer[] puntosProde){
        List<ArrayList> tabla = new ArrayList<>();
        tabla.add(Constantes.TABLA_RESULTADO_PRODE);

        try{
            prode(puntosProde);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Constantes.CONSULTA_1);

            while (resultSet.next()){
                Integer id = resultSet.getInt(Constantes.ID_PRONOSTICO_X_RESULTADO);
                String nombre = resultSet.getString(Constantes.PARTICIPANTE);
                String fase = resultSet.getString(Constantes.FASE);
                Integer ronda = resultSet.getInt(Constantes.RONDA);
                Integer puntos = resultSet.getInt(Constantes.PUNTOS);
                Integer puntosExtras = resultSet.getInt(Constantes.PUNTOS_EXTRAS);
                Integer aciertos = resultSet.getInt(Constantes.ACIERTOS);
                tabla.add(new ArrayList(Arrays.asList(id, nombre, fase, ronda, puntos, puntosExtras, aciertos)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tabla;
    }

    public List<ArrayList> retornaPronosticos(){
        List<ArrayList> tabla = new ArrayList<>();
        tabla.add(Constantes.TABLA_PRONOSTICOS);

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Constantes.CONSULTA_2);

            while (resultSet.next()){
                Integer id = resultSet.getInt(Constantes.ID_PRONOSTICO);
                String nombre = resultSet.getString(Constantes.PARTICIPANTE);
                String gana_1 = resultSet.getString(Constantes.GANA_1);
                String empata = resultSet.getString(Constantes.EMPATA);
                String gana_2 = resultSet.getString(Constantes.GANA_2);

                tabla.add(new ArrayList(Arrays.asList(id, nombre, gana_1, empata, gana_2)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tabla;
    }

    public List<ArrayList> retornaResultados(){
        List<ArrayList> tabla = new ArrayList<>();
        tabla.add(Constantes.TABLA_RESULTADOS);

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Constantes.CONSULTA_3);

            while (resultSet.next()){
                Integer id = resultSet.getInt(Constantes.ID_RESULTADO);
                String equipo_1 = resultSet.getString(Constantes.EQUIPO_1);
                Integer goles_equipo_1 = resultSet.getInt(Constantes.GOLES_EQUIPO_1);
                Integer goles_equipo_2 = resultSet.getInt(Constantes.GOLES_EQUIPO_2);
                String equipo_2 = resultSet.getString(Constantes.EQUIPO_2);
                tabla.add(new ArrayList(Arrays.asList(id, equipo_1, goles_equipo_1, goles_equipo_2, equipo_2)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tabla;
    }

    public List<ArrayList> retornoPronosticosDeUnaPersona(String persona){
        List<ArrayList> tabla = new ArrayList<>();
        tabla.add(Constantes.TABLA_PRONOSTICO_DE_UNA_PERSONA);

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Constantes.retornaConsulta_4(persona));
            Integer indice = 0;

            while (resultSet.next()){
                indice++;
                String nombre = resultSet.getString(Constantes.PARTICIPANTE);
                String fase = resultSet.getString(Constantes.FASE);
                Integer ronda = resultSet.getInt(Constantes.RONDA);
                String gana_1 = resultSet.getString(Constantes.GANA_1);
                String empata = resultSet.getString(Constantes.EMPATA);
                String gana_2 = resultSet.getString(Constantes.GANA_2);
                Integer goles_equipo_1 = resultSet.getInt(Constantes.GOLES_EQUIPO_1);
                Integer goles_equipo_2 = resultSet.getInt(Constantes.GOLES_EQUIPO_2);
                String equipo_1 = resultSet.getString(Constantes.EQUIPO_1);
                String equipo_2 = resultSet.getString(Constantes.EQUIPO_2);
                String pronostico = "";
                if(gana_1!=null) pronostico = "GANA: "+equipo_1;
                else if(empata!=null) pronostico = "EMPATE";
                else if(gana_2!=null) pronostico = "GANA: "+equipo_2;
                tabla.add(new ArrayList(Arrays.asList(indice, nombre, pronostico, fase, ronda, equipo_1, goles_equipo_1, goles_equipo_2, equipo_2)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tabla;
    }

    public List<ArrayList> retornoResultadosDeUnEquipo(String equipo){
        List<ArrayList> tabla = new ArrayList<>();
        tabla.add(Constantes.TABLA_RESULTADOS_DE_UN_EQUIPO);

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Constantes.retornaConsulta_5(equipo));
            Integer indice = 0;

            while (resultSet.next()){
                indice++;
                String fase = resultSet.getString(Constantes.FASE);
                Integer ronda = resultSet.getInt(Constantes.RONDA);
                Integer goles_equipo_1 = resultSet.getInt(Constantes.GOLES_EQUIPO_1);
                Integer goles_equipo_2 = resultSet.getInt(Constantes.GOLES_EQUIPO_2);
                String equipo_1 = resultSet.getString(Constantes.EQUIPO_1);
                String equipo_2 = resultSet.getString(Constantes.EQUIPO_2);
                tabla.add(new ArrayList(Arrays.asList(indice, fase, ronda, equipo_1, goles_equipo_1, goles_equipo_2, equipo_2)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tabla;
    }

    public List<ArrayList> retornoResultadosDeUnaFase(String fase){
        List<ArrayList> tabla = new ArrayList<>();
        tabla.add(Constantes.TABLA_RESULTADOS_DE_UNA_FASE);

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Constantes.retornaConsulta_6(fase));
            Integer indice = 0;

            while (resultSet.next()){
                indice++;
                Integer ronda = resultSet.getInt(Constantes.RONDA);
                Integer goles_equipo_1 = resultSet.getInt(Constantes.GOLES_EQUIPO_1);
                Integer goles_equipo_2 = resultSet.getInt(Constantes.GOLES_EQUIPO_2);
                String equipo_1 = resultSet.getString(Constantes.EQUIPO_1);
                String equipo_2 = resultSet.getString(Constantes.EQUIPO_2);
                tabla.add(new ArrayList(Arrays.asList(indice, fase, ronda, equipo_1, goles_equipo_1, goles_equipo_2, equipo_2)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tabla;
    }

    public void cerrarConexion(){
        try{
            // Cerrando todas la variables relacionadas con la BD.
            connection.close();
            statement.close();
            if(resultSet != null)
                resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void agregarUnPronostico(List<ArrayList> lista){
        try{
            statement = connection.createStatement();
            statement.executeUpdate(Constantes.retornaConsulta_7(lista.get(0)));
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void agregarUnResultado(List<ArrayList> lista){
        try{
            statement = connection.createStatement();
            statement.executeUpdate(Constantes.retornaConsulta_8(lista.get(0)));
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void borrarPronostico(String participante){

        try {
            statement = connection.createStatement();
            statement.executeUpdate(Constantes.retornaConsulta_9(participante));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrarResultado(Integer id){
        try{
            statement = connection.createStatement();
            statement.executeUpdate(Constantes.retornaConsulta_10(id));
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void limpiarTabla(String nombre){
        try{
            statement = connection.createStatement();
            statement.executeUpdate(Constantes.retornaConsulta_11(nombre));
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void prode(Integer[] puntosProde){
        try{
            statement = connection.createStatement();
            // Con parametros para poder avanzar y retroceder registros
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


            resultSet = statement.executeQuery(Constantes.CONSULTA_RESULTADO_PRODE);

            String nombre, fase, gana_1, empata, gana_2, auxFase = "", auxNombre = "";
            Integer ronda, puntos=0, puntosExtras=0, aciertos=0, goles_1, goles_2, contadorRonda=0, auxRonda = 0;

            List<Object> registros = new ArrayList<>();
            Boolean bandera;
            // Iterando los registros
            while (resultSet.next()){
                bandera = false;
                nombre = resultSet.getString(Constantes.PARTICIPANTE);
                fase = resultSet.getString(Constantes.FASE);
                ronda = resultSet.getInt(Constantes.RONDA);
                goles_1 = resultSet.getInt(Constantes.GOLES_EQUIPO_1);
                goles_2 = resultSet.getInt(Constantes.GOLES_EQUIPO_2);
                gana_1 = resultSet.getString(Constantes.GANA_1);
                empata = resultSet.getString(Constantes.EMPATA);
                gana_2 = resultSet.getString(Constantes.GANA_2);


                if((!auxNombre.equals(nombre) && !auxFase.equals(fase)) ||
                        (!auxNombre.equals(nombre) && auxFase.equals(fase)) ||
                        (auxNombre.equals(nombre) && !auxFase.equals(fase))){
                    // Asigno una lista (registro) a la variable registros
                    registros.add(new ArrayList(Arrays.asList(nombre, fase, ronda, puntos, puntosExtras, aciertos)));

                    puntos = 0;
                    puntosExtras = 0;
                    aciertos = 0;
                    contadorRonda = 0;

                }else{
                    //Comparo si acerto el pronostico o no
                    if(gana_1!=null && goles_1>goles_2){
                        bandera = true;
                    }
                    else if(empata!=null && goles_1==goles_2){
                        bandera = true;
                    }
                    else if(gana_2!=null && goles_1<goles_2){
                        bandera = true;
                    }
                    if(bandera){// Si acerto incremento los puntos y aciertos
                        puntos += puntosProde[0];
                        aciertos++;
                    }

                    contadorRonda++;
                    // NO FUNCIONA CORRECTAMENTE LA ASIGNACION DE puntosExtras
                    puntosExtras = (contadorRonda==aciertos)?puntosExtras+puntosProde[1] : 0;
                    // Actualizo los valores del ultimo elemento  en las posiciones dadas
                    ((ArrayList)(registros.get(registros.size()-1))).set(3, puntos);
                    ((ArrayList)(registros.get(registros.size()-1))).set(4, puntosExtras);
                    ((ArrayList)(registros.get(registros.size()-1))).set(5, aciertos);
                }

                auxNombre = nombre;
                auxFase = fase;
                auxRonda = ronda;
            }
            // Insertado los resultado en la talba resultado_prode
            statement = connection.createStatement();
            for(int i=0; i<registros.size(); i++){
                statement.executeUpdate(Constantes.retornaConsultaProde((ArrayList)registros.get(i)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
