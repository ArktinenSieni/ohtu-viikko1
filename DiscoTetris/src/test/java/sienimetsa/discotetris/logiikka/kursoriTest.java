
package sienimetsa.discotetris.logiikka;

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
public class kursoriTest {
    public kursori testiKursori;
    public lauta testiLauta;
    
    
    public kursoriTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testiLauta = new lauta();
        testiKursori = new kursori(testiLauta);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void pysyyRuudukossa() {
        for (int i = 0; i < 10; i++) {
            testiKursori.oikea();
        }
        
        assertEquals(4, testiKursori.getSijainti()[0]);
    }
    
    @Test
    public void pysyyRuudukossa2() {
        for (int i = 0; i < 10; i++) {
            testiKursori.vasen();
        }
        
        assertEquals(0, testiKursori.getSijainti()[0]);
    }
    
    @Test
    public void pysyyRuudukossa3() {
        for (int i = 0; i < 20; i++) {
            testiKursori.ylos();
        }
        
        assertEquals(12, testiKursori.getSijainti()[1]);
    }
    
    @Test
    public void paikkojenVaihto() {
        testiLauta.generoiRivi();
        testiLauta.tyonnaRivi();
        
        palikka eka = testiLauta.getLauta()[0][1];
        palikka toka = testiLauta.getLauta()[1][1];
        
        testiKursori.vaihda();
        
        assertEquals(eka, testiLauta.getLauta()[1][1]);
        assertEquals(toka, testiLauta.getLauta()[0][1]);
    }
    
    @Test
    public void paikkojenVaihto2() {
        testiLauta.generoiRivi();
        testiLauta.tyonnaRivi();
        
        palikka eka = testiLauta.getLauta()[4][1];
        palikka toka = testiLauta.getLauta()[5][1];
        
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
