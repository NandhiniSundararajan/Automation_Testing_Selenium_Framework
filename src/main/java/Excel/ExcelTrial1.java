package Excel;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExcelTrial1 {

   @DataProvider(name = "ExcelData")
    public Object[][] trial1() throws IOException {
        String location = "./src/main/resources/TestData.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook(location);
        XSSFSheet sheet = workbook.getSheet("info");

        System.out.println(sheet.getLastRowNum());
        int rows = sheet.getLastRowNum() + 1;
        int columns = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[rows-1][columns];

        for (int i = 1; i < rows; i++) {
            XSSFRow row = sheet.getRow(i);
            data[i-1][0] = row.getCell(0).getStringCellValue();
            data[i-1][1] = row.getCell(1).getStringCellValue();
            data[i-1][2] = row.getCell(2).getStringCellValue();
        }
        return data;

    }


}
