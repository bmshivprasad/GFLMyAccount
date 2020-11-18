package gflmyaccount.PageObjects;


import gflmyaccount.base.EnhancedBaseClass;
import gflmyaccount.base.Generics;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BillingAndPaymentPage extends EnhancedBaseClass {

    private Generics generics;

    public BillingAndPaymentPage(WebDriver baseDriver) {
        PageFactory.initElements(baseDriver, this);
        generics = new Generics(baseDriver);
        log4j = Logger.getLogger("LandingPage");
    }
    
    
    @FindBy(xpath = "//i[text()='power_settings_new']")
    public WebElement logoutbutton;

    @FindBy(xpath = "//div[text()='Please select an account']/following-sibling::div//input")
    public WebElement dpAccountSelector;

    @FindBy(xpath = "//div[text()='Please select an account']/following-sibling::div/span[contains(@class,'account_number')]")
    public WebElement selectedAccount;

    public void clickonAccountSelector()
    {
        generics.clickOn(dpAccountSelector);
        testStepsLog("Clicked on Account Selector Dropdown");
    }

    @FindBy(xpath = "//div[contains(@class,'ng-option')]//span[text()='BillType11']")
    public WebElement accBilltype11;
    @FindBy(xpath = "//div[contains(@class,'ng-option')]//span[text()='BillType21']")
    public WebElement accBilltype21;
    @FindBy(xpath = "//div[contains(@class,'ng-option')]//span[text()='BillType31']")
    public WebElement accBilltype31;

    public boolean isAllAccountDisplayed()
    {
        if(generics.isDisplay(accBilltype11) && generics.isDisplay(accBilltype21) && generics.isDisplay(accBilltype31))
            return true;
        else
            return false;

    }

    public boolean isAccountSelectionDpDisplayed()
    {
        if(generics.isDisplay(dpAccountSelector))
            return true;
        else
            return false;

    }
    
    @FindBy(xpath = "//a[contains(.,'OVERVIEW')]")
    public WebElement mnu_overview;

    @FindBy(xpath = "//a[contains(.,'ACCOUNTS')]")
    public WebElement mnu_accounts;
  
    @FindBy(xpath = "//a[contains(.,'Support')]")
    public WebElement mnu_support;
    
    @FindBy(xpath = "//div[@id='Navigation']//a")
    public List<WebElement> mnu_available;
    
    
    public boolean isDefaultMenuDispalyedOnFirstSignIn() {
    	
    	System.out.println("LIST SIZE" +mnu_available.size());
    	
    	if(mnu_available.size() == 3)
    	{
    		if(generics.isPresent(mnu_overview) && generics.isPresent(mnu_accounts) && generics.isPresent(mnu_support)) 
    			return true;
    		else
    			return false; 	
    	}
    	else
    	{
      		return false; 	
    	}
    }
    
    

    @FindBy(xpath = "(//div[contains(@class,'ng-option')]/span[2])[1]")
    public WebElement firstAccountfromDP;

    public static String AccountNumber;
    public void getFirstAccountNumber()
    {
        AccountNumber=generics.getText(firstAccountfromDP);
    }
    public void selectFirstAccount()
    {
        generics.clickOn(firstAccountfromDP);
        testStepsLog("First Account Selected : " + AccountNumber);
    }

    @FindBy(xpath = "//a[contains(text(),'My Services')]")
    public WebElement tabMyService;

    @FindBy(xpath = "//div[@id='Navigation']//a[contains(text(),'Service Details')]")
    public WebElement tabServiceDetail;

    @FindBy(xpath = "//a[contains(text(),'My Documents')]")
    public WebElement tabMyDocument;

    @FindBy(xpath = "//a[contains(text(),'Work orders')]")
    public WebElement tabWorkOrder;

    @FindBy(xpath = "//a[contains(text(),'Support')]")
    public WebElement tabSupport;

    @FindBy(xpath = "//a[text()='OVERVIEW']")
    public WebElement tabOverview;
    
    @FindBy(xpath = "//a[text()='ACCOUNTS']")
    public WebElement tabAccounts;

    @FindBy(xpath = "//a[text()='BILLING & Payments']")
    public WebElement tabBillingAndPayement;
    
    public void clickonMyService()
    {
        generics.waitForElementVisible(tabMyService);
        generics.clickOn(tabMyService);
        testStepsLog("Clicked on My Service tab");
        generics.pause(4);
    }
    public void clickonServiceDetail()
    {
        generics.clickOn(tabServiceDetail);
        testStepsLog("Clicked on Service Details tab");
        generics.pause(8);
    }
    public void clickonBillingPayment()
    {
        generics.clickOn(tabBillingAndPayement);
        testStepsLog("Clicked on Billing & Payments tab");
        generics.pause(8);
    }
    public void clickonMyDocument()
    {
        generics.clickOn(tabMyDocument);
        testStepsLog("Clicked on My Document tab");
        generics.pause(4);
    }
    public void clickonWorkOrder()
    {
        generics.clickOn(tabWorkOrder);
        testStepsLog("Clicked on WorkOrders tab");
        generics.pause(4);
    }
    public void clickonSupport()
    {
        generics.clickOn(tabSupport);
        testStepsLog("Clicked on Support tab");
        generics.pause(8);
    }
    
    

    public void clickOverviewTab()
    {
        generics.clickOn(tabOverview);
        testStepsLog("Clicked on Overview tab");
        generics.pause(8);
    }

    public void clickOnAccountsTab()
    {
        generics.clickOn(tabAccounts);
        testStepsLog("Clicked on Accounts tab");
        generics.pause(8);
    }

    
    public  boolean isAllMenuVisible()
    {
        generics.pause(5);
        if(generics.isDisplay(tabMyService) && generics.isDisplay(tabMyDocument) && generics.isDisplay(tabSupport))
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public boolean isSelectedAccountDislayedonAllPages()
    {
        String acc=generics.getText(selectedAccount);
        if(acc.equals(AccountNumber))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @FindBy(xpath = "(//div[contains(@class,'owl-stage')]/div[contains(@class,'owl-item')])[1]//a[contains(@class,'account_link')]")
    public WebElement firstAccountOnOverviewPage;

    @FindBy(xpath = "(//div[contains(@class,'owl-stage')]/div[contains(@class,'owl-item')])[3]//a[contains(@class,'account_link')]")
    public WebElement newAccountOnOverviewPage;

    public void clickonfirstAccountfromOverViewPage()
    {
        generics.waitForElementVisible(firstAccountOnOverviewPage);
        generics.pause(6);
        AccountNumber=generics.getText(firstAccountOnOverviewPage);
        generics.clickOn(firstAccountOnOverviewPage);
        generics.pause(5);
    }
     
    public void clickonSecondAccountfromOverViewPage()
    {
        generics.waitForElementVisible(newAccountOnOverviewPage);
        AccountNumber=generics.getText(newAccountOnOverviewPage);
        generics.clickOn(newAccountOnOverviewPage);
        generics.pause(5);
    }




}