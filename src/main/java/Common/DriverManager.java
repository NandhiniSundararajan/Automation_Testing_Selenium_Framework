package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.PropertiesUtil;

public class DriverManager {

    private static ThreadLocal<WebDriver> tl = new ThreadLocal();
    private static WebDriver driver;


    public static void initiateDriver(){
        String browser = PropertiesUtil.getBrowserName();
        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        }

        tl.set(driver);
    }

    public static WebDriver getDriver(){
        return tl.get();
    }

    public static void quitBrowser(){
        tl.get().quit();
    }

}
