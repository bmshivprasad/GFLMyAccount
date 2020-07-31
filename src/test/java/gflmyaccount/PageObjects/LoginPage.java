package gflmyaccount.PageObjects;


import gflmyaccount.base.EnhancedBaseClass;
import gflmyaccount.base.Generics;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static gflmyaccount.utilities.ExcelColumns.EMAIL;
import static gflmyaccount.utilities.ExcelColumns.PWD;

public class LoginPage extends EnhancedBaseClass {

    WebDriver localDriver;
    Generics generics;

    public LoginPage(WebDriver baseDriver) {
        this.localDriver = baseDriver;
        PageFactory.initElements(localDriver, this);
        generics = new Generics(localDriver);
        log4j = Logger.getLogger("LoginPage");
    }

    @FindBy(xpath = "//input[@name='Username or email address']")
    public WebElement txtemail;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement txtpasswword;

    @FindBy(xpath = "//button[@form='localAccountForm']")
    public WebElement btnsubmit;


    public void login(int row) {
        generics.moveTo(txtemail);
        generics.clickOn(txtemail);
        testStepsLog("Clicked on Email Field ");
        String EML = excelUtils.getTestData(PROFILE, row, EMAIL);
        generics.type(txtemail, EML);
        generics.clickOn(txtpasswword);
        String PASS = excelUtils.getTestData(PROFILE, row, PWD);
        generics.type(txtpasswword, PASS);
        generics.clickOn(btnsubmit);
        generics.pause(2);

    }}