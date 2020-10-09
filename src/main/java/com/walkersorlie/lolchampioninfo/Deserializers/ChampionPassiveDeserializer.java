
package com.walkersorlie.lolchampioninfo.Deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.walkersorlie.lolchampioninfo.Champion.ChampionPassive;
import java.io.IOException;

/**
 *
 * @author Walker Sorlie
 */
public class ChampionPassiveDeserializer extends StdDeserializer<ChampionPassive> {
   
    public ChampionPassiveDeserializer() {
        this(null);
    }
    
    public ChampionPassiveDeserializer(Class<?> vc) {
        super(vc);
    }
    
    @Override
    public ChampionPassive deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        JsonNode passive = node.get("passive");
        
        String passiveName = passive.get("name").asText();
        String passiveDescription = passive.get("description").asText();
        
        return new ChampionPassive(passiveName, passiveDescription);
    }
}
