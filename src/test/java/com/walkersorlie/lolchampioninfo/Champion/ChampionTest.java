/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walkersorlie.lolchampioninfo.Champion;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author TexasRanger
 */
public class ChampionTest {
    
    public ChampionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Champion.
     */
    @org.junit.jupiter.api.Test
    public void testGetId() {
        System.out.println("getId");
        Champion instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKey method, of class Champion.
     */
    @org.junit.jupiter.api.Test
    public void testGetKey() {
        System.out.println("getKey");
        Champion instance = null;
        long expResult = 0L;
        long result = instance.getKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Champion.
     */
    @org.junit.jupiter.api.Test
    public void testGetName() {
        System.out.println("getName");
        Champion instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllyTips method, of class Champion.
     */
    @org.junit.jupiter.api.Test
    public void testGetAllyTips() {
        System.out.println("getAllyTips");
        Champion instance = null;
        List<String> expResult = null;
        List<String> result = instance.getAllyTips();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnemyTips method, of class Champion.
     */
    @org.junit.jupiter.api.Test
    public void testGetEnemyTips() {
        System.out.println("getEnemyTips");
        Champion instance = null;
        List<String> expResult = null;
        List<String> result = instance.getEnemyTips();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStats method, of class Champion.
     */
    @org.junit.jupiter.api.Test
    public void testGetStats() {
        System.out.println("getStats");
        Champion instance = null;
        ChampionStats expResult = null;
        ChampionStats result = instance.getStats();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpells method, of class Champion.
     */
    @org.junit.jupiter.api.Test
    public void testGetSpells() {
        System.out.println("getSpells");
        Champion instance = null;
        Map<String, ChampionSpell> expResult = null;
        Map<String, ChampionSpell> result = instance.getSpells();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassive method, of class Champion.
     */
    @org.junit.jupiter.api.Test
    public void testGetPassive() {
        System.out.println("getPassive");
        Champion instance = null;
        String[] expResult = null;
        String[] result = instance.getPassive();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Champion.
     */
    @org.junit.jupiter.api.Test
    public void testHashCode() {
        System.out.println("hashCode");
        Champion instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Champion.
     */
    @org.junit.jupiter.api.Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Champion instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Champion.
     */
    @org.junit.jupiter.api.Test
    public void testToString() {
        System.out.println("toString");
        Champion instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
