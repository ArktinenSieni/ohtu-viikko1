package diskotetris.logiikka;

/**
 * Luokka yksittäisen palikan luomiselle.
 * @see diskotetris.logiikka.Lauta
 * 
 * @author mcraty
 * 
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
