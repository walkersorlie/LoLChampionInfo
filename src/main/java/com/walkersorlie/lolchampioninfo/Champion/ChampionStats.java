
package com.walkersorlie.lolchampioninfo.Champion;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.walkersorlie.lolchampioninfo.Deserializers.ChampionStatsDeserializer;

/**
 *
 * @author Walker Sorlie
 */
@JsonDeserialize(using = ChampionStatsDeserializer.class)
public class ChampionStats {
    private double hp;
    private double hpperlevel;
    private double mp;
    private double mpperlevel;
    private double movespeed;
    private double armor;
    private double armorperleve;
    private double spellblock;
    private double spellblockperlevel;
    private double attackrange;
    private double hpregen;
    private double hpregenperlevel;
    private double mpregen;
    private double mpregenperlevel;
    private double crit;
    private double critperleve;
    private double attackdamage;
    private double attackdamageperlevel;
    private double attackspeedperlevel;
    private double attackspeed;

    public ChampionStats(double hp, double hpperlevel, double mp, double mpperlevel, double movespeed, double armor, double armorperleve, double spellblock, double spellblockperlevel, double attackrange, double hpregen, double hpregenperlevel, double mpregen, double mpregenperlevel, double crit, double critperleve, double attackdamage, double attackdamageperlevel, double attackspeedperlevel, double attackspeed) {
        this.hp = hp;
        this.hpperlevel = hpperlevel;
        this.mp = mp;
        this.mpperlevel = mpperlevel;
        this.movespeed = movespeed;
        this.armor = armor;
        this.armorperleve = armorperleve;
        this.spellblock = spellblock;
        this.spellblockperlevel = spellblockperlevel;
        this.attackrange = attackrange;
        this.hpregen = hpregen;
        this.hpregenperlevel = hpregenperlevel;
        this.mpregen = mpregen;
        this.mpregenperlevel = mpregenperlevel;
        this.crit = crit;
        this.critperleve = critperleve;
        this.attackdamage = attackdamage;
        this.attackdamageperlevel = attackdamageperlevel;
        this.attackspeedperlevel = attackspeedperlevel;
        this.attackspeed = attackspeed;
    }

    public double getHp() {
        return hp;
    }

    public double getHpperlevel() {
        return hpperlevel;
    }

    public double getMp() {
        return mp;
    }

    public double getMpperlevel() {
        return mpperlevel;
    }

    public double getMovespeed() {
        return movespeed;
    }

    public double getArmor() {
        return armor;
    }

    public double getArmorperleve() {
        return armorperleve;
    }

    public double getSpellblock() {
        return spellblock;
    }

    public double getSpellblockperlevel() {
        return spellblockperlevel;
    }

    public double getAttackrange() {
        return attackrange;
    }

    public double getHpregen() {
        return hpregen;
    }

    public double getHpregenperlevel() {
        return hpregenperlevel;
    }

    public double getMpregen() {
        return mpregen;
    }

    public double getMpregenperlevel() {
        return mpregenperlevel;
    }

    public double getCrit() {
        return crit;
    }

    public double getCritperleve() {
        return critperleve;
    }

    public double getAttackdamage() {
        return attackdamage;
    }

    public double getAttackdamageperlevel() {
        return attackdamageperlevel;
    }

    public double getAttackspeedperlevel() {
        return attackspeedperlevel;
    }

    public double getAttackspeed() {
        return attackspeed;
    }
    
    
}
