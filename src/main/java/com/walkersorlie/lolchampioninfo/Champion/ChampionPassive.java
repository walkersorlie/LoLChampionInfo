
package com.walkersorlie.lolchampioninfo.Champion;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.walkersorlie.lolchampioninfo.Deserializers.ChampionPassiveDeserializer;

/**
 *
 * @author Walker Sorlie
 */
@JsonDeserialize(using = ChampionPassiveDeserializer.class)
public class ChampionPassive {
    
    private final String name;
    private final String description;
    
    public ChampionPassive(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
