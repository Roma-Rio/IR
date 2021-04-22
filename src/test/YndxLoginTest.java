package test;

import main.java.Actions.LoginPageActions;
import main.java.Actions.MainPageActions;
import main.java.Driver.SingletonWebDriver;
import main.java.Utils.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.*;

public class YndxLoginTest {

    private SingletonWebDriver singletonWebDriver = SingletonWebDriver.getInstance();
    private MainPageActions mainPageActions;

    @BeforeMethod
    public void setUp() {
        singletonWebDriver.initialize();
        mainPageActions = new MainPageActions(singletonWebDriver.getDriver());
        singletonWebDriver.openURL(ReadProperties.getProperty("yndx"));
    }

    @AfterMethod
    public void between() {
        singletonWebDriver.pause(1000);
        singletonWebDriver.close();
    }

    @AfterTest
    public void tearDown() {
        singletonWebDriver.quit();
        singletonWebDriver = null;
    }

    @Test(priority = 1)
    public void checkAuthByLogin() {
        LoginPageActions loginPageActions = mainPageActions.goToPassportPage();
        loginPageActions.enterLogin(ReadProperties.getProperty("login"));
        loginPageActions.enterPassword(ReadProperties.getProperty("password"));
        Assert.assertEquals(loginPageActions.getLoginAtMainPage().getText(), "r0maqa");
    }

    @Test(priority = 2)
    public void checkAuthByEmail() {
        LoginPageActions loginPageActions = mainPageActions.goToPassportPage();
        loginPageActions.enterLogin(ReadProperties.getProperty("email"));
        loginPageActions.enterPassword(ReadProperties.getProperty("password"));
        Assert.assertEquals(loginPageActions.getLoginAtMainPage().getText(), "9057244137@list.ru");
    }

    @Test(priority = 6)
    public void getSmsForAuthByPhone() {
        LoginPageActions loginPageActions = mainPageActions.goToPassportPage();
        loginPageActions.enterPhone(ReadProperties.getProperty("phone"));
        Assert.assertEquals(loginPageActions.getSmsText().getText(), "Введите код из смс. Мы отправили его на номер +7 905 724-41-37");
    }

    @Test(priority = 5)
    public void checkRecoveryText() {
        LoginPageActions loginPageActions = mainPageActions.goToPassportPage();
        loginPageActions.enterLogin(ReadProperties.getProperty("login"));
        loginPageActions.getForgetPasswordLink().click();
        Assert.assertEquals(loginPageActions.getSymbolEnterText().getText(), "Введите символы с картинки");
    }

    @Test(priority = 3)
    public void checkEmptyLoginText() {
        LoginPageActions loginPageActions = mainPageActions.goToPassportPage();
        loginPageActions.getSubmitButton().click();
        singletonWebDriver.pause(1000);
        Assert.assertEquals(loginPageActions.getEmptyFieldText().getText(), "Логин не указан");
    }

    @Test(priority = 4)
    public void checkEmptyPasswordText() {
        LoginPageActions loginPageActions = mainPageActions.goToPassportPage();
        loginPageActions.enterLogin(ReadProperties.getProperty("login"));
        singletonWebDriver.pause(1000);
        loginPageActions.getSubmitButton().click();
        Assert.assertEquals(loginPageActions.getEmptyFieldText().getText(), "Пароль не указан");
    }
}
