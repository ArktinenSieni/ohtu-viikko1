
package diskotetris.logiikka;

import diskotetris.logiikka.Palikka;
import diskotetris.logiikka.Lauta;
import diskotetris.logiikka.Vari;
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
public class LautaTest {

    public Lauta testiLauta;

    public LautaTest() {

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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void rivinGenerointi() {
        this.testiLauta.generoiRivi();

        for (int i = 0; i < this.testiLauta.getLauta().length; i++) {
            assertTrue(testiLauta.getLauta()[i][0].getVari() != Vari.TYHJA);
        }

    }

    

    @Test
    public void vaihto() {
        testiLauta.getLauta()[3][0] = new Palikka(Vari.PUNAINEN);
        testiLauta.getLauta()[3][1] = new Palikka(Vari.VIOLETTI);
        testiLauta.vaihto(3, 0, 3, 1);

        assertEquals(Vari.VIOLETTI, testiLauta.getLauta()[3][0].getVari());
        assertEquals(Vari.PUNAINEN, testiLauta.getLauta()[3][1].getVari());
        
    }
    
    @Test
    public void rivinTyonto() {
        testiLauta.alusta();
        
        this.rivinGenerointi();
        
        this.testiLauta.tyonnaRivi();
        
        for (int i = 0; i < this.testiLauta.getLauta().length; i++) {
            assertTrue(this.testiLauta.getLauta()[i][1].getVari() != Vari.TYHJA);
        }
    }
    
    @Test
    public void palikanPudotus() {
        testiLauta.alusta();
        
        testiLauta.generoiRivi();
        
        for (int i = 0; i < 3; i++) {
            testiLauta.tyonnaRivi();
        }
        
        testiLauta.pudotaPalikka(0, 3);
        
        testiLauta.pudotaPalikka(5, 3);
        
        assertTrue(testiLauta.getLauta()[5][1].getVari() != Vari.TYHJA);
        assertTrue(testiLauta.getLauta()[0][1].getVari() != Vari.TYHJA);
    }
    
    @Test
    public void painovoima() {
        for (int i = 0; i < testiLauta.maxX(); i++) {
            testiLauta.getPalikka(i, 3).setVari(testiLauta.arvoVari());
        }
        
        for (int i = 0; i < testiLauta.maxX(); i++) {
            assertFalse(testiLauta.getPalikanVari(i, 3) == Vari.TYHJA);
            
        }
        
        testiLauta.painovoima();
        
        for (int i = 0; i < testiLauta.maxX(); i++) {
            assertFalse(testiLauta.getPalikanVari(i, 1) == Vari.TYHJA);
            assertTrue(testiLauta.getPalikanVari(i, 3) == Vari.TYHJA);
        }
    }
    
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
