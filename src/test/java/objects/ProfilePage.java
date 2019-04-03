package objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BaseObjects{
    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Leagues')]")
    private WebElement leagues;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-info btn-lg btn-block']")
    private WebElement assignPlayer;

    @FindBy(how = How.XPATH, using = "//h2[@class='mt-2']")
    private WebElement playerMatchesHeader;

    public static By leagueList(String league){
        return By.xpath("//a[contains(text(),'" +league+"')]");
    }

    public ProfilePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public ProfilePage goToLeagues(){
        clickElement(leagues);
        return this;
    }

    public ProfilePage isLeagueInLeagueList(String league){;
        try {
            isElementVisible(leagueList(league));
            System.out.println("League: " + league + " found");
        } catch (Exception e){
            throw e;
        }
        return this;
    }
}
