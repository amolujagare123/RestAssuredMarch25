package SamplAPI.DataProvider;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class MyDataProvider {




public static Object[][] getMyData(String sheetName,String filepath) throws IOException {
    // 1. Read the file
    FileInputStream fis = new FileInputStream(filepath);

    // 2. create the object workbook
    XSSFWorkbook workbook = new XSSFWorkbook(fis);

    // 3. get sheet name
    XSSFSheet sheet = workbook.getSheet(sheetName);

    // 4. get row count
    int rowCount = sheet.getPhysicalNumberOfRows() ;
    int colCount = sheet.getRow(0).getLastCellNum();

    Object[][] data = new Object[rowCount-1][colCount];

    for(int i=0;i<rowCount-1;i++) {

        XSSFRow row = sheet.getRow(i+1);

        for (int j=0;j<colCount;j++)
        {
            data[i][j] = row.getCell(j).toString();
        }

            /*data[i][0] = row.getCell(0).toString();
            data[i][1] = row.getCell(1).toString();*/
    }
    return data;
}
}