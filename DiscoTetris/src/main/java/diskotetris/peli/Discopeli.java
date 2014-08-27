package diskotetris.peli;

import diskotetris.kayttoliittyma.Paivitettava;
import diskotetris.logiikka.Kursori;
import diskotetris.logiikka.Lauta;
import diskotetris.logiikka.Palikka;
import diskotetris.logiikka.Tarkastaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 * Toimii logiikan ja käyttöliittymän "välittäjänä". Kokoaa logiikan yhteen
 * käyttöliittymän käytettäväksi.
 *
 * @author matti
 */
public class Discopeli extends Timer implements ActionListener {

    private final Lauta pelilauta;
    private final Tarkastaja tarkastaja;
    private final Kursori kursori;
    private boolean pyoriiko;
    private boolean gameOver;
    private Paivitettava paivitettava;
    private Pistelaskuri laskuri;
    private Tiedostonlukija lukija;
    private ArrayList<Integer> pisteet;

    public Discopeli() throws FileNotFoundException {
        super(1000, null);
        pelilauta = new Lauta();
        tarkastaja = new Tarkastaja(pelilauta);
        kursori = new Kursori(pelilauta);
        gameOver = false;
        laskuri = new Pistelaskuri();
        lukija = new Tiedostonlukija();
        pisteet = lukija.luePisteet();
        generoiAloitus();

        addActionListener(this);
    }

    public Pistelaskuri getLaskuri() {
        return laskuri;
    }

    public ArrayList<Integer> getPisteet() {
        Collections.sort(pisteet);
        Collections.reverse(pisteet);
        return pisteet;
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
     * Työntää yhden rivin ylös ottamatta huomioon pelikentän rajoja.
     */
    public void tyonnaRivi() {
            pelilauta.tyonnaRivi();
            laskuri.aikaKuluu();
            laskuri.muutaPisteita(-100);
    }

    /**
     * Pelin alkaessa suoritettava toiminto. Peli alkaa aina kolmella
     * generoidulla rivillä.
     */
    public void generoiAloitus() {
        pelilauta.alusta();

        for (int i = 0; i < 5; i++) {
            pelilauta.generoiRivi();
            pelilauta.tyonnaRivi();
        }

        pelilauta.generoiRivi();

        this.gameOver = false;

        laskuri.aloitusTilanne();
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
     * Poistaa kaikki vähintään kolmen pituiset yhdistelmät kerralla. Lisäksi
     * ilmoittaa metodin kutsujalle, että tapahtuiko poistoa.
     */
    public boolean poistaYhdistelmat() {
        ArrayList<Palikka> poistettavat = this.tarkastaja.tarkastaLauta();

        if (poistettavat.size() > 0) {
            laskuri.laskePisteet(poistettavat.size());

            for (Palikka palikka : poistettavat) {
                pelilauta.poistaPalikka(palikka);
            }
            paivitettava.paivita();
            return true;
        }
        return false;
    }

    /**
     * Tarkastaa että onko poistettavia. Jokaisen palikoiden poiston jälkeen
     * pudottaa palikat.
     */
    public void tarkastaLauta() {
        this.pelilauta.painovoima();
        while (poistaYhdistelmat()) {
            this.pelilauta.painovoima();
        }
    }

    /**
     * Tarkastaa että täyttyvätkö pelin jatkumisen ehdot.
     *
     */
    public boolean jatkuukoPeli() {
        this.gameOver = tarkastaja.liianKorkea();
        if (laskuri.getAika() == 0) {
            this.gameOver = true;
        }

        if (this.gameOver) {
            return false;
        }

        return true;
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jatkuukoPeli()) {
            tarkastaLauta();
            paivitettava.paivita();
            laskuri.aikaKuluu();

        } else {
            pisteet.add(laskuri.getPisteet());
            lukija.tallennaEnnatykset(pisteet);

            this.generoiAloitus();

        }

    }

}
