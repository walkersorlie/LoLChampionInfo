
package com.walkersorlie.lolchampioninfo.Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Walker Sorlie
 */
@Entity
public class EnemyTipsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  
    
    @ManyToOne
    @JoinColumn(name = "CHAMPION_ID")
    private ChampionEntity champion;
    
    @Column(name = "ENEMY_TIP_DESCRIPTION", length = 500)
    private String tip;

    
    public EnemyTipsEntity() { }

    public EnemyTipsEntity(ChampionEntity champion, String tip) {
        this.champion = champion;
        this.tip = tip;
    }

    public Long getId() {
        return id;
    }

    public ChampionEntity getChampion() {
        return champion;
    }

    public String getTip() {
        return tip;
    }

    public void setChampion(ChampionEntity champion) {
        this.champion = champion;
    }

    public void setTip(String tip) {
        this.tip = tip;
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
        if (!(object instanceof EnemyTipsEntity)) {
            return false;
        }
        EnemyTipsEntity other = (EnemyTipsEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "com.walkersorlie.lolchampioninfo.Entities.EnemyTipsEntity[ id=" + id + " ]";
    }

}
