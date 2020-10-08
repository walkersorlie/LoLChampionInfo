
package com.walkersorlie.lolchampioninfo.TableModels;

import com.walkersorlie.lolchampioninfo.Champion.ChampionSpell;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Walker Sorlie
 */
public class SpellsTableModel extends AbstractTableModel {
    
    private final String[] columns = {"Spell Letter", "Spell Name", "Description"};
//    private final HashMap<String, ChampionSpell> spells;
    private final ChampionSpell[] spells;
    
    public SpellsTableModel(ChampionSpell[] spells) {
        this.spells = spells;
    }
    
    @Override
    public int getRowCount() {
        return spells.length;
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
        
        if(columnIndex == 0) {
            switch (rowIndex) {
                case 0: {
                    value = "Q";
                    break;
                }
                case 1: {
                    value = "W";
                    break;
                }
                case 2: {
                    value = "E";
                    break;
                }
                case 3: {
                    value = "R";
                    break;
                }
                
            }
        }
        else if(columnIndex == 1) {
            switch(rowIndex) {
                case 0: {
                    ChampionSpell spell = spells[0];
                    value = spell.getName();
                    break;
                }
                case 1: {
                    ChampionSpell spell = spells[1];
                    value = spell.getName();
                    break;
                }
                case 2: {
                    ChampionSpell spell = spells[2];
                    value = spell.getName();
                    break;
                }
                case 3: {
                    ChampionSpell spell = spells[3];
                    value = spell.getName();
                    break;
                }
                default: value = "None";
            }
        }
        else {
            switch(rowIndex) {
                case 0: {
                    ChampionSpell spell = spells[0];
                    value = spell.getDescription();
                    break;
                }
                case 1: {
                    ChampionSpell spell = spells[1];
                    value = spell.getDescription();
                    break;
                }
                case 2: {
                    ChampionSpell spell = spells[2];
                    value = spell.getDescription();
                    break;
                }
                case 3: {
                    ChampionSpell spell = spells[3];
                    value = spell.getDescription();
                    break;
                }
                default: value = "None";
            }
        }     
        return value;
    }
}
