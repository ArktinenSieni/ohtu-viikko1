package sienimetsa.discotetris.logiikka;

import java.util.Random;

public class palikka {
    private int vari;
    private int pysty;
    private int vaaka;
    
    public palikka() {
        this.vari = 0;
        this.pysty = 0;
        this.vaaka = 0;
    }

    public int getVari() {
        return vari;
    }
    
    public void setVari(int parametri) {
        this.vari = vari;
    }
    
    public void asetaKoordinaatti(int vaaka, int pysty) {
        this.vaaka = vaaka;
        this.pysty = pysty;
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
