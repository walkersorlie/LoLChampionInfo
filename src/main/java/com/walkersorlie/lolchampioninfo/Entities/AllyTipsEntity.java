
package com.walkersorlie.lolchampioninfo.Entities;

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
@Table(name = "ALLY_TIPS_ENTITY")
public class AllyTipsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ALLY_TIP_ID")
    private Long id;  
    
    @ManyToOne
    @JoinColumn(name = "CHAMPION_ID")
    private ChampionEntity champion;
    
    @Column(name = "ALLY_TIP_DESCRIPTION", length = 500)
    private String tip;

    
    public AllyTipsEntity() { }
 
    public AllyTipsEntity(ChampionEntity champion, String tip) {
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
        if (!(object instanceof AllyTipsEntity)) {
            return false;
        }
        AllyTipsEntity other = (AllyTipsEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.walkersorlie.lolchampioninfo.Entities.AllyTipsEntity[ id=" + id + " ]";
    }

}
