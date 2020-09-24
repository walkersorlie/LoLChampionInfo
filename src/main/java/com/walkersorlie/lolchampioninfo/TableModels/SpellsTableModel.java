
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
    
    public SpellsTableModel(HashMap<String, ChampionSpell> spells) {
        this.spells = spells;
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
    public String getValueAt(int rowIndex, int columnIndex) {
        String value = "";
        if(columnIndex == 0) {
            Iterator<String> itr = spells.keySet().iterator();
            while(itr.hasNext()) {
                String spell = itr.next();
                char c = spell.charAt(spell.length() - 1);
                switch(c) {
                    case 'Q': value = spell;
                        break;
                    case 'W': value = spell;
                        break;
                    case 'E': value = spell;
                        break;
                    case 'R': value = spell;
                        break;
                    default: value = "None";
                }
            }
        }
        else {
            Iterator<Map.Entry<String, ChampionSpell>> itr = spells.entrySet().iterator();
            while(itr.hasNext()) {
                Map.Entry<String, ChampionSpell> spell = itr.next();
                String key = spell.getKey();
                char c = key.charAt(key.length() - 1);
                switch(c) {
                    case 'Q': value = spell.getValue().getDescription();
                        break;
                    case 'W': value = spell.getValue().getDescription();
                        break;
                    case 'E': value = spell.getValue().getDescription();
                        break;
                    case 'R': value = spell.getValue().getDescription();
                        break;
                    default: value = "None";
                }
            }
        }
        return value;
    }
}
