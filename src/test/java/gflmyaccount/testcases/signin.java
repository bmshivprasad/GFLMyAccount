package gflmyaccount.testcases;

import gflmyaccount.PageObjects.LoginPage;
import gflmyaccount.base.EnhancedBaseClass;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class signin extends EnhancedBaseClass {

    public signin() {
        log4j = Logger.getLogger("SignIn");
    }


    public static int getRandomIntBetweenRange(int min, int max) {
        int x = (int) ((Math.random() * ((max - min) + 1)) + min);
        return x;
    }

    @Test(priority = 1)
    public void TC01_SignIn() throws IOException, InterruptedException {

        testCaseLog("TC01_SignIn");
        LoginPage login = new LoginPage(gflmyaccountDriver);

        login.loginAs(USER_NAME, PASSWORD);





    }
}
