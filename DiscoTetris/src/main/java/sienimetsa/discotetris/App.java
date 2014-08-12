package sienimetsa.discotetris;

import sienimetsa.discotetris.logiikka.Vari;
import sienimetsa.discotetris.logiikka.kursori;
import sienimetsa.discotetris.logiikka.lauta;
import sienimetsa.discotetris.logiikka.palikka;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        lauta testilauta = new lauta();
        kursori kohdistin = new kursori(testilauta);

        tulostaRivit(testilauta, 2);
        
        
        testilauta.generoiRivi();

        System.out.println("***");
        System.out.println("Generointi");
        System.out.println("***");

        testilauta.generoiRivi();
        tulostaRivit(testilauta, 2);

        System.out.println("***");
        System.out.println("Vaihto");
        System.out.println("***");

        testilauta.vaihto(0, 0, 0, 1);
        tulostaRivit(testilauta, 2);

        System.out.println("***");
        System.out.println("Työntö");
        System.out.println("***");

        testilauta.tyonnaRivi();
        tulostaRivit(testilauta, 3);
        
        System.out.println("***");
        System.out.println("Pudotus");
        System.out.println("***");
        
        testilauta.tyonnaRivi();
        testilauta.tyonnaRivi();
        testilauta.pudotaPalikka(0, 4);
        testilauta.pudotaPalikka(5, 3);
        tulostaRivit(testilauta, 4);

        System.out.println("***");
        System.out.println("Painovoima");
        System.out.println("***");
        
        testilauta.painovoima();
        tulostaRivit(testilauta, 4);
        
        System.out.println("***");
        System.out.println("vaihtokursorilla");
        System.out.println("***");
        
        kohdistin.oikea();
        kohdistin.oikea();
        kohdistin.vaihda();
        
        tulostaRivit(testilauta, 3);
    }

    public static void tulostaRivit(lauta banaani, int rivimaara) {
        for (int j = rivimaara - 1; j >= 0; j--) {

            for (int i = 0; i < banaani.getLauta().length; i++) {
                System.out.print("[" + banaani.getLauta()[i][j].getVari() + "]");
            }
            System.out.println("");
        }
    }
}
