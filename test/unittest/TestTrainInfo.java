/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import traininfomation.TrainInfo;

/**
 *
 * @author dan
 */
public class TestTrainInfo {
    TrainInfo train;
    public TestTrainInfo() {
    }
    
    @BeforeClass
    public static void setUpClass() {
         
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.train = new TrainInfo("Saltash", "1000", "1001");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testStationName() {
         assertEquals("Test if station name is the same as the one inputted", train.getName(), "Saltash");
     }
     @Test
     public void testArrivalTime() {
         assertEquals("Test if Arrival time is the same as the one inputted", train.getArrives(), "1000");
     }
     @Test
     public void testDepartTime() {
         assertEquals("Test if Depart time is the same as the one inputted", train.getDeparts(), "1001");
     }
}
