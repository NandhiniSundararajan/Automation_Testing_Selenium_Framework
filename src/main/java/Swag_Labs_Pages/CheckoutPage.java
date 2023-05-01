package Swag_Labs_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Common.DriverManager.*;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends BasePage{

    //Locators
    By itemsInCartLocator = By.xpath("//div[@class='inventory_item_name']");
    By checkoutButtonLocator = By.id("checkout");

    //Methods
    public List<String> getItemsFromCart() {
        List <WebElement> itemsInCart = getDriver().findElements(itemsInCartLocator);
        List <String> items = new ArrayList<>();
        for(WebElement item : itemsInCart){
            items.add(item.getText());
        }
        return items;
    }
    public UserInformationPage checkout() {
        click(checkoutButtonLocator);
        return new UserInformationPage();
    }
}
