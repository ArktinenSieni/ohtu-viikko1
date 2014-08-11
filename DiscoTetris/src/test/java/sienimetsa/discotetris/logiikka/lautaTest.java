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

    public lauta testiLauta;

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
        testiLauta = new lauta();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void rivinGenerointi() {
        this.testiLauta.generoiRivi();

        for (int i = 0; i < 5; i++) {

            assertTrue(testiLauta.getLauta()[i][0].getVari() != null);

        }

    }

    @Test
    public void vaihtoKohdeTyhja() {
        testiLauta.getLauta()[1][0] = new palikka(Vari.SININEN);
        testiLauta.vaihto(1, 0, 1, 1);
        assertEquals(Vari.SININEN, testiLauta.getLauta()[1][1].getVari());

    }

    @Test
    public void vaihtoAlkuTyhja() {
        testiLauta.getLauta()[2][1] = new palikka(Vari.KELTAINEN);
        testiLauta.vaihto(2, 0, 2, 1);
        assertEquals(Vari.KELTAINEN, testiLauta.getLauta()[2][0].getVari());

    }

    @Test
    public void vaihtoMolemmissaPalikat() {
        testiLauta.getLauta()[3][0] = new palikka(Vari.PUNAINEN);
        testiLauta.getLauta()[3][1] = new palikka(Vari.VIOLETTI);
        testiLauta.vaihto(3, 0, 3, 1);

        assertEquals(Vari.VIOLETTI, testiLauta.getLauta()[3][0]);
        assertEquals(Vari.PUNAINEN, testiLauta.getLauta()[3][1]);
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
