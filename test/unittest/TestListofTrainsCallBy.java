/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittest;

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
import webconnect.MockWebConnection;

/**
 *
 * @author dan
 */
public class TestListofTrainsCallBy {
    private MockWebConnection mockCon;
    private ArrayList<TrainInfo> trainAtCallBymmock;
    private TrainInfomation mocktrainStation;
    public TestListofTrainsCallBy() {
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
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test 
    public void testCheckCorrectValues(){
        trainAtCallBymmock = mocktrainStation.getListOfTrainswillCallAtStation("Plymouth", "Liskeard");
        assertEquals("check name is Plymouth", trainAtCallBymmock.get(0).getName(), "Plymouth");
        assertEquals("check arrival time is 1029", trainAtCallBymmock.get(0).getArrives(), "1029");
        assertEquals("check depart time is 1033", trainAtCallBymmock.get(0).getDeparts(), "1033");
        
        assertEquals("check name is Liskeard", trainAtCallBymmock.get(1).getName(), "Liskeard");
        assertEquals("check arrival time is 1100", trainAtCallBymmock.get(1).getArrives(), "1100");
        assertEquals("check depart time is 1101", trainAtCallBymmock.get(1).getDeparts(), "1101");

    }
    @Test 
    public void testCheckOrderOfTimes(){
        trainAtCallBymmock = mocktrainStation.getListOfTrainswillCallAtStation("Teignmouth", "Dawlish");
        assertEquals("check arrival time is 1028", trainAtCallBymmock.get(0).getArrives(), "1028");
        assertEquals("check depart time is 1029", trainAtCallBymmock.get(0).getDeparts(), "1029");
        
        assertEquals("check arrival time is 1033", trainAtCallBymmock.get(1).getArrives(), "1033");
        assertEquals("check depart time is 1034", trainAtCallBymmock.get(1).getDeparts(), "1034");
    }
    @Test 
    public void testCheckTheSourceAndDestinationSize(){
        trainAtCallBymmock = mocktrainStation.getListOfTrainswillCallAtStation("Saltash", "Par");
        if (trainAtCallBymmock.size() % 2 ==0) {
            assertTrue("There is an even amount of objects", true);
        }
        else{
            assertTrue("There is an odd number of objects", false);
        }
    }
    @Test 
    public void testCheckIfOutputShouldBeNull(){
        trainAtCallBymmock = mocktrainStation.getListOfTrainswillCallAtStation("2323523", "45345");
        if (trainAtCallBymmock.size() ==0) {
            assertTrue("The program returned null", true);
        }
        else{
            assertTrue("The program returned items when it shouldnt have", false);
        }
    }
    @Test 
    public void testCheckIfMissedOutAnyTrains(){
        trainAtCallBymmock = mocktrainStation.getListOfTrainswillCallAtStation("Birmingham New Street", "Stockport");
        assertEquals("There should only be two objects for this call", trainAtCallBymmock.size(),2);
    }
    @Test
    public void testIfArrivalTimeGreaterThanLastTrainsDepartTime() {
        
        this.trainAtCallBymmock = this.mocktrainStation.getListOfTrainswillCallAtStation("Totnes", "Plymouth");
        for (int i = 1; i < trainAtCallBymmock.size()-1; i+=2) {
            if (Integer.parseInt(trainAtCallBymmock.get(i-1).getDeparts()) > Integer.parseInt(trainAtCallBymmock.get(i).getArrives())) {
                assertTrue("The depart time of the last train is greater than the arrival time of current train", false);
            }
        }
        assertTrue(true);
        
    }
    
    
    
    
}
