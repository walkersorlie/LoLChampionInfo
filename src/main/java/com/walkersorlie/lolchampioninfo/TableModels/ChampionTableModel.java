
package com.walkersorlie.lolchampioninfo.TableModels;

import com.walkersorlie.lolchampioninfo.Champion.ChampionAttributesEnum;
import com.walkersorlie.lolchampioninfo.Champion.Champion;
import com.walkersorlie.lolchampioninfo.Champion.ChampionPassive;
import com.walkersorlie.lolchampioninfo.Champion.ChampionSpell;
import com.walkersorlie.lolchampioninfo.Champion.ChampionStats;
import java.util.EnumMap;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class ChampionTableModel extends AbstractTableModel {

    private final EnumMap championData = new EnumMap(ChampionAttributesEnum.class);
    private final String[] columnNames =  {"Attribute"};
    private final String[] rowNames = {ChampionAttributesEnum.ID.toString(), ChampionAttributesEnum.KEY.toString(), ChampionAttributesEnum.NAME.toString(),
        ChampionAttributesEnum.ALLYTIPS.toString(), ChampionAttributesEnum.ENEMYTIPS.toString(), ChampionAttributesEnum.STATS.toString(), 
        ChampionAttributesEnum.SPELLS.toString(), ChampionAttributesEnum.PASSIVE.toString()};

    public ChampionTableModel(Champion champion) {        
        championData.put(ChampionAttributesEnum.ID, champion.getId());
        championData.put(ChampionAttributesEnum.KEY, champion.getKey());
        championData.put(ChampionAttributesEnum.NAME, champion.getName());
        championData.put(ChampionAttributesEnum.ALLYTIPS, champion.getAllyTips());
        championData.put(ChampionAttributesEnum.ENEMYTIPS, champion.getEnemyTips());
        championData.put(ChampionAttributesEnum.STATS, champion.getStats());
        championData.put(ChampionAttributesEnum.SPELLS, champion.getSpells());
        championData.put(ChampionAttributesEnum.PASSIVE, champion.getPassive());
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
    /**
     * Not including 'ID', 'KEY', and 'NAME' fields, so subtract 3 from the total number of fields
     */
    public int getRowCount() {
        return Champion.NUMBER_OF_FIELDS - 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(rowIndex) {
           case 0: return ChampionAttributesEnum.ALLYTIPS;
           case 1: return ChampionAttributesEnum.ENEMYTIPS;
           case 2: return ChampionAttributesEnum.STATS;
           case 3: return ChampionAttributesEnum.SPELLS;
           case 4: return ChampionAttributesEnum.PASSIVE;
           default: return "None";
       }
    }
    
    public TableModel getCellTableModel(int rowIndex, int columnIndex) {
        TableModel tableModel;

        switch(rowIndex) {
            case 0: {
                List<String> tips = (List)championData.get(ChampionAttributesEnum.ALLYTIPS);
                tableModel = new TipsTableModel(tips);
                break;
            }
            case 1: {
                List<String> tips = (List)championData.get(ChampionAttributesEnum.ENEMYTIPS);
                tableModel = new TipsTableModel(tips);
                break;
            }
            case 2: {
                ChampionStats stats = (ChampionStats)championData.get(ChampionAttributesEnum.STATS);
                tableModel = new StatsTableModel(stats);
                break;
            }
            case 3: {
                ChampionSpell[] spells = (ChampionSpell[])championData.get(ChampionAttributesEnum.SPELLS);
                tableModel = new SpellsTableModel(spells);
                break;
            }
            case 4: {
                ChampionPassive passive = (ChampionPassive)championData.get(ChampionAttributesEnum.PASSIVE);
                tableModel = new PassiveTableModel(passive);
                break;
            }
            default: tableModel = new DefaultTableModel();
        }
        return tableModel;
    }
}