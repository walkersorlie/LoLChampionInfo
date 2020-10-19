
package com.walkersorlie.lolchampioninfo.TableModels;

import com.walkersorlie.lolchampioninfo.Champion.ChampionAttributesEnum;
import com.walkersorlie.lolchampioninfo.Champion.Champion;
import com.walkersorlie.lolchampioninfo.Entities.*;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class ChampionTableModel extends AbstractTableModel {

    private final EnumMap championData = new EnumMap(ChampionAttributesEnum.class);
    private final String[] columnNames =  {"Attribute"};
    private final String[] rowNames = {ChampionAttributesEnum.ID.toString(), ChampionAttributesEnum.KEY.toString(), ChampionAttributesEnum.NAME.toString(),
        ChampionAttributesEnum.ALLYTIPS.toString(), ChampionAttributesEnum.ENEMYTIPS.toString(), ChampionAttributesEnum.STATS.toString(), 
        ChampionAttributesEnum.SPELLS.toString(), ChampionAttributesEnum.PASSIVE.toString()};

    public ChampionTableModel(ChampionEntity champion) {        
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
                List<AllyTipsEntity> tipsEntities = (List)championData.get(ChampionAttributesEnum.ALLYTIPS);
                List<String> tips = tipsEntities.stream()
                        .map(tip -> tip.getTip())
                        .collect(Collectors.toList());
                tableModel = new TipsTableModel(tips);
                break;
            }
            case 1: {
                List<EnemyTipsEntity> tipsEntities = (List)championData.get(ChampionAttributesEnum.ENEMYTIPS);
                List<String> tips = tipsEntities.stream()
                        .map(tip -> tip.getTip())
                        .collect(Collectors.toList());
                tableModel = new TipsTableModel(tips);
                break;
            }
            case 2: {
                ChampionStatsEntity statsEntity = (ChampionStatsEntity)championData.get(ChampionAttributesEnum.STATS);
                tableModel = new StatsTableModel(statsEntity);
                break;
            }
            case 3: {
                List<ChampionSpellEntity> entityList = (List)championData.get(ChampionAttributesEnum.SPELLS);
                tableModel = new SpellsTableModel(entityList);
                break;
            }
            case 4: {
                ChampionPassiveEntity passive = (ChampionPassiveEntity)championData.get(ChampionAttributesEnum.PASSIVE);
                tableModel = new PassiveTableModel(passive);
                break;
            }
            default: tableModel = new DefaultTableModel();
        }
        return tableModel;
    }
}