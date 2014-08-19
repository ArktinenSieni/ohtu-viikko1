package diskotetris.kayttoliittyma;

import diskotetris.logiikka.Kursori;
import diskotetris.logiikka.Lauta;
import diskotetris.logiikka.Palikka;
import diskotetris.logiikka.Vari;
import diskotetris.peli.Discopeli;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author matti
 */
public class Piirtoalusta extends JPanel {

    private Lauta pelilauta;
    private Kursori kursori;

    public Piirtoalusta(Discopeli peli) {
        super.setBackground(Color.black);
        this.pelilauta = peli.getPelilauta();
        this.kursori = peli.getKursori();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        piirraPalikat(graphics);
        piirraKursori(graphics);

    }

    public void piirraKursori(Graphics graphics) {
        graphics.setColor(Color.green);

        int x = kursori.getX() * 50;
        int y = 600 - kursori.getY() * 50;

        graphics.fillRect(x, y, 100, 5);
        graphics.fillRect(x + 100, y, 5, 50);
        graphics.fillRect(x, y, 5, 45);
        graphics.fillRect(x, y + 45, 105, 5);
    }

    private Color variToColor(Vari vari) {
        if (vari == Vari.SININEN) {
            return Color.blue;
        }

        if (vari == Vari.KELTAINEN) {
            return Color.yellow;
        }
        if (vari == Vari.PUNAINEN) {
            return Color.red;
        }
        if (vari == Vari.VIOLETTI) {
            return Color.magenta;
        }
        if (vari == Vari.VALKOINEN) {
            return Color.white;
        }

        return Color.black;
    }

    public void piirraPalikat(Graphics graphics) {
        for (int i = 0; i < pelilauta.maxX(); i++) {
            for (int j = 1; j < pelilauta.maxY() - 1; j++) {
                graphics.setColor(variToColor(pelilauta.getPalikanVari(i, j)));

                graphics.fillRect(i * 50, 600 - j * 50, 50, 50);
            }
        }
    }

}
