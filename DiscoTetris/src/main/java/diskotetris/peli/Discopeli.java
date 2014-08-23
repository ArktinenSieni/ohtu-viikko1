package diskotetris.peli;

import diskotetris.kayttoliittyma.Paivitettava;
import diskotetris.logiikka.Kursori;
import diskotetris.logiikka.Lauta;
import diskotetris.logiikka.Palikka;
import diskotetris.logiikka.Tarkastaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

    public Discopeli() {
        super(1000, null);
        pelilauta = new Lauta();
        tarkastaja = new Tarkastaja(pelilauta);
        kursori = new Kursori(pelilauta);
        pyoriiko = false;
        gameOver = false;
        generoiAloitus();

        addActionListener(this);
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

        this.pyoriiko = true;
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
        tarkastaLauta();
        paivitettava.paivita();

    }

}
