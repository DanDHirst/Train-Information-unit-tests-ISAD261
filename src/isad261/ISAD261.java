/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isad261;

import webconnect.WebConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.String.format;
import static java.lang.System.in;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import org.json.simple.parser.ParseException;
import traininfomation.TrainInfomation;

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
    
    public static void main(String[] args) throws ParseException {
    WebConnection con = new WebConnection();
    System.out.println(con.getJson());
    TrainInfomation system = new TrainInfomation();
    String result = system.getListTrainAtStation("Plymouth");
        System.out.println(system.getItem(1));
  }

  
    
}
