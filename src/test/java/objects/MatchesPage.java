package objects;

import objects.Match.Match;
import objects.Match.MatchCreator;
import objects.Player.Player;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MatchesPage extends BaseObjects {
    WebDriver driver;
    MatchCreator matchCreator = new MatchCreator();

    @FindBy(how = How.XPATH, using = "//ul[@class='nav justify-content-end']//a[contains(text(),'Add match')]")
    private WebElement addMatchButton;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Type first player name']")
    private WebElement firstPlayerName;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Type second player name']")
    private WebElement secondPlayerName;


    public MatchesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void createMatch(String playerOne, String playerTwo){
        List<Match> matchList = matchCreator.createMatch(playerOne, playerTwo);
        for(Match match: matchList){
            clickElement(addMatchButton);
            typeText(firstPlayerName,playerOne);
            typeText(secondPlayerName,playerTwo);
        }
    }
}
