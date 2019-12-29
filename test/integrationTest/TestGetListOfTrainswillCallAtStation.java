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

/**
 *
 * @author dan
 */
public class TestGetListOfTrainswillCallAtStation {
    
    public TestGetListOfTrainswillCallAtStation() {
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
    public void getListTrainCallAtStation(){
        try {
            TrainInfomation trainStation = new TrainInfomation();
            ArrayList<TrainInfo> trainAtcall = trainStation.getListOfTrainswillCallAtStation("Totnes","Plymouth");
            if(trainAtcall.size() != 0){
                assertTrue(true);
            }
            else{
                assertTrue("No data is returned", false);
            }
        } catch (ParseException ex) {
            Logger.getLogger(TestGetListTrainAtPlatform.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
