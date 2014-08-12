package sienimetsa.discotetris.logiikka;

/**
 *
 * @author mcraty
 */
public class kursori {

    private int sijaintiX;
    private int sijaintiY;
    private lauta pelilauta;

    public kursori(lauta pelilauta) {
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
        if (sijaintiX < pelilauta.getLauta()[0].length - 2) {
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
