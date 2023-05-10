package TestngTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AmazonTests {



    @Test(priority = 3, dependsOnMethods = "amazonTest3")
    public void amazonTest1(){
        Assert.assertTrue(true);
        Reporter.log("Checking log");
        System.out.println("t1 test");
    }

    @Test(invocationCount = 2, timeOut = 5000)
    public void amazonTest2() throws InterruptedException {
        //Thread.sleep(2000);
        Assert.assertTrue(true);
        System.out.println("t2 check");
    }

    @Test
    public void amazonTest3(){
        System.out.println("t3 check");
        Assert.assertTrue(false);
    }
}
