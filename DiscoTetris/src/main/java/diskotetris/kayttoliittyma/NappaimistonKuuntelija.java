package diskotetris.kayttoliittyma;

import diskotetris.logiikka.Kursori;
import diskotetris.peli.Discopeli;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
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

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            kursori.vasen();
//            peli.getPelilauta().painovoima();
//            peli.poistaYhdistelmat();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            kursori.oikea();
//            peli.getPelilauta().painovoima();
//            peli.poistaYhdistelmat();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            kursori.ylos();
//            peli.getPelilauta().painovoima();
//            peli.poistaYhdistelmat();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            kursori.alas();
//            peli.getPelilauta().painovoima();
//            peli.poistaYhdistelmat();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            kursori.vaihda();
//            peli.getPelilauta().painovoima();
//            peli.poistaYhdistelmat();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            peli.tyonnaRivi();
//            peli.getPelilauta().painovoima();
//            peli.poistaYhdistelmat();
        }

        component.repaint();
    }

}
