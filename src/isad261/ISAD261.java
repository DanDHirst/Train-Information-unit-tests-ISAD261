/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isad261;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import webconnect.WebConnection;



/**
 *
 * @author dhirst1
 */
public class ISAD261 {
    // resources used http://www.java2s.com/Tutorials/Java/Network_How_to/URL/Get_JSON_from_URL.htm
    //https://code.google.com/archive/p/json-simple/downloads
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws MalformedURLException, IOException, ParseException {
    WebConnection con = new WebConnection();
//        String json = "[" + con.getJson() + "]";

        JSONParser parser = new JSONParser();
        JSONArray jsons = (JSONArray) parser.parse(con.getJson());
        for (int i = 0; i < jsons.size(); i++) {
            JSONObject obj = (JSONObject) jsons.get(i);
//            System.out.println("obj: " + obj);
            //JSONObject obj = new JSONObject(jsons.get(i));
//            System.out.println(obj.get("stops"));
            JSONArray objs = (JSONArray) obj.get("stops");
//            System.out.println(objs.get(i));
            int length = objs.size();
            for (int j = 0; j < length; j++) {
                JSONObject tempObj = (JSONObject) objs.get(j);
                System.out.println(tempObj.get("arrives"));
            }
            System.out.println("new train");
            
            
            
        }
//        System.out.println(jsons);
        
    
    
//    String result = system.getListTrainAtStation("Plymouth");
//        System.out.println(system.getItem(1));
    }

  
    
}
