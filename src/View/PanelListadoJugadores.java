package View;

import Controller.ControllerPanelAgregacion;
import Controller.ControllerPanelListado;
import Model.Jugador;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

public class PanelListadoJugadores extends JPanel {

    public static JList<Jugador> listaJugadores;
    public PanelListadoJugadores() {


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

        itemListadoJugadores.setEnabled(false);
        //itemListadoEquipos.setEnabled(false);
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

        JPanel roundedPanel = new RoundedPanel(30);
        roundedPanel.setBounds(230, 150, 750, 470);
        roundedPanel.setBackground(Color.WHITE);
        roundedPanel.setLayout(null);

        JLabel label = new JLabel("Listado de Jugadores");
        label.setFont( new Font("Arial", Font.BOLD, 20));
        label.setBounds(250, 20, 250, 70);

        roundedPanel.add(label);

        // PRIMERA COLUMNA PRIMERA PARTE

        JButton botonFiltradoEquipos= new JButton("Listado Equipos");
        botonFiltradoEquipos.setBounds(50,350,160,80);
        botonFiltradoEquipos.setBorder(new LineBorder(Color.BLACK, 2));
        botonFiltradoEquipos.setBackground(Color.WHITE);
        botonFiltradoEquipos.setFocusPainted(false);
        botonFiltradoEquipos.addActionListener(e -> {
            Marco.cardLayout.show(Marco.cards, "Panel Listado Equipos");
        });

        roundedPanel.add(botonFiltradoEquipos);

        // PRIMERA FILA DE CAMPOS

        JLabel textNombre = new JLabel("Nombre");
        textNombre.setBounds(300,110,100,50);

        JTextField fieldNombre = new JTextField();
        fieldNombre.setBounds(267,150,120,20);
        fieldNombre.setBorder(new LineBorder(Color.BLACK, 2));

        JLabel textAno = new JLabel("Año");
        textAno.setBounds(440,110,100,50);

        JTextField fieldAno = new JTextField();
        fieldAno.setBounds(397,150,120,20);
        fieldAno.setBorder(new LineBorder(Color.BLACK, 2));

        JLabel textDemarcacion = new JLabel("Demarcación");
        textDemarcacion.setBounds(540,110,100,50);

        JTextField fieldDemarcacion = new JTextField();
        fieldDemarcacion.setBounds(527,150,120,20);
        fieldDemarcacion.setBorder(new LineBorder(Color.BLACK, 2));

        roundedPanel.add(textDemarcacion);
        roundedPanel.add(fieldDemarcacion);
        roundedPanel.add(fieldAno);
        roundedPanel.add(textAno);
        roundedPanel.add(textNombre);
        roundedPanel.add(fieldNombre);

        // SEGUNDA FILA DE CAMPOS

        JLabel textAltura = new JLabel("Altura");
        textAltura.setBounds(305,170,100,50);

        JTextField fieldAltura = new JTextField();
        fieldAltura.setBounds(267,210,120,20);
        fieldAltura.setBorder(new LineBorder(Color.BLACK, 2));

        JLabel textDorsal = new JLabel("Dorsal");
        textDorsal.setBounds(435,170,100,50);

        JTextField fieldDorsal = new JTextField();
        fieldDorsal.setBounds(397,210,120,20);
        fieldDorsal.setBorder(new LineBorder(Color.BLACK, 2));

        JLabel textClub = new JLabel("Club");
        textClub.setBounds(570,170,100,50);

        JTextField fieldClub = new JTextField();
        fieldClub.setBounds(527,210,120,20);
        fieldClub.setBorder(new LineBorder(Color.BLACK, 2));

        roundedPanel.add(textAltura);
        roundedPanel.add(fieldAltura);
        roundedPanel.add(textClub);
        roundedPanel.add(fieldClub);
        roundedPanel.add(textDorsal);
        roundedPanel.add(fieldDorsal);

        // TERCERA FILA, LISTA

        DefaultListModel listModelJugador = new DefaultListModel();

        ArrayList<Jugador> jugadores = ControllerPanelListado.recogerDatosJugadores();

        for(int i=0; i<jugadores.size(); i++) {
            listModelJugador.add(i, jugadores.get(i));
        }

        listaJugadores = new JList<>();

        listaJugadores.setBounds(267,260,380,170);
        listaJugadores.setBorder(new LineBorder(Color.BLACK, 2));

        listaJugadores.setModel(listModelJugador);

        roundedPanel.add(listaJugadores);

        // PRIMERA COLUMNA SEGUNDA PARTE

        JButton botonLimpiar = new JButton(new ImageIcon("src/Recursos/limpiar.png"));
        botonLimpiar.setBounds(90,280,80,50);
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

        JButton botonBorrar = new JButton(new ImageIcon("src/Recursos/borrar.png"));
        botonBorrar.setBounds(90,210,80,50);
        botonBorrar.setBorder(new LineBorder(Color.BLACK, 2));
        botonBorrar.setBackground(Color.WHITE);
        botonBorrar.setFocusPainted(false);
        botonBorrar.addActionListener(e -> {

            Jugador jugador = listaJugadores.getSelectedValue();
            listModelJugador.removeElement(jugador);
            ControllerPanelListado.eliminarJugador(jugador);
            ControllerPanelListado.actualizarJlistJugador();

            ArrayList<JTextField>campos = new ArrayList<>();
            campos.add(fieldDemarcacion);
            campos.add(fieldAno);
            campos.add(fieldNombre);
            campos.add(fieldAltura);
            campos.add(fieldClub);
            campos.add(fieldDorsal);
            ControllerPanelAgregacion.vaciar(campos);
        });

        JButton botonEditar = new JButton(new ImageIcon("src/Recursos/lapiz.png"));
        botonEditar.setBounds(90,140,80,50);
        botonEditar.setBorder(new LineBorder(Color.BLACK, 2));
        botonEditar.setBackground(Color.WHITE);
        botonEditar.setFocusPainted(false);
        botonEditar.addActionListener(e -> {
            Jugador jugador = listaJugadores.getSelectedValue();
            fieldAltura.setText(String.valueOf(jugador.getAltura()));
            fieldAno.setText(String.valueOf(jugador.getAnioNacimiento()));
            fieldClub.setText(String.valueOf(jugador.getClubPertenencia()));
            fieldDemarcacion.setText(String.valueOf(jugador.getDemarcacion()));
            fieldDorsal.setText(String.valueOf(jugador.getDorsal()));
            fieldNombre.setText(String.valueOf(jugador.getNombre()));
            fieldNombre.setEditable(false);
        });

        JButton botonGuardar = new JButton(new ImageIcon("src/Recursos/si.png"));
        botonGuardar.setBounds(660,160,80,50);
        botonGuardar.setBackground(Color.WHITE);
        botonGuardar.setFocusPainted(false);
        botonGuardar.setContentAreaFilled(false);
        botonGuardar.setBorder(null);
        botonGuardar.addActionListener(e -> {
            String demarcacion = fieldDemarcacion.getText();
            int ano = Integer.parseInt(fieldAno.getText());
            String nombre = fieldNombre.getText();
            double altura = Double.parseDouble(fieldAltura.getText());
            String club = fieldClub.getText();
            int dorsal = Integer.parseInt(fieldDorsal.getText());

            ControllerPanelListado.actualizarJugador(new Jugador(demarcacion,nombre,ano,altura,dorsal,club));

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
        roundedPanel.add(botonEditar);
        roundedPanel.add(botonLimpiar);
        roundedPanel.add(botonBorrar);

        // AÑADIDAS A LA PANTALAL EN GENERAL

        this.add(myBar);
        this.add(roundedPanel);

    }
}

class RoundedPanel extends JPanel {
    private int cornerRadius;

    public RoundedPanel(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(0, 0, width - 1, height - 1, cornerRadius, cornerRadius);
        g2.setColor(getBackground());
        g2.fill(roundedRectangle);

        g2.setColor(getForeground());
        g2.draw(roundedRectangle);

        g2.dispose();
    }
}