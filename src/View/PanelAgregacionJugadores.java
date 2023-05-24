package View;

import Controller.ControllerPanelAgregacion;
import Controller.ControllerPanelListado;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class PanelAgregacionJugadores extends JPanel {

    public PanelAgregacionJugadores() {

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
        itemAnadirJugadores.setEnabled(false);
        //itemAnadirEquipos.setEnabled(false);
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

        JLabel label = new JLabel("Agregación de Jugadores");
        label.setFont( new Font("Arial", Font.BOLD, 20));
        label.setBounds(235, 20, 300, 70);

        roundedPanel.add(label);

        // PRIMERA COLUMNA PRIMERA PARTE

        JButton botonAgregacionEquipos= new JButton("Agregacion de Equipos");
        botonAgregacionEquipos.setBounds(50,210,180,80);
        botonAgregacionEquipos.setBorder(new LineBorder(Color.BLACK, 2));
        botonAgregacionEquipos.setBackground(Color.WHITE);
        botonAgregacionEquipos.setFocusPainted(false);
        botonAgregacionEquipos.addActionListener(e -> {
            Marco.cardLayout.show(Marco.cards, "Panel Agregacion Equipos");
        });

        roundedPanel.add(botonAgregacionEquipos);

        JLabel textNombre = new JLabel("Nombre");
        textNombre.setBounds(300,140,100,50);

        JTextField fieldNombre = new JTextField();
        fieldNombre.setBounds(267,180,120,20);
        fieldNombre.setBorder(new LineBorder(Color.BLACK, 2));

        JLabel textAno = new JLabel("Año");
        textAno.setBounds(440,140,100,50);

        JTextField fieldAno = new JTextField();
        fieldAno.setBounds(397,180,120,20);
        fieldAno.setBorder(new LineBorder(Color.BLACK, 2));

        JLabel textDemarcacion = new JLabel("Demarcación");
        textDemarcacion.setBounds(540,140,100,50);

        JTextField fieldDemarcacion = new JTextField();
        fieldDemarcacion.setBounds(527,180,120,20);
        fieldDemarcacion.setBorder(new LineBorder(Color.BLACK, 2));

        roundedPanel.add(textDemarcacion);
        roundedPanel.add(fieldDemarcacion);
        roundedPanel.add(fieldAno);
        roundedPanel.add(textAno);
        roundedPanel.add(textNombre);
        roundedPanel.add(fieldNombre);

        // SEGUNDA FILA DE CAMPOS

        JLabel textAltura = new JLabel("Altura");
        textAltura.setBounds(305,315,100,50);

        JTextField fieldAltura = new JTextField();
        fieldAltura.setBounds(267,300,120,20);
        fieldAltura.setBorder(new LineBorder(Color.BLACK, 2));

        JLabel textDorsal = new JLabel("Dorsal");
        textDorsal.setBounds(435,315,100,50);

        JTextField fieldDorsal = new JTextField();
        fieldDorsal.setBounds(397,300,120,20);
        fieldDorsal.setBorder(new LineBorder(Color.BLACK, 2));

        JLabel textClub = new JLabel("Club");
        textClub.setBounds(570,320,100,50);

        JTextField fieldClub = new JTextField();
        fieldClub.setBounds(527,300,120,20);
        fieldClub.setBorder(new LineBorder(Color.BLACK, 2));

        roundedPanel.add(textAltura);
        roundedPanel.add(fieldAltura);
        roundedPanel.add(textClub);
        roundedPanel.add(fieldClub);
        roundedPanel.add(textDorsal);
        roundedPanel.add(fieldDorsal);

        // PRIMERA COLUMNA SEGUNDA PARTE

        JButton botonLimpiar = new JButton(new ImageIcon("src/Recursos/limpiar.png"));
        botonLimpiar.setBounds(100,310,80,50);
        botonLimpiar.setBorder(new LineBorder(Color.BLACK, 2));
        botonLimpiar.setBackground(Color.WHITE);
        botonLimpiar.setFocusPainted(false);
        botonLimpiar.addActionListener(e -> {
            ArrayList<JTextField>campos = new ArrayList<>();
            campos.add(fieldDemarcacion);
            campos.add(fieldAno);
            campos.add(fieldNombre);
            campos.add(fieldAltura);
            campos.add(fieldClub);
            campos.add(fieldDorsal);
            ControllerPanelAgregacion.vaciar(campos);
        });

        JButton botonGuardar = new JButton(new ImageIcon("src/Recursos/si.png"));
        botonGuardar.setBounds(100,140,80,50);
        botonGuardar.setBackground(Color.WHITE);
        botonGuardar.setFocusPainted(false);
        botonGuardar.setBorder(new LineBorder(Color.BLACK, 2));
        botonGuardar.addActionListener(e -> {
            String demarcacion = fieldDemarcacion.getText();
            int ano = Integer.parseInt(fieldAno.getText());
            String nombre = fieldNombre.getText();
            double altura = Double.parseDouble(fieldAltura.getText());
            String club = fieldClub.getText();
            int dorsal = Integer.parseInt(fieldDorsal.getText());

            ControllerPanelAgregacion.insertarJugador(demarcacion,nombre,ano,altura,dorsal,club);

            ArrayList<JTextField>campos = new ArrayList<>();
            campos.add(fieldDemarcacion);
            campos.add(fieldAno);
            campos.add(fieldNombre);
            campos.add(fieldAltura);
            campos.add(fieldClub);
            campos.add(fieldDorsal);

            ControllerPanelAgregacion.vaciar(campos);

            ControllerPanelListado.actualizarJlistJugador();
        });

        roundedPanel.add(botonGuardar);
        roundedPanel.add(botonLimpiar);

        this.add(myBar);
        this.add(roundedPanel);
    }

}
