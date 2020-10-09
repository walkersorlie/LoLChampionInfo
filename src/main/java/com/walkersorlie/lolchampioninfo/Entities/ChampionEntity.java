
package com.walkersorlie.lolchampioninfo.Entities;

import com.walkersorlie.lolchampioninfo.Champion.ChampionPassive;
import com.walkersorlie.lolchampioninfo.Champion.ChampionSpell;
import com.walkersorlie.lolchampioninfo.Champion.ChampionStats;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Walker Sorlie
 */

@Entity
@Table(name = "CHAMPION_ENTITY")
public class ChampionEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "CHAMPION_ID")
    private String id;
    
    @Column(name = "KEY")
    private Long key;
    
    @Column(name = "NAME")
    private String name;
    
    @OneToMany(mappedBy = "CHAMPION_ENTITY")
    private List<String> allyTips;
    
    @OneToMany(mappedBy = "CHAMPION_ENTITY")
    private List<String> enemyTips;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private ChampionStats stats;
    
    @OneToMany(mappedBy = "CHAMPION_ENTITY")
    private ChampionSpell[] spells;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private ChampionPassive passive;
    
    
    public ChampionEntity() { }
    
    public ChampionEntity(String id, Long key, String name, List<String>allyTips, List<String>enemyTips, ChampionStats stats, ChampionSpell[] spells, ChampionPassive passive) {
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

    public void setId(String id) {
        this.id = id;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAllyTips() {
        return allyTips;
    }

    public void setAllyTips(List<String> allyTips) {
        this.allyTips = allyTips;
    }

    public List<String> getEnemyTips() {
        return enemyTips;
    }

    public void setEnemyTips(List<String> enemyTips) {
        this.enemyTips = enemyTips;
    }

    public ChampionStats getStats() {
        return stats;
    }

    public void setStats(ChampionStats stats) {
        this.stats = stats;
    }

    public ChampionSpell[] getSpells() {
        return spells;
    }

    public void setSpells(ChampionSpell[] spells) {
        this.spells = spells;
    }

    public ChampionPassive getPassive() {
        return passive;
    }

    public void setPassive(ChampionPassive passive) {
        this.passive = passive;
    }
}
