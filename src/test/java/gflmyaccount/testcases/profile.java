package gflmyaccount.testcases;

import gflmyaccount.PageObjects.LoginLogoutPage;
import gflmyaccount.PageObjects.ProfilePage;
import gflmyaccount.base.EnhancedBaseClass;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class profile extends EnhancedBaseClass
{

    @Test(priority = 1)
public void TC02_View_Profile() throws IOException, InterruptedException {

    testCaseLog("TC02_View_Profile");
    gflmyaccount.PageObjects.LoginPage login = new gflmyaccount.PageObjects.LoginPage(gflmyaccountDriver);
    ProfilePage pp = new ProfilePage(gflmyaccountDriver);
    LoginLogoutPage ll = new LoginLogoutPage(gflmyaccountDriver);

        //FileInputStream fis = new FileInputStream("C:\\Users\\smanjeshwar\\Documents\\GFLMyAccount\\src\\test\\java\\gfl\\testData\\myprofile.xlsx");
   // FileInputStream fis = new FileInputStream("C:\\Users\\KrinaGandhi\\Documents\\myprofile.xlsx");
    FileInputStream fis = new FileInputStream("C:\\MyAccount\\src\\test\\java\\gfl\\testData\\myprofile.xlsx");
//     FileInputStream fis = new FileInputStream(TEST_DATA_LOCATION+"\\myprofile.xlsx");
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet sheet = wb.getSheet("Sheet1");
    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
    //Create a loop over all the rows of excel file to read it
    for (int i = 0; i < rowCount+1; i++) {
        pp.logon(i+1);
       // pp.profilepageview(i+1);
        Thread.sleep(500);
        pp.profilepageverify(i+1);

           /* Row row = sheet.getRow(i);
            //Create a loop to print cell values in a row
            for (int j = 0; j < row.getLastCellNum(); j++) {
                //Print Excel data in console
                System.out.print(row.getCell(j).getStringCellValue()+"|| "); */

    }

}
}