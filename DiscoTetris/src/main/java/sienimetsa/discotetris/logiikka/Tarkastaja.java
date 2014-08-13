package sienimetsa.discotetris.logiikka;

import java.util.ArrayList;

/**
 *
 * @author matti
 */
public class Tarkastaja {

    private lauta pelilauta;

    public Tarkastaja(lauta lauta) {
        this.pelilauta = lauta;
    }

    public ArrayList<palikka> tarkastaYlos(int x, int y) {
        ArrayList<palikka> yhdistelmat = new ArrayList<palikka>();
        if (pelilauta.getLauta()[x][y].getVari() != Vari.TYHJA) {
            yhdistelmat.add(pelilauta.getLauta()[x][y]);

            if (y < pelilauta.maxY() - 1 && pelilauta.getLauta()[x][y].getVari() == pelilauta.getLauta()[x][y + 1].getVari()) {
                ArrayList<palikka> ylhaalla = tarkastaYlos(x, y + 1);
                for (palikka object : ylhaalla) {
                    yhdistelmat.add(object);
                }
            }
        }

        return yhdistelmat;
    }
   
    public ArrayList<palikka> tarkastaOikea(int x, int y) {
        ArrayList<palikka> yhdistelmat = new ArrayList<palikka>();
        if (pelilauta.getLauta()[x][y].getVari() != Vari.TYHJA) {
            yhdistelmat.add(pelilauta.getLauta()[x][y]);

            if (x < pelilauta.maxX() - 1 && pelilauta.getLauta()[x][y].getVari() == pelilauta.getLauta()[x + 1][y].getVari()) {
                ArrayList<palikka> oikealla = tarkastaOikea(x + 1, y);
                for (palikka object : oikealla) {
                    yhdistelmat.add(object);
                }
            }
        }

        return yhdistelmat;
    }
    
    public ArrayList<palikka> tarkastaLauta() {
        ArrayList<palikka> poistettavat = new ArrayList<palikka>();
        
        for (int i = 0; i < pelilauta.maxX(); i++) {
            for (int j = 1; j < pelilauta.maxY(); j++) {
                ArrayList<palikka> ylos = this.tarkastaYlos(i, j);
                
                if(ylos.size() >= 3) {
                    for (palikka object : ylos) {
                        if (!poistettavat.contains(object)) {
                            poistettavat.add(object);
                        }
                    }
                }
                
                ArrayList<palikka> oikea = this.tarkastaOikea(i, j);
                if(oikea.size() >= 3) {
                    for (palikka object : oikea) {
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
            if (pelilauta.getLauta()[i][pelilauta.maxY() - 1].getVari() != Vari.TYHJA) {
                return true;
            }
        }
        
        return false;
    }

}
