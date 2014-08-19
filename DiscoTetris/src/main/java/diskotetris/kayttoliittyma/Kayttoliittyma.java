package diskotetris.kayttoliittyma;

import diskotetris.peli.Discopeli;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
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
    private Discopeli peli;
    private Piirtoalusta piirtoalusta;

    public Kayttoliittyma(Discopeli peli) {
        this.peli = peli;
        this.piirtoalusta = new Piirtoalusta(this.peli);
    }

    @Override
    public void run() {
        frame = new JFrame("Disko Tetris");

        final int leveys = 500;
        final int korkeus = 630;
        Dimension haluttuKoko = new Dimension(leveys, korkeus);

        frame.setPreferredSize(haluttuKoko);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void luoKomponentit(Container container) {
        JPanel testiTiedot = luoPelitiedot();

        container.add(piirtoalusta);
        
        container.add(testiTiedot, BorderLayout.EAST);
        
        frame.addKeyListener(new NappaimistonKuuntelija(peli.getKursori(), piirtoalusta));

    }

    private JPanel luoPelitiedot() {
        JPanel panel = new JPanel(new GridLayout(3, 1));


        panel.setPreferredSize(new Dimension(190, 600));

        JLabel aika = new JLabel("Aika: 120");
        JLabel taso = new JLabel("Taso: 3");
        JLabel pisteet = new JLabel("Pisteet: 9001");

        panel.add(aika);
        panel.add(taso);
        panel.add(pisteet);

        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }

}
