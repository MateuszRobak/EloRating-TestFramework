package objects;

import config.Selectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Profile extends BaseObjects{
    WebDriver driver;

    @FindBy(how = How.XPATH,using = "//img[@id='user-image']")
    public  WebElement profile;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'profile')]")
    public  WebElement yourProfile;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Leagues')]")
    public  WebElement leagues;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-info btn-lg btn-block']")
    public  WebElement assignPlayer;

    @FindBy(how = How.XPATH, using = "//h2[@class='mt-2']")
    public  WebElement playerMatchesHeader;

    public Profile(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public Profile goToProfile(){
        clickElement(profile);
        clickElement(yourProfile);
        return this;
    }

    public Profile goToLeagues(){
        goToProfile();
        clickElement(leagues);
        return this;
    }

    public Profile isLeagueInLeagueList(String league){
        goToLeagues();
        try {
            isElementVisible(Selectors.leagueList(league));
            System.out.println("League: " + league + " found");
        } catch (Exception e){
            throw e;
        }
        return this;
    }

    public PlayersPage assignProfileToCreatedLeague(){
        clickElement(Navbar.playersLink);
        clickElement(assignPlayer);
        isElementVisible(playerMatchesHeader);
        return new PlayersPage(driver);
    }
}
