package objects;

import config.Selectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseObjects{
    WebDriver driver;
    @FindBy(how = How.XPATH,using="//input[@placeholder='League name']")
    public  WebElement leagueNameInput;

    @FindBy(how = How.XPATH,using="//button[contains(text(),'Create league')]")
    public  WebElement createLeagueButton;

    @FindBy(how = How.XPATH, using="//span[contains(text(),'Sign in')]")
    public  WebElement signIn;

    @FindBy(how = How.XPATH, using ="//input[@name='identifier']")
    public  WebElement login;

    @FindBy(how = How.XPATH, using ="//content[@class='CwaK9']/span[1]")
    public  WebElement next;

    @FindBy(how = How.XPATH, using="//input[@name='password']")
    public  WebElement password;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-success btn-lg btn-block']")
    public  WebElement assignLeague;

    @FindBy(how = How.XPATH, using ="//h4[contains(text(),'Success!')]")
    public  WebElement sucessfullLeagueAssignment;

    @FindBy(how = How.XPATH, using = "//img[@class='rounded']")
    public  WebElement rounded;

    @FindBy(how = How.XPATH, using = "//div[@class='input-group input-group-lg mr-sm-2 mb-sm-0']//input[@id='leagueToSearchForm']")
    public WebElement leagueToSearchForm;

    @FindBy(how = How.XPATH, using = "//div[@class='input-group input-group-lg mr-sm-2 mb-sm-0']//button[@type='submit'][contains(text(),'Go to')]")
    public WebElement goTo;

    @FindBy(how = How.ID, using = "ngb-typeahead-0-1")
    public WebElement typehead;

    public static By typehead2(String leagueName){
        return By.xpath("//span[contains(text(),'" + leagueName + "')]");
    }


    public MainPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public MainPage signIn() throws Exception{
        clickElement(signIn);
        String parentWindow = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles())
        {
            driver.switchTo().window(winHandle);
            driver.manage().window().maximize();

        }
        typeText(login,Selectors.username);
        clickElement(next);
        Thread.sleep(1000);
        typeText(password, Selectors.passwordUser);
        clickElement(next);
        driver.switchTo().window(parentWindow);
        isElementVisible(rounded);
        return this;    }


    public Profile createLeague(String leagueName){
        typeText(leagueNameInput,leagueName);
        clickElement(createLeagueButton);
        clickElement(assignLeague);
        isElementVisible(sucessfullLeagueAssignment);
        return new Profile(driver);
    }

    public Profile goToLeague(String leagueName){
        typeText(leagueToSearchForm,leagueName);
        clickElement(typehead2(leagueName));
        clickElement(goTo);
        return new Profile(driver);
    }


}
