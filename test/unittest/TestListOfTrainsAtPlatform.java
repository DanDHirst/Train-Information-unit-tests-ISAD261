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
public class TestListOfTrainsAtPlatform {
    private MockWebConnection mockCon;
    private ArrayList<TrainInfo> trainAtPlatformmock;
    private TrainInfomation mocktrainStation;
    public TestListOfTrainsAtPlatform() {
        try {
            this.mockCon = new MockWebConnection();
            mockCon.getJson();
            mocktrainStation = new TrainInfomation("mock");
        } catch (IOException ex) {
            Logger.getLogger(TestGetListOfTrainswillCallAtStation.class.getName()).log(Level.SEVERE, null, ex);
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

    @Test
    public void TestIfNoTrainsAtPlatform() {
        
        this.trainAtPlatformmock = this.mocktrainStation.getListTrainAtPlatform("10010");
        if (trainAtPlatformmock.size() == 0) {
            assertTrue("There is no trains for this platform", true);
        }
        else {
            assertTrue("The program returned infomation when it shouldn't have", false);
        }
    }
    @Test
    public void TestIfOutputCorrectTimes() {
        
        this.trainAtPlatformmock = this.mocktrainStation.getListTrainAtPlatform("3");
        for (int i = 0; i < 5; i++) {
            TrainInfo tr = trainAtPlatformmock.get(i);
             if (i == 0) {
                 if (tr.getArrives().equals("1028") && tr.getDeparts().equals("1029") ) {
                     assertTrue("Correct Time", true);
                 }
                 else{
                     assertTrue("Incorrect times should have been arrival:1028 and" + " depart: 1029" +  " and were Arrrival:" + tr.getArrives()+ " depart:"+ tr.getDeparts(), false);
                 }
             
            }
             else if(i==1){
                 if (tr.getArrives().equals("1033") && tr.getDeparts().equals("1034") ) {
                     assertTrue("Correct Time", true);
                 }
                 else{
                     assertTrue("Incorrect times should have been arrival:1033 and" + " depart: 1034" +  " and were Arrrival:" + tr.getArrives()+ " depart:"+ tr.getDeparts(), false);
                 }
             }
             else if(i==2){
                 if (tr.getArrives().equals("1045") && tr.getDeparts().equals("1047") ) {
                     assertTrue("Correct Time", true);
                 }
                 else{
                     assertTrue("Incorrect times should have been arrival:1045 and" + " depart: 1047" +  " and were Arrrival:" + tr.getArrives()+ " depart:"+ tr.getDeparts(), false);
                 }
             }
             else if(i==3){
                 if (tr.getArrives().equals("1059") && tr.getDeparts().equals("1100") ) {
                     assertTrue("Correct Time", true);
                 }
                 else{
                     assertTrue("Incorrect times should have been arrival:1059 and" + " depart: 1100" +  " and were Arrrival:" + tr.getArrives()+ " depart:"+ tr.getDeparts(), false);
                 }
             }
             else if(i==4){
                 if (tr.getArrives().equals("1112") && tr.getDeparts().equals("1117") ) {
                     assertTrue("Correct Time", true);
                 }
                 else{
                     assertTrue("Incorrect times should have been arrival:1112 and" + " depart: 1117" +  " and were Arrrival:" + tr.getArrives()+ " depart:"+ tr.getDeparts(), false);
                 }
             }
             
             else{
                 break;
             }
        }
    }
    @Test 
    public void TestCorrectOutputforPlatform(){
        this.trainAtPlatformmock = this.mocktrainStation.getListTrainAtPlatform("2");
        assertEquals(trainAtPlatformmock.get(0).getName(), "Totnes");
        assertEquals(trainAtPlatformmock.get(1).getName(), "Ivybridge");
        assertEquals(trainAtPlatformmock.get(2).getName(), "Plymouth");
        assertEquals(trainAtPlatformmock.get(3).getName(), "Saltash");
        assertEquals(trainAtPlatformmock.get(4).getName(), "St Germans");
        assertEquals(trainAtPlatformmock.get(5).getName(), "Liskeard");
        assertEquals(trainAtPlatformmock.get(6).getName(), "Bodmin Parkway");
        assertEquals(trainAtPlatformmock.get(7).getName(), "Par");
        assertEquals(trainAtPlatformmock.get(8).getName(), "St Austell");
        assertEquals(trainAtPlatformmock.get(9).getName(), "Truro");
        assertEquals(trainAtPlatformmock.get(10).getName(), "Redruth");
        assertEquals(trainAtPlatformmock.get(11).getName(), "Camborne");
        assertEquals(trainAtPlatformmock.get(12).getName(), "Hayle");
        assertEquals(trainAtPlatformmock.get(13).getName(), "St Erth");
        assertEquals(trainAtPlatformmock.get(14).getName(), "Penzance");
        
    }
    @Test 
    public void TestPlatformReturnNumber(){
        this.trainAtPlatformmock = this.mocktrainStation.getListTrainAtPlatform("2");
        System.out.println(trainAtPlatformmock.size());
        assertEquals("The platform returns amount of trains", trainAtPlatformmock.size(), 15);
        
    } 
}
