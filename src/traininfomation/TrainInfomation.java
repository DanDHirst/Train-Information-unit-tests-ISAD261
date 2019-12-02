/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traininfomation;

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
    private JSONObject jsonObj = new JSONObject();
    public TrainInfomation() throws ParseException{
        WebConnection con = new WebConnection();
//        JSONParser parser = new JSONParser();
//        JSONObject json = (JSONObject) parser.parse(con.getJson());
        JSONArray array = new JSONArray();
        array.add(con.getJson());
        JSONObject obj = new JSONObject();
        obj.put("Trains", array);
        this.jsonObj = obj;
    }
    public String getListTrainAtStation(String Station){
        return null;        
    }
    public String getListTrainAtPlatform(String Platform){
        return null;
    }
    public String getListOfTrainswillCallAtStation(String Source, String Destination){
        return null;
    }
    public String getOverdueTrains(String Station){
        return null;
    }
    public String getItem(int index){
        return (String) jsonObj.get(index);
    }
}
