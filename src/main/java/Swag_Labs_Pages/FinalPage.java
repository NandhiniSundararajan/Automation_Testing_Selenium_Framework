package Swag_Labs_Pages;

import org.openqa.selenium.By;
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
        successMsg = getDriver().findElement(successMsgLocator).getText();
        return successMsg;
    }
}
