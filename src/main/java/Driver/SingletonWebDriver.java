package main.java.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SingletonWebDriver {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static SingletonWebDriver instance;

    private SingletonWebDriver() {
    }

    public static SingletonWebDriver getInstance() {
        if (instance == null) {
            instance = new SingletonWebDriver();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void initialize() {
        driver.set(new ChromeDriver());
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void quit() {
        getDriver().quit();
    }

    public void close() {
        getDriver().close();
    }

    public void openURL(String URL) {
        getDriver().get(URL);
    }

    public void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
