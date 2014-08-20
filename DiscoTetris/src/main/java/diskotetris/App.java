package diskotetris;

import diskotetris.kayttoliittyma.Kayttoliittyma;
import diskotetris.logiikka.Tarkastaja;
import diskotetris.logiikka.Vari;
import diskotetris.logiikka.Kursori;
import diskotetris.logiikka.Lauta;
import diskotetris.logiikka.Palikka;
import diskotetris.peli.Discopeli;
import java.util.ArrayList;
import javax.swing.SwingUtilities;


/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Kayttoliittyma testi = new Kayttoliittyma();
        SwingUtilities.invokeLater(testi);



    }

    public static void tulostaRivit(Lauta banaani, int rivimaara) {
        for (int j = rivimaara - 1; j >= 0; j--) {

            for (int i = 0; i < banaani.getLauta().length; i++) {
                System.out.print("[" + banaani.getLauta()[i][j].getVari() + "]");
            }
            System.out.println("");
        }
    }
    
    public static void tulostaLauta(Lauta banaani) {
        for (int j = banaani.maxY() - 1; j >= 0; j--) {
            for (int i = 0; i < banaani.maxX(); i++) {
                System.out.print("[" + banaani.getLauta()[i][j].getVari() + "]");
            }
            System.out.println("");
        }
    }
}
