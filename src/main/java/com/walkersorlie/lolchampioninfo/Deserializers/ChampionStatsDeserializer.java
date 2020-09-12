
package com.walkersorlie.lolchampioninfo.Deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.walkersorlie.lolchampioninfo.Champion.ChampionStats;
import java.io.IOException;

/**
 *
 * @author Walker Sorlie
 */
public class ChampionStatsDeserializer extends StdDeserializer<ChampionStats> {
    
    public ChampionStatsDeserializer() {
        this(null);
    }
    
    public ChampionStatsDeserializer(Class<?> vc) {
        super(vc);
    }
    
    @Override
    public ChampionStats deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        JsonNode stats = node.get("stats");
        
        double hp = stats.get("hp").doubleValue();
        double hpPerLevel = stats.get("hpperlevel").doubleValue();
        double mp = stats.get("mp").doubleValue();
        double mpPerLevel = stats.get("mpperlevel").doubleValue();
        double moveSpeed = stats.get("movespeed").doubleValue();
        double armor = stats.get("armor").doubleValue();
        double armorPerLevel = stats.get("armorperlevel").doubleValue();
        double spellBlock = stats.get("spellblock").doubleValue();
        double spellBlockPerLevel = stats.get("spellblockperlevel").doubleValue();
        double attackRange = stats.get("attackrange").doubleValue();
        double hpRegen = stats.get("hpregen").doubleValue();
        double hpRegenPerLevel = stats.get("hpregenperlevel").doubleValue();
        double mpRegen = stats.get("mpregen").doubleValue();
        double mpRegenPerLevel = stats.get("mpregenperlevel").doubleValue();
        double crit = stats.get("crit").doubleValue();
        double critPerLevel = stats.get("critperlevel").doubleValue();
        double attackDamage =  stats.get("attackdamage").doubleValue();
        double attackDamagePerLevel =  stats.get("attackdamageperlevel").doubleValue();
        double attackSpeedPerLevel =  stats.get("attackspeedperlevel").doubleValue();
        double attackSpeed =  stats.get("attackspeed").doubleValue();
        
        
        return new ChampionStats(hp, hpPerLevel, mp, mpPerLevel, moveSpeed, armor, armorPerLevel, spellBlock, spellBlockPerLevel,
                attackRange, hpRegen, hpRegenPerLevel, mpRegen, mpRegenPerLevel, crit, critPerLevel, 
                attackDamage, attackDamagePerLevel, attackSpeedPerLevel, attackSpeed);
    }

}
