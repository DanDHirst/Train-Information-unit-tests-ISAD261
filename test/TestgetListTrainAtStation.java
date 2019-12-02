/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import traininfomation.TrainInfomation;

/**
 *
 * @author dhirst1
 */
public class TestgetListTrainAtStation {
    
    public TestgetListTrainAtStation() {
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
    public void getListTrainAtStation() throws ParseException{
        TrainInfomation system = new TrainInfomation();
        String result = system.getListTrainAtStation("Plymouth");
        if(result != null){
            assertTrue(true);
        }
        else{
            assertTrue("No data is returned", false);
        }
    }
}
