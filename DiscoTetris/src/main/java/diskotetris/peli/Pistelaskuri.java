package diskotetris.peli;

import java.util.ArrayList;

/**
 * Luokka pisteiden ja ajan päivittämiselle. 
 *
 * @author mcraty
 */
public class Pistelaskuri {

    private int aika;
    private int pisteet;
    private int viimeisinLisatty;

    public void Pistelaskuri() {
        aika = 0;
        pisteet = 0;
        this.viimeisinLisatty = 0;
    }

    public int getViimeisinLisatty() {
        return viimeisinLisatty;
    }

    public int getAika() {
        return aika;
    }

    public int getPisteet() {
        return pisteet;
    }

    public void setAika(int aika) {
        this.aika = aika;
    }

    public void aloitusTilanne() {
        aika = 60;
        pisteet = 0;
    }

    /**
     * Vähentää aikaa.
     */
    public void aikaKuluu() {
        if (aika > 0) {
            aika--;
        }
    }
    
    /**
     * Vähentää tai lisää pisteitä. Tarkoitettu palikoiden työntämisestä
     * aihetuvaan sakkoon.
     * 
     * @param pistemaara 
     */
    public void muutaPisteita(int pistemaara) {
        this.pisteet += pistemaara;
    }

    /**
     * Laskee saadun pistemäärän ja saadun lisäajan. 
     *
     * @param poistetut poistettavien palikoiden lukumäärä
     * @see diskotetris.logiikka.Tarkastaja
     */
    public void laskePisteet(int poistetut) {
        if (poistetut < 3) {

        } else if (poistetut >= 3 && poistetut < 5) {
            pisteet += poistetut * 100;
            this.viimeisinLisatty = poistetut * 100;
            aika += 2;
        } else if (poistetut >= 5 && poistetut < 7) {
            pisteet += poistetut * 300;
            this.viimeisinLisatty = poistetut * 300;
            aika += 3;
        } else if (poistetut >= 7) {
            pisteet += poistetut * 500;
            this.viimeisinLisatty = poistetut * 500;
            aika += 5;
        }
    }
}
