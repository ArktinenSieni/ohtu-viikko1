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
    private int kulunutAika;

    public void Pistelaskuri() {
        aika = 0;
        pisteet = 0;
        this.viimeisinLisatty = 0;
        this.kulunutAika = 0;
    }

    public int getKulunutAika() {
        return this.kulunutAika;
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
        aika = 120;
        pisteet = 0;
        kulunutAika = 0;
    }

    /**
     * Vähentää aikaa.
     */
    public void aikaKuluu() {
        if (aika > 0) {
            aika--;
            this.kulunutAika ++;
        }
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
            aika += 1;
        } else if (poistetut >= 5 && poistetut < 7) {
            pisteet += poistetut * 300;
            this.viimeisinLisatty = poistetut * 300;
            aika += 2;
        } else if (poistetut >= 7) {
            pisteet += poistetut * 500;
            this.viimeisinLisatty = poistetut * 500;
            aika += 3;
        }
    }
}
