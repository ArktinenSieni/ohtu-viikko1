/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diskotetris.logiikka;

/**
 *
 * @author mcraty
 */
public class Kursori {
    private int sijaintiX;
    private int sijaintiY;
    private Lauta pelilauta;

    public Kursori(Lauta pelilauta) {
        sijaintiX = 0;
        sijaintiY = 1;
        this.pelilauta = pelilauta;
    }

    public void ylos() {
        if (sijaintiY < pelilauta.getLauta()[1].length - 2) {
            sijaintiY++;
        }
    }

    public void alas() {
        if (sijaintiY > 1) {
            sijaintiY--;
        }
    }

    public void vasen() {
        if (sijaintiX > 0) {
            sijaintiX--;
        }
    }

    public void oikea() {
        if (sijaintiX < pelilauta.getLauta().length - 2) {
            sijaintiX++;
        }
    }

    public void vaihda() {
        pelilauta.vaihto(sijaintiX, sijaintiY, sijaintiX + 1, sijaintiY);
    }

    public int[] getSijainti() {
        int[] koordinaatit = new int[2];
        koordinaatit[0] = sijaintiX;
        koordinaatit[1] = sijaintiY;

        return koordinaatit;
    }
}
