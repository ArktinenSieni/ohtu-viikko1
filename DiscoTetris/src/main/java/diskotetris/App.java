package diskotetris;

import diskotetris.kayttoliittyma.Kayttoliittyma;
import diskotetris.peli.Discopeli;
import java.io.FileNotFoundException;
import javax.swing.SwingUtilities;


/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws FileNotFoundException {
        Kayttoliittyma GUI = new Kayttoliittyma(new Discopeli());
        SwingUtilities.invokeLater(GUI);
        
        while (GUI.getPaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei luotu");
            }
        }
        GUI.getDiscopeli().setPaivitettava(GUI.getPaivitettava());
        GUI.getDiscopeli().start();
        
    }

    
}
