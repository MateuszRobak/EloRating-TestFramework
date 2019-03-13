package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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

    public String getText(By element){
        isElementVisible(element);
        return driver.findElement(element).getText();
    }

    public void typeText(WebElement element, String text){
        clickElement(element);
        element.clear();
        element.sendKeys(text);
    }

    @FindBy(how = How.XPATH,using = "//img[@id='user-image']")
    private  WebElement profile;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'profile')]")
    private  WebElement yourProfile;

    private static By dashboardLink = By.xpath("//a[contains(text(),'DashboardPage')]");

    private static By matchesLink = By.xpath("//a[contains(text(),'Matches')]");

    private static By playersLink = By.xpath("//a[contains(text(),'Players')]");

    private static By queueLink = By.xpath("//a[contains(text(),'Queue')]");

    public DashboardPage goToDashboard(){
        clickElement(dashboardLink);
        return new DashboardPage(driver);
    }

    public ProfilePage goToProfile(){
        clickElement(profile);
        clickElement(yourProfile);
        return new ProfilePage(driver);
    }

    public MatchesPage goToMatches(){
        clickElement(matchesLink);
        return new MatchesPage(driver);
    }

    public PlayersPage goToPlayersPage(){
        clickElement(playersLink);
        return new PlayersPage(driver);
    }

    public QueuePage showQueue(){
        clickElement(queueLink);
        return new QueuePage(driver);
    }
}
