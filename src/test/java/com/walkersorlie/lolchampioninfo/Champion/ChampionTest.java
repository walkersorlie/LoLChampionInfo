/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walkersorlie.lolchampioninfo.Champion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walkersorlie.lolchampioninfo.NetworkRequest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Walker Sorlie
 */
public class ChampionTest {
    private static Champion champion;
    
    
    public ChampionTest() throws Exception {
        String response = NetworkRequest.sendGet("Aatrox");
        champion = new ObjectMapper().readValue(response, Champion.class);
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
    @Test
    public void testGetId() {
        System.out.println("getId");
        assertEquals("Aatrox", champion.getId());
    }

    /**
     * Test of getKey method, of class Champion.
     */
    @Test
    public void testGetKey() {
        System.out.println("getKey");
        assertEquals(266, champion.getKey());
    }

    /**
     * Test of getName method, of class Champion.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        assertEquals("Aatrox", champion.getName());
    }

    /**
     * Test of getAllyTips method, of class Champion.
     */
    @Test
    public void testGetAllyTips() {
        System.out.println("getAllyTips");
        List<String> expResult = new ArrayList() {
                {
                    add("Use Umbral Dash while casting The Darkin Blade to increase your chances of hitting the enemy.");
                    add("Crowd Control abilities like Infernal Chains or your allies' immobilizing effects will help you set up The Darkin Blade.");
                    add("Cast World Ender when you are sure you can force a fight.");
                }
        };
        assertEquals(expResult, champion.getAllyTips());
    }

    /**
     * Test of getEnemyTips method, of class Champion.
     */
    @Test
    public void testGetEnemyTips() {
        System.out.println("getEnemyTips");
        List<String> expResult = new ArrayList() {
                {
                    add("Aatrox's attacks are very telegraphed, so use the time to dodge the hit zones.");
                    add("Aatrox's Infernal Chains are easier to exit when running towards the sides or at Aatrox.");
                    add("Keep your distance when Aatrox uses his Ultimate to prevent him from reviving.");
                }
        };
        List<String> result = champion.getEnemyTips();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStats method, of class Champion.
     */
    @Test
    public void testGetStats() {
        System.out.println("getStats");
        ChampionStats expResult = new ChampionStats(580, 90, 0, 0, 345, 38, 3.25, 32.1, 1.25, 175, 3, 1, 0, 0, 0, 0, 60, 5, 2.5, 0.651);
        ChampionStats result = champion.getStats();
        assertEquals(expResult.getHp(), result.getHp());
        assertEquals(expResult.getHpPerLevel(), result.getHpPerLevel());
        assertEquals(expResult.getMp(), result.getMp());
        assertEquals(expResult.getMpPerLevel(), result.getMpPerLevel());
        assertEquals(expResult.getMoveSpeed(), result.getMoveSpeed());
        assertEquals(expResult.getArmor(), result.getArmor());
        assertEquals(expResult.getArmorPerLeveL(), result.getArmorPerLeveL());
        assertEquals(expResult.getSpellBlock(), result.getSpellBlock());
        assertEquals(expResult.getSpellBlockPerLevel(), result.getSpellBlockPerLevel());
        assertEquals(expResult.getAttackRange(), result.getAttackRange());
        assertEquals(expResult.getHpRegen(), result.getHpRegen());
        assertEquals(expResult.getHpRegenPerLevel(), result.getHpRegenPerLevel());
        assertEquals(expResult.getMpRegen(), result.getMpRegen());
        assertEquals(expResult.getMpRegenPerLevel(), result.getMpRegenPerLevel());
        assertEquals(expResult.getCrit(), result.getCrit());
        assertEquals(expResult.getCritPerLeveL(), result.getCritPerLeveL());
        assertEquals(expResult.getAttackDamage(), result.getAttackDamage());
        assertEquals(expResult.getAttackDamagePerLevel(), result.getAttackDamagePerLevel());
        assertEquals(expResult.getAttackspeedPerLevel(), result.getAttackspeedPerLevel());
        assertEquals(expResult.getAttackSpeed(), result.getAttackSpeed());
    }

    /**
     * Test of getSpells method, of class Champion.
     */
    @Test
    public void testGetSpells() {
        System.out.println("getSpells");
        ChampionSpell aatroxQ = new ChampionSpell("AatroxQ", "The Darkin Blade", "Aatrox slams his greatsword down, dealing physical damage. He can swing three times, each with a different area of effect.", "Aatrox slams his greatsword down, dealing <physicalDamage>{{ qdamage }} physical damage</physicalDamage>. The Darkin Blade may be re-cast 2 additional times, each one increasing in damage.<br /><br />Each strike can hit with the Edge, briefly knocking enemies up and dealing more damage.");
        ChampionSpell aatroxW = new ChampionSpell("AatroxW", "Infernal Chains", "Aatrox smashes the ground, dealing damage to the first enemy hit. Champions and large monsters have to leave the impact area quickly or they will be dragged to the center and take the damage again.", "Aatrox smashes the ground, dealing <physicalDamage>{{ wdamage }} physical damage</physicalDamage> to the first enemy hit and slowing by {{ wslowpercentage*-100 }}% for {{ wslowduration }}s.<br /><br />Champions or Large Monsters have {{ wslowduration }}s to leave the impact area or be dragged back and damaged again.");
        ChampionSpell aatroxE = new ChampionSpell("AatroxE", "Umbral Dash", "Passively, Aatrox heals when damaging enemy champions. On activation, he dashes in a direction.", 	"<spellPassive>Passive:</spellPassive> Aatrox heals for {{ espellvamp }}% of damage he deals to champions.<br /><br /><spellActive>Active:</spellActive> Aatrox dashes in a direction.");
        ChampionSpell aatroxR = new ChampionSpell("AatroxR", "World Ender", "Aatrox unleashes his demonic form, fearing nearby enemy minions and gaining attack damage, increased healing, and movement speed. If he gets a takedown, this effect is extended.", 	"Aatrox reveals his true demonic form for {{ rduration }} seconds. On activation, he fears nearby enemy minions and gains Movement Speed, decaying over the duration. While World Ender persists, he gains {{ rtotaladamp*100 }}% Attack Damage and increases self healing by {{ rhealingamp*100 }}%.<br /><br />On enemy champion takedown, World Ender is extended.");
//        Map<String, ChampionSpell> result = champion.getSpells();
//        ChampionSpell[] result = champion.getSpells();
        List<ChampionSpell> result = champion.getSpells();
        int i = 0;
        while(i < result.size()) {
            switch(i) {
                case 0: {
                    ChampionSpell spell = result.get(i);
                    assertEquals(aatroxQ.getId(), spell.getId());
                    assertEquals(aatroxQ.getDescription(), spell.getDescription());
                    assertEquals(aatroxQ.getToolTip(), spell.getToolTip());
                    break;
                }
                case 1: {
                    ChampionSpell spell = result.get(i);
                    assertEquals(aatroxW.getId(), spell.getId());
                    assertEquals(aatroxW.getDescription(), spell.getDescription());
                    assertEquals(aatroxW.getToolTip(), spell.getToolTip());
                    break;
                }
                case 2: {
                    ChampionSpell spell = result.get(i);
                    assertEquals(aatroxE.getId(), spell.getId());
                    assertEquals(aatroxE.getDescription(), spell.getDescription());
                    assertEquals(aatroxE.getToolTip(), spell.getToolTip());
                    break;
                }
                case 3: {
                    ChampionSpell spell = result.get(i);
                    assertEquals(aatroxR.getId(), spell.getId());
                    assertEquals(aatroxR.getDescription(), spell.getDescription());
                    assertEquals(aatroxR.getToolTip(), spell.getToolTip());
                    break;
                }
                default: fail("Not equal");
            }
            i++;
        }
        
//        Iterator<Map.Entry<String, ChampionSpell>> itr = result.entrySet().iterator();
//        while(itr.hasNext()) {
//            Map.Entry<String, ChampionSpell> spell = itr.next();
//            switch(spell.getKey()) {
//                case "AatroxQ": {
//                    assertEquals(aatroxQ.getId(), spell.getValue().getId());
//                    assertEquals(aatroxQ.getDescription(), spell.getValue().getDescription());
//                    assertEquals(aatroxQ.getToolTip(), spell.getValue().getToolTip());
//                    break;
//                }         
//                case "AatroxW": { 
//                    assertEquals(aatroxW.getId(), spell.getValue().getId());
//                    assertEquals(aatroxW.getDescription(), spell.getValue().getDescription());
//                    assertEquals(aatroxW.getToolTip(), spell.getValue().getToolTip());
//                    break;
//                }    
//                case "AatroxE": {
//                    assertEquals(aatroxE.getId(), spell.getValue().getId());
//                    assertEquals(aatroxE.getDescription(), spell.getValue().getDescription());
//                    assertEquals(aatroxE.getToolTip(), spell.getValue().getToolTip());
//                    break;
//                }
//                case "AatroxR": {
//                    assertEquals(aatroxR.getId(), spell.getValue().getId());
//                    assertEquals(aatroxR.getDescription(), spell.getValue().getDescription());
//                    assertEquals(aatroxR.getToolTip(), spell.getValue().getToolTip());
//                    break;
//                }
//                default: fail("Not equal");
//            }         
//        }
    }

    /**
     * Test of getPassive method, of class Champion.
     */
    @Test
    public void testGetPassive() {
        System.out.println("getPassive");
        ChampionPassive expResult = new ChampionPassive("Deathbringer Stance", "Periodically, Aatrox's next basic attack deals bonus <physicalDamage>physical damage</physicalDamage> and heals him, based on the target's max health. ");
        ChampionPassive result = champion.getPassive();
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getDescription(), result.getDescription());
    }

    /**
     * Test of toString method, of class Champion.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Champion: Aatrox";
        String result = champion.toString();
        assertEquals(expResult, result);
    }
    
}
