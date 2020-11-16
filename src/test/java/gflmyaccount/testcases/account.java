package gflmyaccount.testcases;

import gflmyaccount.PageObjects.LoginLogoutPage;
import gflmyaccount.PageObjects.AccountPage;
import gflmyaccount.base.EnhancedBaseClass;
import gflmyaccount.base.Generics;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class account extends EnhancedBaseClass
{


    @Test(dataProvider = "LinkAccount")
public void TC03_Link_Account_Verification(String username1,String pswrd1, String username2,String pswrd2,String accountnumber1, String postalcode1,String accountnumber2, String postalcode2,String accountnumber3, String postalcode3,String invoicenumber1, String amount1,String invoicenumber2, String amount2,String invoicenumber3, String amount3) throws IOException, InterruptedException {

        // System.out.println(username1+","+pswrd1+","+username2+","+pswrd2+","+accountnumber+","+Postalcode);
        testCaseLog("TC03_Link_Account_Verification");
        Generics generics;
        gflmyaccount.PageObjects.LoginPage login = new gflmyaccount.PageObjects.LoginPage(gflmyaccountDriver);
        AccountPage ap = new AccountPage(gflmyaccountDriver);
        LoginLogoutPage ll = new LoginLogoutPage(gflmyaccountDriver);
//        FileInputStream fis = new FileInputStream("C:\\MyAccount\\src\\test\\java\\gfl\\testData\\myaccount.xlsx");
//////     FileInputStream fis = new FileInputStream(TEST_DATA_LOCATION+"\\myprofile.xlsx");
//        XSSFWorkbook wb = new XSSFWorkbook(fis);
//        XSSFSheet sheet = wb.getSheet("Sheet1");
//        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
////    //Create a loop over all the rows of excel file to read it
//        for (int i = 0; i < rowCount + 1; i++) {
////        ll.logon(i+1);*/

            try {
                ll.logon(username1, pswrd1);
                testStepsLog("Accounts Page test cases started");
                testStepsLog("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                ap.click_on_account_page();
                testStepsLog("Accounts page opened");
                testStepsLog("-------------------------------Linking Accounts by Accounts number---------------------------------");
                testStepsLog("Link Account Popup opened--> Linking type 1 Account\n");
                ap.link_by_account_number(accountnumber1, postalcode1);
                testStepsLog("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                testStepsLog("Link Account Popup opened--> Linking Type 2 Account");
                ap.link_by_account_number(accountnumber2, postalcode2);
                testStepsLog("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                testStepsLog("Link Account Popup opened--> Linking Type 3 Account");
                ap.link_by_account_number(accountnumber3, postalcode3);
                testStepsLog("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                testStepsLog("Link Account Popup opened\n");
                testStepsLog("--------------------------------Linking Accounts by Invoice number---------------------------------");
                testStepsLog("Link by Invoice Popup opened--> Linking Type 1 invoice");
                ap.link_by_invoice_number(invoicenumber1, amount1);
                testStepsLog("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                testStepsLog("Link by Invoice Popup opened--> Linking Type 2 invoice");
                ap.link_by_invoice_number(invoicenumber2, amount2);
                testStepsLog("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                testStepsLog("Link by Invoice Popup opened--> Linking Type 3 invoice");
                ap.link_by_invoice_number(invoicenumber3, amount3);
                testStepsLog("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                testStepsLog("Check if Accounts are present in Linked Accounts table of " + username1 + "\n");
                ap.check_if_accounts_present_in_accountlink_table(accountnumber1, username1);
                ap.check_if_accounts_present_in_accountlink_table(accountnumber2, username1);
                ap.check_if_accounts_present_in_accountlink_table(accountnumber3, username1);
                ll.logout(username1);
                ll.logon(username2, pswrd2);
                ap.click_on_account_page();
                testStepsLog("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                testStepsLog("Link Account Popup opened--> Linking type 1 Account\n");
                ap.link_by_account_number(accountnumber1, postalcode1);
                testStepsLog("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                testStepsLog("Link Account Popup opened--> Linking type 2 Account\n");
                ap.link_by_account_number(accountnumber2, postalcode2);
                testStepsLog("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                testStepsLog("Link Account Popup opened--> Linking type 3 Account\n");
                ap.link_by_invoice_number(invoicenumber3, amount3);
                testStepsLog("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                ap.check_if_accounts_present_in_pendinglink_table(accountnumber1, username2);
                ap.check_if_accounts_present_in_pendinglink_table(accountnumber2, username2);
                ap.check_if_accounts_present_in_pendinglink_table(accountnumber3, username2);
                ll.logout(username2);
                ll.logon(username1, pswrd1);
                ap.click_on_account_page();
                ap.check_if_accounts_present_in_pendinglink_table(accountnumber1, username1);
                ap.check_if_accounts_present_in_pendinglink_table(accountnumber2, username1);
                ap.check_if_accounts_present_in_pendinglink_table(accountnumber3, username1);

                Thread.sleep(10);

            } catch (StaleElementReferenceException e) {

                e.printStackTrace();
            }
        }


    @Test(dataProvider = "LinkAccount")
    public void TC04_Unlink_Account_Verification(String username1,String pswrd1, String username2,String pswrd2,String accountnumber1, String postalcode1,String accountnumber2, String postalcode2,String accountnumber3, String postalcode3,String invoicenumber1, String amount1,String invoicenumber2, String amount2,String invoicenumber3, String amount3) throws IOException, InterruptedException {

        // System.out.println(username1+","+pswrd1+","+username2+","+pswrd2+","+accountnumber+","+Postalcode);
        testCaseLog("TC04_Unlink_Account_Verification");
        Generics generics;
        gflmyaccount.PageObjects.LoginPage login = new gflmyaccount.PageObjects.LoginPage(gflmyaccountDriver);
        AccountPage ap = new AccountPage(gflmyaccountDriver);
        LoginLogoutPage ll = new LoginLogoutPage(gflmyaccountDriver);

        ll.logon(username1, pswrd1);
        ap.click_on_account_page();
        testStepsLog("Unlink account verification test cases started");
        testStepsLog("-------------------------------Unlinking Accounts by Accounts number---------------------------------");
        testStepsLog("Link Account Popup opened--> Linking type 1 Account\n");
        ap.removelink_by_account_number(accountnumber1, username1);
        testStepsLog("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        testStepsLog("Link Account Popup opened--> Linking Type 2 Account\n");
        ap.removelink_by_account_number(accountnumber2, username1);
        testStepsLog("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        testStepsLog("Link Account Popup opened--> Linking Type 3 Account\n");
        ap.removelink_by_account_number(accountnumber3, username1);
        testStepsLog("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        ap.check_if_accounts_present_in_accountlink_table(accountnumber1, username1);
        ap.check_if_accounts_present_in_accountlink_table(accountnumber2, username1);
        ap.check_if_accounts_present_in_accountlink_table(accountnumber3, username1);
    }

    @Test(dataProvider = "LinkAccount")
    public void TC05_Edit_account_details(String username1,String pswrd1, String username2,String pswrd2,String accountnumber1, String postalcode1,String accountnumber2, String postalcode2,String accountnumber3, String postalcode3,String invoicenumber1, String amount1,String invoicenumber2, String amount2,String invoicenumber3, String amount3) throws IOException, InterruptedException {
      //  System.out.println(username1);
        testCaseLog("TC05_Edit_account_details");
        Generics generics;
        gflmyaccount.PageObjects.LoginPage login = new gflmyaccount.PageObjects.LoginPage(gflmyaccountDriver);
        AccountPage ap = new AccountPage(gflmyaccountDriver);
        LoginLogoutPage ll = new LoginLogoutPage(gflmyaccountDriver);

        ll.logon(username1, pswrd1);
        testStepsLog("Edit account details test cases started");
        ap.click_on_account_page();
        testStepsLog("-------------------------------Editing Accounts by Accounts number---------------------------------");
        testStepsLog("Type 1 Account\n");
        ap.edit_account_details(accountnumber1,username1,"updatedacc1","Type_1");
        testStepsLog("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        testStepsLog("Type 2 Account\n");
        ap.edit_account_details(accountnumber2,username1,"updatedacc2","Type_2");
        testStepsLog("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        testStepsLog("Type 3 Account\n");
        ap.edit_account_details(accountnumber3,username1,"updatedacc3","Type_3");


    }

    @Test(dataProvider = "LinkAccount")
    public void TC06_Add_authorized_user(String username1,String pswrd1, String username2,String pswrd2,String accountnumber1, String postalcode1,String accountnumber2, String postalcode2,String accountnumber3, String postalcode3,String invoicenumber1, String amount1,String invoicenumber2, String amount2,String invoicenumber3, String amount3) throws IOException, InterruptedException {

        // System.out.println(username1+","+pswrd1+","+username2+","+pswrd2+","+accountnumber+","+Postalcode);
        testCaseLog("TC06_Add_authorized_user");
        Generics generics;
        gflmyaccount.PageObjects.LoginPage login = new gflmyaccount.PageObjects.LoginPage(gflmyaccountDriver);
        AccountPage ap = new AccountPage(gflmyaccountDriver);
        LoginLogoutPage ll = new LoginLogoutPage(gflmyaccountDriver);

        ll.logon(username1, pswrd1);
        testStepsLog("Add authorized user test cases started");
        ap.click_on_account_page();
        testStepsLog("-------------------------------Editing Accounts by Accounts number---------------------------------");
        testStepsLog("Type 1 Account\n");
        ap.add_authorized_user(accountnumber1,username1,username2);
    }

    @DataProvider(name="LinkAccount")
    public Object[][] getDataForm(){
        AccountPage ap = new AccountPage(gflmyaccountDriver);
        return ap.getLinkAccountDataForm();
//        return new Object[][]{
////
//                {"krinaAcc2@gfl.com","krina123@","krinaAcc3@gfl.com","krina123@","KrinaAccType1","111111","KrinaAccType2","111111","KrinaAccType3","111111","701","222","703","222","706","222"}
//        };

    }
}