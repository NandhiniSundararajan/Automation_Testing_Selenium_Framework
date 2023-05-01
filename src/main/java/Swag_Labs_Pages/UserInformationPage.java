package Swag_Labs_Pages;

import org.openqa.selenium.By;

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
        sendKeys(firstNameLocator,firstName);
        sendKeys(lastNameLocator,lastName);
        sendKeys(postalCodeLocator,postalCode);
    }
    public OverviewPage navigateToOverviewPage(){
        click(continueButtonLocator);
        return new OverviewPage();
    }
}
