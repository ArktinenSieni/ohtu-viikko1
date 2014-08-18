/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    
    public void generoiAloitus() {
        for (int i = 0; i < 3; i++) {
            pelilauta.generoiRivi();
            pelilauta.tyonnaRivi();
        }
        
        pelilauta.generoiRivi();
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
