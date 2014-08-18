package diskotetris.kayttoliittyma;

import diskotetris.logiikka.Vari;
import diskotetris.peli.Discopeli;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author matti
 */
public class Piirtoalusta extends JPanel {

    private Discopeli peli;

    public Piirtoalusta(Discopeli peli) {
        super.setBackground(Color.black);
        this.peli = peli;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
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
}
