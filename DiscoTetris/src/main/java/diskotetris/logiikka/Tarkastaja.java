package diskotetris.logiikka;

import java.util.ArrayList;

/**
 *
 * @author mcraty
 * 
 * Luokan tarkoituksena tarkastaa pelilaudalta vierekkäiset kolmenyhdistelmät.
 * Ajatuksena on tarkastaa ne rekursiivisesti, kasata listaan, ja palauttaa 
 * toiselle oliolle poistettavaksi.
 */
public class Tarkastaja {

    private Lauta pelilauta;

    public Tarkastaja(Lauta lauta) {
        this.pelilauta = lauta;
    }

    /**
     * Etsii palikat alhaalta ylös, jotka ovat samanvärisiä lähtöpalikan
     * kanssa.
     * 
     * @param x
     * @param y
     * @return Samanväriset palikat listassa.
     */
    public ArrayList<Palikka> tarkastaYlos(int x, int y) {
        ArrayList<Palikka> yhdistelmat = new ArrayList<Palikka>();
        if (pelilauta.getPalikanVari(x, y) != Vari.TYHJA) {
            yhdistelmat.add(pelilauta.getPalikka(x, y));

            if (y < pelilauta.maxY() - 1 && pelilauta.getPalikanVari(x, y) == pelilauta.getPalikanVari(x, y + 1)) {
                ArrayList<Palikka> ylhaalla = tarkastaYlos(x, y + 1);
                for (Palikka object : ylhaalla) {
                    yhdistelmat.add(object);
                }
            }
        }

        return yhdistelmat;
    }
   
    /**
     * Etsii palikat vasemmalta oikealle, jotka ovat samanvärisiä
     * lähtöpalikan kanssa.
     * 
     * @param x
     * @param y
     * @return Samanväriset palikat listassa.
     */
    public ArrayList<Palikka> tarkastaOikea(int x, int y) {
        ArrayList<Palikka> yhdistelmat = new ArrayList<Palikka>();
        if (pelilauta.getPalikanVari(x, y) != Vari.TYHJA) {
            yhdistelmat.add(pelilauta.getPalikka(x, y));

            if (x < pelilauta.maxX() - 1 && pelilauta.getPalikanVari(x, y) == pelilauta.getPalikanVari(x + 1, y)) {
                ArrayList<Palikka> oikealla = tarkastaOikea(x + 1, y);
                for (Palikka object : oikealla) {
                    yhdistelmat.add(object);
                }
            }
        }

        return yhdistelmat;
    }
    
    /**
     * Tarkastaa kaikki laudan yhdistelmät. 
     * Poistettavien listaan lisätään ainoastaan jos kyseinen palikka jo ei ole
     * listassa, ja kun vierekkäisiä samanvärisiä on vähintään kolme.
     * 
     * @return 
     */
    public ArrayList<Palikka> tarkastaLauta() {
        ArrayList<Palikka> poistettavat = new ArrayList<Palikka>();
        
        for (int i = 0; i < pelilauta.maxX(); i++) {
            for (int j = 1; j < pelilauta.maxY(); j++) {
                ArrayList<Palikka> ylos = this.tarkastaYlos(i, j);
                
                if(ylos.size() >= 3) {
                    for (Palikka object : ylos) {
                        if (!poistettavat.contains(object)) {
                            poistettavat.add(object);
                        }
                    }
                }
                
                ArrayList<Palikka> oikea = this.tarkastaOikea(i, j);
                if(oikea.size() >= 3) {
                    for (Palikka object : oikea) {
                        if (!poistettavat.contains(object)) {
                            poistettavat.add(object);
                        }
                    }
                }
                
            }
        }
        
        return poistettavat;
    }
    
    /**
     * Tarkastaa korkeimman rivin tilan.
     * Käytetään pelin jatkumista tarkastaessa.
     * 
     * @return 
     */
    public boolean liianKorkea() {
        for (int i = 0; i < this.pelilauta.maxX(); i++) {
            if (pelilauta.getPalikanVari(i, pelilauta.maxY() - 1) != Vari.TYHJA) {
                return true;
            }
        }
        
        return false;
    }

}
