
package com.walkersorlie.lolchampioninfo.Entities;

import com.walkersorlie.lolchampioninfo.Champion.ChampionStats;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Walker Sorlie
 */
@Entity
@Table(name = "STATS_ENTITY")
public class ChampionStatsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "CHAMPION_ID")
    private ChampionEntity champion;
    
    @Column(name = "HP")
    private double hp;
    
    @Column(name = "HP_PER_LEVEL")
    private double hpPerLevel;
    
    @Column(name = "MP")
    private double mp;
    
    @Column(name = "MP_PER_LEVEL")
    private double mpPerLevel;
    
    @Column(name = "MOVE_SPEED")
    private double moveSpeed;
    
    @Column(name = "ARMOR")
    private double armor;
    
    @Column(name = "ARMOR_PER_LEVEL")
    private double armorPerLeveL;
    
    @Column(name = "SPELL_BLOCK")
    private double spellBlock;
    
    @Column(name = "SPELL_BLOCK_PER_LEVEL")
    private double spellBlockPerLevel;
    
    @Column(name = "ATTACK_RANGE")
    private double attackRange;
    
    @Column(name = "HP_REGEN")
    private double hpRegen;
    
    @Column(name = "HP_REGEN_PER_LEVEL")
    private double hpRegenPerLevel;
    
    @Column(name = "MP_REGEN")
    private double mpRegen;
    
    @Column(name = "MP_REGEN_PER_LEVEL")
    private double mpRegenPerLevel;
    
    @Column(name = "CRIT")
    private double crit;
    
    @Column(name = "CRIT_PER_LEVEL")
    private double critPerLeveL;
    
    @Column(name = "ATTACK_DAMAGE")
    private double attackDamage;
    
    @Column(name = "ATTACK_DAMAGE_PER_LEVEL")
    private double attackDamagePerLevel;
    
    @Column(name = "ATTACK_SPEED_PER_LEVEL")
    private double attackspeedPerLevel;
    
    @Column(name = "ATTACK_SPEED")
    private double attackSpeed;

    
    public ChampionStatsEntity() { }
    
    public ChampionStatsEntity(ChampionEntity championEntity, ChampionStats championStats) {
        this.champion = championEntity;
        this.hp = championStats.getHp();
        this.hpPerLevel = championStats.getHpPerLevel();
        this.mp = championStats.getMp();
        this.mpPerLevel = championStats.getMpPerLevel();
        this.moveSpeed = championStats.getMoveSpeed();
        this.armor = championStats.getArmor();
        this.armorPerLeveL = championStats.getArmorPerLeveL();
        this.spellBlock = championStats.getSpellBlock();
        this.spellBlockPerLevel = championStats.getSpellBlockPerLevel();
        this.attackRange = championStats.getAttackRange();
        this.hpRegen = championStats.getHpRegen();
        this.hpRegenPerLevel = championStats.getHpRegenPerLevel();
        this.mpRegen = championStats.getMpRegen();
        this.mpRegenPerLevel = championStats.getMpRegenPerLevel();
        this.crit = championStats.getCrit();
        this.critPerLeveL = championStats.getCritPerLeveL();
        this.attackDamage = championStats.getAttackDamage();
        this.attackDamagePerLevel = championStats.getAttackDamagePerLevel();
        this.attackspeedPerLevel = championStats.getAttackspeedPerLevel();
        this.attackSpeed = championStats.getAttackSpeed();
    }

    public ChampionStatsEntity(ChampionEntity champion, double hp, double hpPerLevel, double mp, double mpPerLevel, double moveSpeed, double armor, double armorPerLeveL, double spellBlock, double spellBlockPerLevel, double attackRange, double hpRegen, double hpRegenPerLevel, double mpRegen, double mpRegenPerLevel, double crit, double critPerLeveL, double attackDamage, double attackDamagePerLevel, double attackspeedPerLevel, double attackSpeed) {
        this.champion = champion;
        this.hp = hp;
        this.hpPerLevel = hpPerLevel;
        this.mp = mp;
        this.mpPerLevel = mpPerLevel;
        this.moveSpeed = moveSpeed;
        this.armor = armor;
        this.armorPerLeveL = armorPerLeveL;
        this.spellBlock = spellBlock;
        this.spellBlockPerLevel = spellBlockPerLevel;
        this.attackRange = attackRange;
        this.hpRegen = hpRegen;
        this.hpRegenPerLevel = hpRegenPerLevel;
        this.mpRegen = mpRegen;
        this.mpRegenPerLevel = mpRegenPerLevel;
        this.crit = crit;
        this.critPerLeveL = critPerLeveL;
        this.attackDamage = attackDamage;
        this.attackDamagePerLevel = attackDamagePerLevel;
        this.attackspeedPerLevel = attackspeedPerLevel;
        this.attackSpeed = attackSpeed;
    }
    
    public Long getId() {
        return id;
    }

    public ChampionEntity getChampion() {
        return champion;
    }

    public double getHp() {
        return hp;
    }

    public double getHpPerLevel() {
        return hpPerLevel;
    }

    public double getMp() {
        return mp;
    }

    public double getMpPerLevel() {
        return mpPerLevel;
    }

    public double getMoveSpeed() {
        return moveSpeed;
    }

    public double getArmor() {
        return armor;
    }

    public double getArmorPerLeveL() {
        return armorPerLeveL;
    }

    public double getSpellBlock() {
        return spellBlock;
    }

    public double getSpellBlockPerLevel() {
        return spellBlockPerLevel;
    }

    public double getAttackRange() {
        return attackRange;
    }

    public double getHpRegen() {
        return hpRegen;
    }

    public double getHpRegenPerLevel() {
        return hpRegenPerLevel;
    }

    public double getMpRegen() {
        return mpRegen;
    }

    public double getMpRegenPerLevel() {
        return mpRegenPerLevel;
    }

    public double getCrit() {
        return crit;
    }

    public double getCritPerLeveL() {
        return critPerLeveL;
    }

    public double getAttackDamage() {
        return attackDamage;
    }

    public double getAttackDamagePerLevel() {
        return attackDamagePerLevel;
    }

    public double getAttackspeedPerLevel() {
        return attackspeedPerLevel;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    } 

    public void setChampion(ChampionEntity champion) {
        this.champion = champion;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setHpPerLevel(double hpPerLevel) {
        this.hpPerLevel = hpPerLevel;
    }

    public void setMp(double mp) {
        this.mp = mp;
    }

    public void setMpPerLevel(double mpPerLevel) {
        this.mpPerLevel = mpPerLevel;
    }

    public void setMoveSpeed(double moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public void setArmorPerLeveL(double armorPerLeveL) {
        this.armorPerLeveL = armorPerLeveL;
    }

    public void setSpellBlock(double spellBlock) {
        this.spellBlock = spellBlock;
    }

    public void setSpellBlockPerLevel(double spellBlockPerLevel) {
        this.spellBlockPerLevel = spellBlockPerLevel;
    }

    public void setAttackRange(double attackRange) {
        this.attackRange = attackRange;
    }

    public void setHpRegen(double hpRegen) {
        this.hpRegen = hpRegen;
    }

    public void setHpRegenPerLevel(double hpRegenPerLevel) {
        this.hpRegenPerLevel = hpRegenPerLevel;
    }

    public void setMpRegen(double mpRegen) {
        this.mpRegen = mpRegen;
    }

    public void setMpRegenPerLevel(double mpRegenPerLevel) {
        this.mpRegenPerLevel = mpRegenPerLevel;
    }

    public void setCrit(double crit) {
        this.crit = crit;
    }

    public void setCritPerLeveL(double critPerLeveL) {
        this.critPerLeveL = critPerLeveL;
    }

    public void setAttackDamage(double attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void setAttackDamagePerLevel(double attackDamagePerLevel) {
        this.attackDamagePerLevel = attackDamagePerLevel;
    }

    public void setAttackspeedPerLevel(double attackspeedPerLevel) {
        this.attackspeedPerLevel = attackspeedPerLevel;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
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
        if (!(object instanceof ChampionStatsEntity)) {
            return false;
        }
        ChampionStatsEntity other = (ChampionStatsEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.walkersorlie.lolchampioninfo.Entities.StatsEntity[ id=" + id + " ]";
    }

}
