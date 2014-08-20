package diskotetris.logiikka;

import java.util.Random;

/**
 *
 * @author mcraty Luokka pitää yllä pelilautaa ja siinä olevia palikoita.
 * Vaakarivi (y-akseli) 0 on tarkoitettu ainoastaan riviksi, johon generoidaan
 * rivi, joka on täynnä erivärisiä palikoita. Vaakariviä 13 käytetään pelin
 * jatkumisen tarkistamiseen. Jos rivillä 13 on värillinen palikka, peli
 * päättyy. Itse pelaajan käytössä on siis vaakarivit 1-12, ja pystyrivit
 * (x-akseli) 0-5.
 */
public class Lauta {

    private Palikka[][] pelilauta;
    final int x;
    final int y;

    public Lauta() {
        pelilauta = new Palikka[6][14];
        x = pelilauta.length;
        y = pelilauta[0].length;
        this.alusta();

    }

    public int maxX() {
        return x;
    }

    public int maxY() {
        return y;
    }

    public Palikka getPalikka(int x, int y) {
        return pelilauta[x][y];
    }

    public Vari getPalikanVari(int x, int y) {
        return getPalikka(x, y).getVari();
    }

    public Vari getPalikanVari(Palikka palikka) {
        return palikka.getVari();
    }

    /**
     * Metodi joka alustaa pelilaudan joka pelin alkuun. Se täyttää jokaisen
     * taulukon paikan "tyhjällä" palikalla.
     */
    public void alusta() {
        for (int i = 0; i < maxX(); i++) {
            for (int j = 0; j < maxY(); j++) {
                pelilauta[i][j] = new Palikka(Vari.TYHJA);
            }
        }
    }

    /**
     * Arpoo palikalle Värin. Helpottaa rivien generointia.
     *
     * @return Palauttaa arvotun Värin.
     */
    private Vari arvoVari() {
        Vari[] varit = {Vari.KELTAINEN, Vari.PUNAINEN, Vari.SININEN, Vari.VALKOINEN, Vari.VIOLETTI};

        Random arpoja = new Random();
        int luku = arpoja.nextInt(5);

        return varit[luku];
    }

    /**
     * Generoi yksittäisen rivin. Asetetaan vaakariville 0.
     */
    public void generoiRivi() {
        for (int i = 0; i < pelilauta.length; i++) {
            pelilauta[i][0] = new Palikka(arvoVari());
        }
    }

    /**
     * Vaihdetaan kahden palikan paikkaa koordinaattien perusteella.
     * Hyödynnetään Kursori-oliolla.
     *
     * @see diskotetris.logiikka.Kursori
     *
     * @param alkuX Ensimmäisen palikan x-koordinaatti.
     * @param alkuY Ensimmäisen palikan y-koordinaatti.
     * @param kohdeX Toisen palikan x-koordinaatti.
     * @param kohdeY Toisen palikan y-koordinaatti.
     */
    public void vaihto(int alkuX, int alkuY, int kohdeX, int kohdeY) {

        if (((alkuX >= 0 && alkuX <= maxX() - 1)
                && (alkuY >= 0 && alkuY <= maxY() - 1))
                && ((kohdeX >= 0 && kohdeX <= maxX() - 1)
                && (kohdeY >= 0 && kohdeY <= maxY() - 1))) {
            Palikka apu = pelilauta[alkuX][alkuY];

            pelilauta[alkuX][alkuY] = pelilauta[kohdeX][kohdeY];
            pelilauta[kohdeX][kohdeY] = apu;

        }

    }

    /**
     * Työnnetään koko taulukon palikoita ylöspäin yhdellä rivillä.
     * Mukaanlukien myös vaakarivi 0, johon on jo valmis rivi generoitu.
     *
     */
    public void tyonnaRivi() {

        for (int i = 0; i < pelilauta.length; i++) {
            for (int j = pelilauta[i].length; j > 0; j--) {
                vaihto(i, j, i, j - 1);
            }
        }
        this.generoiRivi();
    }

    /**
     * Pudotetaan yksittäinen palikka.
     * Valitaan koordinaattien perusteella. Painovoima-metodin apumetodi.
     * 
     * @param x
     * @param y 
     */
    public void pudotaPalikka(int x, int y) {
        if (y > 1 && getPalikanVari(x, y - 1) == Vari.TYHJA) {
            vaihto(x, y, x, y - 1);
            pudotaPalikka(x, y - 1);
        }
    }

    /**
     * Logiikka kaikkien palikoiden pudottamiselle.
     * Tapahtuu tapauksessa jos värillisen palikan alla on tyhjä palikka.
     */
    public void painovoima() {
        for (int i = 0; i < maxX(); i++) {
            for (int j = 0; j < maxY(); j++) {
                this.pudotaPalikka(i, j);
            }
        }
    }

    /**
     * Palikan "tyhjentäminen" koordinaattien mukaan.
     * Täytyy vielä punnita hyödyllisyyttä.
     * 
     * @param x
     * @param y 
     */
    public void poistaPalikka(int x, int y) {
        this.pelilauta[x][y].setVari(Vari.TYHJA);
    }
    
    /**
     * Palikan "tyhjentäminen" annetun palikan mukaan.
     * 
     * @param palikka 
     */
    public void poistaPalikka(Palikka palikka) {
        palikka.setVari(Vari.TYHJA);
    }

    public Palikka[][] getLauta() {
        return pelilauta;
    }
}
