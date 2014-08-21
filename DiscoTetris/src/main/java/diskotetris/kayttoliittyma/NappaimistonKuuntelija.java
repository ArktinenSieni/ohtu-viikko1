package diskotetris.kayttoliittyma;

import diskotetris.logiikka.Kursori;
import diskotetris.peli.Discopeli;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Ottaa vastaan näppäimistökomennot peliä varten. Testiversiossa myös
 * päivittää laudan.
 * 
 * @author mcraty
 */
public class NappaimistonKuuntelija implements KeyListener {

    private final Component component;
    private final Discopeli peli;
    private final Kursori kursori;

    public NappaimistonKuuntelija(Discopeli peli, Component component) {
        this.peli = peli;
        this.kursori = peli.getKursori();
        this.component = component;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Määrittelee kunkin näppäimistön napin painalluksen seuraukset.
     * 
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            kursori.vasen();
            peli.tarkastaLauta();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            kursori.oikea();
            peli.tarkastaLauta();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            kursori.ylos();
            peli.tarkastaLauta();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            kursori.alas();
            peli.tarkastaLauta();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            kursori.vaihda();
            peli.tarkastaLauta();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            peli.tyonnaRivi();
            peli.tarkastaLauta();
        }

        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}
