
package com.walkersorlie.lolchampioninfo;

import com.walkersorlie.lolchampioninfo.Champion.Champion;
import com.walkersorlie.lolchampioninfo.Champion.ChampionStats;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class ChampionTableModel extends AbstractTableModel {

    private Champion champion;
    private Object[][] championData;
    private final String[] columnNames =  {"Champion", "Value"};
    private final String[] rowNames = {"ID", "Key", "Name", "Ally tips", "Enemy tips", "Stats", "Spells", "Passive"}

    public ChampionTableModel(Champion champion) {
        this.champion = champion;
        
        championData = {
            { champion.getID() },
            { champion.getKey() },
            { champion.getName() },
            { champion.getAllyTips() },
            { champion.getEnemyTips() },
            { champion.getStats() },
            { champion.getSpells() },
            { champion.getPassive() }
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public String getRowName(int row) {
        return rowNames[row];
    }

    @Override
    public int getRowCount() {
        return Champion.NUMBER_OF_FIELDS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        private ChampionStats stats;
        private Map<String, ChampionSpell> spells;
        private Map<String, String> passive;

        if (rowIndex == 0 || rowIndex == 1 || rowIndex == 2) {
            return championData[rowIndex][columnIndex]
        }
        else if (rowIndex == 3 || rowIndex == 4) {
            String[] tips = championData[rowIndex][columnIndex].toArray();
            return tips;
        }
        
        return "None";
    }
}