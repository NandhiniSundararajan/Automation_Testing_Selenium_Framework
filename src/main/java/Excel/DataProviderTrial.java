package Excel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class DataProviderTrial {

    @Test(dataProvider = "ExcelData", dataProviderClass = ExcelTrial1.class)
    public void dpTest(String[] a) {
      // LocalDateTime dt = LocalDateTime.now();
      // System.out.println(dt);
        System.out.print(a[0] + " :: ");
        System.out.print(a[1] + " :: ");
        System.out.println(a[2]);
    }

    //done for practice with hardcoded data
    @DataProvider(name="dp")
    public Object[][] supplydata(){
        Integer[][] data = new Integer[2][2];
        data[0][0] = 100;
        data[0][1] = 200;

        data[1][0] = 300;
        data[1][1] = 400;
        return data;
    }
}
