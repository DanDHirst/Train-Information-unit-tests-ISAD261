/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrationTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import traininfomation.TrainInfo;
import traininfomation.TrainInfomation;
import webconnect.WebConnection;

/**
 *
 * @author dan
 */
public class TestGetListOfTrainswillCallAtStation {
    private WebConnection Con;
    private ArrayList<TrainInfo> trainAtcall;
    private TrainInfomation trainStation;
    public TestGetListOfTrainswillCallAtStation() {
        try {
            this.Con = new WebConnection();
            Con.getJson();
            trainStation = new TrainInfomation();
        } catch (ParseException ex) {
            Logger.getLogger(TestGetListOfTrainswillCallAtStation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void TestIfMethodOutputsInfomation(){
       
            
            trainAtcall = trainStation.getListOfTrainswillCallAtStation("Totnes","Plymouth");
            if(trainAtcall.size() != 0){
                assertTrue(true);
            }
            else{
                assertTrue("No data is returned", false);
            }
       
    }
    @Test
    public void TestIfNoTrainsAtStations() {
        
        this.trainAtcall = this.trainStation.getListOfTrainswillCallAtStation("Saltash", "NoWhere567");
        if (trainAtcall.size() == 0) {
            assertTrue("There is no trains for this platform", true);
        }
        else {
            assertTrue("The program returned infomation when it shouldn't have", false);
        }
    }
    @Test
    public void TestIfArrivalTimeGreaterThanLastTrainsDepartTime() {
        
        this.trainAtcall = this.trainStation.getListOfTrainswillCallAtStation("Totnes", "Plymouth");
        for (int i = 1; i < trainAtcall.size()-1; i+=2) {
            if (Integer.parseInt(trainAtcall.get(i-1).getDeparts()) > Integer.parseInt(trainAtcall.get(i).getArrives())) {
                assertTrue("The depart time of the last train is greater than the arrival time of current train", false);
            }
        }
        assertTrue(true);
        
    }
    
   
}
