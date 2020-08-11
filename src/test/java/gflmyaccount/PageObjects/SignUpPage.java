package gflmyaccount.PageObjects;


import gflmyaccount.base.EnhancedBaseClass;
import gflmyaccount.base.Generics;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends EnhancedBaseClass {

    private Generics generics;

    public SignUpPage(WebDriver baseDriver) {
        PageFactory.initElements(baseDriver, this);
        generics = new Generics(baseDriver);
        log4j = Logger.getLogger("LandingPage");
    }

    @FindBy(xpath = "//i[text()='power_settings_new']")
    public WebElement logoutbutton;




}