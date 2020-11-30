package gflmyaccount.PageObjects;

import com.lowagie.text.Cell;
import gflmyaccount.base.Generics;
import gflmyaccount.testcases.profile;
import gflmyaccount.utilities.ExcelColumnsAccount;
import io.github.bonigarcia.wdm.SeleniumServerStandaloneManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class AccountPage extends profile implements ExcelColumnsAccount {

    WebDriver localDriver;
    Generics generics;
    SoftAssert sassert = new SoftAssert();

//    static String USERNAME1;
//    static String pswrd1;
//    static String username2;
//    static String pswrd2;
//    static String accountnumber1;
//    static String postalcode1;
//    static String accountnumber2;
//    static String postalcode2;
//    static String accountnumber3;
//    static String postalcode3;
//    static String invoicenumber1;
//    static String amount1;
//    static String invoicenumber2;
//    static String amount2;
//    static String invoicenumber3;
//    static String amount3;

    public AccountPage(WebDriver baseDriver) {
        this.localDriver = baseDriver;
        PageFactory.initElements(localDriver, this);
        generics = new Generics(localDriver);
        log4j = Logger.getLogger("LoginLogoutPage");
    }

    @FindBy(css = "[href='/en-CA/accounts']")
    public WebElement accountlink;
    @FindBy(xpath = "//*[text()='LINK ACCOUNT']")
    public WebElement linkaccountbutton;
    @FindBy(xpath = "//button[text()='Link Account']")
    public WebElement innerlinkaccountbutton;
    @FindBy(xpath = "//*[text()='GFL has two easy ways for you to link an account']")
    public WebElement linkaccountpopup;
    @FindBy(css = ".main_link_green")
    public List<WebElement> linkingoptions;
    //    @FindBy(xpath="//*[translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')='go back']")
//    public WebElement gobackbutton;
    @FindBy(xpath = "//h2[text()='Please enter the account number and postal code below.']")
    public WebElement accountnumberpopup;
    @FindBy(css = "[formcontrolname='accountNumber']")
    public WebElement accountnumberfield;
    @FindBy(css = "[formcontrolname='billingZipCode']")
    public WebElement postalcodefield;
    @FindBy(xpath = "//h2[text()='Please enter the invoice number and invoice amount below.']")
    public WebElement invoicenumberpopup;
    @FindBy(css = "[formcontrolname='invoiceNumber']")
    public WebElement invoicenumberfield;
    @FindBy(css = "input[formcontrolname='invoiceAmount']")
    public WebElement invoiceamountfield;
    @FindBy(css = "[role='gridcell']")
    public List<WebElement> linkedaccounttable;
    @FindBy(css = "snack-bar-container [role='alert'] div")
    public WebElement linkaccountmessage;

    @FindBy(css = "app-linked-accounts [data-label='Account'] a")
    public List<WebElement> linkacctable;
    @FindBy(css = "app-pending-accounts [data-label='Account']")
    public List<WebElement> pendinglinkstable;
    @FindBy(css = "app-linked-accounts [data-label='Account_Name']")
    public List<WebElement> linkaccsitename;
    @FindBy(css = "app-linked-accounts [data-label='Authorized Users']")
    public List<WebElement> authorizedusercolumn;

    //    @FindBy(css = "tbody[role='rowgroup'] .cdk-column-Account")
//    public List<WebElement> linkacctable;
//    @FindBy(css="tbody[role='rowgroup'] .cdk-column-ACCOUNT_NUMBER")
//    public List<WebElement> pendinglinkstable;
//    @FindBy(css="tbody[role='rowgroup'] .cdk-column-Account_Name")
//    public List<WebElement> linkaccsitename;
//    @FindBy(css="tbody[role='rowgroup'] .cdk-column-Authorized_Users")
//    public List<WebElement> authorizedusercolumn;
    @FindBy(xpath = "//button[(text()='Request Access')]")
    public WebElement requestaccess;
    @FindBy(css = "snack-bar-container mat-icon:nth-child(3)")
    public WebElement closemessage;
    @FindBy(xpath = "//*[contains(text(),'Unlink')]")
    public WebElement unlinkaccbuttton;
    @FindBy(xpath = "//*[contains(text(),'Unlink')]")
    public WebElement unlinkaccountbuttton;
    @FindBy(xpath = "//button[contains(text(),'Unlink Site')]")
    public WebElement unlinksitebuttton;
    @FindBy(xpath = "//*[translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')='remove link']")
    public WebElement removelink;
    @FindBy(css = "div .card input[type='text']")
    public WebElement accsitenamefield;
    @FindBy(xpath = "//*[contains(text(),'Save')]")
    public WebElement savechanges;
    @FindBy(xpath = "//*[(text()='Linked Accounts')]")
    public WebElement linkedaccounttext;
    @FindBy(css = "button .action")
    public WebElement adduser;
    @FindBy(css = "div .email-auths input")
    public List<WebElement> adduseremailfield;
    @FindBy(css = "div .user span")
    public List<WebElement> uservalue;
    @FindBy(css = "mat-error[role='alert']")
    public WebElement authorizedusererror;
    @FindBy(css = ".ac_info .ac_block")
    public WebElement accsiteinfo;
    @FindBy(css = " .ac_block")
    public List<WebElement> accountdetails;
    @FindBy(xpath = "//*[text()='Account Number']/following-sibling::*")
    public WebElement accountname;
    @FindBy(xpath = "//*[text()='Billing TYPE']/following-sibling::*")
    public WebElement billingname;
    @FindBy(css = "div .ac_info h5")
    public List<WebElement> sitedetails;
    @FindBy(css = " .button_main_grey")
    public List<WebElement> gobackgrey;


    static String logerror;
    static String titlelpage;


    public void click_on_account_page() throws IOException {
        generics.waitForElementVisible(accountlink);
        generics.isClickable(accountlink);
        generics.clickOnJS(accountlink);
        generics.waitForElementVisible(linkaccountbutton);
        generics.isClickable(linkaccountbutton);
    }
//    public void click_on_goback() throws IOException{
//
//    }

    public void click_on_linkbutton() throws IOException {
        generics.pause(1);
        generics.waitForElementVisible(linkaccountbutton);
        generics.isClickable(linkaccountbutton);
        generics.clickOnJS(linkaccountbutton);
        generics.waitForElementVisible(linkaccountpopup);
        //generics.pause(2);
    }

    public void click_on_inner_linkbutton() throws IOException {

        generics.pause(1);
        generics.isClickable(innerlinkaccountbutton);
        generics.clickOn(innerlinkaccountbutton);

    }

    public void click_on_link_by_accountnumber() throws IOException {
        generics.waitForElementVisible(linkingoptions.get(0));
        generics.isClickable(linkingoptions.get(0));
        testStepsLog("Clicking on |Link By Account Number option|");
        generics.clickOnJS(linkingoptions.get(0));
        generics.waitForElementVisible(accountnumberpopup);
        testStepsLog("Link by Account number popup opened");
    }

    public void click_on_link_by_invoicenumber() throws IOException {
        //generics.waitForElementVisible(linkingoptions.get(1));
        generics.isClickable(linkingoptions.get(1));
        testStepsLog("Clicking on |Link By Invoice Number option|");
        generics.clickOnJS(linkingoptions.get(1));
        generics.waitForElementVisible(invoicenumberpopup);
        testStepsLog("Link by Invoice number popup opened");
        //generics.pause(2);
    }

    public void fill_account_number_values(String account_number, String postal_code) throws IOException {
        // generics.waitForElementVisible(accountnumberfield);
        generics.isClickable(accountnumberfield);
        generics.waitForElementVisible(accountnumberfield);
        generics.type(accountnumberfield, account_number);
        generics.pause(2);
        generics.type(postalcodefield, postal_code);
        generics.pause(2);
        testStepsLog("Account values filled\n");
    }

    public void fill_invoice_number_values(String invoice_number, String invoice_amount) throws IOException {
        //generics.pause(10);
        generics.isClickable(invoicenumberfield);
        generics.type(invoicenumberfield, invoice_number);
        generics.pause(2);
        generics.type(invoiceamountfield, invoice_amount);
        generics.pause(2);
        testStepsLog("Invoice values filled\n");
    }

    public void click_on_goback() throws IOException {
        //generics.waitForElementVisible(gobackbutton);
        try {
            if (generics.isPresent(gobackgrey.get(0)))
                for (WebElement goback : gobackgrey) {
                    String gobacktext = goback.getText();
                    if (gobacktext.trim().equalsIgnoreCase("go back"))
                        generics.isClickableElement(goback);
                    generics.clickOn(goback);
                }
        } catch (Exception E) {

        }
        //generics.pause(2);
    }

    public void account_setting_messae_displayed(String acc) throws IOException {
        if (linkaccountmessage.getText().contains("updated successfully")) {
            testStepsLog("Test Pass-->Account updated successfully--->" + acc + "\n");
        } else if (linkaccountmessage.getText().contains("invalid entries")) {
            testFailLog("Test Fail-->Account details not updated--->" + acc + "\n");
        }else{
            testFailLog("Test Fail-->Account details not updated---> "+linkaccountmessage.getText()+" message displaying for--> " + acc + "\n");
        }
        generics.pause(1);
        if (generics.isPresent(closemessage)) {
            generics.clickOnJS(closemessage);
        }
        click_on_goback();
    }


    public void link_account_message_displayed(String acc)throws IOException {
        generics.pause(1);
        if (linkaccountmessage.getText().contains("Account has been successfully linked") || linkaccountmessage.getText().contains("Site has been successfully linked")) {
            testStepsLog("Test Pass-->Account linked successfully--->" + acc + "\n");
            generics.pause(1);
            if (generics.isPresent(closemessage)) {
                generics.clickOnJS(closemessage);
            }
        } else if (linkaccountmessage.getText().contains("must be linked by invoice number")) {
            testFailLog("Test Fail-->>Account linking failed due to Validation--->" + acc + "\n");
            testStepsLog("Validation is \n" + linkaccountmessage.getText() + "\n");
            generics.pause(1);
            if (generics.isPresent(closemessage)) {
                generics.clickOnJS(closemessage);
            }
            click_on_goback();
            click_on_goback();
        } else if (linkaccountmessage.getText().contains("You are already linked")) {
            testFailLog("Test Fail-->>Account linking failed because Account is already linked--->" + acc + "\n");
            generics.pause(1);
            if (generics.isPresent(closemessage)) {
                generics.clickOnJS(closemessage);
            }
//            generics.pause(1);
            click_on_goback();
            click_on_goback();
        } else if (linkaccountmessage.getText().contains("already a pending request to link")) {
            testFailLog("Test Fail-->There is already a pending request to link this account !--->" + acc + "\n");
            generics.pause(1);
            if (generics.isPresent(closemessage)) {
                    generics.clickOnJS(closemessage);
            }
//            if (generics.isPresent(gobackbutton)) {
//                    click_on_goback();
//            }
//            if (generics.isPresent(gobackbutton)) {
//                    click_on_goback();
//            }
            click_on_goback();
            click_on_goback();
        } else if (linkaccountmessage.getText().contains("Account Link Request has been sent ") || linkaccountmessage.getText().contains("Site Link Request has been sent")) {
            testFailLog("Test Fail-->Account linking request has been set successfully as account is already linked to another user--->" + acc + "\n");
            generics.pause(1);
            if (generics.isPresent(closemessage)) {
                    generics.clickOnJS(closemessage);
            }
//              if (generics.isPresent(gobackbutton)) {
//                  click_on_goback();
//                }
            click_on_goback();
        } else {
                testFailLog("Test Fail-->>Account linking failed due to Error-->" + acc + "\n");
                testStepsLog("Error is \n" + linkaccountmessage.getText() + "\n");
                generics.pause(1);
                if (generics.isPresent(closemessage)) {
                    generics.clickOnJS(closemessage);
                }
//                if (generics.isPresent(gobackbutton)) {
//                    click_on_goback();
//                }
//                if (generics.isPresent(gobackbutton)) {
//                    click_on_goback();
//                }
            click_on_goback();
            }


    }
    public void unlink_account_site_message_displayed(String acc,String username)throws IOException {
        generics.pause(1);
        if (generics.isPresent(linkaccountmessage)) {
        if (linkaccountmessage.getText().contains("Account has been unlinked") || linkaccountmessage.getText().contains("Site Unlinked")) {
            testStepsLog("Test Pass-->Account/Site unlinked successfully--->" + acc + "\n");
            generics.pause(1);
            if (generics.isPresent(closemessage)) {
                generics.clickOnJS(closemessage);
            }
        }
        }
    }
    public void check_if_account_linked(String acc) throws IOException {
          generics.pause(1);
        if (generics.isPresent(linkaccountmessage)) {
            link_account_message_displayed(acc);
        } else if (generics.isPresent(requestaccess)) {
            testFailLog("Test Fail-->Account already linked to another user, need to request access for-->" + acc + "\n");
            generics.clickOnJS(requestaccess);
            link_account_message_displayed(acc);

        }
    }

//    else {
//            testStepsLog("Test Fail-->>Error Occured\n");
//            if (generics.isPresent(linkaccountmessage)) {
//                testStepsLog("Error is:"+linkaccountmessage.getText()+"\n");
//            }
//            if(generics.isPresent(closemessage)){
//                generics.clickOnJS(closemessage);
//            }
//            if(generics.isPresent(gobackbutton))
//            {
//                click_on_goback();
//            }
//            if(generics.isPresent(gobackbutton))
//            {
//                click_on_goback();
//            }
//
//        }
//    }
    //public void check_if_accounts_present_in_accountlink_table(String acc1,String acc2,String acc3,String user) throws IOException{
    public void check_if_accounts_present_in_accountlink_table(String acc1,String user) throws IOException{
        boolean flag=false;
        for (WebElement name : linkacctable) {
            String accountname=name.getText();
            if (accountname.contains(acc1)) {
//            if (name.getText().contains(acc1)||name.getText().contains(acc2)||name.getText().contains(acc3)) {
                testStepsLog("Test Pass-->Account present in linked Accounts table-->" + accountname + " For user--->"+user+"\n");
                flag=true;
                break;
            }
        }
            if(!flag)
            {
                testFailLog("Test Fail-->Account is not present in linked Accounts table-->" + acc1 + " For user--->"+user+"\n");
            }


//            else{
//                testStepsLog("Account is not present in linked Accounts table"+name.getText()+" For user--->"+user+"\n");
//            }


        }
        public boolean click_on_account_display(String acc) throws IOException{
            boolean flag=false;
            for (WebElement name : linkacctable) {
                String accountname=name.getText();
                if (accountname.contains(acc)) {
                    name.findElement(By.xpath("../..//a/mat-icon")).click();
                    testStepsLog("Editing Account details:"+acc+"\n");
                    flag=true;
                    break;
                }

            }
            return flag;
        }


    public void check_if_accounts_present_in_pendinglink_table(String acc1,String user) throws IOException{
        boolean flag=false;
        for (WebElement name : pendinglinkstable) {
            String accountname=name.getText();
            if (accountname.contains(acc1)) {
//            if (name.getText().contains(acc1)||name.getText().contains(acc2)||name.getText().contains(acc3)) {
                testStepsLog("Test Pass-->Account present in Pending links table-->" + accountname + " For user--->"+user+"\n");
                flag=true;
                break;
            }
        }
        if(!flag)
        {
            testFailLog("Test Fail-->Account is not present in Pending links table-->" + acc1 + " For user--->"+user+"\n");
        }

    }

    public void check_if_accountsite_nickname_present_in_linkacc_table(String acc,String updatedname,String user) throws IOException{
        boolean flag=false;
        for (WebElement name : linkaccsitename) {
            String accountname=name.getText();
            if (accountname.contains(updatedname)) {
//            if (name.getText().contains(acc1)||name.getText().contains(acc2)||name.getText().contains(acc3)) {
                testStepsLog("Test Pass-->Updated Nickname present in Accounts links table-->" + acc + " For user--->"+user+"\n");
                flag=true;
                break;
            }
        }
        if(!flag)
        {
            testFailLog("Test Fail-->Updated Nickname is not present in Accounts links table -->" + acc + " For user--->"+user+"\n");
        }

    }
//    public void check_if_accounts_present_in_pendinglink_table(String acc1,String acc2,String acc3,String user) throws IOException {
//
//        for (WebElement name : pendinglinkstable) {
//            if (name.getText().contains(acc1)||name.getText().contains(acc2)||name.getText().contains(acc3)) {
//                testStepsLog("Account present in Pending links table-->" + name.getText() + " For user--->"+user+"\n");
//            }else{
//                testStepsLog("Account is not present in Pending links table"+name.getText()+" For user--->"+user+"\n");
//            }
//
//        }
//    }
    public void link_by_account_number(String acc,String postal) throws IOException{
        generics.waitForElementVisible(linkedaccounttext);
        click_on_linkbutton();
        click_on_link_by_accountnumber();
        fill_account_number_values(acc,postal);
        click_on_inner_linkbutton();
        generics.pause(1);
        check_if_account_linked(acc);
        generics.waitForElementVisible(linkedaccounttext);
    }
    public void link_by_invoice_number(String inv,String amt) throws IOException{
        generics.waitForElementVisible(linkedaccounttext);
        click_on_linkbutton();
        click_on_link_by_invoicenumber();
        fill_invoice_number_values(inv,amt);
        click_on_inner_linkbutton();
        generics.pause(1);
        check_if_account_linked(inv);
        generics.waitForElementVisible(linkedaccounttext);
    }
    public void removelink_by_account_number(String acc,String username)throws IOException{
        generics.waitForElementVisible(linkedaccounttext);
        boolean flag=false;
        flag= click_on_account_display(acc);
        generics.pause(1);
        if(flag) {
            generics.waitForElementVisible(unlinkaccbuttton);

            if (generics.isPresent(unlinkaccbuttton)) {
                testStepsLog("Clicking on Unlink \n");
                generics.clickOn(unlinkaccbuttton);
            }
            if (generics.isPresent(unlinksitebuttton)) {
                generics.clickOn(unlinksitebuttton);
            }
            generics.isClickable(removelink);
            testStepsLog("Clicking on Remove link \n");
            generics.clickOn(removelink);
            unlink_account_site_message_displayed(acc, username);
            generics.waitForElementVisible(linkedaccounttext);
            testStepsLog("Back to Link account page \n");
        }
        if(!flag)
        {
            testStepsLog(acc+" Account is not present in link account table\n");
        }
    }
    public void verify_acc_details(String acc,String username,String type)throws IOException{
        if(generics.isPresent(unlinkaccountbuttton)) {
            if (generics.getText(accountname).contentEquals(acc)) {
                testStepsLog("Account number verified for " + acc);
            } else {
                testFailLog("Test Failed---->" + accountname.getText() + " Account displayed, instead of" + acc + "\n");
            }
            switch (type) {
                case "Type_1":
                    if (generics.getText(billingname).contains("Customer (A/R Customer)")) {
                        testStepsLog("Type 1 Customer verified\n");
                    } else {
                        testStepsLog(generics.getText(billingname) + " value displaying\n");
                    }
                    break;
                case "Type_2":
                    if (generics.getText(billingname).contains("Site (A/R Customer)")) {
                        testStepsLog("Type 2 Customer verified\n");
                    } else {
                        testStepsLog(generics.getText(billingname) + " value displaying\n");
                    }
                    break;
                case "Type_3":
                    if (generics.getText(billingname).contains("Site (A/R Site)")) {
                        testStepsLog("Type 3 Customer verified\n");
                    } else {
                        testStepsLog(generics.getText(billingname) + " value displaying\n");
                    }
                    break;
                default:
                    testFailLog("Test Fail--> Error occured " + generics.getText(billingname) + " is displaying\n");

            }
//        }else if(generics.isPresent(unlinksitebuttton)){
//            if (generics.getText(sitedetails.get(0)).contentEquals(acc)) {
//                testStepsLog("Account number verified for " + acc);
//            } else {
//                testFailLog("Test Failed---->" + sitedetails.get(0) + " Account displayed, instead of" + acc + "\n");
//            }
//            switch (type) {
////                case "Type_1":
////                    if (generics.getText(accountdetails.get(2)).contains("Customer (A/R Customer)")) {
////                        testStepsLog("Type 1 Customer verified\n");
////                    } else {
////                        testStepsLog(generics.getText(accountdetails.get(2)) + " value displaying\n");
////                    }
////                    break;
////                case "Type_2":
////                    if (generics.getText(accountdetails.get(2)).contains("Site (A/R Customer)")) {
////                        testStepsLog("Type 2 Customer verified\n");
////                    } else {
////                        testStepsLog(generics.getText(accountdetails.get(2)) + " value displaying\n");
////                    }
////                    break;
//                case "Type_3":
//                    if (generics.getText(sitedetails.get(2)).contains("Site (A/R Site)")) {
//                        testStepsLog("Type 3 Customer verified\n");
//                    } else {
//                        testStepsLog(generics.getText(sitedetails.get(2)) + " value displaying\n");
//                    }
//                    break;
//                default:
//                    testStepsLog("Error occured " + generics.getText(sitedetails.get(2)) + "\n");
//
//            }

        }

    }
    public void edit_account_details(String acc,String username,String updatedname,String type)throws IOException{
        boolean flag=false;
        generics.waitForElementVisible(linkedaccounttext);
        flag= click_on_account_display(acc);
        generics.pause(2);
        verify_acc_details(acc,username,type);

        //te
        // stStepsLog("Edit Account/Site details pge opened--> Editing "+acc+" account\n");
        generics.pause(2);
            if(flag) {
                generics.waitForElementVisible(accsitenamefield);
                //testStepsLog(accsitenamefield.getAttribute("value"));
                generics.clickOn(accsitenamefield);
                generics.type(accsitenamefield, updatedname);
                generics.scrollToTop();
                generics.pause(1);
                if(generics.isClickableElement(savechanges)){
                    generics.clickOnJS(savechanges);
                }else{
                    testFailLog("Test Fail-->Unable to save changes");
                }
               // account_setting_messae_displayed(acc);
                if(accsitenamefield.getAttribute("value").contentEquals(updatedname)){
                    testStepsLog("Test Pass--> Account name updated, new name is --> "+accsitenamefield.getAttribute("value")+" \n");
                }else {
                    testFailLog("Test Fail--> Account name is not updated, name appearing is --> "+accsitenamefield.getAttribute("value")+" \n");
                }
                click_on_goback();
                generics.waitForElementVisible(linkedaccounttext);
                testStepsLog("Back to link account page\n");
                check_if_accountsite_nickname_present_in_linkacc_table(acc, updatedname, username);
            }else {
                testFailLog(acc+" Account is not present in link account table\n");

            }
    }
    public void add_authorized_user(String acc,String username,String emailaddress)throws IOException {
        boolean flag = false;
        generics.waitForElementVisible(linkedaccounttext);
        flag = click_on_account_display(acc);
        //testStepsLog("Edit Account/Site details pge opened--> Editing "+acc+" account\n");
        generics.pause(3);
        int emailfields=1;
        if (flag) {
            if (adduseremailfield.get(0).getAttribute("ng-reflect-model").contentEquals(emailaddress)) {
                testStepsLog(emailaddress + " User is already present in Authorized user list\n");
                generics.pause(1);
//                generics.clickOnJS(gobackbutton);
                click_on_goback();

            }
             else {
                 if(generics.isPresent(adduseremailfield.get(0))){
                     generics.waitForElementVisible(adduser);
                     generics.clickOn(adduser);
                     emailfields=adduseremailfield.size();
                     //testStepsLog(Integer.toString(emailfields));
                     generics.waitForElementVisible(adduseremailfield.get(emailfields-1));
                     generics.type(adduseremailfield.get(emailfields-1), emailaddress);

                 }else {
                     generics.waitForElementVisible(adduser);
                     generics.clickOn(adduser);
                     generics.waitForElementVisible(adduseremailfield.get(0));
                     generics.type(adduseremailfield.get(0), emailaddress);
                 }
                generics.pause(1);
                if (generics.isPresent(authorizedusererror)) {
                    testStepsLog(authorizedusererror.getText() + " Error occured\n");

                }
                if(generics.getText(uservalue.get(emailfields-1)).contains("CK GFL"))
                {
                    generics.scrollToTop();
                    generics.clickOnJS(savechanges);
                    account_setting_messae_displayed(acc);
                    //generics.clickOnJS(gobackbutton);
                    generics.waitForElementVisible(linkedaccounttext);
                    generics.pause(1);
                    boolean flag1 = false;
                    for (WebElement name : linkacctable) {
                        String accountname = name.getText();
                        if (accountname.contains(acc)) {
                            name.findElement(By.xpath("..//td[contains(@class,'cdk-column-Authorized_Users')]/div")).getText().contains("CK GFL");
                            testStepsLog("For " + acc + " Authorized user--> " + emailaddress + " is present in link account table for-->" + username + "\n");
                            flag1 = true;
                            break;

                        }
                    }
                    if (!flag1) {
                        testFailLog("Test failFor " + acc + " Authorized user--> " + emailaddress + "is not present in link account table for--> " + username + "\n");

                    }
                }else {
                    testStepsLog(emailaddress+" is not verified, displaying error "+generics.getText(uservalue.get(emailfields-1))+"  so, unable to add new user\n");
                    generics.pause(1);
                    generics.scrollToTop();
//                    generics.clickOnJS(gobackbutton);
                    click_on_goback();
                }


            }
        }
            if (!flag) {
                testStepsLog("Account is not present in link account table"+acc+"\n");

            }

    }

    public Object[][] getLinkAccountDataForm() {
        int totalRow = excelUtils.lastRowNumber("myaccount", "Sheet1");
        XSSFRow excelrow = excelUtils.getRowData("myaccount", 1);
        DataFormatter dateFormat = new DataFormatter();
//        Object[][] data = new Object[0][];
//        for (int i = 1; i <= totalRow; i++) {
//            XSSFRow excelrow = excelUtils.getRowData("myaccount", i);
////            try {
////                System.out.println(excelrow.getCell(USERNAME1).getStringCellValue());
////            } catch (Exception e) {
////                DataFormatter dateFormat = new DataFormatter();
////                System.out.println(dateFormat.formatCellValue(excelrow.getCell(USERNAME1)));
////            }
//
//            //System.out.println(Double.toString(excelrow.getCell(INVOICENUMBER1).getNumericCellValue()));
////            System.out.println(excelrow.getCell(USERNAME1).getStringCellValue());
//
//            DataFormatter dateFormat = new DataFormatter();
//            //
//            //
//            //
//             data = new Object[][]{
//                    {
//                            dateFormat.formatCellValue(excelrow.getCell(USERNAME1)),
//                            dateFormat.formatCellValue(excelrow.getCell(PASSWORD1)),
//                            dateFormat.formatCellValue(excelrow.getCell(USERNAME2)),
//                            dateFormat.formatCellValue(excelrow.getCell(PASSWORD2)),
//                            dateFormat.formatCellValue(excelrow.getCell(ACCOUNTNUMBER1)),
//                            dateFormat.formatCellValue(excelrow.getCell(POSTALCODE1)),
//                            dateFormat.formatCellValue(excelrow.getCell(ACCOUNTNUMBER2)),
//                            dateFormat.formatCellValue(excelrow.getCell(POSTALCODE2)),
//                            dateFormat.formatCellValue(excelrow.getCell(ACCOUNTNUMBER3)),
//                            dateFormat.formatCellValue(excelrow.getCell(POSTALCODE3)),
//                            dateFormat.formatCellValue(excelrow.getCell(INVOICENUMBER1)),
//                            dateFormat.formatCellValue(excelrow.getCell(AMOUNT1)),
//                            dateFormat.formatCellValue(excelrow.getCell(INVOICENUMBER2)),
//                            dateFormat.formatCellValue(excelrow.getCell(AMOUNT2)),
//                            dateFormat.formatCellValue(excelrow.getCell(INVOICENUMBER3)),
//                            dateFormat.formatCellValue(excelrow.getCell(AMOUNT3)),
////
////
//
////
//                    },
//            };
//        }
//        return data;
        return new Object[][]{
//                {excelrow.getCell(0).getStringCellValue(),excelrow.getCell(1).getStringCellValue(),excelrow.getCell(2).getStringCellValue(),excelrow.getCell(3).getStringCellValue(),excelrow.getCell(4).getStringCellValue(),excelrow.getCell(5).getStringCellValue(),excelrow.getCell(6).getStringCellValue(),excelrow.getCell(7).getStringCellValue(),excelrow.getCell(8).getStringCellValue(),excelrow.getCell(9).getStringCellValue(),excelrow.getCell(10).getStringCellValue(),excelrow.getCell(11).getStringCellValue(),excelrow.getCell(12).getStringCellValue(),excelrow.getCell(13).getStringCellValue(),excelrow.getCell(14).getStringCellValue(),excelrow.getCell(15).getStringCellValue()}
//                {"gflconnect999@grr.la","GFL@1234%","ckgfl@grr.la","GFL@1234%","xyzType1","111111","xyzType2","111111","xyzType3","111111","MyAccInv2","222","MyAccInv4","222","MyAccInv6","222"}
                {
                        dateFormat.formatCellValue(excelrow.getCell(USERNAME1)),
                            dateFormat.formatCellValue(excelrow.getCell(PASSWORD1)),
                            dateFormat.formatCellValue(excelrow.getCell(USERNAME2)),
                            dateFormat.formatCellValue(excelrow.getCell(PASSWORD2)),
                            dateFormat.formatCellValue(excelrow.getCell(ACCOUNTNUMBER1)),
                            dateFormat.formatCellValue(excelrow.getCell(POSTALCODE1)),
                            dateFormat.formatCellValue(excelrow.getCell(ACCOUNTNUMBER2)),
                            dateFormat.formatCellValue(excelrow.getCell(POSTALCODE2)),
                            dateFormat.formatCellValue(excelrow.getCell(ACCOUNTNUMBER3)),
                            dateFormat.formatCellValue(excelrow.getCell(POSTALCODE3)),
                            dateFormat.formatCellValue(excelrow.getCell(INVOICENUMBER1)),
                            dateFormat.formatCellValue(excelrow.getCell(AMOUNT1)),
                            dateFormat.formatCellValue(excelrow.getCell(INVOICENUMBER2)),
                            dateFormat.formatCellValue(excelrow.getCell(AMOUNT2)),
                            dateFormat.formatCellValue(excelrow.getCell(INVOICENUMBER3)),
                            dateFormat.formatCellValue(excelrow.getCell(AMOUNT3)),
                }
        };
    }



    public void refresh() throws IOException{
        localDriver.navigate().refresh();
    }
    }
