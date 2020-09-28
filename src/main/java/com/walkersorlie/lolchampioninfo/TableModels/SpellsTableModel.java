
package com.walkersorlie.lolchampioninfo.TableModels;

import com.walkersorlie.lolchampioninfo.Champion.ChampionSpell;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Walker Sorlie
 */
public class SpellsTableModel extends AbstractTableModel {
    
    private final String[] columns = {"Spell", "Description"};
    private final HashMap<String, ChampionSpell> spells;
    
    public SpellsTableModel(Map<String, ChampionSpell> spells) {
        this.spells = (HashMap)spells;
    }
    
    @Override
    public int getRowCount() {
        return spells.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        String value = "";
        
        /**
         * Return the spell name
         */
        if(columnIndex == 0) {
            switch(rowIndex) {
                case 0: {
                    Iterator<String> itr = spells.keySet().iterator();
                    while(itr.hasNext()) {
                        String spell = itr.next();
                        char c = spell.charAt(spell.length() - 1);
                        if(c ==  'Q')
                            value = formatSpellName(spell);
                    }
                    break;
                }
                case 1: {
                    Iterator<String> itr = spells.keySet().iterator();
                    while(itr.hasNext()) {
                        String spell = itr.next();
                        char c = spell.charAt(spell.length() - 1);
                        if(c ==  'W')
                            value = formatSpellName(spell);
                    }
                    break;
                }
                case 2: {
                    Iterator<String> itr = spells.keySet().iterator();
                    while(itr.hasNext()) {
                        String spell = itr.next();
                        char c = spell.charAt(spell.length() - 1);
                        if(c ==  'E')
                            value = formatSpellName(spell);
                    }
                    break;
                }
                case 3: {
                    Iterator<String> itr = spells.keySet().iterator();
                    while(itr.hasNext()) {
                        String spell = itr.next();
                        char c = spell.charAt(spell.length() - 1);
                        if(c ==  'R')
                            value = formatSpellName(spell);
                    }
                    break;
                }
                default: value = "None";
            }
        }
        
        /**
         * Return the spell description
         */
        else {
            switch(rowIndex) {
                case 0: {
                    Iterator<Map.Entry<String, ChampionSpell>> itr = spells.entrySet().iterator();
                    while(itr.hasNext()) {
                        Map.Entry<String, ChampionSpell> spell = itr.next();
                        String key = spell.getKey();
                        char c = key.charAt(key.length() - 1);
                        if(c == 'Q')
                            value = spell.getValue().getDescription();
                    }
                    break;
                }
                case 1: {
                    Iterator<Map.Entry<String, ChampionSpell>> itr = spells.entrySet().iterator();
                    while(itr.hasNext()) {
                        Map.Entry<String, ChampionSpell> spell = itr.next();
                        String key = spell.getKey();
                        char c = key.charAt(key.length() - 1);
                        if(c == 'W')
                            value = spell.getValue().getDescription();
                    }
                    break;
                }
                case 2: {
                    Iterator<Map.Entry<String, ChampionSpell>> itr = spells.entrySet().iterator();
                    while(itr.hasNext()) {
                        Map.Entry<String, ChampionSpell> spell = itr.next();
                        String key = spell.getKey();
                        char c = key.charAt(key.length() - 1);
                        if(c == 'E')
                            value = spell.getValue().getDescription();
                    }
                    break;
                }
                case 3: {
                    Iterator<Map.Entry<String, ChampionSpell>> itr = spells.entrySet().iterator();
                    while(itr.hasNext()) {
                        Map.Entry<String, ChampionSpell> spell = itr.next();
                        String key = spell.getKey();
                        char c = key.charAt(key.length() - 1);
                        if(c == 'R')
                            value = spell.getValue().getDescription();
                    }
                    break;
                }
                default: value = "None";
            }      
        }
        return value;
    }
    
    private String formatSpellName(String id) {
        char letter = id.charAt(id.length() - 1);
        String newId = id.substring(0, id.length() - 1) + " " + letter;
        return newId;
    }
}
