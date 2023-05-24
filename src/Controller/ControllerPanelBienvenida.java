package Controller;

import View.Marco;
import View.PanelBienvenida;
import javax.swing.*;

public class ControllerPanelBienvenida {

    public static void verificar(JPasswordField passwordField) {

        String texto = passwordField.getText();

        if (texto.equals("hola01")) {
            Marco.cardLayout.show(Marco.cards, "Panel Listado Jugadores");
        } else {
            PanelBienvenida.cajaContrasena.setText("");
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
