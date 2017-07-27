/*
 *Junit Test for the Pet Class
 */
package com.aut.pdc.mike.gamemodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pet Test
 * @author Minghao Yang
 */
public class PetTest {
    
    public PetTest() {
    }

    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of AliveString method, of class Pet.
     */
    @Test
    public void testAliveString() {
        System.out.println("AliveString");
        Pet instance = new Pet("Luson",100,100,80,1,true,"Test");
        String expResult = "Alive";
        String result = instance.AliveString();
        assertEquals(expResult, result);
    }


    /**
     * Test of grow method, of class Pet.
     */
    @Test
    public void testGrow() {
        System.out.println("grow");
        Pet instance = new Pet("Luson",100,100,80,1,true,"Test");
        instance.grow();
        System.out.print(instance);
    }

    /**
     * Test of situationCheck method, of class Pet.
     */
    @Test
    public void testSituationCheck() {
        System.out.println("situationCheck");
        Pet instance = new Pet("Luson",40,40,30,1,true,"Test");
        String result = instance.situationCheck();
        System.out.print(result);
    }

    /**
     * Test of getSick method, of class Pet.
     */
    @Test
    public void testGetSick() {
        System.out.println("getSick");
        Pet instance = new Pet("Luson",100,100,80,1,true,"Test");
        instance.getSick();
        System.out.print(instance);
    }

    
}
