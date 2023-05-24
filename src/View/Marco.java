package View;

import javax.swing.*;
import java.awt.*;

public class Marco extends JFrame {
    public static CardLayout cardLayout;
    public static JPanel cards;

    public Marco() {
        this.setBounds(350, 120, 1200, 808);
        this.setResizable(false);

        PanelBienvenida panelBienvenida = new PanelBienvenida();
        PanelListadoJugadores panelListadoJugadores = new PanelListadoJugadores();
        PanelListadoEquipos panelListadoEquipos = new PanelListadoEquipos();
        PanelAgregacionJugadores panelAgregacionJugadores = new PanelAgregacionJugadores();
        PanelAgregacionEquipos panelAgregacionEquipos = new PanelAgregacionEquipos();

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        cards.add(panelBienvenida, "Panel Bienvenida");
        cards.add(panelListadoJugadores, "Panel Listado Jugadores");
        cards.add(panelListadoEquipos,"Panel Listado Equipos");
        cards.add(panelAgregacionJugadores,"Panel Agregacion Jugadores");
        cards.add(panelAgregacionEquipos, "Panel Agregacion Equipos");

        this.add(cards);

        this.setVisible(true);
    }
}