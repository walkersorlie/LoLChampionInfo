
package com.walkersorlie.lolchampioninfo;

import com.walkersorlie.lolchampioninfo.Champion.Champion;
import com.walkersorlie.lolchampioninfo.Champion.ChampionStats;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class ChampionTableModel extends AbstractTableModel {

    private Champion champion;
    private Object[][] data;
    private String[] columnNames =  {"Stat Name", "Value"};


    public ChampionTableModel(Champion champion) {
        this.champion = champion;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return champion.NUMBER_OF_FIELDS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}