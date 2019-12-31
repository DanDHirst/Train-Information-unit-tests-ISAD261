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
    public void TestCheckCorrectValues(){
        trainAtcall = trainStation.getListOfTrainswillCallAtStation("Plymouth", "Liskeard");
        assertEquals("check name is Plymouth", trainAtcall.get(0).getName(), "Plymouth");
        assertEquals("check arrival time is 1029", trainAtcall.get(0).getArrives(), "1029");
        assertEquals("check depart time is 1033", trainAtcall.get(0).getDeparts(), "1033");
        
        assertEquals("check name is Liskeard", trainAtcall.get(1).getName(), "Liskeard");
        assertEquals("check arrival time is 1100", trainAtcall.get(1).getArrives(), "1100");
        assertEquals("check depart time is 1101", trainAtcall.get(1).getDeparts(), "1101");

    }
    @Test 
    public void TestCheckOrderOfTimes(){
        trainAtcall = trainStation.getListOfTrainswillCallAtStation("Teignmouth", "Dawlish");
        assertEquals("check arrival time is 1028", trainAtcall.get(0).getArrives(), "1028");
        assertEquals("check depart time is 1029", trainAtcall.get(0).getDeparts(), "1029");
        
        assertEquals("check arrival time is 1033", trainAtcall.get(1).getArrives(), "1033");
        assertEquals("check depart time is 1034", trainAtcall.get(1).getDeparts(), "1034");
    }
    
    @Test 
    public void TestCheckTheSourceAndDestinationSize(){
        trainAtcall = trainStation.getListOfTrainswillCallAtStation("Saltash", "Par");
        if (trainAtcall.size() % 2 ==0) {
            assertTrue("There is an even amount of objects", true);
        }
        else{
            assertTrue("There is an odd number of objects", false);
        }
    }
    @Test 
    public void TestCheckIfOutputShouldBeNull(){
        trainAtcall = trainStation.getListOfTrainswillCallAtStation("2323523", "45345");
        if (trainAtcall.size() ==0) {
            assertTrue("The program returned null", true);
        }
        else{
            assertTrue("The program returned items when it shouldnt have", false);
        }
    }
    @Test 
    public void TestCheckIfMissedOutAnyTrains(){
        trainAtcall = trainStation.getListOfTrainswillCallAtStation("Birmingham New Street", "Stockport");
        assertEquals("There should only be two objects for this call", trainAtcall.size(),2);
    }
    
}
