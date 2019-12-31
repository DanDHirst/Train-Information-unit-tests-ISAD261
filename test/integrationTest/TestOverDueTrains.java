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
public class TestOverDueTrains {
    private WebConnection Con;
    private ArrayList<TrainInfo> trainOverdue;
    private TrainInfomation trainStation;
    public TestOverDueTrains() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void TestIfMethodOutputsInfomation(){
            trainOverdue = trainStation.getOverdueTrains("Plymouth", 1100);
            if(trainOverdue.size() != 0){
                assertTrue(true);
            }
            else{
                assertTrue("No data is returned", false);
            }

     }
     
    @Test
    public void TestProgramOutputsValidString(){
        trainOverdue = this.trainStation.getOverdueTrains("Saltash", 1050);
        assertEquals("Check message is valid", "The train arriving at Saltash for 1041 is Overdue. We are sorry for any inconvenience this may have caused you!", trainOverdue.get(0));
        
    } 
    @Test
    public void TestProgramInvalidStationTime(){
        trainOverdue = this.trainStation.getOverdueTrains("Plymouths", 2000);
        assertTrue("check if the method returns null if there is no overdue trains", trainOverdue.size() == 0);
    }
    @Test
    public void TestCheckIfNumberOfOverdueTrainsIsCorrect(){
        trainOverdue = this.trainStation.getOverdueTrains("Liskeard", 1500);
        assertTrue("check if the method returns all the overdue trains", trainOverdue.size() == 2);
    }
    @Test
    public void TestCheckDoesntCrashWhenDispatchIsNull(){
        trainOverdue = this.trainStation.getOverdueTrains("Penzance", 1500);
        assertTrue("check if the method returns all the overdue train that have null at the end", trainOverdue.size() >= 1);
    }
    @Test
    public void TestCheckTheEdgeCasesOfTheTime(){
        trainOverdue = this.trainStation.getOverdueTrains("St Germans", 1047);
        assertEquals("time is 1047 so should not be late",trainOverdue.size(), 0);
        trainOverdue = this.trainStation.getOverdueTrains("St Germans", 1048);
        assertEquals("time is 1048 so should not be late",trainOverdue.size(), 0);
        trainOverdue = this.trainStation.getOverdueTrains("St Germans", 1049);
        assertEquals("time is 1049 so should be late",trainOverdue.size(),1);
        
    }
}
