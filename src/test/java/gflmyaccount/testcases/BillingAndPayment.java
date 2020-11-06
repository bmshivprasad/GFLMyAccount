package gflmyaccount.testcases;

import gflmyaccount.PageObjects.BillingAndPaymentPage;
import gflmyaccount.PageObjects.LoginPage;
import gflmyaccount.base.EnhancedBaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class BillingAndPayment extends EnhancedBaseClass {

    public BillingAndPayment() {
        log4j = Logger.getLogger("BillingAndPayment");
    }


    public static int getRandomIntBetweenRange(int min, int max) {
        int x = (int) ((Math.random() * ((max - min) + 1)) + min);
        return x;
    }

    @Test
    public void TC01_Verify_Account_Selection_dropdown_is_visible_on_top_right_corner() throws IOException, InterruptedException {

        testCaseLog("Verify_Account_Selection_dropdown_is_visible_on_top_right_corner");
        LoginPage login = new LoginPage(gflmyaccountDriver);
        login.loginAs(USER_NAME, PASSWORD);
        BillingAndPaymentPage bp=new BillingAndPaymentPage(gflmyaccountDriver);
        if(bp.isAccountSelectionDpDisplayed())
        {
            success("Account Selection dropdown visible on top right corner");
        }
        else
        {
            failure("Account Selection dropdown not visible on top right corner");
        }

    }

    @Test
    public void TC02_Verify_Top_Menu_bar_displayed_with_all_account_user_have_attached() throws IOException, InterruptedException
    {

        testCaseLog("TC01_Verify_Top_Menu_bar_displayed_with_all_account_user_have_attached");
        LoginPage login = new LoginPage(gflmyaccountDriver);
        login.loginAs(USER_NAME, PASSWORD);
        BillingAndPaymentPage bp=new BillingAndPaymentPage(gflmyaccountDriver);
        bp.clickonAccountSelector();
        if(bp.isAllAccountDisplayed())
        {
            success("All type of account displayed in dropdown");
        }
        else
        {
            failure("All type of account not displayed in dropdown");
        }

    }

    @Test
    public void TC03_Verify_Account_Selected_updated_on_all_pages_of_my_services_My_work_Support_page() throws IOException, InterruptedException
    {

        testCaseLog("TC03_Verify_Account_Selected_updated_on_all_pages_of_my_services_My_work_Support_page");
        LoginPage login = new LoginPage(gflmyaccountDriver);
        login.loginAs(USER_NAME, PASSWORD);
        BillingAndPaymentPage bp=new BillingAndPaymentPage(gflmyaccountDriver);
        bp.clickonAccountSelector();
        bp.getFirstAccountNumber();
        bp.selectFirstAccount();
        bp.clickonMyService();
        bp.clickonServiceDetail();

        if(bp.isSelectedAccountDislayedonAllPages())
        {
            success("Selected Account number displayed on My Service Page");
        }
        else
        {
            failure("Selected Account number displayed on My Service Page");
        }

        bp.clickonMyDocument();
        bp.clickonWorkOrder();

        if(bp.isSelectedAccountDislayedonAllPages())
        {
            success("Selected Account number displayed on My Documents Page");
        }
        else
        {
            failure("Selected Account number displayed on My Documents Page");
        }
        bp.clickonSupport();
        if(bp.isSelectedAccountDislayedonAllPages())
        {
            success("Selected Account number displayed on Support Page");
        }
        else
        {
            failure("Selected Account number displayed on My Support Page");
        }

    }
    @Test
    public void TC04_Verify_Account_Selected_from_overview_page_will_automatically_updated_on_account_selector() throws IOException, InterruptedException
    {

        testCaseLog("TC04_Verify_Account_Selected_from_overview_page_will_automatically_updated_on_account_selector");
        LoginPage login = new LoginPage(gflmyaccountDriver);
        login.loginAs(USER_NAME, PASSWORD);
        BillingAndPaymentPage bp=new BillingAndPaymentPage(gflmyaccountDriver);
        bp.clickonfirstAccountfromOverViewPage();
        bp.clickonMyService();
        bp.clickonServiceDetail();

        if(bp.isSelectedAccountDislayedonAllPages())
        {
            success("Selected account from overview page is automatically updated on account selector");
        }
        else
        {
            failure("Selected account from overview page is automatically not updated on account selector");
        }
        bp.clickOverviewTab();

        bp.clickonSecondAccountfromOverViewPage();

        if(bp.isSelectedAccountDislayedonAllPages())
        {
            success("updated account from overview page is automatically updated on account selector");
        }
        else
        {
            failure("updated account from overview page is automatically not updated on account selector");
        }


    }

    @Test
    public void TC05_Verify_User_can_navigate_arround_with_selected_account() throws IOException, InterruptedException
    {

        testCaseLog("TC05_Verify_User_can_naigate_arround_with_selected_account");
        LoginPage login = new LoginPage(gflmyaccountDriver);
        login.loginAs(USER_NAME, PASSWORD);
        BillingAndPaymentPage bp=new BillingAndPaymentPage(gflmyaccountDriver);
        bp.clickonfirstAccountfromOverViewPage();
        bp.clickonMyService();
        bp.clickonServiceDetail();

        if(bp.isSelectedAccountDislayedonAllPages())
        {
            success("Selected Account number displayed on My Service Page");
        }
        else
        {
            failure("Selected Account number displayed on My Service Page");
        }

        bp.clickonMyDocument();
        bp.clickonWorkOrder();

        if(bp.isSelectedAccountDislayedonAllPages())
        {
            success("Selected Account number displayed on My Documents Page");
        }
        else
        {
            failure("Selected Account number displayed on My Documents Page");
        }
        bp.clickonSupport();
        if(bp.isSelectedAccountDislayedonAllPages())
        {
            success("Selected Account number displayed on Support Page");
        }
        else
        {
            failure("Selected Account number displayed on My Support Page");
        }

    }
    @Test
    public void TC06_Verify_All_menus_displayed_to_user_once_user_select_any_account() throws IOException, InterruptedException
    {

        testCaseLog("TC06_Verify_All_menus_displayed_to_user_once_user_select_any_account");
        LoginPage login = new LoginPage(gflmyaccountDriver);
        login.loginAs(USER_NAME, PASSWORD);
        BillingAndPaymentPage bp=new BillingAndPaymentPage(gflmyaccountDriver);
        bp.clickonfirstAccountfromOverViewPage();

        if(bp.isAllMenuVisible())
        {
            success("All other menus visible once user select any account");
        }
        else
        {
            failure("All other menus not visible once user select any account");
        }


    }
}
