package main.java.Actions;

import main.java.Locators.MainPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPageActions extends MainPage {
    private WebDriver webDriver;

    public MainPageActions(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPageActions goToPassportPage (){
         getLoginButton().sendKeys(Keys.ENTER);
        return new LoginPageActions(webDriver);
    }
}
