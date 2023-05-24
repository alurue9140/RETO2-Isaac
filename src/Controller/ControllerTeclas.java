package Controller;

import View.PanelBienvenida;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ControllerTeclas extends KeyAdapter {
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar()==KeyEvent.VK_ENTER){
            PanelBienvenida.botonOK.doClick();
        }
    }
}
