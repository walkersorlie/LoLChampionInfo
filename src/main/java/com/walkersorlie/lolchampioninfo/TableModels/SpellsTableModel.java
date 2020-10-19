
package com.walkersorlie.lolchampioninfo.TableModels;

import com.walkersorlie.lolchampioninfo.Entities.ChampionSpellEntity;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Walker Sorlie
 */
public class SpellsTableModel extends AbstractTableModel {
    
    private final String[] columns = {"Spell Letter", "Spell Name", "Description"};
    private final List<ChampionSpellEntity> spells;
    
    public SpellsTableModel(List<ChampionSpellEntity> spells) {
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
                    ChampionSpellEntity spell = spells.get(0);
                    value = spell.getName();
                    break;
                }
                case 1: {
                    ChampionSpellEntity spell = spells.get(1);
                    value = spell.getName();
                    break;
                }
                case 2: {
                    ChampionSpellEntity spell = spells.get(2);
                    value = spell.getName();
                    break;
                }
                case 3: {
                    ChampionSpellEntity spell = spells.get(3);
                    value = spell.getName();
                    break;
                }
                default: value = "None";
            }
        }
        else {
            switch(rowIndex) {
                case 0: {
                    ChampionSpellEntity spell = spells.get(0);
                    value = spell.getDescription();
                    break;
                }
                case 1: {
                    ChampionSpellEntity spell = spells.get(1);
                    value = spell.getDescription();
                    break;
                }
                case 2: {
                    ChampionSpellEntity spell = spells.get(2);
                    value = spell.getDescription();
                    break;
                }
                case 3: {
                    ChampionSpellEntity spell = spells.get(3);
                    value = spell.getDescription();
                    break;
                }
                default: value = "None";
            }
        }     
        return value;
    }
}
