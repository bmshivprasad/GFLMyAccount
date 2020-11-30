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

public class AccountsPage extends EnhancedBaseClass {

    private Generics generics;
    public WebDriver localDriver;	
    public AccountsPage(WebDriver baseDriver) {
        PageFactory.initElements(baseDriver, this);
        generics = new Generics(baseDriver);
        log4j = Logger.getLogger("LandingPage");
        localDriver =baseDriver;
    }
    
    
    @FindBy(xpath = "//h3[contains(.,'Linked Accounts')]")
    public WebElement lblAccounts;
   
    @FindBy(xpath = "//input[@formcontrolname='siteName']")
    public WebElement txtAccountName;
   
    @FindBy(xpath = "//a[contains(.,'Save Changes')]")
    public WebElement btnSaveChanges;
     
    public void editSiteName() {
    	assignNickNameToSite();
    	SaveChanges();
    }
   
    public void assignNickNameToSite() {
    	testStepsLog("Give nick name to site.");
    	generics.isDisplay(lblAccounts);
    	System.out.println("xx" + BillingAndPaymentPage.AccountNumber);
    	localDriver.findElement(By.xpath("//tr//td[contains(.,'"+BillingAndPaymentPage.AccountNumber+"')]/../td[@data-label='actions']//a")).click();
    	generics.pause(10);
    	SiteSelectorPage.siteName = generics.getRandomCharacters(3) + SiteSelectorPage.siteName;
    	generics.waitForElementVisible(txtAccountName);
    	generics.type(txtAccountName,SiteSelectorPage.siteName);
    		
    }
   
    
    public void SaveChanges() {
    	testStepsLog("Click on Save Changes button.");
    	generics.clickOn(btnSaveChanges);
    	
    }
    
}