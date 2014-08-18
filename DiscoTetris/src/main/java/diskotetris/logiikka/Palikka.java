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
public class Palikka {

    private Vari vari;
    
    public Palikka(Vari vari) {
        this.vari = vari;
    }

    public Vari getVari() {
        return vari;
    }
    
    public void setVari(Vari uusi) {
        this.vari = uusi;
    }
}
