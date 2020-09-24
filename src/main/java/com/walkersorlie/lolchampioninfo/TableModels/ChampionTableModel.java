
package com.walkersorlie.lolchampioninfo.TableModels;

import com.walkersorlie.lolchampioninfo.Champion.ChampionAttributesEnum;
import com.walkersorlie.lolchampioninfo.Champion.Champion;
import java.util.EnumMap;
import javax.swing.table.AbstractTableModel;


public class ChampionTableModel extends AbstractTableModel {

//    private final Champion champion;
    private final EnumMap championData = new EnumMap(ChampionAttributesEnum.class);
    private final String[] columnNames =  {"Attribute", "Value"};
    private final String[] rowNames = {ChampionAttributesEnum.ID.toString(), ChampionAttributesEnum.KEY.toString(), ChampionAttributesEnum.NAME.toString(),
        ChampionAttributesEnum.ALLYTIPS.toString(), ChampionAttributesEnum.ENEMYTIPS.toString(), ChampionAttributesEnum.STATS.toString(), 
        ChampionAttributesEnum.SPELLS.toString(), ChampionAttributesEnum.PASSIVE.toString()};

    public ChampionTableModel(Champion champion) {
//        this.champion = champion;
        
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
    public int getRowCount() {
        return Champion.NUMBER_OF_FIELDS;
    }
    
    public Class getRowClass(int row) {
        return getValueAt(row, 0).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         
         switch(columnIndex) {
             case 0: {
                 switch(rowIndex) {
                     case 0: return ChampionAttributesEnum.ID;
                     case 1: return ChampionAttributesEnum.KEY;
                     case 2: return ChampionAttributesEnum.NAME;
                     case 3: return ChampionAttributesEnum.ALLYTIPS;
                     case 4: return ChampionAttributesEnum.ENEMYTIPS;
                     case 5: return ChampionAttributesEnum.STATS;
                     case 6: return ChampionAttributesEnum.SPELLS;
                     case 7: return ChampionAttributesEnum.PASSIVE;
                     default: return "None";
                 }
             }
             case 1: {
                 switch(rowIndex) {
                    case 0: return championData.get(ChampionAttributesEnum.ID);
                    case 1: return championData.get(ChampionAttributesEnum.KEY);
                    case 2: return championData.get(ChampionAttributesEnum.NAME);
                    case 3: return championData.get(ChampionAttributesEnum.ALLYTIPS);
                    case 4: return championData.get(ChampionAttributesEnum.ENEMYTIPS);
                    case 5: return championData.get(ChampionAttributesEnum.STATS);
                    case 6: return championData.get(ChampionAttributesEnum.SPELLS);
                    case 7: return championData.get(ChampionAttributesEnum.PASSIVE);
                    default: return "None";
                 }
             }
             default: return "None";
         }   
    }
}