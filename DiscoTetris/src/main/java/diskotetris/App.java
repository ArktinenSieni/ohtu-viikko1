package diskotetris;

import diskotetris.kayttoliittyma.Kayttoliittyma;
import javax.swing.SwingUtilities;


/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Kayttoliittyma GUI = new Kayttoliittyma();
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
