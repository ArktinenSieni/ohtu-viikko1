package sienimetsa.discotetris.logiikka;

import java.util.Random;

public class palikka {
    private int vari;
    private int pysty;
    private int vaaka;
    
    public palikka(int vari, int pysty, int vaaka) {
        this.vari = vari;
        this.pysty = pysty;
        this.vaaka = vaaka;
    }

    public int getVari() {
        return vari;
    }
    
    public void setVari(int parametri) {
        this.vari = vari;
    }

    public int getPysty() {
        return pysty;
    }

    public int getVaaka() {
        return vaaka;
    }
    
    public void arvoVari() {
        Random arpoja = new Random();
        
        while (this.vari == 0) {
            setVari(arpoja.nextInt(6));
        }
    }
    
    public void vaihdaVareja(palikka vaihdettava) {
        int apu = this.vari;
        
        setVari(vaihdettava.getVari());
        vaihdettava.setVari(apu);
    }
}
