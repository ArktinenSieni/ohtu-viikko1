
package diskotetris.logiikka;

import diskotetris.logiikka.Kursori;
import diskotetris.logiikka.Palikka;
import diskotetris.logiikka.Lauta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mcraty
 */
public class KursoriTest {
    public Kursori testiKursori;
    public Lauta testiLauta;
    
    
    public KursoriTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testiLauta = new Lauta();
        testiKursori = new Kursori(testiLauta);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void pysyyRuudukossa() {
        for (int i = 0; i < 10; i++) {
            testiKursori.oikea();
        }
        
        assertEquals(4, testiKursori.getX());
    }
    
    @Test
    public void pysyyRuudukossa2() {
        for (int i = 0; i < 10; i++) {
            testiKursori.vasen();
        }
        
        assertEquals(0, testiKursori.getX());
    }
    
    @Test
    public void pysyyRuudukossa3() {
        for (int i = 0; i < 20; i++) {
            testiKursori.ylos();
        }
        
        assertEquals(12, testiKursori.getY());
    }
    
    @Test
    public void paikkojenVaihto() {
        testiLauta.generoiRivi();
        testiLauta.tyonnaRivi();
        
        Palikka eka = testiLauta.getLauta()[0][1];
        Palikka toka = testiLauta.getLauta()[1][1];
        
        testiKursori.vaihda();
        
        assertEquals(eka, testiLauta.getLauta()[1][1]);
        assertEquals(toka, testiLauta.getLauta()[0][1]);
    }
    
    @Test
    public void paikkojenVaihto2() {
        testiLauta.generoiRivi();
        testiLauta.tyonnaRivi();
        
        Palikka eka = testiLauta.getLauta()[4][1];
        Palikka toka = testiLauta.getLauta()[5][1];
        
        for (int i = 0; i < 5; i++) {
            testiKursori.oikea();
        }
        
        testiKursori.vaihda();
        
        assertEquals(eka, testiLauta.getLauta()[5][1]);
        assertEquals(toka, testiLauta.getLauta()[4][1]);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
