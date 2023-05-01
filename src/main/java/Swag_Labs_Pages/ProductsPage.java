package Swag_Labs_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static Common.DriverManager.*;

public class ProductsPage extends BasePage{

    String productPageTitle;
    String URL = "https://www.saucedemo.com/cart.html";

    //Locators
    String addToCartXpath = "//div[@class='inventory_item_name' and contains(.,'$$')]/ancestor::div[@class='inventory_item_label']/following-sibling::div//button";
    By shoppingCartBadgeLocator = By.xpath("//span[@class='shopping_cart_badge']");
    By shoppingCartIconLocator = By.xpath("//a[@class='shopping_cart_link']");

    //Methods
    public void navigateToProductsPage(){
        getDriver().get(URL);
    }

    public String getProductsPageTitle(){
        explicitWait().until(ExpectedConditions.presenceOfElementLocated(By.className("title")));
        return getDriver().findElement(By.className("title")).getText();
    }

    public int noOfItemsInCart() {
        List<WebElement> noOfItemsInCart = getDriver().findElements(shoppingCartBadgeLocator);
        if(noOfItemsInCart.size()>0){
            return Integer.parseInt(getText(shoppingCartBadgeLocator));
        }
        else{
            return 0;
        }
    }

    public void addToCart(String item){
        getDriver().findElement(By.xpath(addToCartXpath.replace("$$",item))).click();
    }

    public CheckoutPage openShoppingCart(){
        click(shoppingCartIconLocator);
        getDriver().get(URL);
        return new CheckoutPage();
    }
}
