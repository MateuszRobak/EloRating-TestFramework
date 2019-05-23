package objects;

import objects.Player.Player;
import objects.Player.PlayerCreator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

public class PlayersPage extends BaseObjects {
    WebDriver driver;
    PlayerCreator playerCreator = new PlayerCreator();

    @FindBy(how = How.XPATH, using = "//div[@id='main-container']//div[2]//ul[1]//li[1]//a[1]")
    private WebElement addPlayer;

    @FindBy(how = How.XPATH, using = "//input[@name='username']")
    public WebElement username;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Create')]")
    private WebElement createPlayer;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Players list')]")
    private WebElement playersPageHeader;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Yes')]")
    private WebElement yesButton;


    private static By playerName(java.lang.String playerName) {
        return By.xpath("//a[contains(text(),'" + playerName + "')]");
    }

    private static By removePlayerButton(java.lang.String playerName) {
        return By.xpath("//a[contains(text(),'" + playerName + "')]/../..//button[1]");
    }

    private static By deletedPlayer(java.lang.String playerName) {
        return By.xpath("//del[contains(text(),'" + playerName + "')]");
    }

    private static By getPlayerName(int i){
        return By.xpath("//tr["+i+"]//td[1]//a");
    }

    private static By playersQ = By.xpath("//table[1]//tbody[1]/tr");

    private static int minimumPlayersQuantity = 2;

    private static int playersQuantity(WebDriver driver){
        int playersQuantity = driver.findElements(playersQ).size();
        return playersQuantity+1;
    }

    private void addPlayer(Player player){
        clickElement(addPlayer);
        setPlayerName(player.getName());
        clickElement(createPlayer);
        isElementVisible(playerName(player.getName()));
    }

    public PlayersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public ArrayList<Player> getPlayersList() {
        ArrayList<Player> playerList = new ArrayList<>();
        if (playersQuantity(driver) < 2) {
            Assert.assertNotEquals(playersQuantity(driver),minimumPlayersQuantity,"Players quantity is lower than " + minimumPlayersQuantity);
        }
        for (int i = 1; i < playersQuantity(driver); i++) {
            Player player = new Player();
            player.setName(getText(getPlayerName(i)));
            playerList.add(player);
        }
        return playerList;
    }

    public List<Player> createPlayers(int playersQuantity) throws Exception {
        goToPlayersPage();
        List<Player> playerList = playerCreator.createPlayerList(playersQuantity);
        for (Player player : playerList) {
            addPlayer(player);
//            clickElement(addPlayer);
//            setPlayerName(player.getName());
//            clickElement(createPlayer);
//            isElementVisible(playerName(player.getName()));
        } return getPlayersList();
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
