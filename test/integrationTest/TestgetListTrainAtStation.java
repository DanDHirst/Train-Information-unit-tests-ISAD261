package integrationTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 * @author dhirst1
 */
public class TestgetListTrainAtStation {
    private WebConnection Con;
    private ArrayList<TrainInfo> trainAtStation;
    private TrainInfomation trainStation;
    public TestgetListTrainAtStation() {
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
    // @Test
    // public void hello() {}
    @Test
    public void TestIfMethodOutputsInfomation() throws ParseException{
        trainAtStation = trainStation.getListTrainAtStation("Castle Cary");
        if(trainAtStation.size() != 0){
            assertTrue(true);
        }
        else{
            assertTrue("No data is returned", false);
        }
    }
    @Test
    public void TestIfNoTrainsAtStation(){
        trainAtStation = trainStation.getListTrainAtStation("A Station that doesnt exist");
        if (trainAtStation.size() == 0) {
             assertTrue("This station should return nothing", true);
        }
        else{
            assertTrue("this station shouldnt have returned anything", false);
        }
    }
    @Test 
    public void TestInputString() {
        trainAtStation = this.trainStation.getListTrainAtStation("3");
        if (trainAtStation.size() == 0) {
            assertTrue("There is no trains for this String input", true);
        }
        else {
            assertTrue("The program returned infomation when it shouldn't have", false);
        }
        
    }
    @Test 
    public void TestOutputDataisCorrect() {
        
        trainAtStation = trainStation.getListTrainAtStation("Plymouth");
        if (trainAtStation.size() > 0) {
            for (TrainInfo tr : trainAtStation) {
                if (tr.getName().equals("Plymouth")) {
                    if ("1029".equals(tr.getArrives())) {
                        if ("1033".equals(tr.getDeparts())) {
                            assertTrue("Station is correct", true);
                            break;
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
    public void TestNumberOfTrains(){
        
        trainAtStation = trainStation.getListTrainAtStation("Totnes");
        if (trainAtStation.size() == 5) {
            assertTrue("This the correct amount of trains", true);
        }
        else{
            assertTrue("Program returned " + trainAtStation.size() + " and should have returned 1", false );
        }
    }
    @Test 
    
    public void TestCheckArrivalAndDepartTimes(){
        
        trainAtStation = trainStation.getListTrainAtStation("Saltash");
        for(TrainInfo tr : trainAtStation){
            if (tr.getArrives().equals("1041")) {
                if (tr.getDeparts().equals("1042")) {
                    assertTrue("Program returned the correct arrival and depart time", true);
                    break;
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
