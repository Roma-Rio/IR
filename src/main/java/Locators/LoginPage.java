package main.java.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id = "passp-field-login")
    private WebElement loginField;

    @FindBy(css = ".Button2_type_submit")
    private WebElement submitButton;

    @FindBy(id = "passp-field-passwd")
    private WebElement passwordField;

    @FindBy(css = ".passp-sign-in-button")
    private WebElement signInButton;

    @FindBy(linkText = "Не помню пароль")
    private WebElement forgetPasswordLink;

    @FindBy(css = ".Title_align_center")
    private WebElement smsText;

    @FindBy(className = "passp-title")
    private WebElement symbolEnterText;

    @FindBy(css = ".Textinput-Hint_state_error")
    private WebElement emptyFieldText;

    @FindBy(css = ".desk-notif-card__domik-user")
    private WebElement loginAtMainPage;



    public WebElement getPasswordField() { return passwordField; }
    public WebElement getSignInButton() {  return signInButton;  }
    public WebElement getForgetPasswordLink() { return forgetPasswordLink;}
    public WebElement getLoginField() { return loginField; }
    public WebElement getSubmitButton() {  return submitButton; }
    public WebElement getSmsText() {  return smsText; }
    public WebElement getSymbolEnterText() {  return symbolEnterText; }
    public WebElement getEmptyFieldText() { return emptyFieldText;}
    public WebElement getLoginAtMainPage() { return loginAtMainPage;}

}

