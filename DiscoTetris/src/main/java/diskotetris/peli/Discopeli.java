package diskotetris.peli;

import diskotetris.kayttoliittyma.Kayttoliittyma;
import java.util.ArrayList;
import diskotetris.logiikka.Tarkastaja;
import diskotetris.logiikka.Vari;
import diskotetris.logiikka.Kursori;
import diskotetris.logiikka.Lauta;
import diskotetris.logiikka.Palikka;
import java.awt.Component;
import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author matti
 *
 * Toimii logiikan ja käyttöliittymän "välittäjänä". Kokoaa logiikan yhteen
 * käyttöliittymän käytettäväksi.
 */
public class Discopeli {

    final Lauta pelilauta;
    final Tarkastaja tarkastaja;
    final Kursori kursori;
    public boolean pyoriiko;
    public boolean gameOver;
    private Component component;

    public Discopeli(Kayttoliittyma UI) {
        pelilauta = new Lauta();
        tarkastaja = new Tarkastaja(pelilauta);
        kursori = new Kursori(pelilauta);
        pyoriiko = false;
        gameOver = false;
        component = UI.getPiirtoalusta();
        generoiAloitus();
    }

    public Lauta getPelilauta() {
        return pelilauta;
    }

    public Tarkastaja getTarkastaja() {
        return tarkastaja;
    }

    public Kursori getKursori() {
        return kursori;
    }

    /**
     * Työntää yhden rivin ylös ottaen huomioon pelilaudan rajat.
     */
    public void tyonnaRivi() {
        if (!tarkastaja.liianKorkea()) {
            pelilauta.tyonnaRivi();
        }
    }

    /**
     * Pelin alkaessa suoritettava toiminto. Peli alkaa aina kolmella
     * generoidulla rivillä.
     */
    public void generoiAloitus() {
        pelilauta.alusta();
        
        for (int i = 0; i < 3; i++) {
            pelilauta.generoiRivi();
            pelilauta.tyonnaRivi();
        }

        pelilauta.generoiRivi();
    }

    /**
     * Tuottaa uuden rivin. Suoritetaan joko pelaajan aloitteesta, tai tietyn
     * aikamäärän kuluessa.
     */
    public void uusiRivi() {
        pelilauta.tyonnaRivi();
        pelilauta.generoiRivi();
    }

    /**
     * Poistaa kaikki vähintään kolmen pituiset yhdistelmät kerralla.
     */
    public void poistaYhdistelmat() {
        ArrayList<Palikka> poistettavat = this.tarkastaja.tarkastaLauta();

        for (Palikka palikka : poistettavat) {
            pelilauta.poistaPalikka(palikka);
        }
    }

    /**
     * Päivittää laudan tilanteen yhdistelmien ja avoimien kohtien esiintyessä.
     */
    public void laudanPaivitys() {
        pelilauta.painovoima();
        poistaYhdistelmat();
        pelilauta.painovoima();
        

    }

    /**
     * Tarkastaa että täyttyvätkö pelin jatkumisen ehdot.
     *
     */
    public void jatkuukoPeli() {
        this.gameOver = tarkastaja.liianKorkea();
    }

    /**
     * Metodi pelipäivityksien hoitamiseksi.
     */
    public void peliLooppi() throws InterruptedException {

        while (!gameOver) {
            laudanPaivitys();
            component.repaint();
            Thread.sleep(1);

        }
        
        generoiAloitus();
        
        peliLooppi();

    }
}
