package diskotetris.peli;

import diskotetris.kayttoliittyma.Kayttoliittyma;
import diskotetris.logiikka.Palikka;
import diskotetris.logiikka.Vari;
import java.io.FileNotFoundException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author matti
 */
public class DiscopeliTest {
    public Discopeli testipeli;
    public Kayttoliittyma GUI;
    
    public DiscopeliTest() throws FileNotFoundException {
        testipeli = new Discopeli();
        GUI = new Kayttoliittyma(testipeli);
        testipeli.setPaivitettava(GUI.getPaivitettava());
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testipeli.generoiAloitus();
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void alustusToimii() {
        
        testipeli.generoiAloitus();
        
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < testipeli.getPelilauta().maxX(); j++) {
                assertFalse(testipeli.getPelilauta().getPalikanVari(j, i) == Vari.TYHJA);
            }
        }
        
        assertEquals(0, testipeli.getLaskuri().getPisteet());
        assertEquals(120, testipeli.getLaskuri().getAika());
    }
    
    @Test
    public void yhdistelmienPoisto() {
        testipeli.getPelilauta().alusta();
        assertEquals(false, testipeli.poistaYhdistelmat());
    }
    
    @Test
    public void yhdistelmienPoisto2() {
        for (int i = 0; i < testipeli.getPelilauta().maxX(); i++) {
            testipeli.getPelilauta().getPalikka(i, 1).setVari(Vari.PUNAINEN);
        }
        assertTrue(testipeli.poistaYhdistelmat());
        
        for (int i = 0; i < testipeli.getPelilauta().maxX(); i++) {
            assertTrue(testipeli.getPelilauta().getPalikanVari(i, 1) == Vari.TYHJA);
        }
    }
    
    @Test
    public void laudanTarkastus() {
        testipeli.getPelilauta().alusta();
        
        for (int i = 1; i <= 3; i++) {
            testipeli.getPelilauta().getPalikka(0, i).setVari(Vari.PUNAINEN);
        }
        testipeli.getPelilauta().getPalikka(0, 4).setVari(Vari.KELTAINEN);
        
        testipeli.tarkastaLauta();
        
        assertEquals(Vari.KELTAINEN, testipeli.getPelilauta().getPalikanVari(0, 1));
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
