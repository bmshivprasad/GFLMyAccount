package gflmyaccount.testcases;

import gflmyaccount.PageObjects.AccountsPage;
import gflmyaccount.PageObjects.BillingAndPaymentPage;
import gflmyaccount.PageObjects.LoginPage;
import gflmyaccount.PageObjects.SiteSelectorPage;
import gflmyaccount.base.EnhancedBaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class SiteSelector extends EnhancedBaseClass {

    public SiteSelector() {
        log4j = Logger.getLogger("BillingAndPayment");
    }


    public static int getRandomIntBetweenRange(int min, int max) {
        int x = (int) ((Math.random() * ((max - min) + 1)) + min);
        return x;
    }

    @Test
    public void TC01_Verify_Site_Selector_is_available_on_my_service_page() throws IOException, InterruptedException {

        testCaseLog("TC01_Verify_Site_Selector_is_available_on_my_service_page");
        LoginPage login = new LoginPage(gflmyaccountDriver);
        login.loginAs(USER_NAME, PASSWORD);
        BillingAndPaymentPage bp =new BillingAndPaymentPage(gflmyaccountDriver);
        SiteSelectorPage sp=new SiteSelectorPage(gflmyaccountDriver);
        bp.clickOverviewTab();
        bp.clickonfirstAccountfromOverViewPage();
        
        if(sp.isSiteSelectorDisplayed()) {
        	success("Site Selector dropdown is available on my service page.");
        }
        else
        {
            failure("Site Selector dropdown is available on my service page.");
        }
 
    }
    
    @Test
    public void TC02_Verify_user_can_view_all_sites_of_the_selected_account_in_site_selector_dropdown_whom_they_have_authorized_access() throws IOException, InterruptedException {

        testCaseLog("TC02_Verify_user_can_view_all_sites_of_the_selected_account_in_site_selector_dropdown_whom_they_have_authorized_access");
        LoginPage login = new LoginPage(gflmyaccountDriver);
        login.loginAs(USER_NAME, PASSWORD);
        BillingAndPaymentPage bp =new BillingAndPaymentPage(gflmyaccountDriver);
        SiteSelectorPage sp=new SiteSelectorPage(gflmyaccountDriver);
        bp.clickOverviewTab();
        bp.clickonfirstAccountfromOverViewPage();
        
        if(sp.isSiteSelectorDisplayed()) {
        	success("Site Selector dropdown is available on my service page.");
        }
        else
        {
            failure("Site Selector dropdown is available on my service page.");
        }
        
        sp.clickOnSiteSelector();
        
        if(sp.isAllSiteDisplayed()) {
        	success("All authorised Site are available on my service page.");
        }
        else
        {
            failure("All authorised Site are available on my service page.");
        }
 
    }
    
    @Test
    public void TC03_Verify_user_can_switch_the_Sties() throws IOException, InterruptedException {

        testCaseLog("TC03_Verify_user_can_switch_the_Sties");
        LoginPage login = new LoginPage(gflmyaccountDriver);
        login.loginAs(USER_NAME, PASSWORD);
        BillingAndPaymentPage bp =new BillingAndPaymentPage(gflmyaccountDriver);
        SiteSelectorPage sp=new SiteSelectorPage(gflmyaccountDriver);
        bp.clickOverviewTab();
        bp.clickonfirstAccountfromOverViewPage();
        
        if(sp.isSiteSelectorDisplayed()) {
        	success("Site Selector dropdown is available on my service page.");
        }
        else
        {
            failure("Site Selector dropdown is available on my service page.");
        }
        
        sp.clickOnSiteSelector();
        
        if(sp.isAllSiteDisplayed()) {
        	success("All authorised Site are available on my service page.");
        }
        else
        {
            failure("All authorised Site are available on my service page.");
        }
        
        sp.clickOnFirstSiteFromSelector();
        
        if(sp.isSelectedSiteDislayed()) {
        	success("Site switched successfully.");
        }
        else
        {
            failure("Site switched successfully.");
        }
        
    }
    
    @Test
    public void TC04_Verify_on_switching_sites_all_details_are_updated_as_per_site_selection() throws IOException, InterruptedException {

        testCaseLog("TC04_Verify_on_switching_sites_all_details_are_updated_as_per_site_selection");
        LoginPage login = new LoginPage(gflmyaccountDriver);
        login.loginAs(USER_NAME, PASSWORD);
        BillingAndPaymentPage bp =new BillingAndPaymentPage(gflmyaccountDriver);
        SiteSelectorPage sp=new SiteSelectorPage(gflmyaccountDriver);
        bp.clickonfirstAccountfromOverViewPage();
        if(sp.isSiteSelectorDisplayed()) {
            success("Site Selector dropdown is available on my service page.");
        }
        else
        {
            failure("Site Selector dropdown is available on my service page.");
        }

        bp.clickonMyService();
        bp.clickonBillingPayment();


        
        sp.clickOnSiteSelector();
        
        if(sp.isAllSiteDisplayed()) {
        	success("All authorised Site are available on my service page.");
        }
        else
        {
            failure("All authorised Site are available on my service page.");
        }
        
        sp.clickOnFirstSiteFromSelector();
        if(sp.isSelectedSiteDislayed())
        {
        	success("Site switched successfully.");
        }
        else
        {
            failure("Site switched successfully.");
        }
        int len1=sp.getNumberofrow();
        sp.clickOnSiteSelector();
        sp.clickOnSecondSiteFromSelector();

        if(sp.isSelectedSiteDislayed())
        {
            success("Site switched successfully.");
        }
        else
        {
            failure("Site switched successfully.");
        }
        int len2=sp.getNumberofrow();
        if(len1!=len2)
            success("Records updated based on site selection");
        else
            failure("Records not updated based on site selection");

    }
    
    @Test
    public void TC05_Verify_site_nickname_displayed_in_site_selector() throws IOException, InterruptedException {

        testCaseLog("TC_05_Verify_site_nickname_displayed_in_site_selector");
        LoginPage login = new LoginPage(gflmyaccountDriver);
        login.loginAs(USER_NAME, PASSWORD);
        BillingAndPaymentPage bp =new BillingAndPaymentPage(gflmyaccountDriver);
        SiteSelectorPage sp=new SiteSelectorPage(gflmyaccountDriver);
        AccountsPage ap = new AccountsPage(gflmyaccountDriver);
        bp.clickOverviewTab();
        bp.clickonfirstAccountfromOverViewPage();
        if(sp.isSiteSelectorDisplayed()) {
        	success("Site Selector dropdown is available on my service page.");
        }
        else
        {
            failure("Site Selector dropdown is available on my service page.");
        }
        
        sp.clickOnSiteSelector();
        sp.clickOnFirstSiteFromSelector();
        bp.clickOnAccountsTab();
        ap.editSiteName();
        bp.clickonServiceDetail();
        sp.clickOnSiteSelector();
        
        if(sp.isSiteNickNameDisplayed()) {
        	success("Site nick name is available in Service Selector.");
        }
        else
        {
            failure("Site nick name is available in Service Selector.");
        }
 
    }
    

}
