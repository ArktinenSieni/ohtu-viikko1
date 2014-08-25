package diskotetris.peli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Huolehtii piste-ennätysten tallentamisesta.
 *
 * @author matti
 */
public class Tiedostonlukija {

    private File pisteEnnatykset;

    public Tiedostonlukija() {
        this.pisteEnnatykset = new File("pisteennatykset.txt");

        if (!pisteEnnatykset.exists()) {
            try {
                pisteEnnatykset.createNewFile();
            } catch (IOException ex) {
                System.out.println("Tiedostoa ei saatu luotua!");
            }
        }
    }

    /**
     * Lukee pistetiedoston sisällön palauttaen
     *
     * @return palauttaa pisteet ArrayListissä
     * @throws FileNotFoundException
     */
    public ArrayList<Integer> luePisteet() throws FileNotFoundException {
        ArrayList<Integer> pisteet = new ArrayList<Integer>();
        Scanner lukija = new Scanner(pisteEnnatykset);

        while (lukija.hasNextLine()) {
            pisteet.add(Integer.parseInt(lukija.nextLine()));
        }

        return pisteet;
    }

    /**
     * Tallentaa kymmenen parasta pistemäärää.
     *
     * @param pisteet
     */
    public void tallennaEnnatykset(ArrayList<Integer> pisteet) {
        FileWriter kirjoittaja;

        try {
            kirjoittaja = new FileWriter(pisteEnnatykset);
            for (Integer integer : pisteet) {
                kirjoittaja.write("" + integer + "\n");
            }
            
            kirjoittaja.close();

        } catch (IOException ex) {
            System.out.println("Kirjoittajan luominen epäonnistui");
        }
    }
}
