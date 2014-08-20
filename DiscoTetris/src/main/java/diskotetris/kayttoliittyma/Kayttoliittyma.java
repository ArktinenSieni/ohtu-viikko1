package diskotetris.kayttoliittyma;

import diskotetris.peli.Discopeli;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author matti
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private final Discopeli peli;
    private final Piirtoalusta piirtoalusta;

    public Kayttoliittyma() {
        this.peli = new Discopeli(this);
        this.piirtoalusta = new Piirtoalusta(this.peli);
    }

    @Override
    public void run() {
        frame = new JFrame("Disco Tetris");

        final int leveys = 500;
        final int korkeus = 600;
        Dimension haluttuKoko = new Dimension(leveys, korkeus);

        frame.setPreferredSize(haluttuKoko);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        

    }

    private void luoKomponentit(Container container) {
        JPanel testiTiedot = luoPelitiedot();

        container.add(testiTiedot, BorderLayout.EAST);

        container.add(piirtoalusta);

        frame.addKeyListener(new NappaimistonKuuntelija(peli, piirtoalusta));

    }

    private JPanel luoPelitiedot() {
        JPanel panel = new JPanel(new GridLayout(3, 1));

        panel.setPreferredSize(new Dimension(200, 600));

        JLabel aika = new JLabel("Nuolinäppäimet");
        JLabel taso = new JLabel("Space: vaihto");
        JLabel pisteet = new JLabel("S: Uusi rivi");

        panel.add(aika);
        panel.add(taso);
        panel.add(pisteet);

        return panel;
    }

    

    public JFrame getFrame() {
        return frame;
    }

    public Piirtoalusta getPiirtoalusta() {
        return this.piirtoalusta;
    }

}
