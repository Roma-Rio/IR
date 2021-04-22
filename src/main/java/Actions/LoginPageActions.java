package main.java.Actions;

import main.java.Locators.LoginPage;
import main.java.Utils.ReadProperties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageActions extends LoginPage {
    private WebDriver webDriver;

    public LoginPageActions(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPageActions enterLogin (String login) {
        getLoginField().sendKeys(login);
        getSubmitButton().click();
        return new LoginPageActions(webDriver);
    }

    public LoginPageActions enterPhone (String phone){
        getLoginField().sendKeys(phone);
        getSubmitButton().sendKeys(Keys.ENTER);
        return new LoginPageActions(webDriver);
    }

    public LoginPageActions enterPassword (String password)  {
        getPasswordField().sendKeys(password);
        getSignInButton().click();
        return new LoginPageActions(webDriver);
    }

 //   public LoginPageActions getLoginIntoProfile (String password)  {
 //       getPasswordField().sendKeys(password);
 //       getSignInButton().click();
 //       return new LoginPageActions(webDriver);
 //   }

}

