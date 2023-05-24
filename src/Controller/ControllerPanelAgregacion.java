package Controller;

import DataBase.Connect;
import Model.Jugador;
import View.PanelAgregacionJugadores;
import View.PanelListadoJugadores;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import static View.PanelListadoJugadores.listaJugadores;

public class ControllerPanelAgregacion {
    public static void insertarEquipo(String pais, String competicion, String entrenador,  String nombre,  int anoF){
        String sql = "INSERT INTO equipos(pais,competicion,entrenador,nombre,anoF) VALUES(?,?,?,?,?)";

        try (Connection conn = Connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pais);
            pstmt.setString(2, competicion);
            pstmt.setString(3, entrenador);
            pstmt.setString(4, nombre);
            pstmt.setInt(5,anoF);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        ControllerPanelListado.actualizarJlistEquipo();
    }
    public static void insertarJugador(String demarcacion, String nombre, int anioNacimiento, double altura, int dorsal, String clubPertenencia){
        String sql = "INSERT INTO jugadores(id,demarcacion,nombre,anioNacimiento,altura,dorsal,clubPertenencia) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = Connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(2, demarcacion);
            pstmt.setString(3, nombre);
            pstmt.setInt(4, anioNacimiento);
            pstmt.setDouble(5, altura);
            pstmt.setInt(6,dorsal);
            pstmt.setString(7,clubPertenencia);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        ControllerPanelListado.actualizarJlistJugador();
    }

    public static void vaciar(ArrayList<JTextField>campos) {
        for (JTextField campo:campos) {
            campo.setText("");
        }
    }


}
