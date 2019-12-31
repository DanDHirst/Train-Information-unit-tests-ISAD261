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
public class TestGetListTrainAtPlatform {
    private WebConnection Con;
    private ArrayList<TrainInfo> trainAtPlatform;
    private TrainInfomation trainStation;
    public TestGetListTrainAtPlatform() {
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
    @Test
    public void TestIfMethodOutputsInfomation(){
    
            trainAtPlatform = trainStation.getListTrainAtPlatform("3");
            if(trainAtPlatform.size() != 0){
                assertTrue(true);
            }
            else{
                assertTrue("No data is returned", false);
            }
       
    }
    @Test
    public void TestIfNoTrainsAtPlatform(){
        
    }
}
