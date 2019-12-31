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
public class TestOverDueTrains {
    
    private MockWebConnection mockCon;
    private ArrayList<TrainInfo> trainOverDueMock;
    private TrainInfomation mocktrainStation;
    public TestOverDueTrains() {
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
    public void TestProgramOutputsValidString(){
        trainOverDueMock = this.mocktrainStation.getOverdueTrains("Saltash", 1050);
        assertEquals("Check message is valid", "The train arriving at Saltash for 1041 is Overdue. We are sorry for any inconvenience this may have caused you!", trainOverDueMock.get(0));
        
    }
    @Test
    public void TestProgramInvalidStationTime(){
        trainOverDueMock = this.mocktrainStation.getOverdueTrains("Plymouths", 2000);
        assertTrue("check if the method returns null if there is no overdue trains", trainOverDueMock.size() == 0);
    }
    @Test
    public void TestCheckIfNumberOfOverdueTrainsIsCorrect(){
        trainOverDueMock = this.mocktrainStation.getOverdueTrains("Liskeard", 1500);
        assertTrue("check if the method returns all the overdue trains", trainOverDueMock.size() == 1);
    }
    @Test
    public void TestCheckDoesntCrashWhenDispatchIsNull(){
        trainOverDueMock = this.mocktrainStation.getOverdueTrains("Penzance", 1500);
        assertTrue("check if the method returns all the overdue train that have null at the end", trainOverDueMock.size() == 1);
    }
    
    @Test
    public void TestCheckTheEdgeCasesOfTheTime(){
        trainOverDueMock = this.mocktrainStation.getOverdueTrains("Plymouth", 1028);
        assertEquals("time is 1028 so should not be late",trainOverDueMock.size(), 0);
        trainOverDueMock = this.mocktrainStation.getOverdueTrains("Plymouth", 1029);
        assertEquals("time is 1029 so should not be late",trainOverDueMock.size(), 0);
        trainOverDueMock = this.mocktrainStation.getOverdueTrains("Plymouth", 1030);
        assertEquals("time is 1030 so should be late",trainOverDueMock.size(),1);
        
    }
    
}
