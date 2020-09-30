
package com.walkersorlie.lolchampioninfo.TableModels;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Walker Sorlie
 */
public class ChampionsListTableModel extends AbstractTableModel {
    
    private String[] columns = {"Champions"};
    private ArrayList<String> champions;
    
    public ChampionsListTableModel(ArrayList<String> champions) {
        this.champions = champions;
    }

    @Override
    public int getRowCount() {
        return champions.size();
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
        return champions.get(rowIndex);             
    }
}
