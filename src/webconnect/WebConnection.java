/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webconnect;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author dhirst1
 */
public class WebConnection {
    public WebConnection(){
        
    }
    private static String streamToString(InputStream inputStream) {
    String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
    return text;
  }

  public static String jsonGetRequest(String urlQueryString) {
    String json = null;
    try {
      URL url = new URL(urlQueryString);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setDoOutput(true);
      connection.setInstanceFollowRedirects(false);
      connection.setRequestMethod("GET");
      connection.setRequestProperty("Content-Type", "application/json");
      connection.setRequestProperty("charset", "utf-8");
      connection.connect();
      InputStream inStream = connection.getInputStream();
      json = streamToString(inStream); // input stream to string
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return json;
  }
  public String getJson(){
      return jsonGetRequest("http://web.socem.plymouth.ac.uk/david/trains.json");
  }
  
}
