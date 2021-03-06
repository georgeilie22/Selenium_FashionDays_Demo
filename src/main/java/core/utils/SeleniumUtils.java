package core.utils;

import core.BuildBrowser;
import core.Config;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.KeyEvent;

public class SeleniumUtils {

    private static WebDriver driver;
    private static Actions actions;

    public static WebDriver buildDriver() {
        BuildBrowser browser = new BuildBrowser(Config.getBrowserType());
        driver = browser
                .withSize(Config.getSize())
                .isHeadless(Config.getHeadless())
                .build();
        return driver;
    }

    public static void waitForElementAndClick(int seconds, WebElement element) {
        new WebDriverWait(driver, seconds).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void waitForElementToBeVisible(int seconds, WebElement element){
        new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOf(element));
    }

    public static void staticWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void moveToObject(WebDriver driver, WebElement element){
        actions= new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public static void moveToObjectAndClick(WebDriver driver, WebElement element){
        actions= new Actions(driver);
        actions.moveToElement(element)
                .click()
                .build()
                .perform();
    }

    public static void clickWriteAndEnter(WebDriver driver, WebElement element,String text){
        actions= new Actions(driver);
        actions.moveToElement(element).click().sendKeys(text).sendKeys(Keys.ENTER).build().perform();
    }

}
