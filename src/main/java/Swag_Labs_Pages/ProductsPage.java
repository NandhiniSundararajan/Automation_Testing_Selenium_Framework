package Swag_Labs_Pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.ReporterUtil;
import util.ScreenShotUtil;

import java.util.List;

import static Common.DriverManager.*;

public class ProductsPage extends BasePage{

    String productPageTitle;
    String URL = "https://www.saucedemo.com/cart.html";

    //Locators
    private String addToCartXpath = "//div[@class='inventory_item_name' and contains(.,'$$')]/ancestor::div[@class='inventory_item_label']/following-sibling::div//button";
    private By shoppingCartBadgeLocator = By.xpath("//span[@class='shopping_cart_badge']");
    private By shoppingCartIconLocator = By.xpath("//a[@class='shopping_cart_link']");

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
        ReporterUtil.getTest().info("No. of items in the cart is checked");
        String screenshot = ScreenShotUtil.takeScreenShot();
        ReporterUtil.getTest().info(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
        if(noOfItemsInCart.size()>0){
            return Integer.parseInt(getText(shoppingCartBadgeLocator));
        }
        else{
            return 0;
        }
    }

    public void addToCart(String item){
        ReporterUtil.getTest().info("Items are added to the cart");
        getDriver().findElement(By.xpath(addToCartXpath.replace("$$",item))).click();
        String screenshot = ScreenShotUtil.takeScreenShot();
        ReporterUtil.getTest().info(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
    }

    public CheckoutPage openShoppingCart(){
        ReporterUtil.getTest().info("Shopping cart icon is clicked");
        click(shoppingCartIconLocator);
        getDriver().get(URL);
        return new CheckoutPage();
    }
}
