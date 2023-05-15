package Swag_Labs_Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static Common.DriverManager.*;

public class BaseTests {

    @BeforeMethod
    public void setup(){
    initiateDriver();
    }

     @AfterMethod
     public void teardown(){
        quitBrowser();
        //getDriver().quit();
     }
}
