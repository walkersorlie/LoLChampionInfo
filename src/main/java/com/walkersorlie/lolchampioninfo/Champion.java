
package com.walkersorlie.lolchampioninfo;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Walker Sorlie
 */
public class Champion {
    private String id;
    private long key;
    private String name;
    private List<String> allyTips;
    private List<String> enemyTips;
    private List<Integer> stats;
    
    private Map<String, ChampionSpell> spells;
    private Map<String, String> passive;

    public Champion(String id, long key, String name, List<String> allyTips, List<String> enemyTips, List<Integer> stats, Map<String, ChampionSpell> spells, Map<String, String> passive) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.allyTips = allyTips;
        this.enemyTips = enemyTips;
        this.stats = stats;
        this.spells = spells;
        this.passive = passive;
    }

    public String getId() {
        return id;
    }
    
    public long getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public List<String> getAllyTips() {
        return allyTips;
    }

    public List<String> getEnemyTips() {
        return enemyTips;
    }

    public List<Integer> getStats() {
        return stats;
    }

    public Map<String, ChampionSpell> getSpells() {
        return spells;
    }

    public Map<String, String> getPassive() {
        return passive;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + (int) (this.key ^ (this.key >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Champion other = (Champion) obj;
        if (this.key != other.key) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Champion{" + name + '}';
    }
    
    
}
