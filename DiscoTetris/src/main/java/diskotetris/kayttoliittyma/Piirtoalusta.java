package diskotetris.kayttoliittyma;

import diskotetris.logiikka.Kursori;
import diskotetris.logiikka.Lauta;
import diskotetris.logiikka.Vari;
import diskotetris.peli.Discopeli;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Collections;
import javax.swing.JPanel;

/**
 * Piirtää pelilaudan palikat ja kursorin.
 *
 * @author matti
 */
public class Piirtoalusta extends JPanel implements Paivitettava {

    private final Lauta pelilauta;
    private final Kursori kursori;
    private final Discopeli peli;

    public Piirtoalusta(Discopeli peli) {
        super.setBackground(Color.black);
        this.pelilauta = peli.getPelilauta();
        this.kursori = peli.getKursori();
        this.peli = peli;
    }

    /**
     * Kokoaa piirrettävät kohteet.
     *
     * @param graphics
     */
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        piirraPalikat(graphics);
        piirraKursori(graphics);
        piirraPistealusta(graphics);

    }

    /**
     * Piirtää vaaleanvihreän värisen kursorin kursori-metodin koordinaattien
     * mukaan.
     *
     * @see diskotetris.logiikka.Kursori
     *
     * @param graphics
     */
    public void piirraKursori(Graphics graphics) {
        graphics.setColor(Color.green);

        int x = kursori.getX() * 50;
        int y = 600 - kursori.getY() * 50;

        graphics.fillRect(x, y, 100, 5);
        graphics.fillRect(x + 95, y, 5, 50);
        graphics.fillRect(x, y, 5, 45);
        graphics.fillRect(x, y + 45, 100, 5);
    }

    /**
     * Muuttaa annetun Väri-enumluokan Swingin luokkaan Color. Palikoiden
     * piirtämiseen vaadittava apumetodi.
     *
     * @param vari Annettu Vari
     * @return Swingin Color
     */
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

    /**
     * Piirtää palikat pelilaudalle. Ottaa koordinaatit lauta-luokan mukaan.
     *
     * @see diskotetris.logiikka.Lauta
     *
     * @param graphics
     */
    public void piirraPalikat(Graphics graphics) {
        for (int i = 0; i < pelilauta.maxX(); i++) {
            for (int j = 1; j < pelilauta.maxY() - 1; j++) {
                graphics.setColor(variToColor(pelilauta.getPalikanVari(i, j)));

                graphics.fill3DRect(i * 50, 600 - j * 50, 50, 50, true);

            }
        }
    }

    @Override
    public void paivita() {
        super.repaint();
    }

    private void piirraPistealusta(Graphics graphics) {
        graphics.setColor(Color.lightGray);
        graphics.setFont(new Font("Helvetica", Font.BOLD, 18));
        
        graphics.fill3DRect(300, 0, 200, 200, true);
        graphics.setColor(Color.black);
        graphics.drawString("Pisteesi: " + peli.getLaskuri().getPisteet(), 320, 50);
        graphics.drawString("+ " + peli.getLaskuri().getViimeisinLisatty(), 320, 150);
        
        if (peli.getLaskuri().getAika() < 10) {
            graphics.setColor(Color.red);
        } else {
            graphics.setColor(Color.darkGray);
        }
        
        graphics.fill3DRect(300, 200, 200, 200, true);
        graphics.setColor(Color.black);
        graphics.drawString("Aika: " + peli.getLaskuri().getAika(), 310, 250);
        graphics.drawString("Space = vaihda", 310, 290);
        graphics.drawString("palikoiden paikkaa", 310, 310);
        graphics.drawString("S = työnnä rivi", 310, 330);
        graphics.drawString("R = uusi peli", 310, 350);
        
        
        graphics.setColor(Color.lightGray);
        graphics.fill3DRect(300, 400, 200, 200, true);
        
        graphics.setColor(Color.black);
        
        for (int i = 0; i < peli.getPisteet().size() && i <= 10 ; i++) {
            graphics.drawString("" + (i + 1) + ". " + peli.getPisteet().get(i), 320, 420 + 20 * i);
            
        }
    }

}
