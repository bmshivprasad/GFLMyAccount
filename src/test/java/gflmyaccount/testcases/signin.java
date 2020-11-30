package gflmyaccount.testcases;

import gflmyaccount.PageObjects.LoginPage;
import gflmyaccount.base.EnhancedBaseClass;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class signin extends EnhancedBaseClass{

    @Test(priority = 1)
    public void TC01_SignIn() throws IOException, InterruptedException {

        testCaseLog("TC01_SignIn");
        gflmyaccount.PageObjects.LoginPage login = new gflmyaccount.PageObjects.LoginPage(gflmyaccountDriver);
        LoginPage lp = new LoginPage(gflmyaccountDriver);
        FileInputStream fis = new FileInputStream("C:\\Users\\smanjeshwar\\Documents\\GFLMyAccount\\src\\test\\java\\gfl\\testData\\myprofile.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        //Create a loop over all the rows of excel file to read it
        for (int i = 0; i < rowCount+1; i++) {
            lp.login(i+1);
           /* Row row = sheet.getRow(i);
            //Create a loop to print cell values in a row
            for (int j = 0; j < row.getLastCellNum(); j++) {
                //Print Excel data in console
                System.out.print(row.getCell(j).getStringCellValue()+"|| "); */

            }

          		}
    }
