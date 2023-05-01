package Swag_Labs_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.PropertiesUtil;

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
    }

    public void waitUntilLoginLogoIsVisible(){
        explicitWait().until(ExpectedConditions.presenceOfElementLocated(loginLogoLocator));
    }

    public ProductsPage loginUsingValidCredentials(String uname, String password){
        sendKeys(usernameLocator,uname);
        sendKeys(passwordLocator,password);
        click(loginButtonLocator);
        return new ProductsPage();
    }

    public void loginUsingInvalidCredentials(String uname, String password){
        sendKeys(usernameLocator,uname);
        sendKeys(passwordLocator,password);
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
