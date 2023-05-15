package Swag_Labs_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PropertiesUtil;

import java.time.Duration;

import static Common.DriverManager.*;

public class BasePage {

    public void click(By by) {
        waitUntilElementIsVisible(by).click();
    }

    public String getText(By by) {
        //System.out.println(getDriver().findElement(by).getText());
        return getDriver().findElement(by).getText();
    }

    public void sendKeys(By by, String value) {
        getDriver().findElement(by).sendKeys(value);
    }

    public WebDriverWait explicitWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(PropertiesUtil.getExplicitTimeoutInSeconds()));
    }

    public WebElement waitUntilElementIsVisible(By by) {
        return explicitWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(by)));
    }
}
