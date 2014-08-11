package sienimetsa.discotetris.logiikka;

import java.util.Random;

public class lauta {

    private palikka[][] pelilauta;

    public lauta() {
        pelilauta = new palikka[5][13];
        
        for (palikka[] object : pelilauta) {
            for (palikka object1 : object) {
                object1 = new palikka(Vari.TYHJA);
            }
        }

    }

    public Vari arvoVari() {
        Vari[] varit = {Vari.KELTAINEN, Vari.PUNAINEN, Vari.SININEN, Vari.VALKOINEN, Vari.VIOLETTI};
        
        Random arpoja = new Random();
        int luku = arpoja.nextInt(4);
        
        return varit[luku];
    }
    
    public void generoiRivi() {
        for (int i = 0; i < 5; i++) {
            pelilauta[i][0] = new palikka(arvoVari());
        }
    }
    
    public void vaihto(int alkuX, int alkuY, int kohdeX, int kohdeY) {
        
            palikka apu = pelilauta[alkuX][alkuY];
            
            pelilauta[alkuX][alkuY] = pelilauta[kohdeX][kohdeY];
            pelilauta[kohdeX][kohdeY] = apu;
        
    }
    
    public palikka[][] getLauta() {
        return pelilauta;
    }

}
