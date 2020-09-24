
package com.walkersorlie.lolchampioninfo;

import com.walkersorlie.lolchampioninfo.Champion.ChampionSpell;
import com.walkersorlie.lolchampioninfo.Champion.ChampionStats;
import com.walkersorlie.lolchampioninfo.TableModels.PassiveTableModel;
import com.walkersorlie.lolchampioninfo.TableModels.SpellsTableModel;
import com.walkersorlie.lolchampioninfo.TableModels.StatsTableModel;
import com.walkersorlie.lolchampioninfo.TableModels.TipsTableModel;
import java.awt.Component;
import java.util.HashMap;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Walker Sorlie
 */
public class TableInTableRenderer extends JTable implements TableCellRenderer  {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = null;
        if(column == 1) {
            switch(row) {
                case 3: case 4: {
                    List<String> tips = (List)value;
                    TipsTableModel tableModel = new TipsTableModel(tips);
                    component = new JTable(tableModel);
                    break;
                }
                case 5: {
                    ChampionStats stats = (ChampionStats)value;
                    StatsTableModel tableModel = new StatsTableModel(stats);
                    component = new JTable(tableModel);
                    break;
                }
                case 6: {
                    HashMap<String, ChampionSpell> spells = (HashMap)value;
                    SpellsTableModel tableModel = new SpellsTableModel(spells);
                    component = new JTable(tableModel);
                    break;
                }
                case 7: {
                    String[] passive = (String[])value;
                    PassiveTableModel tableModel = new PassiveTableModel(passive);
                    component = new JTable(tableModel);
                    break;
                }
                default: component = null;
            }
        }
        return component;
    }

}
