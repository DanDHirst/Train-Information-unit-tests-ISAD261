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
public class TestGetListTrainAtPlatform {
    
    public TestGetListTrainAtPlatform() {
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
    @Test
    public void getListTrainAtPlatform(){
        try {
            TrainInfomation trainStation = new TrainInfomation();
            ArrayList<TrainInfo> trainAtPlatform = trainStation.getListTrainAtPlatform("3");
            if(trainAtPlatform.size() != 0){
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
