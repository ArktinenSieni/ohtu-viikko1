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
public class lautaTest {
    
    public lautaTest() {
    
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
    public void aloituksenGenerointi() {
        lauta testilauta = new lauta();
        palikka[][] apulauta = testilauta.getAreena();
        
        testilauta.generoiAloitus();
        
        boolean onkoVareja = false;
        
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                if (apulauta[i][j].getVari() != 0) {
                    onkoVareja = true;
                }
            }
        }
        
        assertTrue(onkoVareja);
                
    }
    
    @Test
    public void tyhjennysToimii() {
        lauta testilauta = new lauta();
        palikka[][] apulauta = testilauta.getAreena();
        
        testilauta.generoiAloitus();
        testilauta.tyhjenna();
        
        boolean onkoVareja = false;
        
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                if (apulauta[i][j].getVari() != 0) {
                    onkoVareja = true;
                }
            }
        }
        
        assertFalse(onkoVareja);
    }
    
    @Test
    public void uudessaRivissaEiTyhjia() {
        lauta testilauta = new lauta();
        palikka[][] apulauta = testilauta.getAreena();
        
        boolean onkoTyhjia = false;
        
        for (int i = 0; i < 15; i++) {
            testilauta.generoiUusiRivi();
            for (int j = 0; j < 5; j++) {
                palikka kuutio = apulauta[j][0];
                
                if (kuutio.getVari() == 0) {
                    onkoTyhjia = true;
                }
            }
            
            testilauta.tyhjenna();
        }
        
        assertFalse(onkoTyhjia);
    }
    
    @Test
    public void palikkaPutoaa() {
        lauta testilauta = new lauta();
        palikka[][] apulauta = testilauta.getAreena();
        
        apulauta[3][6].setVari(1);
        
        testilauta.pudotaPalikka(3, 6, 5);
        
        assertTrue(apulauta[3][6].getVari() == 0 && apulauta[3][6].getVari() == 1);
    }
    
    public void palikkaEiPutoaYli() {
        lauta testilauta = new lauta();
        palikka[][] apulauta = testilauta.getAreena();
        
        apulauta[3][6].setVari(1);
        
        testilauta.pudotaPalikka(3, 6, 6);
        
        assertTrue(apulauta[3][6].getVari() == 1 && apulauta[3][0].getVari() == 0);
    }
    
}
