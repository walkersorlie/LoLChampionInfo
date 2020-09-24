
package com.walkersorlie.lolchampioninfo.Champion;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.walkersorlie.lolchampioninfo.Deserializers.ChampionStatsDeserializer;

/**
 *
 * @author Walker Sorlie
 */
@JsonDeserialize(using = ChampionStatsDeserializer.class)
public class ChampionStats {
    private final double hp;
    private final double hpPerLevel;
    private final double mp;
    private final double mpPerLevel;
    private final double moveSpeed;
    private final double armor;
    private final double armorPerLeveL;
    private final double spellBlock;
    private final double spellBlockPerLevel;
    private final double attackRange;
    private final double hpRegen;
    private final double hpRegenPerLevel;
    private final double mpRegen;
    private final double mpRegenPerLevel;
    private final double crit;
    private final double critPerLeveL;
    private final double attackDamage;
    private final double attackDamagePerLevel;
    private final double attackspeedPerLevel;
    private final double attackSpeed;

    public ChampionStats(double hp, double hpperlevel, double mp, double mpperlevel, double movespeed, double armor, double armorperleve, double spellblock, double spellblockperlevel, double attackrange, double hpregen, double hpregenperlevel, double mpregen, double mpregenperlevel, double crit, double critperleve, double attackdamage, double attackdamageperlevel, double attackspeedperlevel, double attackspeed) {
        this.hp = hp;
        this.hpPerLevel = hpperlevel;
        this.mp = mp;
        this.mpPerLevel = mpperlevel;
        this.moveSpeed = movespeed;
        this.armor = armor;
        this.armorPerLeveL = armorperleve;
        this.spellBlock = spellblock;
        this.spellBlockPerLevel = spellblockperlevel;
        this.attackRange = attackrange;
        this.hpRegen = hpregen;
        this.hpRegenPerLevel = hpregenperlevel;
        this.mpRegen = mpregen;
        this.mpRegenPerLevel = mpregenperlevel;
        this.crit = crit;
        this.critPerLeveL = critperleve;
        this.attackDamage = attackdamage;
        this.attackDamagePerLevel = attackdamageperlevel;
        this.attackspeedPerLevel = attackspeedperlevel;
        this.attackSpeed = attackspeed;
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

    
    
}
