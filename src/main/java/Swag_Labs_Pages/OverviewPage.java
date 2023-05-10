package Swag_Labs_Pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.ReporterUtil;
import util.ScreenShotUtil;

import static Common.DriverManager.*;

import java.util.List;

public class OverviewPage extends BasePage {

    Double sum = 0.0;
    Double taxAmount, totalAmount, totalAmountFromApp;
    //Locators
    By itemPriceLocator = By.xpath("//div[@class='inventory_item_price']");
    By subtotalPriceLocator = By.xpath("//div[@class='summary_subtotal_label']");
    By taxAmountFromAppLocator = By.xpath("//div[@class='summary_tax_label']");
    By totalAmountLocator = By.xpath("//div[@class='summary_info_label summary_total_label']");
    By finishButtonLocator = By.xpath("//button[@id='finish']");

    //Methods
    public FinalPage navigateToFinalPage() {
        click(finishButtonLocator);
        return new FinalPage();
    }

    public Double sumOfItemPrices() {

        explicitWait().until(ExpectedConditions.presenceOfElementLocated(itemPriceLocator));
        List<WebElement> prices = getDriver().findElements(itemPriceLocator);

        for (WebElement price : prices) {
            price.getText().split("[$]")[1].trim();
            sum = sum + Double.valueOf(price.getText().split("[$]")[1]);
        }
        return sum;
    }

    public Double getTaxAmountFromApp() {
        String taxFromApp = getDriver().findElement(taxAmountFromAppLocator).getText();
        Double taxAmountFromApp = Double.valueOf(taxFromApp.split("[$]")[1]);
        return taxAmountFromApp;
    }

    public Double calculateTaxAmount(Double amount) {
        taxAmount = (amount * 0.08);
        String tempAmount = String.format("%1.2f", taxAmount);
        taxAmount = Double.valueOf(tempAmount);
        ReporterUtil.getTest().info("The tax amount to be paid is calculated as: " + taxAmount);
        return taxAmount;
    }

    public Double calculateTotalAmountToBePaid() {
        totalAmount = sum + taxAmount;
        ReporterUtil.getTest().info("The total amount to be paid is calculated as: " + totalAmount);
        return totalAmount;
    }

    public Double totalAmountFromTheApp() {
        totalAmountFromApp = Double.valueOf(getDriver().findElement(totalAmountLocator).getText().split("[$]")[1]);
        String screenshot = ScreenShotUtil.takeScreenShot();
        ReporterUtil.getTest().info(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
        return totalAmountFromApp;
    }
}
