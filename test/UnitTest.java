/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import unittest.TestGetListOfTrainswillAtStation;
import unittest.TestListOfTrainsAtPlatform;
import unittest.TestListofTrainsCallBy;
import unittest.TestOverDueTrains;
import unittest.TestTrainInfo;

/**
 *
 * @author dan
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestGetListOfTrainswillAtStation.class, TestListOfTrainsAtPlatform.class , TestListofTrainsCallBy.class , TestOverDueTrains.class,TestTrainInfo.class})
public class UnitTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
