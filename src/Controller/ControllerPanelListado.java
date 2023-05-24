package Controller;

import DataBase.Connect;
import Model.Equipo;
import Model.Jugador;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

import static View.PanelListadoJugadores.listaJugadores;
import static View.PanelListadoEquipos.listaEquipos;

public class ControllerPanelListado {

    public static ArrayList<Jugador> recogerDatosJugadores(){
        ArrayList<Jugador> jugadores = new ArrayList<>();

        String sql = "SELECT * FROM jugadores";

        try (Connection conn = Connect.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()) {
                String demacacion = rs.getString("demarcacion");
                String nombre =  rs.getString("nombre");
                int ano = rs.getInt("anioNacimiento");
                double altura = rs.getDouble("altura");
                int dorsal = rs.getInt("dorsal");
                String club = rs.getString("clubPertenencia");

                jugadores.add(new Jugador(demacacion,nombre,ano,altura,dorsal,club));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return jugadores;
    }

    public static ArrayList<Equipo> recogerDatosEquipos(){
        ArrayList<Equipo> equipos = new ArrayList<>();

        String sql = "SELECT * FROM equipos";

        try (Connection conn = Connect.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                String pais = rs.getString("pais");
                String competicion =  rs.getString("competicion");
                String entrenador = rs.getString("entrenador");
                String nombre = rs.getString("nombre");
                int anoF = rs.getInt("anoF");

                equipos.add(new Equipo(pais,competicion,entrenador,nombre,anoF));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return equipos;
    }

    public static void eliminarEquipo(Equipo equipo) {
        String sql = "DELETE FROM equipos WHERE nombre = ?";

        try (Connection conn = Connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, equipo.getNombre());
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarJugador(Jugador jugador) {
        String sql = "DELETE FROM jugadores WHERE nombre = ?";

        try (Connection conn = Connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, jugador.getNombre());
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void actualizarEquipo(Equipo equipo) {
        String sql = "UPDATE equipos SET pais = ? , "
                + "competicion = ? ,"
                + "entrenador = ? ,"
                + "anoF = ? "
                + "WHERE nombre = ?";

        try (Connection conn = Connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, equipo.getPais());
            pstmt.setString(2, equipo.getCompeticion());
            pstmt.setString(3, equipo.getEntrenador());
            pstmt.setInt(4, equipo.getAnoF());
            pstmt.setString(5, equipo.getNombre());


            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void actualizarJugador(Jugador jugador) {
        String sql = "UPDATE jugadores SET demarcacion = ? , "
                + "anioNacimiento = ? ,"
                + "altura = ? ,"
                + "dorsal = ? ,"
                + "clubPertenencia = ?"
                + "WHERE nombre = ?";

        try (Connection conn = Connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, jugador.getDemarcacion());
            pstmt.setInt(2, jugador.getAnioNacimiento());
            pstmt.setDouble(3,jugador.getAltura());
            pstmt.setInt(4,jugador.getDorsal());
            pstmt.setString(5,jugador.getClubPertenencia());
            pstmt.setString(6,jugador.getNombre());

            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void actualizarJlistEquipo() {
        DefaultListModel listModelEquipo = new DefaultListModel();

        ArrayList<Equipo> equipos = ControllerPanelListado.recogerDatosEquipos();

        for(int i=0; i<equipos.size(); i++) {
            listModelEquipo.add(i, equipos.get(i));
        }

        listaEquipos.setModel(listModelEquipo);

    }

    public static void actualizarJlistJugador() {
        DefaultListModel listModelJugador = new DefaultListModel();

        ArrayList<Jugador> jugadores = ControllerPanelListado.recogerDatosJugadores();

        for(int i=0; i<jugadores.size(); i++) {
            listModelJugador.add(i, jugadores.get(i));
        }

        listaJugadores.setModel(listModelJugador);
    }

}
