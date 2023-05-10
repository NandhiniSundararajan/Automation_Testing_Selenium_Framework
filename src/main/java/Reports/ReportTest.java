package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;

public class ReportTest {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        int hour = localDateTime.getHour();
        int second = localDateTime.getSecond();

        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("ExtReports/Spark_" + hour + "_" + second + ".html");
        spark.config().setDocumentTitle("Selenium Reports");
        spark.config().setTheme(Theme.STANDARD);
        extent.attachReporter(spark);

        ExtentTest test1 = extent.createTest("Test1");
        test1.info("done with line 1");
        test1.info("success!!");
        test1.assignAuthor("AAA");
        test1.assignDevice("Windows");
        test1.assignCategory("reg");

        ExtentTest test2 = extent.createTest("Test2");
        test2.info("done with line 1");
        test2.info("success!!");
        test2.assignAuthor("BBB");
        test2.assignDevice("Windows");
        test2.assignCategory("smoke");

        ExtentTest test3 = extent.createTest("Test3");
        test3.info("done with line 1");
        test3.info("success!!");
        test3.assignAuthor("CCC");
        test3.assignDevice("Linux");
        test3.assignCategory("reg");

        ExtentTest test4 = extent.createTest("Test4");
        test4.info("done with line 1");
        test4.info("success!!");
        test4.assignAuthor("DDD");
        test4.assignDevice("Linux");
        test4.assignCategory("smoke");

        extent.flush();

    }
}
