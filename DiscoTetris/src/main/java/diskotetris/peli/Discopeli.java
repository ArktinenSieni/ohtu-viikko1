package diskotetris.peli;

import java.util.ArrayList;
import diskotetris.logiikka.Tarkastaja;
import diskotetris.logiikka.Vari;
import diskotetris.logiikka.Kursori;
import diskotetris.logiikka.Lauta;
import diskotetris.logiikka.Palikka;

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
    
    public Discopeli() {
        pelilauta = new Lauta();
        tarkastaja = new Tarkastaja(pelilauta);
        kursori = new Kursori(pelilauta);
        pyoriiko = false;
        gameOver = false;
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
     * Pelin alkaessa suoritettava toiminto.
     * Peli alkaa aina kolmella generoidulla rivillä.
     */
    public void generoiAloitus() {
        for (int i = 0; i < 3; i++) {
            pelilauta.generoiRivi();
            pelilauta.tyonnaRivi();
        }
        
        pelilauta.generoiRivi();
    }
    
    /**
     * Tuottaa uuden rivin.
     * Suoritetaan joko pelaajan aloitteesta, tai tietyn aikamäärän kuluessa.
     */
    public void uusiRivi() {
        pelilauta.tyonnaRivi();
        pelilauta.generoiRivi();
    }
    
    public void poistaYhdistelmat() {
        ArrayList<Palikka> poistettavat = this.tarkastaja.tarkastaLauta();
        
        for (Palikka palikka : poistettavat) {
            pelilauta.poistaPalikka(palikka);
        }
    }
    
    public void peliLooppi() {
            pelilauta.painovoima();
            ArrayList<Palikka> lista = tarkastaja.tarkastaLauta();
            //render
            //päivitysmetodi todennäköisemmin tulee käyttöliittymän puolelle
            
            if(lista.size() > 3) {
                //pisteytä
                for (Palikka object : lista) {
                    object.setVari(Vari.TYHJA);
                    lista.clear();
                }
                //render
                
            }
    }
}
