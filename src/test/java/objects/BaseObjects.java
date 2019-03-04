package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseObjects {
    WebDriver driver;
    WebDriverWait wait;

    public BaseObjects(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver,5);
    }

    public void isElementVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void isElementVisible(By element){
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeClickable(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickElement(WebElement element){
        waitForElementToBeClickable(element);
        element.click();
    }

    public void clickElement(By element){
        waitForElementToBeClickable(element);
        driver.findElement(element).click();
    }

    public String getText(WebElement element){
        isElementVisible(element);
        return element.getText();
    }

    public void typeText(WebElement element, String text){
        clickElement(element);
        element.clear();
        element.sendKeys(text);
    }
}
