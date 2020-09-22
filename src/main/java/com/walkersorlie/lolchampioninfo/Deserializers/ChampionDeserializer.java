
package com.walkersorlie.lolchampioninfo.Deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import com.walkersorlie.lolchampioninfo.Champion.Champion;
import com.walkersorlie.lolchampioninfo.Champion.ChampionSpell;
import com.walkersorlie.lolchampioninfo.Champion.ChampionStats;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Walker Sorlie
 */
public class ChampionDeserializer extends StdDeserializer<Champion> {
    
    public ChampionDeserializer() {
        this(null);
    }
    
    public ChampionDeserializer(Class<?> vc) {
        super(vc);
    }
    
    
    @Override
    public Champion deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
       
	JsonNode node = jp.getCodec().readTree(jp);
        JsonNode dataNode = node.get("data");
        
        String championName = "";
        Iterator itr = dataNode.fieldNames();
        while(itr.hasNext()) {
            championName = (String) itr.next();
        }
        JsonNode champ = dataNode.get(championName);
        
        String id = champ.get("id").asText();
        Long key = champ.get("key").asLong();
        String name = champ.get("name").asText();
        List<String> allyTips = new ArrayList<>();
        List<String> enemyTips = new ArrayList<>();
        ChampionStats stats = new ObjectMapper().readValue(champ.toString(), ChampionStats.class);
        
        Map<String, ChampionSpell> spells = new HashMap<>(7);
        Map<String, String> passive = new HashMap<>(5);
        
        Iterator allyItr = champ.get("allytips").iterator();
        while(allyItr.hasNext()) {
            TextNode tip = (TextNode) allyItr.next();
            allyTips.add(tip.asText());
        }
        
        Iterator enemyItr = champ.get("enemytips").iterator();
        while(enemyItr.hasNext()) {
            TextNode tip = (TextNode) enemyItr.next();
            enemyTips.add(tip.asText());
        }
        
        JsonNode spellsArray = champ.get("spells");
        Iterator spellsItr = spellsArray.iterator();
        while(spellsItr.hasNext()) {
            JsonNode index = (JsonNode) spellsItr.next();
            ChampionSpell spell = createSpell(index);
            
            spells.put(spell.getId(), spell);
        }
        
        JsonNode passiveNode = champ.get("passive");
        passive.put(passiveNode.get("name").asText(), passiveNode.get("description").asText());

        return new Champion(id, key, name, allyTips, enemyTips, stats, spells, passive);
    }
    
    
    private ChampionSpell createSpell(JsonNode node) {
        ChampionSpell spell = new ChampionSpell(node.get("id").asText(), node.get("name").asText(), node.get("description").asText(), node.get("tooltip").asText());
        
        return spell;
    }
}
