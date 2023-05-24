package View;

import Controller.ControllerPanelAgregacion;
import Controller.ControllerPanelListado;
import Model.Equipo;
import Model.Jugador;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class PanelListadoEquipos extends JPanel {

    public static JList<Equipo> listaEquipos;

    public PanelListadoEquipos() {


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
        itemListadoEquipos.setEnabled(false);
        //itemAnadirJugadores.setEnabled(false);
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

        JLabel label = new JLabel("Listado de Equipos");
        label.setFont( new Font("Arial", Font.BOLD, 20));
        label.setBounds(250, 20, 250, 70);

        roundedPanel.add(label);

        // PRIMERA COLUMNA PRIMERA PARTE

        JButton botonFiltradoJugadores= new JButton("Listado Jugadores");
        botonFiltradoJugadores.setBounds(50,350,160,80);
        botonFiltradoJugadores.setBorder(new LineBorder(Color.BLACK, 2));
        botonFiltradoJugadores.setBackground(Color.WHITE);
        botonFiltradoJugadores.setFocusPainted(false);
        botonFiltradoJugadores.addActionListener(e -> {
            Marco.cardLayout.show(Marco.cards, "Panel Listado Jugadores");
        });

        roundedPanel.add(botonFiltradoJugadores);

        // PRIMERA FILA DE CAMPOS

        JLabel textPais = new JLabel("País");
        textPais.setBounds(310,110,100,50);

        JTextField fieldPais = new JTextField();
        fieldPais.setBounds(267,150,120,20);
        fieldPais.setBorder(new LineBorder(Color.BLACK, 2));

        JLabel textCompeticion = new JLabel("Competición");
        textCompeticion.setBounds(415,110,100,50);

        JTextField fieldCompeticion = new JTextField();
        fieldCompeticion.setBounds(397,150,120,20);
        fieldCompeticion.setBorder(new LineBorder(Color.BLACK, 2));

        JLabel textEntrenador = new JLabel("Entrenador");
        textEntrenador.setBounds(550,110,100,50);

        JTextField fieldEntrenador = new JTextField();
        fieldEntrenador.setBounds(527,150,120,20);
        fieldEntrenador.setBorder(new LineBorder(Color.BLACK, 2));

        roundedPanel.add(textPais);
        roundedPanel.add(fieldPais);
        roundedPanel.add(textCompeticion);
        roundedPanel.add(fieldCompeticion);
        roundedPanel.add(textEntrenador);
        roundedPanel.add(fieldEntrenador);

        // SEGUNDA FILA DE CAMPOS

        JLabel textNombre = new JLabel("Nombre");
        textNombre.setBounds(360,170,100,50);

        JTextField fieldNombre = new JTextField();
        fieldNombre.setBounds(327,210,120,20);
        fieldNombre.setBorder(new LineBorder(Color.BLACK, 2));

        JLabel textAnoF = new JLabel("Año F");
        textAnoF.setBounds(495,170,100,50);

        JTextField fieldAno = new JTextField();
        fieldAno.setBounds(457,210,120,20);
        fieldAno.setBorder(new LineBorder(Color.BLACK, 2));

        roundedPanel.add(textNombre);
        roundedPanel.add(fieldNombre);
        roundedPanel.add(textAnoF);
        roundedPanel.add(fieldAno);

        // TERCERA FILA, LISTA
        DefaultListModel listModelEquipo = new DefaultListModel();

        ArrayList<Equipo> equipos = ControllerPanelListado.recogerDatosEquipos();

        for(int i=0; i<equipos.size(); i++) {
            listModelEquipo.add(i, equipos.get(i));
        }

        listaEquipos = new JList<>();

        listaEquipos.setBounds(267,260,380,170);
        listaEquipos.setBorder(new LineBorder(Color.BLACK, 2));

        listaEquipos.setModel(listModelEquipo);

        roundedPanel.add(listaEquipos);

        // PRIMERA COLUMNA SEGUNDA PARTE

        JButton botonLimpiar = new JButton(new ImageIcon("src/Recursos/limpiar.png"));
        botonLimpiar.setBounds(90,280,80,50);
        botonLimpiar.setBorder(new LineBorder(Color.BLACK, 2));
        botonLimpiar.setBackground(Color.WHITE);
        botonLimpiar.setFocusPainted(false);
        botonLimpiar.addActionListener(e -> {
            ArrayList<JTextField>campos = new ArrayList<>();
            campos.add(fieldNombre);
            campos.add(fieldAno);
            campos.add(fieldPais);
            campos.add(fieldCompeticion);
            campos.add(fieldEntrenador);
            ControllerPanelAgregacion.vaciar(campos);
        });

        JButton botonBorrar = new JButton(new ImageIcon("src/Recursos/borrar.png"));
        botonBorrar.setBounds(90,210,80,50);
        botonBorrar.setBorder(new LineBorder(Color.BLACK, 2));
        botonBorrar.setBackground(Color.WHITE);
        botonBorrar.setFocusPainted(false);
        botonBorrar.addActionListener(e -> {
            Equipo equipo = listaEquipos.getSelectedValue();
            listModelEquipo.removeElement(equipo);
            ControllerPanelListado.eliminarEquipo(equipo);
            ControllerPanelListado.actualizarJlistEquipo();


            ArrayList<JTextField>campos = new ArrayList<>();
            campos.add(fieldNombre);
            campos.add(fieldAno);
            campos.add(fieldPais);
            campos.add(fieldCompeticion);
            campos.add(fieldEntrenador);
            ControllerPanelAgregacion.vaciar(campos);
        });

        JButton botonEditar = new JButton(new ImageIcon("src/Recursos/lapiz.png"));
        botonEditar.setBounds(90,140,80,50);
        botonEditar.setBorder(new LineBorder(Color.BLACK, 2));
        botonEditar.setBackground(Color.WHITE);
        botonEditar.setFocusPainted(false);
        botonEditar.addActionListener(e -> {
            Equipo equipo = listaEquipos.getSelectedValue();
            fieldAno.setText(String.valueOf(equipo.getAnoF()));
            fieldCompeticion.setText((equipo.getCompeticion()));
            fieldEntrenador.setText((equipo.getEntrenador()));
            fieldPais.setText((equipo.getPais()));
            fieldNombre.setText((equipo.getNombre()));
            fieldNombre.setEditable(false);
        });

        JButton botonGuardar = new JButton(new ImageIcon("src/Recursos/si.png"));
        botonGuardar.setBounds(660,160,80,50);
        botonGuardar.setBackground(Color.WHITE);
        botonGuardar.setFocusPainted(false);
        botonGuardar.setContentAreaFilled(false);
        botonGuardar.setBorder(null);
        botonGuardar.addActionListener(e -> {
            String pais = fieldPais.getText();
            String competicion = fieldCompeticion.getText();
            String entrenador = fieldEntrenador.getText();
            String nombre = fieldNombre.getText();
            int anoF = Integer.parseInt(fieldAno.getText());

            ControllerPanelListado.actualizarEquipo(new Equipo(pais,competicion,entrenador,nombre,anoF));

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
        roundedPanel.add(botonEditar);
        roundedPanel.add(botonLimpiar);
        roundedPanel.add(botonBorrar);

        // AÑADIDAS A LA PANTALAL EN GENERAL

        this.add(myBar);
        this.add(roundedPanel);

    }
}