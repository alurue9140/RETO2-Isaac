package View;

import Controller.ControllerPanelBienvenida;
import Controller.ControllerTeclas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.lang.System.exit;

public class PanelBienvenida extends JPanel {

    public static JPasswordField cajaContrasena;

    public static JButton botonOK;

    public PanelBienvenida() {
        setLayout(null);
        this.setVisible(true);

        // Panel para la imagen
        JPanel panelImagen = new JPanel();
        panelImagen.setBounds(490, 210, 200, 210); // Establece las coordenadas y el tamaño del panel de la imagen
        ImageIcon imagen = new ImageIcon("src/Recursos/inicio.png");
        JLabel etiquetaImagen = new JLabel(imagen);
        etiquetaImagen.setBounds(0, 0, 200, 200); // Establece las coordenadas y el tamaño de la imagen dentro del panel
        panelImagen.add(etiquetaImagen);

        // Panel para la caja de texto
        JPanel panelTexto = new JPanel();
        panelTexto.setBounds(470, 420, 200, 30); // Establece las coordenadas y el tamaño del panel de texto
        cajaContrasena = new JPasswordField(16); // Puedes ajustar el tamaño de la caja de texto aquí

        cajaContrasena.addKeyListener(new ControllerTeclas());
        panelTexto.add(cajaContrasena);


        // Panel para los boton OK
        JPanel panelBotonOK = new JPanel();
        panelBotonOK.setBounds(590, 420, 200, 35); // Establece las coordenadas y el tamaño del panel de botones
        botonOK = new JButton("OK");
        botonOK.setFont(new Font("Arial",Font.BOLD,16));
        botonOK.setContentAreaFilled(false);
        botonOK.setBorder(null);
        botonOK.addActionListener((e) -> {
            ControllerPanelBienvenida.verificar(cajaContrasena);
        });
        panelBotonOK.add(botonOK);

        // Panel para los boton Apagar
        JPanel panelBotonApagar = new JPanel();
        panelBotonApagar.setBounds(1020, 680, 200, 100); // Establece las coordenadas y el tamaño del panel de botones
        JButton botonApagar = new JButton(new ImageIcon("src/Recursos/apagar.png"));
        botonApagar.setContentAreaFilled(false);
        botonApagar.setBorder(null);
        botonApagar.addActionListener((e) -> {
            exit(0);
        });
        panelBotonApagar.add(botonApagar);

        /*
        // Panel para cambiar fondo
        JPanel panelAlternoModo = new JPanel();
        panelAlternoModo.setBounds(1120, 680, 200, 100); // Establece las coordenadas y el tamaño del panel de botones
        JButton botonAlternoModo = new JButton(new ImageIcon("src/Recursos/apagar.png"));
        botonAlternoModo.setContentAreaFilled(false);
        botonAlternoModo.setBorder(null);
        botonAlternoModo.addActionListener((e) -> {
            exit(0);
        });
        panelAlternoModo.add(botonAlternoModo);

         */

        // Agregar los paneles al panel de bienvenida
        add(panelImagen);
        add(panelTexto);
        add(panelBotonOK);
        add(panelBotonApagar);
        //add(panelAlternoModo);
    }

}
