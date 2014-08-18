package diskotetris.logiikka;

import java.util.ArrayList;

/**
 *
 * @author matti
 */
public class Tarkastaja {

    private Lauta pelilauta;

    public Tarkastaja(Lauta lauta) {
        this.pelilauta = lauta;
    }

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
    
    public boolean liianKorkea() {
        for (int i = 0; i < this.pelilauta.maxX(); i++) {
            if (pelilauta.getPalikanVari(i, pelilauta.maxY() - 1) != Vari.TYHJA) {
                return true;
            }
        }
        
        return false;
    }

}
