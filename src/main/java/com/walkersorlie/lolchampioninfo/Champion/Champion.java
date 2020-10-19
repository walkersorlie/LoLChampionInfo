
package com.walkersorlie.lolchampioninfo.Champion;

import com.walkersorlie.lolchampioninfo.Deserializers.ChampionDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Walker Sorlie
 */
@JsonDeserialize(using = ChampionDeserializer.class)
public class Champion {
    
    public static int NUMBER_OF_FIELDS = 8;
    
    private final String id;
    private final long key;
    private final String name;
    private final List<String> allyTips;
    private final List<String> enemyTips;
    private final ChampionStats stats;
    private final List<ChampionSpell> spells;
    private final ChampionPassive passive;

    public Champion(String id, long key, String name, List<String> allyTips, List<String> enemyTips, ChampionStats stats, List<ChampionSpell> spells, ChampionPassive passive) {
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

    public ChampionStats getStats() {
        return stats;
    }

    public List<ChampionSpell> getSpells() {
        return spells;
    }

    public ChampionPassive getPassive() {
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
        return "Champion: " + name;
    }     
}
