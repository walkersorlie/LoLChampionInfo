
package com.walkersorlie.lolchampioninfo.Entities;

import com.walkersorlie.lolchampioninfo.Champion.ChampionPassive;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Walker Sorlie
 */
@Entity
@Table(name = "CHAMPION_PASSIVE_ENTITY")
public class ChampionPassiveEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private ChampionEntity champion;
    
    @Column(name = "PASSIVE_NAME")
    private String name;
    
    @Column(name = "PASSIVE_DESCRIPTION", length = 500)
    private String description;

    
    public ChampionPassiveEntity() { }
    
    public ChampionPassiveEntity(ChampionEntity championEntity, ChampionPassive passive) {
        this.champion = championEntity;
        this.name = passive.getName();
        this.description = passive.getDescription();
    }

    public ChampionPassiveEntity(ChampionEntity champion, String name, String description) {
        this.champion = champion;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public ChampionEntity getChampion() {
        return champion;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setChampion(ChampionEntity champion) {
        this.champion = champion;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChampionPassiveEntity)) {
            return false;
        }
        ChampionPassiveEntity other = (ChampionPassiveEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.walkersorlie.lolchampioninfo.Entities.ChampionPassiveEntity[ id=" + id + " ]";
    }

}
