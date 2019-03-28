package objects;

import objects.Match.Match;
import objects.Match.MatchCreator;
import objects.Player.Player;
import org.openqa.selenium.By;
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

    private static By playerDropdown(String playerName) {
        return By.xpath("//ngb-highlight[@ng-reflect-result='" + playerName + " (1000)']");
    }

//    return By.xpath("//a[contains(text(),'" + playerName + "')]/../..//button[1]");

    @FindBy(how = How.XPATH, using = "//input[@placeholder='HH']")
    private WebElement matchHH;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='MM']")
    private WebElement matchMM;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Type second player name']")
    private WebElement secondPlayerName;

    @FindBy(how = How.ID, using = "matchSaveBtn")
    private WebElement matchSaveButton;

    private static By getPlayerName(int i) {
        return By.xpath("//tr[" + i + "]//td[1]//a");
    }

    private void setMatchTimeStamp(Match match) {
        typeText(matchHH, match.getHour());
        typeText(matchMM, match.getMinute());
    }

    private void setPlayerOne(Player playerOne) {
        typeText(firstPlayerName, playerOne.getName());
        clickElement(playerDropdown(playerOne.getName()));
    }

    private void setPlayerTwo(Player playerTwo) {
        typeText(secondPlayerName, playerTwo.getName());
        clickElement(playerDropdown(playerTwo.getName()));
    }

    private void isMatchAdded(Match match) {
        confirmMatch(match.getHour() + ":" + match.getMinute());
    }

    private static By confirmMatch(String timestamp) {
        return By.xpath("//td[contains(text(),'" + timestamp + "')]");
    }

    private void addMatch() {
        clickElement(addMatchButton);
    }

    private void saveMatch() {
        clickElement(matchSaveButton);
    }


    public MatchesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void createMatch(List<Player> playerList, int playerOneID, int playerTwoID, int addMinutesToCurrentTime) {
        Player playerOne = playerList.get(playerOneID);
        Player playerTwo = playerList.get(playerTwoID);
        List<Match> matchList = matchCreator.createOneMatch(playerOne, playerTwo, addMinutesToCurrentTime);
        for (Match match : matchList) {
            addMatch();
            setMatchTimeStamp(match);
            setPlayerOne(playerOne);
            setPlayerTwo(playerTwo);
            saveMatch();
            isMatchAdded(match);
        }
    }

    public void createMatchFromPlayersList(List<Player> playerList) {
        int playerOneID = 0;
        int playerTwoID = 1;
        Player playerOne = playerList.get(playerOneID);
        Player playerTwo = playerList.get(playerTwoID);
        List<Match> matchList = matchCreator.createMatchFromPlayerList(playerList, playerOne, playerTwo);
        for (Match match : matchList) {
            addMatch();
            setMatchTimeStamp(match);
            setPlayerOne(playerOne);
            setPlayerTwo(playerTwo);
            saveMatch();
            isMatchAdded(match);
            try {
                playerOne = playerList.get(playerOneID += 2);
                playerTwo = playerList.get(playerTwoID += 2);
            } catch (IndexOutOfBoundsException e) {
            }
        }
    }

//    public ArrayList<Player> getPlayersList(){
//        goToPlayersPage();
//        int playersQuantity = driver.findElements(By.xpath("//table[1]//tbody[1]/tr")).size();
//        ArrayList<Player> players = new ArrayList<>();
//        for(int i = 1; i<playersQuantity+1; i++){
//            Player player = new Player();
//            player.setName(getText(getPlayerName(i)));
//            players.add(player);
//        }
//        return players;
//    }

//    public String getPlayersName(int index){
//        List<Player> playerList = getPlayersList();
//        Player player = playerList.get(index);
//        String player2 = player.getName();
//        return player2;
//    }
//
//    public void createMatch(String playerOne, String playerTwo){
//        List<Match> matchList = matchCreator.createMatch(playerOne, playerTwo);
//        for(Match match: matchList){
//            clickElement(addMatchButton);
//            typeText(firstPlayerName,playerOne);
//            typeText(secondPlayerName,playerTwo);
//        }
//    }
}
