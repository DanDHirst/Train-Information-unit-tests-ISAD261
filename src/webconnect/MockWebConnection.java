/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webconnect;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author dan
 */
public class MockWebConnection {

    public MockWebConnection() {
    }
    private static String streamToString(InputStream inputStream) {
    String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
    return text;
  }
    
    public String getJson() throws FileNotFoundException, IOException, ParseException{


        JSONParser parser = new JSONParser();
        String jsonObjects = ("[{\"stops\":[{\"name\":\"Totnes\",\"arrives\":\"0959\",\"departs\":\"1000\"},{\"name\":\"Ivybridge\",\"arrives\":\"1016\",\"departs\":\"1016\"},{\"name\":\"Plymouth\",\"arrives\":\"1029\",\"departs\":\"1033\"},{\"name\":\"Saltash\",\"arrives\":\"1041\",\"departs\":\"1042\"},{\"name\":\"St Germans\",\"arrives\":\"1048\",\"departs\":\"1049\"},{\"name\":\"Liskeard\",\"arrives\":\"1100\",\"departs\":\"1101\"},{\"name\":\"Bodmin Parkway\",\"arrives\":\"1115\",\"departs\":\"1117\"},{\"name\":\"Par\",\"arrives\":\"1127\",\"departs\":\"1128\"},{\"name\":\"St Austell\",\"arrives\":\"1135\",\"departs\":\"1136\"},{\"name\":\"Truro\",\"arrives\":\"1152\",\"departs\":\"1153\"},{\"name\":\"Redruth\",\"arrives\":\"1206\",\"departs\":\"1207\"},{\"name\":\"Camborne\",\"arrives\":\"1212\",\"departs\":\"1213\"},{\"name\":\"Hayle\",\"arrives\":\"1220\",\"departs\":\"1220\"},{\"name\":\"St Erth\",\"arrives\":\"1224\",\"departs\":\"1225\"},{\"name\":\"Penzance\",\"arrives\":\"1234\",\"departs\":null}],\"platform\":\"2\",\"departs\":\"0947\"},{\"stops\":[{\"name\":\"Teignmouth\",\"arrives\":\"1028\",\"departs\":\"1029\"},{\"name\":\"Dawlish\",\"arrives\":\"1033\",\"departs\":\"1034\"},{\"name\":\"Exeter St Davids\",\"arrives\":\"1045\",\"departs\":\"1047\"},{\"name\":\"Tiverton Parkway\",\"arrives\":\"1059\",\"departs\":\"1100\"},{\"name\":\"Taunton\",\"arrives\":\"1112\",\"departs\":\"1117\"},{\"name\":\"Bristol Temple Meads\",\"arrives\":\"1151\",\"departs\":\"1200\"},{\"name\":\"Bristol Parkway\",\"arrives\":\"1208\",\"departs\":\"1209\"},{\"name\":\"Cheltenham Spa\",\"arrives\":\"1238\",\"departs\":\"1240\"},{\"name\":\"Birmingham New Street\",\"arrives\":\"1325\",\"departs\":\"1331\"},{\"name\":\"Wolverhampton\",\"arrives\":\"1347\",\"departs\":\"1348\"},{\"name\":\"Stafford\",\"arrives\":\"1401\",\"departs\":\"1402\"},{\"name\":\"Stoke-on-Trent\",\"arrives\":\"1417\",\"departs\":\"1420\"},{\"name\":\"Macclesfield\",\"arrives\":\"1436\",\"departs\":\"1437\"},{\"name\":\"Stockport\",\"arrives\":\"1449\",\"departs\":\"1450\"},{\"name\":\"Manchester Piccadilly\",\"arrives\":\"1500\",\"departs\":null}],\"platform\":\"3\",\"departs\":\"1022\"}]");
       
        
        String json = jsonObjects;
        return json;
        
  }
}
