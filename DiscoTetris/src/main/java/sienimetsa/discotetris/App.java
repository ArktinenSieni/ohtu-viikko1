package sienimetsa.discotetris;

import sienimetsa.discotetris.logiikka.Vari;
import sienimetsa.discotetris.logiikka.lauta;
import sienimetsa.discotetris.logiikka.palikka;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Potaatti" );
        lauta testi = new lauta();
        
        testi.getLauta()[0][1] = new palikka(Vari.KELTAINEN);
        
        System.out.println(testi.getLauta()[0][1].getVari());
        
        testi.vaihto(1, 1, 0, 1);
        
        System.out.println(testi.getLauta()[1][1].getVari());
    }
}
