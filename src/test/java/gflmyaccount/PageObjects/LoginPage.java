package gflmyaccount.PageObjects;



import gflmyaccount.base.Generics;
import gflmyaccount.testcases.signin;
import gflmyaccount.utilities.ExcelColumnsProfile;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.io.IOException;
import java.util.List;


public class LoginPage extends signin implements ExcelColumnsProfile {

    WebDriver localDriver;
    Generics generics;

    public LoginPage(WebDriver baseDriver) {
        this.localDriver = baseDriver;
        PageFactory.initElements(localDriver, this);
        generics = new Generics(localDriver);
        log4j = Logger.getLogger("LoginPage");
    }

    public void loginAs(String username, String password) {

        generics.moveTo(txtemail);
        generics.clickOn(txtemail);
        testStepsLog("Clicked on Email Field ");
        //String EML = excelUtils.getTestData(PROFILE, row, EMAIL);
        generics.type(txtemail, username);
        testStepsLog("Email entered");
        generics.clickOn(txtpasswword);
        //String PASS = excelUtils.getTestData(PROFILE, row, PWD);
        //String RESP = excelUtils.getTestData(PROFILE, row,4);
        generics.type(txtpasswword, password);
        testStepsLog("Password entered");
        generics.clickOn(btnsubmit);
        testStepsLog("Clicked on Submit");
        titlelpage=localDriver.getTitle();
        if (titlelpage.equalsIgnoreCase("MyAccountFe"))
        {
            System.out.println("Test Passed : Log in Successful with valid credentials");

        }
        else {

            System.out.println("Test Passed : Error generated for Invalid credentials = "  + logerror);

        }

    }
    @FindBy(xpath = " //span[contains(text(),'LOGIN')]")
    public WebElement txtlogin;


    @FindBy(xpath = "//input[@id='email']")
    public WebElement txtemail;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement txtpasswword;
    @FindBy(xpath = "//button[@form='localAccountForm']")
    public WebElement btnsubmit;
    @FindBy(xpath = "//button[@routerlink='/profile']")
    public WebElement drpprofile;
    @FindBy(xpath = "//span[text()='SIGN OUT']")
    public WebElement btnsignout;
    @FindBy(xpath = "//div[@class='error pageLevel']")
    public WebElement errlogin;
    @FindBy(xpath = "//title[contains(text(),'MyAccountFe')]")
    public WebElement landpagetitle;
    @FindBy(css = "a[data-toggle='dropdown']")
    public List<WebElement> drpdownmainheader;

static  String logerror;
static String titlelpage;
    public void login(int row) throws IOException {
        generics.moveTo(txtlogin);
        generics.clickOn(txtlogin);
        generics.moveTo(txtemail);
        generics.clickOn(txtemail);
        testStepsLog("Clicked on Email Field ");
        String EML = excelUtils.getTestData(PROFILE, row, EMAIL);
        generics.type(txtemail, EML);
        testStepsLog("Email entered");
        generics.clickOn(txtpasswword);
        String PASS = excelUtils.getTestData(PROFILE, row, PWD);
        //String RESP = excelUtils.getTestData(PROFILE, row,4);
        generics.type(txtpasswword, PASS);
        testStepsLog("Password entered");
        generics.clickOn(btnsubmit);
        testStepsLog("Clicked on Submit");
        titlelpage=localDriver.getTitle();
        if (titlelpage.equalsIgnoreCase("MyAccountFe"))
        { System.out.println("Test Passed : Log in Successful with valid credentials");
            generics.pause(3);
            generics.moveTo(drpprofile);
            generics.clickOn(drpprofile);
            testStepsLog("Clicked profile drop down ");
            generics.pause(1);
            generics.moveTo(btnsignout);
            generics.clickOn(btnsignout);
            testStepsLog("Clicked on Sign Out ");
            generics.pause(2);
        }
        else {
            generics.moveTo(errlogin);
            generics.clickOn(errlogin);
            logerror = generics.getText(errlogin);
            System.out.println("Test Passed : Error generated for Invalid credentials = "  + logerror);

        }


}}