package Swag_Labs_Pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import util.ReporterUtil;
import util.ScreenShotUtil;

import static Common.DriverManager.*;

public class FinalPage extends BasePage{

    String successMsg;
    //Locators
    By successMsgLocator = By.xpath("//h2[@class='complete-header']");
    By backHomeButtonLocator = By.xpath("//button[@id='back-to-products']");

    //Methods
    public void navigateBackToHomePage(){
        click(backHomeButtonLocator);
    }

    public String successMsgFromApp(){
        String screenshot = ScreenShotUtil.takeScreenShot();
        ReporterUtil.getTest().info(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
        successMsg = getDriver().findElement(successMsgLocator).getText();
        ReporterUtil.getTest().info("Success msg from the app: " + successMsg);
        return successMsg;
    }
}
