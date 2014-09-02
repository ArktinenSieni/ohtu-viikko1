/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diskotetris.peli;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matti
 */
public class PistelaskuriTest {
    public Pistelaskuri testilaskuri;
    
    public PistelaskuriTest() {
        testilaskuri = new Pistelaskuri();
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
    
    @Test
    public void pisteidenlaskua() {
        testilaskuri.laskePisteet(10);
        assertEquals(10 * 500, testilaskuri.getPisteet());
        assertEquals(3, testilaskuri.getAika());
    }
    
    @Test
    public void pisteidenlaskua2() {
        testilaskuri.laskePisteet(3);
        assertEquals(300, testilaskuri.getViimeisinLisatty());
        testilaskuri.laskePisteet(3);
        testilaskuri.laskePisteet(4);
        
        assertEquals(10 * 100, testilaskuri.getPisteet());
        assertEquals(3, testilaskuri.getAika());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
