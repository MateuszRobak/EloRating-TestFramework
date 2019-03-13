package objects;

import config.Selectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainPage extends BaseObjects {
    WebDriver driver;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='League name']")
    private WebElement leagueNameInput;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Create league')]")
    private WebElement createLeagueButton;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Sign in')]")
    private WebElement signIn;

    @FindBy(how = How.XPATH, using = "//input[@name='identifier']")
    private WebElement login;

    @FindBy(how = How.XPATH, using = "//content[@class='CwaK9']/span[1]")
    private WebElement next;

    @FindBy(how = How.XPATH, using = "//input[@name='password']")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-success btn-lg btn-block']")
    private WebElement assignLeague;

    @FindBy(how = How.XPATH, using = "//h4[contains(text(),'Success!')]")
    private WebElement sucessfullLeagueAssignment;

    @FindBy(how = How.XPATH, using = "//img[@class='rounded']")
    private WebElement rounded;

    @FindBy(how = How.XPATH, using = "//div[@class='input-group input-group-lg mr-sm-2 mb-sm-0']//input[@id='leagueToSearchForm']")
    private WebElement leagueToSearchForm;

    @FindBy(how = How.XPATH, using = "//div[@class='input-group input-group-lg mr-sm-2 mb-sm-0']//button[@type='submit'][contains(text(),'Go to')]")
    private WebElement goTo;

    @FindBy(how = How.ID, using = "ngb-typeahead-0-1")
    private WebElement typehead;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-info btn-lg btn-block']")
    private WebElement assignPlayer;

    @FindBy(how = How.XPATH, using = "//h2[@class='mt-2']")
    private WebElement playerMatchesHeader;

    private static By typehead2(String leagueName) {
        return By.xpath("//span[contains(text(),'" + leagueName + "')]");
    }


    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage signIn() throws Exception {
        clickElement(signIn);
        String parentWindow = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            driver.manage().window().maximize();

        }
        typeText(login, Selectors.username);
        clickElement(next);
        Thread.sleep(1000);
        typeText(password, Selectors.passwordUser);
        clickElement(next);
        driver.switchTo().window(parentWindow);
        isElementVisible(rounded);
        return this;
    }

    private static String setLeagueName() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss");
        String leagueName = dateFormat.format(date);
        return leagueName;
    }

    public MainPage createLeague() {
        typeText(leagueNameInput, setLeagueName());
        clickElement(createLeagueButton);
        clickElement(assignLeague);
        isElementVisible(sucessfullLeagueAssignment);
        assignProfileToCreatedLeague();
        return this;
    }

    public MainPage goToLeague(String leagueName) {
        typeText(leagueToSearchForm, leagueName);
        clickElement(typehead2(leagueName));
        clickElement(goTo);
        return this;
    }

    private MainPage assignProfileToCreatedLeague() {
        goToPlayersPage();
        clickElement(assignPlayer);
        isElementVisible(playerMatchesHeader);
        return this;
    }


}







