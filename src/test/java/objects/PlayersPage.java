package objects;

import objects.Player.Player;
import objects.Player.PlayerCreator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PlayersPage extends BaseObjects {
    WebDriver driver;
    PlayerCreator playerCreator = new PlayerCreator();

    @FindBy(how = How.XPATH, using = "//div[@id='main-container']//div[2]//ul[1]//li[1]//a[1]")
    private WebElement addPlayer;

    @FindBy(how = How.XPATH, using = "//input[@name='username']")
    public WebElement username;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Create')]")
    public WebElement createPlayer;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Players list')]")
    public WebElement playersPageHeader;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Yes')]")
    public WebElement yesButton;


    private static By playerName(java.lang.String playerName) {
        return By.xpath("//a[contains(text(),'" + playerName + "')]");
    }

    private static By removePlayerButton(java.lang.String playerName) {
        return By.xpath("//a[contains(text(),'" + playerName + "')]/../..//button[1]");
    }

    private static By deletedPlayer(java.lang.String playerName) {
        return By.xpath("//del[contains(text(),'" + playerName + "')]");
    }

    public PlayersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    ;

    public void addPlayer(int playersQuantity, boolean removePlayers) throws Exception {
        goToPlayersPage();
        List<Player> playerList = playerCreator.createPlayers(playersQuantity);
        for (Player player : playerList) {
            clickElement(addPlayer);
            setPlayerName(player.getName());
            clickElement(createPlayer);
            isElementVisible(playerName(player.getName()));
            if (removePlayers) {
                removePlayer(player);
            }
        }
    }

    public void removePlayer(Player player) {
        clickElement(removePlayerButton(player.getName()));
        clickElement(yesButton);
        isElementVisible(deletedPlayer(player.getName()));
    }

    private PlayersPage setPlayerName(java.lang.String playerName) {
        typeText(username, playerName);
        return this;
    }
}
