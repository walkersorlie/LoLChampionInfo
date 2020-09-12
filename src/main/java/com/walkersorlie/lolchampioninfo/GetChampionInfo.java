
package com.walkersorlie.lolchampioninfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.util.stream.Collectors;


/**
 *
 * @author Walker Sorlie
 */
public class GetChampionInfo {
    private final HttpURLConnection httpCon;

    
    public GetChampionInfo(String name) throws MalformedURLException, ProtocolException, IOException {
        String stringURL = "http://ddragon.leagueoflegends.com/cdn/10.18.1/data/en_US/champion";
        URL url;
        
        if (checkName(name).isEmpty())
            url = new URL(stringURL + ".json");
        else
            url = new URL(stringURL + "/" + checkName(name));
        
	httpCon = (HttpURLConnection) url.openConnection();
	httpCon.setRequestMethod("GET");
    }
    
     public String sendGet() throws Exception {
         BufferedReader responseReader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
         try {            
            String response = responseReader.lines().collect(Collectors.joining());

            System.out.println(response);
            
            return response;    
         }
        
         finally {
             if (responseReader != null) {
                 responseReader.close();
             }
             if (httpCon != null) {
                 httpCon.disconnect();
             }
         }       
     }
     
    private String checkName(String name) {
        if (name.isEmpty() || name.equals("Enter champion name"))
            return "";
        else
            return name.trim().toLowerCase().substring(0, 1).toUpperCase() + name.substring(1) + ".json";
    }
}
