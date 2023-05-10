package Swag_Labs_Pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import util.ReporterUtil;
import util.ScreenShotUtil;

public class UserInformationPage extends BasePage{

    String URL = "https://www.saucedemo.com/checkout-step-two.html";

    //Locators
    By firstNameLocator = By.id("first-name");
    By lastNameLocator = By.id("last-name");
    By postalCodeLocator = By.id("postal-code");
    By errorNotificationLocator = By.xpath("//h3[@data-test='error']");
    By continueButtonLocator = By.id("continue");

    //Methods
    public void getUserInformation(String firstName, String lastName, String postalCode){
        ReporterUtil.getTest().info("User information is entered: Firstname: "+ firstName +", Lastname: " + lastName +", PostalCode: " + postalCode);
        sendKeys(firstNameLocator,firstName);
        sendKeys(lastNameLocator,lastName);
        sendKeys(postalCodeLocator,postalCode);
        String screenshot = ScreenShotUtil.takeScreenShot();
        ReporterUtil.getTest().info(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
    }
    public OverviewPage navigateToOverviewPage(){
        click(continueButtonLocator);
        return new OverviewPage();
    }
}
