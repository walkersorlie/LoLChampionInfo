
package com.walkersorlie.lolchampioninfo.Entities;

import com.walkersorlie.lolchampioninfo.Champion.Champion;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 *
 * @author Walker Sorlie
 */

@Entity
@Table(name = "CHAMPION_ENTITY")
public class ChampionEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "CHAMPION_ID")
    private String id;
    
    @Id
    @Column(name = "CHAMPION_KEY")
    private Long key;
    
    @Column(name = "NAME")
    private String name;
    
    @OneToMany(mappedBy = "champion")
    private List<AllyTipsEntity> allyTips;
    
    @OneToMany(mappedBy = "champion")
    private List<EnemyTipsEntity> enemyTips;
    
    @OneToOne(fetch = FetchType.LAZY)
    private ChampionStatsEntity stats;
    
    @OneToMany(mappedBy = "champion")
    @OrderColumn(name = "CHAMPION_SPELL_ENTITY_ID")
    private List<ChampionSpellEntity> spells;
    
    @OneToOne
    private ChampionPassiveEntity passive;
        
    public ChampionEntity() { }
    
    public ChampionEntity(Champion champion) {
        this.id = champion.getId();
        this.key = champion.getKey();
        this.name = champion.getName();
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

    public List<AllyTipsEntity> getAllyTips() {
        return allyTips;
    }

    public void setAllyTips(List<AllyTipsEntity> allyTips) {
        this.allyTips = allyTips;
    }

    public List<EnemyTipsEntity> getEnemyTips() {
        return enemyTips;
    }

    public void setEnemyTips(List<EnemyTipsEntity> enemyTips) {
        this.enemyTips = enemyTips;
    }

    public ChampionStatsEntity getStats() {
        return stats;
    }

    public void setStats(ChampionStatsEntity stats) {
        this.stats = stats;
    }

    public List<ChampionSpellEntity> getSpells() {
        return spells;
    }

    public void setSpells(List<ChampionSpellEntity> spells) {
        this.spells = spells;
    }

    public ChampionPassiveEntity getPassive() {
        return passive;
    }

    public void setPassive(ChampionPassiveEntity passive) {
        this.passive = passive;
    }
}
