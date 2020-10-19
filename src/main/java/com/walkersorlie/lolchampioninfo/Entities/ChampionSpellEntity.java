
package com.walkersorlie.lolchampioninfo.Entities;

import com.walkersorlie.lolchampioninfo.Champion.ChampionSpell;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Walker Sorlie
 */
@Entity
@Table(name = "CHAMPION_SPELL_ENTITY")
public class ChampionSpellEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CHAMPION_SPELL_ENTITY_ID")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "CHAMPION_ID")
    private ChampionEntity champion;
    
    @Column(name = "SPELL_ID")
    private String spellId;
    
    @Column(name = "SPELL_NAME")
    private String name;
    
    @Column(name = "SPELL_DESCRIPTION", length = 500)
    private String description;
    
    @Column(name = "SPELL_TOOLTIP", length = 2000)
    private String toolTip;

    
    public ChampionSpellEntity() { }
    
    public ChampionSpellEntity(ChampionEntity championEntity, ChampionSpell spell) {
        champion = championEntity;
        spellId = spell.getId();
        name = spell.getId();
        description = spell.getDescription();
        toolTip = spell.getToolTip();
    }

    public ChampionSpellEntity(ChampionEntity champion, String spellId, String name, String description, String toolTip) {
        this.champion = champion;
        this.spellId = spellId;
        this.name = name;
        this.description = description;
        this.toolTip = toolTip;
    }
        
    public Long getId() {
        return id;
    }

    public ChampionEntity getChampion() {
        return champion;
    }

    public String getSpellId() {
        return spellId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getToolTip() {
        return toolTip;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setChampion(ChampionEntity champion) {
        this.champion = champion;
    }

    public void setSpellId(String spellId) {
        this.spellId = spellId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setToolTip(String toolTip) {
        this.toolTip = toolTip;
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
        if (!(object instanceof ChampionSpellEntity)) {
            return false;
        }
        ChampionSpellEntity other = (ChampionSpellEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.walkersorlie.lolchampioninfo.Entities.ChampionSpell[ id=" + id + " ]";
    }

}
