/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peli;

import java.util.ArrayList;
import sienimetsa.discotetris.logiikka.Tarkastaja;
import sienimetsa.discotetris.logiikka.Vari;
import sienimetsa.discotetris.logiikka.kursori;
import sienimetsa.discotetris.logiikka.lauta;
import sienimetsa.discotetris.logiikka.palikka;

/**
 *
 * @author matti
 */
public class Discopeli {
    final lauta pelilauta;
    final Tarkastaja tarkastaja;
    final kursori kursori;
    public boolean pyoriiko;
    public boolean gameOver;
    
    public Discopeli() {
        pelilauta = new lauta();
        tarkastaja = new Tarkastaja(pelilauta);
        kursori = new kursori(pelilauta);
        pyoriiko = false;
        gameOver = false;
    }

    public lauta getPelilauta() {
        return pelilauta;
    }

    public Tarkastaja getTarkastaja() {
        return tarkastaja;
    }

    public kursori getKursori() {
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
            ArrayList<palikka> lista = tarkastaja.tarkastaLauta();
            //render
            //päivitysmetodi todennäköisemmin tulee käyttöliittymän puolelle
            
            if(lista.size() > 3) {
                //pisteytä
                for (palikka object : lista) {
                    object.setVari(Vari.TYHJA);
                    lista.clear();
                }
                //render
                
            }
    }
}
