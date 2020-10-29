
package com.walkersorlie.lolchampioninfo;

import com.walkersorlie.lolchampioninfo.Champion.MultiNameChampionsEnum;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;


/**
 *
 * @author Walker Sorlie
 */
public final class NetworkRequest {       
    
    private static final String BASE_URL = "http://ddragon.leagueoflegends.com/cdn/10.18.1/data/en_US/champion";
    
    private NetworkRequest() {}
    
     public static String sendGet(String name) throws Exception {
         URL url;
         if (checkName(name).isEmpty()) {
             url = new URL(BASE_URL + ".json");
         } else {
             url = new URL(BASE_URL + "/" + checkName(name));
         }
         System.out.println(url.toString());
         HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
         httpCon.setRequestMethod("GET");

         BufferedReader responseReader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
         String response = responseReader.lines().collect(Collectors.joining());

         return response;         
     }
          
    private static String checkName(String name) {
        if(name.isEmpty())
            return "";
        else {
            String formattedName = name.trim();
            return MultiNameChampionsEnum.checkNameAndAliases(formattedName.toLowerCase(), true);
        }          
    }
}
