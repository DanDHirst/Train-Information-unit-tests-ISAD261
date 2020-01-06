/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traininfomation;

import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import webconnect.MockWebConnection;
import webconnect.WebConnection;

/**
 *
 * @author dhirst1
 */
public class TrainInfomation { 
    private JSONArray jsons = new JSONArray();
    public TrainInfomation() throws ParseException  {
        WebConnection con = new WebConnection();
        JSONParser parser = new JSONParser();
         this.jsons = (JSONArray) parser.parse(con.getJson());
        
    }
    public TrainInfomation(String Mock) throws ParseException, IOException  {
        MockWebConnection con = new MockWebConnection();
        JSONParser parser = new JSONParser();
         this.jsons = (JSONArray) parser.parse(con.getJson());
        
    }
    
    public ArrayList getListTrainAtStation(String Station){
        ArrayList<TrainInfo> trains = new ArrayList<>();
        //loop for all train
        for (int i = 0; i < jsons.size(); i++) {
            JSONObject obj = (JSONObject) jsons.get(i);
            JSONArray objs = (JSONArray) obj.get("stops");
            int length = objs.size();
            //loop thorugh all stations
            for (int j = 0; j < length; j++) {
                JSONObject tempObj = (JSONObject) objs.get(j);
                if (tempObj.get("name").equals(Station)) {
                    String name = (String) tempObj.get("name");
                    String arrives = (String) tempObj.get("arrives");
                    String departs = (String) tempObj.get("departs");
                    TrainInfo train = new TrainInfo(name,arrives,departs);
                    trains.add(train);
                }
                
            }
            
        }
        
        return trains;
    }
    public ArrayList getListTrainAtPlatform(String Platform){
        ArrayList<TrainInfo> trains = new ArrayList<>();
        
        for (int i = 0; i < jsons.size(); i++) {
            JSONObject obj = (JSONObject) jsons.get(i);
            String trainPlat = (String) obj.get("platform");
            if(trainPlat.equals(Platform))
            {
                JSONArray objs = (JSONArray) obj.get("stops");
                int length = objs.size();
            //loop thorugh all stations
                for (int j = 0; j < length; j++) {
                    JSONObject tempObj = (JSONObject) objs.get(j);
                    String name = (String) tempObj.get("name");
                    String arrives = (String) tempObj.get("arrives");
                    String departs = (String) tempObj.get("departs");
                    TrainInfo train = new TrainInfo(name,arrives,departs);
                    trains.add(train);
                }
                
            }
            
        }

        return trains;
    }
    public ArrayList getListOfTrainswillCallAtStation(String Source, String Destination){
        ArrayList<TrainInfo> trains = new ArrayList<>();
        //loop though all the trains
        for (int i = 0; i < jsons.size(); i++) {
            JSONObject obj = (JSONObject) jsons.get(i);
            JSONArray objs = (JSONArray) obj.get("stops");
                int length = objs.size();
            //loop thorugh all stations
                TrainInfo tempSource = null;
                TrainInfo tempDest = null;
                for (int j = 0; j < length; j++) {
                    JSONObject tempObj = (JSONObject) objs.get(j);
                    if (tempObj.get("name").equals(Source)) {
                        String name = (String) tempObj.get("name");
                        String arrives = (String) tempObj.get("arrives");
                        String departs = (String) tempObj.get("departs");
                        tempSource = new TrainInfo(name,arrives,departs);
                    }
                    if (tempObj.get("name").equals(Destination) && tempSource != null) {
                        String name = (String) tempObj.get("name");
                        String arrives = (String) tempObj.get("arrives");
                        String departs = (String) tempObj.get("departs");
                        tempDest = new TrainInfo(name,arrives,departs);
                    }
                    
                    
                    
                }
                if (tempSource != null && tempDest != null) {
                    trains.add(tempSource);
                    trains.add(tempDest);
                
            }
                
        }
        
        
        return trains;
    }
    public ArrayList getOverdueTrains(String Station, int time){
        ArrayList<String> trainMessage = new ArrayList<>();
        for (int i = 0; i < jsons.size(); i++) {
            
            JSONObject obj = (JSONObject) jsons.get(i);
            JSONArray objs = (JSONArray) obj.get("stops");
                int length = objs.size();
                for (int j = 0; j < length; j++) { 
                    JSONObject tempObj = (JSONObject) objs.get(j);
                    if (tempObj.get("name").equals(Station) && time > Integer.parseInt((String) tempObj.get("arrives"))){
                        String message = "The train arriving at " + tempObj.get("name") + " for "+ tempObj.get("arrives")
                                + " is Overdue. We are sorry for any inconvenience this may have caused you!";
                        trainMessage.add(message);
                    }
                    
                } 
        }
        
        return trainMessage;
    }

    public JSONArray getJsons() {
        return jsons;
    }
    
}


