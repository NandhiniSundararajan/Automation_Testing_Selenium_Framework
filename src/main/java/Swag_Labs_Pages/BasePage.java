package Swag_Labs_Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PropertiesUtil;

import java.time.Duration;

import static Common.DriverManager.*;
public class BasePage {

    public void click(By by){
        getDriver().findElement(by).click();
    }

    public String getText(By by){
        //System.out.println(getDriver().findElement(by).getText());
        return getDriver().findElement(by).getText();
    }

    public void sendKeys(By by, String value){
        getDriver().findElement(by).sendKeys(value);
    }
    public WebDriverWait explicitWait(){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(PropertiesUtil.getExplicitTimeoutInSeconds()));
    }
}
