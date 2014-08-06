package sienimetsa.discotetris.logiikka;

import java.util.Random;

public class palikka {
    private int vari;
    
    // Järkkää jossai vaihees et olis numeroiden sijaan numero. Vastaava ku korttihommeli @ ohja
    
    public palikka() {
        this.vari = 0;
    }

    public int getVari() {
        return vari;
    }
    
    public void setVari(int parametri) {
        if (parametri >= 0 && parametri <= 5) {
        this.vari = parametri;
        }
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
