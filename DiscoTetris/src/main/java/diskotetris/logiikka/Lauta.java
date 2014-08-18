/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diskotetris.logiikka;

import java.util.Random;

/**
 *
 * @author mcraty
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
    
    public void alusta() {
        for (int i = 0; i < pelilauta.length; i++) {
            for (int j = 0; j < pelilauta[i].length; j++) {
                pelilauta[i][j] = new Palikka(Vari.TYHJA);
            }
        }
    }

    public Vari arvoVari() {
        Vari[] varit = {Vari.KELTAINEN, Vari.PUNAINEN, Vari.SININEN, Vari.VALKOINEN, Vari.VIOLETTI};

        Random arpoja = new Random();
        int luku = arpoja.nextInt(4);

        return varit[luku + 1];
    }

    public void generoiRivi() {
        for (int i = 0; i < pelilauta.length; i++) {
            pelilauta[i][0] = new Palikka(arvoVari());
        }
    }

    public void vaihto(int alkuX, int alkuY, int kohdeX, int kohdeY) {

        if (((alkuX >= 0 && alkuX <= pelilauta.length - 1) && 
                (alkuY >= 0 && alkuY <= pelilauta[1].length - 1)) && 
                ((kohdeX >= 0 && kohdeX <= pelilauta.length - 1) && 
                (kohdeY >= 0 && kohdeY <= pelilauta[1].length - 1))) {
            Palikka apu = pelilauta[alkuX][alkuY];

            pelilauta[alkuX][alkuY] = pelilauta[kohdeX][kohdeY];
            pelilauta[kohdeX][kohdeY] = apu;

        }

    }

    public void tyonnaRivi() {

        for (int i = 0; i < pelilauta.length ; i++) {
            for (int j = pelilauta[i].length; j > 0; j--) {
                vaihto(i, j, i, j - 1);
            }
        }
    }
    
    public void pudotaPalikka(int x, int y) {
        if (y > 1 && getPalikanVari(x, y - 1) == Vari.TYHJA) {
            vaihto(x, y, x, y - 1);
            pudotaPalikka(x, y - 1);
        }
    }
    
    public void painovoima() {
        for (int i = 0; i < this.pelilauta.length; i++) {
            for (int j = this.pelilauta[i].length - 1; j > 1; j--) {
                this.pudotaPalikka(i, j);
            }
        }
    }
    
    public void poistaPalikka(int x, int y) {
        this.pelilauta[x][y].setVari(Vari.TYHJA);
    }
    
    public void poistaPalikka(Palikka palikka) {
        palikka.setVari(Vari.TYHJA);
    }

    public Palikka[][] getLauta() {
        return pelilauta;
    }
}
