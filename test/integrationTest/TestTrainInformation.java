/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrationTest;

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
public class TestTrainInformation {
    private WebConnection Con;
    private TrainInfomation trainStation;
    public TestTrainInformation() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        try {
            this.Con = new WebConnection();
            Con.getJson();
            trainStation = new TrainInfomation();
        } catch (ParseException ex) {
            Logger.getLogger(TestTrainInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void TestIfJsonDataLoaded(){
        if (trainStation.getJsons() != null) {
            assertTrue("The program returned data", true);
        }
        else{
            assertTrue("The program didnt return any json data", false);
        }
    }
    @Test
    public void TestIfStationMethodOutputsInfomation() {
        ArrayList<TrainInfo> trainAtStation = null;
        trainAtStation = trainStation.getListTrainAtStation("Plymouth");
        if(trainAtStation.size() != 0){
            assertTrue(true);
        }
        else{
            assertTrue("No data is returned", false);
        }
    }
    @Test
    public void TestIfPlatormMethodOutputsInfomation(){
            ArrayList<TrainInfo> trainAtPlatform = null;
            trainAtPlatform = trainStation.getListTrainAtPlatform("3");
            if(trainAtPlatform.size() != 0){
                assertTrue(true);
            }
            else{
                assertTrue("No data is returned", false);
            }
       
    }
    @Test
    public void TestIfCallByMethodOutputsInfomation(){
       
            ArrayList<TrainInfo> trainAtcall = null;
            trainAtcall = trainStation.getListOfTrainswillCallAtStation("Totnes","Plymouth");
            if(trainAtcall.size() != 0){
                assertTrue(true);
            }
            else{
                assertTrue("No data is returned", false);
            }
       
    }
    @Test
     public void TestIfOverdueMethodOutputsInfomation(){
            ArrayList<TrainInfo> trainOverdue = null;
            trainOverdue = trainStation.getOverdueTrains("Plymouth", 1100);
            if(trainOverdue.size() != 0){
                assertTrue(true);
            }
            else{
                assertTrue("No data is returned", false);
            }

     }
     
     
     @Test
    public void TestIfNoTrainsAtStation(){
        ArrayList<TrainInfo> trainAtStation = null;
        trainAtStation = trainStation.getListTrainAtStation("A Station that doesnt exist");
        if (trainAtStation.size() == 0) {
             assertTrue("This station should return nothing", true);
        }
        else{
            assertTrue("this station shouldnt have returned anything", false);
        }
    }
    @Test
    public void TestIfNoTrainsAtPlatform() {
        ArrayList<TrainInfo> trainAtPlatform = null;
        trainAtPlatform = this.trainStation.getListTrainAtPlatform("10010");
        if (trainAtPlatform.size() == 0) {
            assertTrue("There is no trains for this platform", true);
        }
        else {
            assertTrue("The program returned infomation when it shouldn't have", false);
        }
    }
    
    @Test
    public void TestIfNoTrainsAtCallByStation() {
        ArrayList<TrainInfo> trainAtcall = null;
        trainAtcall = this.trainStation.getListOfTrainswillCallAtStation("Saltash", "NoWhere567");
        if (trainAtcall.size() == 0) {
            assertTrue("There is no trains for this platform", true);
        }
        else {
            assertTrue("The program returned infomation when it shouldn't have", false);
        }
    }
    @Test
    public void TestProgramInvalidStationTime(){
        ArrayList<TrainInfo> trainOverdue = null;
        trainOverdue = this.trainStation.getOverdueTrains("Plymouth", 1000);
        assertTrue("check if the method returns null if there is no overdue trains", trainOverdue.size() == 0);
    }
}
