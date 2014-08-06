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
public class tarkastajaTest {
    
    public tarkastajaTest() {
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
    public void loytyykoValit1() {
        lauta testi1 = new lauta();
    
        tarkastaja testitarkastaja = new tarkastaja();
        
        palikka[][] palikat1 = testi1.getAreena();
        
        assertFalse(testitarkastaja.onkoValia(palikat1, 0));
       
    }
    
    @Test
    public void loytyykoValit2() {
        lauta testi2 = new lauta();
        tarkastaja testitarkastaja = new tarkastaja();
        
        palikka[][] palikat2 = testi2.getAreena();
        
        for (int i = 1; i < 2; i++) {
            palikat2[0][i].setVari(1);
        }
        
        assertFalse(testitarkastaja.onkoValia(palikat2, 0));
       
    }
    
    @Test
    public void loytyykoValit3() {
        lauta testi3 = new lauta();
        tarkastaja testitarkastaja = new tarkastaja();
        
        palikka[][] palikat3 = testi3.getAreena();
        
        for (int i = 3; i < 4; i++) {
            palikat3[0][i].setVari(1);
        }
        
        assertTrue(testitarkastaja.onkoValia(palikat3, 0));
       
    }
    
    @Test
    public void loytyykoValit4() {
        lauta testi4 = new lauta();
        tarkastaja testitarkastaja = new tarkastaja();
        
        palikka[][] palikat4 = testi4.getAreena();
        
        palikat4[0][1].setVari(1);
        for (int i = 3; i < 4; i++) {
            palikat4[0][i].setVari(1);
        }
        
        assertTrue(testitarkastaja.onkoValia(palikat4, 0));
       
    }
    
    
    
    
}
