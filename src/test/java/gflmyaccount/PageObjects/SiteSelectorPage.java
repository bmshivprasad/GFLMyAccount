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

public class SiteSelectorPage extends EnhancedBaseClass {

	private Generics generics;

	public SiteSelectorPage(WebDriver baseDriver) {
		PageFactory.initElements(baseDriver, this);
		generics = new Generics(baseDriver);
		log4j = Logger.getLogger("LandingPage");
	}

	public static String siteName;

	@FindBy(xpath = "//div[@class='dropdown-menu show']//ng-select[@placeholder='Select Site']")
	public WebElement drpSiteSelector;

	@FindBy(xpath = "//div[@class='dropdown-menu show']//div[text()='Select Site']/following-sibling::div/span[contains(@class,'account_number')]")
	public WebElement selectSiteName;

	public boolean isSiteSelectorDisplayed() {

		if (generics.isDisplay(drpSiteSelector)) {

			return true;
		} else {
			return false;

		}
	}

	public void clickOnSiteSelector() {

		generics.clickOn(drpSiteSelector);
		generics.pause(2);
	}

	@FindBy(xpath = "//div[contains(@class,'ng-option')]//span[contains(.,'Site 5000 Younge Street, Toronto, Ontario')]")
	public WebElement siteValue1;

	@FindBy(xpath = "//div[contains(@class,'ng-option')]//span[contains(.,' Site 5001Younge Street, Toronto, Ontario')]")
	public WebElement siteValue2;

	public boolean isAllSiteDisplayed() {
		if (generics.isDisplay(siteValue1) && generics.isDisplay(siteValue2))
			return true;
		else
			return false;
	}

	public void clickOnFirstSiteFromSelector() {

		siteName = generics.getText(siteValue1);
		System.out.println(siteName);
		generics.clickOn(siteValue1);
		generics.pause(2);
	}

	public String getSelectedSiteName() {

		return generics.getText(selectSiteName);
	}

	public boolean isSelectedSiteDislayed() {
		String site = generics.getText(selectSiteName);
		System.out.println(site);
		if (site.trim().equals(siteName.trim())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSiteNickNameDisplayed() {
		if (generics.isPresent("//div[contains(@class,'ng-option')]//span[contains(.,'" + siteName + "')]"))
			return true;
		else
			return false;
	}
}