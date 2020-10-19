
package com.walkersorlie.lolchampioninfo.TableModels;

import com.walkersorlie.lolchampioninfo.Champion.ChampionStatsAttributeEnum;
import com.walkersorlie.lolchampioninfo.Entities.ChampionStatsEntity;
import java.util.EnumMap;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Walker Sorlie
 */
public class StatsTableModel extends AbstractTableModel {
    
    private final EnumMap championStats = new EnumMap(ChampionStatsAttributeEnum.class);
    private final String[] columns = {"Stat", "Value"};
    private final String[] rows = {ChampionStatsAttributeEnum.HP.toString(), ChampionStatsAttributeEnum.HP_PER_LEVEL.toString(), 
        ChampionStatsAttributeEnum.MP.toString(), ChampionStatsAttributeEnum.MP_PER_LEVEL.toString(), ChampionStatsAttributeEnum.MOVE_SPEED.toString(), 
        ChampionStatsAttributeEnum.ARMOR.toString(), ChampionStatsAttributeEnum.ARMOR_PER_LEVEL.toString(), ChampionStatsAttributeEnum.SPELL_BLOCK.toString(), 
        ChampionStatsAttributeEnum.SPELL_BLOCK_PER_LEVEL.toString(), ChampionStatsAttributeEnum.ATTACK_RANGE.toString(), ChampionStatsAttributeEnum.HP_REGEN.toString(), 
        ChampionStatsAttributeEnum.HP_REGEN_PER_LEVEL.toString(), ChampionStatsAttributeEnum.MP_REGEN.toString(), ChampionStatsAttributeEnum.MP_REGEN_PER_LEVEL.toString(),
        ChampionStatsAttributeEnum.CRIT.toString(), ChampionStatsAttributeEnum.CRIT_PER_LEVEL.toString(), ChampionStatsAttributeEnum.ATTACK_DAMAGE.toString(), 
        ChampionStatsAttributeEnum.ATTACK_DAMAGE_PER_LEVEL.toString(), ChampionStatsAttributeEnum.ATTACK_SPEED_PER_LEVEL.toString(), ChampionStatsAttributeEnum.ATTACK_SPEED.toString()};
    
    public StatsTableModel(ChampionStatsEntity stats) {
        
        championStats.put(ChampionStatsAttributeEnum.HP, stats.getHp());
        championStats.put(ChampionStatsAttributeEnum.HP_PER_LEVEL, stats.getHpPerLevel());
        championStats.put(ChampionStatsAttributeEnum.MP, stats.getMp());
        championStats.put(ChampionStatsAttributeEnum.MP_PER_LEVEL, stats.getMpPerLevel());
        championStats.put(ChampionStatsAttributeEnum.MOVE_SPEED, stats.getMoveSpeed());
        championStats.put(ChampionStatsAttributeEnum.ARMOR, stats.getArmor());
        championStats.put(ChampionStatsAttributeEnum.ARMOR_PER_LEVEL, stats.getArmorPerLeveL());
        championStats.put(ChampionStatsAttributeEnum.SPELL_BLOCK, stats.getSpellBlock());
        championStats.put(ChampionStatsAttributeEnum.SPELL_BLOCK_PER_LEVEL, stats.getSpellBlockPerLevel());
        championStats.put(ChampionStatsAttributeEnum.ATTACK_RANGE, stats.getAttackRange());
        championStats.put(ChampionStatsAttributeEnum.HP_REGEN, stats.getHpRegen());
        championStats.put(ChampionStatsAttributeEnum.HP_REGEN_PER_LEVEL, stats.getHpRegenPerLevel());
        championStats.put(ChampionStatsAttributeEnum.MP_REGEN, stats.getMpRegen());
        championStats.put(ChampionStatsAttributeEnum.MP_REGEN_PER_LEVEL, stats.getMpPerLevel());
        championStats.put(ChampionStatsAttributeEnum.CRIT, stats.getCrit());
        championStats.put(ChampionStatsAttributeEnum.CRIT_PER_LEVEL, stats.getCritPerLeveL());
        championStats.put(ChampionStatsAttributeEnum.ATTACK_DAMAGE, stats.getAttackDamage());
        championStats.put(ChampionStatsAttributeEnum.ATTACK_DAMAGE_PER_LEVEL, stats.getAttackDamagePerLevel());
        championStats.put(ChampionStatsAttributeEnum.ATTACK_SPEED_PER_LEVEL, stats.getAttackspeedPerLevel());
        championStats.put(ChampionStatsAttributeEnum.ATTACK_SPEED, stats.getAttackSpeed());
    }
        
    @Override
    public int getRowCount() {
        return rows.length;
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
   
        switch(columnIndex) {
            /**
             * Return the key, which is the stat name
             */
            case 0: {
                return rows[rowIndex];
            }
            
            /**
             * Return the stat value
             */
            case 1: {
                switch(rowIndex) {
                    case 0: return championStats.get(ChampionStatsAttributeEnum.HP);
                    case 1: return championStats.get(ChampionStatsAttributeEnum.HP_PER_LEVEL);
                    case 2: return championStats.get(ChampionStatsAttributeEnum.MP);
                    case 3: return championStats.get(ChampionStatsAttributeEnum.MP_PER_LEVEL);
                    case 4: return championStats.get(ChampionStatsAttributeEnum.MOVE_SPEED);
                    case 5: return championStats.get(ChampionStatsAttributeEnum.ARMOR);
                    case 6: return championStats.get(ChampionStatsAttributeEnum.ARMOR_PER_LEVEL);
                    case 7: return championStats.get(ChampionStatsAttributeEnum.SPELL_BLOCK);
                    case 8: return championStats.get(ChampionStatsAttributeEnum.SPELL_BLOCK_PER_LEVEL);
                    case 9: return championStats.get(ChampionStatsAttributeEnum.ATTACK_RANGE);
                    case 10: return championStats.get(ChampionStatsAttributeEnum.HP_REGEN);
                    case 11: return championStats.get(ChampionStatsAttributeEnum.HP_REGEN_PER_LEVEL);
                    case 12: return championStats.get(ChampionStatsAttributeEnum.MP_REGEN);
                    case 13: return championStats.get(ChampionStatsAttributeEnum.MP_REGEN_PER_LEVEL);
                    case 14: return championStats.get(ChampionStatsAttributeEnum.CRIT);
                    case 15: return championStats.get(ChampionStatsAttributeEnum.CRIT_PER_LEVEL);
                    case 16: return championStats.get(ChampionStatsAttributeEnum.ATTACK_DAMAGE);
                    case 17: return championStats.get(ChampionStatsAttributeEnum.ATTACK_DAMAGE_PER_LEVEL);
                    case 18: return championStats.get(ChampionStatsAttributeEnum.ATTACK_SPEED_PER_LEVEL);
                    case 19: return championStats.get(ChampionStatsAttributeEnum.ATTACK_SPEED);
                    default: return "None";
                }           
            }
            default: return "None";
        }  
    }
}
