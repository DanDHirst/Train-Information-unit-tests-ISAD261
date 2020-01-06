/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import traininfomation.TrainInfo;
import traininfomation.TrainInfomation;
import webconnect.MockWebConnection;

/**
 *
 * @author dan
 */
public class TestGetListOfTrainswillAtStation {
    private MockWebConnection mockCon;
    private ArrayList<TrainInfo> trainAtStationmock;
    private TrainInfomation mocktrainStation;
    public TestGetListOfTrainswillAtStation() {
        try {
            this.mockCon = new MockWebConnection();
            mockCon.getJson();
            mocktrainStation = new TrainInfomation("mock");
        } catch (IOException ex) {
            Logger.getLogger(TestGetListOfTrainswillAtStation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(TestGetListOfTrainswillAtStation.class.getName()).log(Level.SEVERE, null, ex);
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
        trainAtStationmock = null;
    }
    
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void testIfNoTrainsAtStation() {
        
        trainAtStationmock = this.mocktrainStation.getListTrainAtStation("Station24621");
        if (trainAtStationmock.size() == 0) {
            assertTrue("There is no trains for this station", true);
        }
        else {
            assertTrue("The program returned infomation when it shouldn't have", false);
        }
    }
    @Test 
    public void testInputString() {
        trainAtStationmock = this.mocktrainStation.getListTrainAtStation("3");
        if (trainAtStationmock.size() == 0) {
            assertTrue("There is no trains for this String input", true);
        }
        else {
            assertTrue("The program returned infomation when it shouldn't have", false);
        }
        
    }
    @Test 
    public void testOutputDataisCorrect() {
        
        trainAtStationmock = mocktrainStation.getListTrainAtStation("Plymouth");
        if (trainAtStationmock.size() > 0) {
            for (TrainInfo tr : trainAtStationmock) {
                if (tr.getName().equals("Plymouth")) {
                    if ("1029".equals(tr.getArrives())) {
                        if ("1033".equals(tr.getDeparts())) {
                            assertTrue("Station is correct", true);
                        }
                        else{
                            assertTrue("The program the wrong depart time it should have returned 1033 instead of: " +tr.getDeparts(), false);
                        }
                    }
                    else{
                    assertTrue("The program the wrong arrival time it should have returned 1029 instead of: " +tr.getArrives(), false);
                }
                }
                else{
                    assertTrue("The program the wrong name it should have returned plymouth instead of: " +tr.getName(), false);
                }
            }
            assertTrue("There is no trains for this String input", true);
        }
        else {
            assertTrue("The program returned infomation when it should have", false);
        }
        
    }
    @Test 
    public void testNumberOfTrains(){
        
        trainAtStationmock = mocktrainStation.getListTrainAtStation("Totnes");
        if (trainAtStationmock.size() == 1) {
            assertTrue("This the correct amount of trains", true);
        }
        else{
            assertTrue("Program returned " + trainAtStationmock.size() + " and should have returned 1", false );
        }
    }
    @Test 
    public void testCheckArrivalAndDepartTimes(){
        
        trainAtStationmock = mocktrainStation.getListTrainAtStation("Saltash");
        for(TrainInfo tr : trainAtStationmock){
            if (tr.getArrives().equals("1041")) {
                if (tr.getDeparts().equals("1042")) {
                    assertTrue("Program returned the correct arrival and depart time", true);
                }
                else{
                    assertTrue("The program returned The wrong depart time", false);
                }
            }
            else{
                assertTrue("The program returned The wrong arrival time", false);
            }
            
        }
    }
    
        
    
}
