

package gflmyaccount.PageObjects;



import gflmyaccount.base.Generics;
import gflmyaccount.testcases.profile;

import gflmyaccount.utilities.ExcelColumns;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.io.IOException;



public class ProfilePage extends profile implements ExcelColumns {

    WebDriver localDriver;
    Generics generics;

    public ProfilePage(WebDriver baseDriver) {
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


    static String logerror;
    static String titlelpage;

    public void logon(int row) throws IOException {
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
    }
    @FindBy(xpath = " //span[contains(text(),'LOGIN')]")
    public WebElement txtlogin;

    @FindBy(xpath = "//mat-card-title[text()='My Profile']")
    public WebElement profilepagetitle;

    @FindBy(xpath = "//mat-card-subtitle[text()='Please contact your GFL Branch to change to your contact info.']")
    public WebElement profilepagehelptext;

    @FindBy(xpath = "//input[@ng-reflect-name='firstName']")
    public WebElement txtprflepgefirstname;

    @FindBy(xpath = "//button[@routerlink='/profile']")
    public WebElement drpprofile;

    @FindBy(xpath = "//input[@ng-reflect-name='lastName']")
    public WebElement txtprflepgelastname;

    @FindBy(xpath = "//input[@ng-reflect-name='phoneNumber']")
    public WebElement txtphone;

    @FindBy(xpath = "//input[@ng-reflect-name='extension']")
    public WebElement txtextension;

    @FindBy(xpath = "//input[@formcontrolname='mobilePhoneNumber']")
    public WebElement txtmobile;

    @FindBy(xpath = "//input[@formcontrolname='faxNumber']")
    public WebElement txtfax;

    @FindBy(xpath = "//input[@formcontrolname='emailAddress']")
    public WebElement txtemailfield;

    @FindBy(xpath = "//mat-select[@formcontrolname='language']")
    public WebElement drplanguage;




    static String profiletitle;
    static String FN;
    static String profilehelptxt;
    static String firstname;
    static String LN;
    static String lastname;
    static String phone;
    static String phne;
    static String extension;
    static String extn;
    static String mobile;
    static String mob;
    static String fax;
    static String fx;
    static String emailfield;
    static String email;
    static String language;
    static String lnge;


    public void profilepageview(int row) throws IOException {

        generics.moveTo(drpprofile);
        generics.clickOn(drpprofile);
        generics.moveTo(profilepagetitle);
        generics.clickOn(profilepagetitle);
        profiletitle=generics.getText(profilepagetitle);
        if (profiletitle.equalsIgnoreCase("MY Profile"))
        {
        testStepsLog("Pass : profile page displayed");}
        else{
            testStepsLog("Fail : profile page not displayed");
        }
        generics.moveTo(profilepagehelptext);
        generics.clickOn(profilepagehelptext);
        profilehelptxt=generics.getText(profilepagehelptext);
        if (profilehelptxt.equalsIgnoreCase("Please contact your GFL Branch to change to your contact info."))
        {
            testStepsLog("Pass : profile page helptext displayed");}
        else{
            testStepsLog("Fail : profile page helptext not displayed" + profilehelptxt );
        }
        FN = excelUtils.getTestData(PROFILE, row, FIRSTNAME);
        generics.moveTo(txtprflepgefirstname);
        generics.clickOn(txtprflepgefirstname);
        firstname= txtprflepgefirstname.getAttribute("value");
        if (FN.equalsIgnoreCase(firstname))
        {
            testStepsLog("Pass : Firstname  is  " +firstname);}
        else{
            testStepsLog("Fail : Firstname  is not " +FN);
        }

        LN = excelUtils.getTestData(PROFILE, row, LASTNAME);
        generics.moveTo(txtprflepgelastname);
        generics.clickOn(txtprflepgelastname);
        lastname= txtprflepgelastname.getAttribute("value");

        if (LN.equalsIgnoreCase(lastname))
        {
            testStepsLog("Pass : Lastname  is  " +lastname);}
        else{
            testStepsLog("Fail : Lastname  is not " +LN);
        }
    phone=excelUtils.getTestData(PROFILE, row, PHONE);
        generics.moveTo(txtphone);
        generics.clickOn(txtphone);
        phne= txtphone.getAttribute("value");

        if ( phone.equalsIgnoreCase(phne))
    {
        testStepsLog("Pass : Phone Number  is  " +phne);}
        else{
        testStepsLog("Fail : Phone Number  is not " +phone);    }

        extension=excelUtils.getTestData(PROFILE, row, EXTENSION);
        generics.moveTo(txtextension);
        generics.clickOn(txtextension);
        extn= txtextension.getAttribute("value");

        if ( extension.equalsIgnoreCase(extn))
        {
            testStepsLog("Pass : Extension  is  " +extn);}
        else{
            testStepsLog("Fail : Extension is not " +extension);
        }

        mobile=excelUtils.getTestData(PROFILE, row, MOBILE);
        generics.moveTo(txtmobile);
        generics.clickOn(txtmobile);
        mob= txtmobile.getAttribute("value");

        if ( mobile.equalsIgnoreCase(mob))
        {
            testStepsLog("Pass : Mobile Number is  " +mob);}
        else{
            testStepsLog("Fail : Mobile Number is not " +mobile);
        }

        fax=excelUtils.getTestData(PROFILE, row, FAX);
        generics.moveTo(txtfax);
        generics.clickOn(txtfax);
        fx= txtfax.getAttribute("value");
        //System.out.println(fx);
        if ( fax.equalsIgnoreCase(fx))
        {
            testStepsLog("Pass : FAX   is  " +fx);}
        else{
            testStepsLog("Fail : FAX  is not " +fax);
        }
        emailfield=excelUtils.getTestData(PROFILE, row,EMAIL);
        generics.moveTo(txtemailfield);
        generics.clickOn(txtemailfield);
        email= txtemailfield.getAttribute("value");

        if ( emailfield.equalsIgnoreCase(email))
        {
            testStepsLog("Pass : Email is  " +email);}
        else{
            testStepsLog("Fail : Email is not " +emailfield);
        }
        language=excelUtils.getTestData(PROFILE, row, LANGUAGE);
        generics.moveTo(drplanguage);
        generics.clickOn(drplanguage);
        //lnge= drplanguage.getAttribute("value");
        lnge=generics.getText(drplanguage);
        //System.out.println(lnge);
    if ( language.equalsIgnoreCase(lnge))
        {
            testStepsLog("Pass : Language  is  "+lnge);}
        else{
            testStepsLog("Fail : Language is not " +language);
        }    }}
