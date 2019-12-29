/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traininfomation;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
    public String getListOfTrainswillCallAtStation(String Source, String Destination){
        return null;
    }
    public String getOverdueTrains(String Station){
        return null;
    }
//    public String getItem(int index){
//        return (String) jsonObj.get(index);
//    }
}
