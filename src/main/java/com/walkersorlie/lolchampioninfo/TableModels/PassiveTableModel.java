
package com.walkersorlie.lolchampioninfo.TableModels;

import com.walkersorlie.lolchampioninfo.Champion.ChampionPassive;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Walker Sorlie
 */
public class PassiveTableModel extends AbstractTableModel {
    
    private final ChampionPassive passive;
    private final String[] columns = {"Passive Name", "What it do?"};
    
    
    public PassiveTableModel(ChampionPassive passive) {
        this.passive = passive;
    }
    
    @Override
    public int getRowCount() {
        return 1;
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        /**
         * Return passive name
         */
        if(columnIndex == 0)
            return passive.getName();
        
        /**
         * Return passive description
         */
        else
            return passive.getDescription();         
    }
}
