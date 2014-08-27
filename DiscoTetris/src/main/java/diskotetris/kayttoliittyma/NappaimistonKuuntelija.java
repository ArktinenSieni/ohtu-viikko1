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

    private final Paivitettava paivitettava;
    private final Discopeli peli;
    private final Kursori kursori;

    public NappaimistonKuuntelija(Discopeli peli, Paivitettava paivitettava) {
        this.peli = peli;
        this.kursori = peli.getKursori();
        this.paivitettava = paivitettava;
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
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            kursori.oikea();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            kursori.ylos();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            kursori.alas();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            kursori.vaihda();            
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            peli.tyonnaRivi();
        }

        paivitettava.paivita();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}
