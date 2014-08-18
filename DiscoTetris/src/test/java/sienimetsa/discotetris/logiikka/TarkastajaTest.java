package sienimetsa.discotetris.logiikka;

import diskotetris.logiikka.Tarkastaja;
import diskotetris.logiikka.Palikka;
import diskotetris.logiikka.Lauta;
import diskotetris.logiikka.Vari;
import java.util.ArrayList;
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
public class TarkastajaTest {
    public Lauta testilauta;
    public Tarkastaja testitarkastaja;
    
    public TarkastajaTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testilauta = new Lauta();
        testitarkastaja = new Tarkastaja(testilauta);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void ylosTarkastus() {
        
        for (int i = 1; i < 5; i++) {
            testilauta.getLauta()[0][i].setVari(Vari.PUNAINEN);
        }
        
        ArrayList<Palikka> lista = testitarkastaja.tarkastaYlos(0, 1);
        
        assertEquals(4, lista.size());
    }
    
    @Test
    public void ylosTarkistus2() {
        testilauta.getLauta()[0][1].setVari(Vari.SININEN);
        
        for (int i = 2; i < 5; i++) {
            testilauta.getLauta()[0][i].setVari(Vari.PUNAINEN);
        }
        
        ArrayList<Palikka> lista1 = testitarkastaja.tarkastaYlos(0, 1);
        ArrayList<Palikka> lista2 = testitarkastaja.tarkastaYlos(0, 2);
        
        assertEquals(1, lista1.size());
        assertEquals(3, lista2.size());
        
    }
    
    @Test
    public void oikealleTarkistus() {
        for (int i = 0; i < 5; i++) {
            testilauta.getLauta()[i][1].setVari(Vari.KELTAINEN);
        }
        
        ArrayList<Palikka> lista = testitarkastaja.tarkastaOikea(0, 1);
        
        assertEquals(5, lista.size());
    }
    
    public void oikealleTarkistus2() {
        for (int i = 0; i < 3; i++) {
            testilauta.getLauta()[i][1].setVari(Vari.KELTAINEN);
        }
        
        for (int i = 3; i < testilauta.maxX(); i++) {
            testilauta.getLauta()[i][1].setVari(Vari.SININEN);
        }
        
        ArrayList<Palikka> lista1 = testitarkastaja.tarkastaOikea(0, 1);
        ArrayList<Palikka> lista2 = testitarkastaja.tarkastaOikea(3, 1);
        
        assertEquals(3, lista1.size());
        assertEquals(3, lista2.size());
    }
    
    public void laudanTarkistus() {
        for (int i = 0; i < 3; i++) {
            testilauta.generoiRivi();
            testilauta.tyonnaRivi();
        }
        
        for (int i = 1; i < 4; i++) {
            testilauta.getLauta()[0][i].setVari(Vari.PUNAINEN);
        }
        
        for (int i = 3; i < testilauta.maxX(); i++) {
            testilauta.getLauta()[i][2].setVari(Vari.SININEN);
        }
        
        ArrayList<Palikka> lista = testitarkastaja.tarkastaLauta();
        
        assertTrue(lista.size() >= 6);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
