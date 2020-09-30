
package com.walkersorlie.lolchampioninfo.Deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author Walker Sorlie
 */
public class ChampionsListDeserializer extends StdDeserializer<ArrayList> {
    
    private ArrayList<String> championsList;
    
    public ChampionsListDeserializer() {
        this(null);
        championsList = new ArrayList();
    }
    
    public ChampionsListDeserializer(Class<?> vc) {
        super(vc);
        championsList = new ArrayList();
    }
    
    @Override
    public ArrayList<String> deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        JsonNode dataNode = node.get("data");
        
        Iterator itr = dataNode.fieldNames();
        while(itr.hasNext()) {
            championsList.add((String)itr.next());       
        }        
        return championsList;
    }
}
