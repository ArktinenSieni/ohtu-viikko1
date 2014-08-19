package diskotetris.kayttoliittyma;

import diskotetris.logiikka.Kursori;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author mcraty
 */
public class NappaimistonKuuntelija implements KeyListener{

    private Component component;
    private Kursori kursori;
    
    public NappaimistonKuuntelija(Kursori kursori, Component component) {
        this.kursori = kursori;
        this.component = component;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            kursori.vasen();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            kursori.oikea();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            kursori.ylos();
            System.out.println(kursori.getY());
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            kursori.alas();
            System.out.println(kursori.getY());
        } 
//        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//            kursori.vaihda();
//        }
        
        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
