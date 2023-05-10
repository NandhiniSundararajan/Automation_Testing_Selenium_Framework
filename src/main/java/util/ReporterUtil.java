package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;

public class ReporterUtil {

    private static ExtentReports extent = new ExtentReports();

    private static ThreadLocal<ExtentTest> tl = new ThreadLocal<>();
    private static ExtentTest test;

    public static void createReport(String name) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String time = localDateTime.getHour() + "_" + localDateTime.getMinute() + "_" + localDateTime.getSecond();


        ExtentSparkReporter spark = new ExtentSparkReporter("ExtReports/spark_" + time + ".html");
        spark.config().setDocumentTitle(name);
        spark.config().setTheme(Theme.DARK);
        extent.attachReporter(spark);
    }

    public static void flushReport() {
        extent.flush();
    }

    public static void createTest(String testCaseName) {
        test = extent.createTest(testCaseName);
        tl.set(test);
    }

    public static ExtentTest getTest() {
        return tl.get();
    }

}
