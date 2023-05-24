package View;

import Controller.ControllerPanelAgregacion;
import Controller.ControllerPanelListado;
import Model.Equipo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class PanelAgregacionEquipos extends JPanel {
    public  PanelAgregacionEquipos() {
        this.setLayout(null);
        this.setVisible(true);

        JMenuBar myBar = new JMenuBar();

        JMenu menuArchive = new JMenu("Archivo");
        JMenuItem itemExport = new JMenuItem("Exportar");
        JMenuItem itemImport = new JMenuItem("Importar");
        JMenuItem itemAjustes = new JMenuItem("Ajustes");
        itemExport.setEnabled(false);
        itemImport.setEnabled(false);
        itemAjustes.setEnabled(false);
        menuArchive.add(itemExport);
        menuArchive.add(itemImport);
        menuArchive.add(itemAjustes);

        JMenu menuIdioma = new JMenu("Idioma");
        JMenuItem itemEspanol = new JMenuItem("Español");
        JMenuItem itemIngles = new JMenuItem("Ingles");
        itemEspanol.setEnabled(false);
        itemIngles.setEnabled(false);
        menuIdioma.add(itemEspanol);
        menuIdioma.add(itemIngles);

        JMenu menuVentana = new JMenu("Ventana");
        JMenuItem itemListadoJugadores = new JMenuItem("Lista de Jugadores");
        itemListadoJugadores.addActionListener(e -> {
            Marco.cardLayout.show(Marco.cards, "Panel Listado Jugadores");
        });
        JMenuItem itemListadoEquipos = new JMenuItem("Lista de Equipos");
        itemListadoEquipos.addActionListener(e -> {
            Marco.cardLayout.show(Marco.cards, "Panel Listado Equipos");
        });
        JMenuItem itemAnadirJugadores = new JMenuItem("Agregación de Jugadores");
        itemAnadirJugadores.addActionListener(e -> {
            Marco.cardLayout.show(Marco.cards, "Panel Agregacion Jugadores");
        });
        JMenuItem itemAnadirEquipos = new JMenuItem("Agregación de Equipos");
        itemAnadirEquipos.addActionListener(e -> {
            Marco.cardLayout.show(Marco.cards, "Panel Agregacion Equipos");
        });

        //itemListadoJugadores.setEnabled(false);
        //itemListadoEquipos.setEnabled(false);
        //itemAnadirJugadores.setEnabled(false);
        itemAnadirEquipos.setEnabled(false);
        menuVentana.add(itemListadoJugadores);
        menuVentana.add(itemAnadirJugadores);
        menuVentana.add(itemListadoEquipos);
        menuVentana.add(itemAnadirEquipos);

        JMenu menuAyuda = new JMenu("Ayuda");

        myBar.add(menuArchive);
        myBar.add(menuIdioma);
        myBar.add(menuVentana);
        myBar.add(menuAyuda);

        myBar.setBounds(0,0,1600,20);

        //

        JPanel roundedPanel = new RoundedPanel(30);
        roundedPanel.setBounds(230, 150, 750, 470);
        roundedPanel.setBackground(Color.WHITE);
        roundedPanel.setLayout(null);

        JLabel label = new JLabel("Agregación de Equipos");
        label.setFont( new Font("Arial", Font.BOLD, 20));
        label.setBounds(235, 20, 300, 70);

        roundedPanel.add(label);

        // PRIMERA COLUMNA PRIMERA PARTE

        JButton botonAgregacionJugadores= new JButton("Agregacion de Jugadores");
        botonAgregacionJugadores.setBounds(50,210,190,80);
        botonAgregacionJugadores.setBorder(new LineBorder(Color.BLACK, 2));
        botonAgregacionJugadores.setBackground(Color.WHITE);
        botonAgregacionJugadores.setFocusPainted(false);
        botonAgregacionJugadores.addActionListener(e -> {
            Marco.cardLayout.show(Marco.cards, "Panel Agregacion Jugadores");
        });

        roundedPanel.add(botonAgregacionJugadores);

        JLabel textPais = new JLabel("País");
        textPais.setBounds(310,140,100,50);

        JTextField fieldPais = new JTextField();
        fieldPais.setBounds(267,180,120,20);
        fieldPais.setBorder(new LineBorder(Color.BLACK, 2));

        JLabel textCompeticion = new JLabel("Competición");
        textCompeticion.setBounds(415,140,100,50);

        JTextField fieldCompeticion = new JTextField();
        fieldCompeticion.setBounds(397,180,120,20);
        fieldCompeticion.setBorder(new LineBorder(Color.BLACK, 2));

        JLabel textEntrenador = new JLabel("Entrenador");
        textEntrenador.setBounds(540,140,100,50);

        JTextField fieldEntrenador = new JTextField();
        fieldEntrenador.setBounds(527,180,120,20);
        fieldEntrenador.setBorder(new LineBorder(Color.BLACK, 2));

        roundedPanel.add(textPais);
        roundedPanel.add(fieldPais);
        roundedPanel.add(textCompeticion);
        roundedPanel.add(fieldCompeticion);
        roundedPanel.add(textEntrenador);
        roundedPanel.add(fieldEntrenador);

        // SEGUNDA FILA DE CAMPOS

        JLabel textNombre = new JLabel("Nombre");
        textNombre.setBounds(360,315,100,50);

        JTextField fieldNombre = new JTextField();
        fieldNombre.setBounds(327,300,120,20);
        fieldNombre.setBorder(new LineBorder(Color.BLACK, 2));

        JLabel textAnoF = new JLabel("Año F");
        textAnoF.setBounds(495,315,100,50);

        JTextField fieldAno = new JTextField();
        fieldAno.setBounds(457,300,120,20);
        fieldAno.setBorder(new LineBorder(Color.BLACK, 2));

        roundedPanel.add(textNombre);
        roundedPanel.add(fieldNombre);
        roundedPanel.add(textAnoF);
        roundedPanel.add(fieldAno);

        // PRIMERA COLUMNA SEGUNDA PARTE

        JButton botonLimpiar = new JButton(new ImageIcon("src/Recursos/limpiar.png"));
        botonLimpiar.setBounds(100,310,80,50);
        botonLimpiar.setBorder(new LineBorder(Color.BLACK, 2));
        botonLimpiar.setBackground(Color.WHITE);
        botonLimpiar.setFocusPainted(false);
        botonLimpiar.addActionListener(e -> {
            ArrayList<JTextField> campos = new ArrayList<>();
            campos.add(fieldNombre);
            campos.add(fieldAno);
            campos.add(fieldPais);
            campos.add(fieldCompeticion);
            campos.add(fieldEntrenador);
            ControllerPanelAgregacion.vaciar(campos);
        });

        JButton botonGuardar = new JButton(new ImageIcon("src/Recursos/si.png"));
        botonGuardar.setBounds(100,140,80,50);
        botonGuardar.setBackground(Color.WHITE);
        botonGuardar.setFocusPainted(false);
        botonGuardar.setBorder(new LineBorder(Color.BLACK, 2));
        botonGuardar.addActionListener(e -> {
            String pais = fieldPais.getText();
            String competicion = fieldCompeticion.getText();
            String entrenador = fieldEntrenador.getText();
            String nombre = fieldNombre.getText();
            int anoF = Integer.parseInt(fieldAno.getText());

            ControllerPanelAgregacion.insertarEquipo(pais,competicion,entrenador,nombre,anoF);

            ArrayList<JTextField>campos = new ArrayList<>();
            campos.add(fieldNombre);
            campos.add(fieldAno);
            campos.add(fieldPais);
            campos.add(fieldCompeticion);
            campos.add(fieldEntrenador);
            ControllerPanelAgregacion.vaciar(campos);

            ControllerPanelListado.actualizarJlistEquipo();
        });

        roundedPanel.add(botonGuardar);
        roundedPanel.add(botonLimpiar);

        this.add(myBar);
        this.add(roundedPanel);
    }
}
