/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class palikkaTest {
    
    public palikkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void palikkaLuotuOikein() {
        palikka nelio = new palikka();
        assertTrue(nelio.getVari() == 0);
    }
    
    @Test
    public void palikanVariOikein() {
        palikka nelio = new palikka();
        nelio.setVari(2);
        assertTrue(nelio.getVari() == 2);
    }
    
    @Test
    public void palikanVariOikein2() {
        palikka nelio = new palikka();
        nelio.setVari(2);
        nelio.setVari(6);
        assertTrue(nelio.getVari() == 2);
    }
    
    @Test
    public void palikoidenVaritVaihtuvat() {
        palikka nelio = new palikka();
        palikka rympyla = new palikka();
        
        nelio.arvoVari();
        rympyla.arvoVari();
        
        int vaihto1 = nelio.getVari();
        int vaihto2 = rympyla.getVari();
        
        nelio.vaihdaVareja(rympyla);
        
        assertTrue(nelio.getVari() == vaihto2 && rympyla.getVari() == vaihto1);
    }
}
