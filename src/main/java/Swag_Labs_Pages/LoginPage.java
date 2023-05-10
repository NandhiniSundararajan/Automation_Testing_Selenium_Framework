package Swag_Labs_Pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.PropertiesUtil;
import util.ReporterUtil;
import util.ScreenShotUtil;

import java.util.List;
import static Common.DriverManager.*;

public class LoginPage extends BasePage {

    String  productPageTitle;
    String URL = PropertiesUtil.getURL();
    ProductsPage productsPageObj;

    //Locators
    By loginLogoLocator = By.className("login_logo");
    By usernameLocator = By.id("user-name");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.id("login-button");
    By errorNotificationLocator = By.xpath("//h3");

    //Methods
    public void navigateToHomePage(){
        getDriver().get(URL);
        getDriver().manage().window().maximize();
        ReporterUtil.getTest().info("Logged into the app" + URL);
        String screenshot = ScreenShotUtil.takeScreenShot();
        ReporterUtil.getTest().info(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
    }

    public void waitUntilLoginLogoIsVisible(){
        explicitWait().until(ExpectedConditions.presenceOfElementLocated(loginLogoLocator));
    }

    public ProductsPage loginUsingValidCredentials(String uname, String password){
        sendKeys(usernameLocator,uname);
        sendKeys(passwordLocator,password);
        click(loginButtonLocator);
        ReporterUtil.getTest().info("Clicked on login button");
        return new ProductsPage();
    }

    public void loginUsingInvalidCredentials(String uname, String password){
        sendKeys(usernameLocator,uname);
        sendKeys(passwordLocator,password);
        String screenshot = ScreenShotUtil.takeScreenShot();
        ReporterUtil.getTest().info(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
        click(loginButtonLocator);
    }
    //to get the error notification
    public String getErrorNotification() {
        List<WebElement> notification = getDriver().findElements(errorNotificationLocator);
        if (notification.size() > 0) {
            return getText(errorNotificationLocator);
        }
        else{
            return null;
        }
    }
}
