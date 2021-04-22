package main.java.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {


    @FindBy(css = ".home-link")
    private WebElement loginButton;

    public WebElement getLoginButton() { return loginButton; }
}
