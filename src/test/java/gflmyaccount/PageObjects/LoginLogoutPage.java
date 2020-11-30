package gflmyaccount.PageObjects;

import gflmyaccount.base.Generics;
import gflmyaccount.testcases.profile;
import gflmyaccount.utilities.ExcelColumnsProfile;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class LoginLogoutPage extends profile implements ExcelColumnsProfile {

    WebDriver localDriver;
    Generics generics;


    public LoginLogoutPage(WebDriver baseDriver) {
        this.localDriver = baseDriver;
        PageFactory.initElements(localDriver, this);
        generics = new Generics(localDriver);
        log4j = Logger.getLogger("LoginLogoutPage");
    }

    @FindBy(css = "#email")
    public WebElement txtemail;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement txtpasswword;
    @FindBy(xpath = "//button[@form='localAccountForm']")
    public WebElement btnsubmit;
    @FindBy(css = "a[data-toggle='dropdown']")
    public List<WebElement> drpdownmainheader;
    @FindBy(xpath = "//*[@x-placement='bottom-start']//li[2]")
    public WebElement signout;


    static String logerror;
    static String titlelpage;

    public void logon(String username, String password) throws IOException {
        generics.moveTo(txtemail);
        generics.clickOn(txtemail);
        testStepsLog("Clicked on Email Field ");
        generics.type(txtemail, username);
        testStepsLog("Email entered");
        generics.clickOn(txtpasswword);
        generics.type(txtpasswword, password);
        testStepsLog("Password entered");
        generics.clickOn(btnsubmit);
        testStepsLog("Clicked on Submit");
       generics.pause(5);
        testStepsLog(username + "  logged in successfully\n");
    }
    public void logout(String username) throws IOException {
        generics.waitForElementVisible(drpdownmainheader.get(0));
        generics.moveTo(drpdownmainheader.get(0));
        generics.clickOn(drpdownmainheader.get(0));
        testStepsLog("Clicking on Signout");
        generics.waitForElementVisible(signout);
        generics.clickOn(signout);
        generics.pause(3);
        testStepsLog("User logged out successfully  "+username+"\n");
    }
}
