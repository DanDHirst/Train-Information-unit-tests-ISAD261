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
    public void TestIfNoTrainsAtPlatform() {
        
        this.trainAtPlatform = this.trainStation.getListTrainAtPlatform("10010");
        if (trainAtPlatform.size() == 0) {
            assertTrue("There is no trains for this platform", true);
        }
        else {
            assertTrue("The program returned infomation when it shouldn't have", false);
        }
    }
    @Test
    public void TestIfOutputCorrectTimes() {
        
        this.trainAtPlatform = this.trainStation.getListTrainAtPlatform("3");
        for (int i = 0; i < 5; i++) {
            TrainInfo tr = trainAtPlatform.get(i);
             if (i == 0) {
                 if (tr.getArrives().equals("1021") && tr.getDeparts().equals("1023") ) {
                     assertTrue("Correct Time", true);
                 }
                 else{
                     assertTrue("Incorrect times should have been arrival:1021 and" + " depart: 1023" +  " and were Arrrival:" + tr.getArrives()+ " depart:"+ tr.getDeparts(), false);
                 }
             
            }
             else if(i==1){
                 if (tr.getArrives().equals("1035") && tr.getDeparts().equals("1038") ) {
                     assertTrue("Correct Time", true);
                 }
                 else{
                     assertTrue("Incorrect times should have been arrival:1035 and" + " depart: 1038" +  " and were Arrrival:" + tr.getArrives()+ " depart:"+ tr.getDeparts(), false);
                 }
             }
             else if(i==2){
                 if (tr.getArrives().equals("1049") && tr.getDeparts().equals("1050") ) {
                     assertTrue("Correct Time", true);
                 }
                 else{
                     assertTrue("Incorrect times should have been arrival:1049 and" + " depart: 1050" +  " and were Arrrival:" + tr.getArrives()+ " depart:"+ tr.getDeparts(), false);
                 }
             }
             else if(i==3){
                 if (tr.getArrives().equals("1124") && tr.getDeparts().equals("1130") ) {
                     assertTrue("Correct Time", true);
                 }
                 else{
                     assertTrue("Incorrect times should have been arrival:1124 and" + " depart: 1130" +  " and were Arrrival:" + tr.getArrives()+ " depart:"+ tr.getDeparts(), false);
                 }
             }
             else if(i==4){
                 if (tr.getArrives().equals("1138") && tr.getDeparts().equals("1140") ) {
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
        this.trainAtPlatform = this.trainStation.getListTrainAtPlatform("2");
        assertEquals(trainAtPlatform.get(0).getName(), "Totnes");
        assertEquals(trainAtPlatform.get(1).getName(), "Ivybridge");
        assertEquals(trainAtPlatform.get(2).getName(), "Plymouth");
        assertEquals(trainAtPlatform.get(3).getName(), "Saltash");
        assertEquals(trainAtPlatform.get(4).getName(), "St Germans");
        assertEquals(trainAtPlatform.get(5).getName(), "Liskeard");
        assertEquals(trainAtPlatform.get(6).getName(), "Bodmin Parkway");
        assertEquals(trainAtPlatform.get(7).getName(), "Par");
        assertEquals(trainAtPlatform.get(8).getName(), "St Austell");
        assertEquals(trainAtPlatform.get(9).getName(), "Truro");
        assertEquals(trainAtPlatform.get(10).getName(), "Redruth");
        assertEquals(trainAtPlatform.get(11).getName(), "Camborne");
        assertEquals(trainAtPlatform.get(12).getName(), "Hayle");
        assertEquals(trainAtPlatform.get(13).getName(), "St Erth");
        assertEquals(trainAtPlatform.get(14).getName(), "Penzance");
        
    }
    
    @Test 
    public void TestPlatformReturnNumber(){
        this.trainAtPlatform = this.trainStation.getListTrainAtPlatform("2");
        assertEquals("The platform returns amount of trains", trainAtPlatform.size(), 37);
        
    } 
    
}
