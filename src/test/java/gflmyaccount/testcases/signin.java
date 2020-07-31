package gflmyaccount.testcases;

import gflmyaccount.PageObjects.LoginPage;
import gflmyaccount.base.EnhancedBaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class signin extends EnhancedBaseClass {
    public signin() {
        log4j = Logger.getLogger("Batch Approval");
    }

    @Test(priority = 1)
    public void TC01_SignIn() throws IOException, InterruptedException {

        testCaseLog("TC01_SignIn");

        gflmyaccount.PageObjects.LoginPage login = new gflmyaccount.PageObjects.LoginPage(gflmyaccountDriver);

        LoginPage lp = new LoginPage(gflmyaccountDriver);
        lp.login(1);

    }}
