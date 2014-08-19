
package diskotetris.logiikka;

/**
 *
 * @author mcraty
 * Luokan tarkoituksena on antaa pelaajan käyttöön metodit palikoiden 
 * liikuttamiseen. Koordinaatit välitetään myös Piirtoalustalle.
 *  
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

    public int getX() {
        return sijaintiX;
    }
    
    public int getY() {
        return sijaintiY;
    }
    
}
