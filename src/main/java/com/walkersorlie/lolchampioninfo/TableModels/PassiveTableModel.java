
package com.walkersorlie.lolchampioninfo.TableModels;

import java.util.HashMap;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Walker Sorlie
 */
public class PassiveTableModel extends AbstractTableModel {
    
    private final String[] passive;
    private final String[] columns = {"Passive Name", "What it do?"};
    
    
    public PassiveTableModel(String[] passive) {
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return passive[0];
        else
            return passive[1];         
    }
}
