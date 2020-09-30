
package com.walkersorlie.lolchampioninfo.TableModels;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Walker Sorlie
 */
public class TipsTableModel extends AbstractTableModel {
    
    private final String[] columns = {"Tip Number", "Tip"};
    private final HashMap<Integer, String> rows;
    
    public TipsTableModel(List<String> tips) {
        rows = new HashMap();
        
        ListIterator<String> itr = tips.listIterator();
        while(itr.hasNext()) {
            int index = itr.nextIndex();
            String tip = itr.next();
            rows.put(index, tip);
        }
    }
        
    @Override
    public int getRowCount() {
        return rows.size();
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
         * Return the key, which is the tip number
         */
        if(columnIndex == 0) {
            Iterator<Integer> itr = rows.keySet().iterator();
            while(itr.hasNext()) {
                int index = itr.next();
                if(rowIndex == index) {
                    return index;
                }                   
            }
        }
        
        /**
         * Return the actual tip
         */
        return rows.get(rowIndex);
    }
}
