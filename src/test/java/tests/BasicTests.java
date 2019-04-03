package tests;

import config.Configuration;
import objects.*;
import objects.Player.Player;
import org.testng.annotations.Test;

import java.util.List;

public class BasicTests extends Configuration{


    @Test()
    public void createMatchFromNewPlayerList() throws Exception {
        MainPage mainPage = logIntoApplication().createLeague();
        PlayersPage playersPage = mainPage.goToPlayersPage();
        playersPage.createPlayers(2);
        List<Player> playerList = playersPage.getPlayersList();
        MatchesPage matchesPage = playersPage.goToMatches();
        matchesPage.createMatch(playerList, 1,2);
    }

    @Test()
    public void createLeaguePlayersAndMatch() throws Exception {
        MainPage mainPage = logIntoApplication().createLeague();
        PlayersPage playersPage = mainPage.goToPlayersPage();
        List<Player> playerList = playersPage.createPlayers(2);
        MatchesPage matchesPage = playersPage.goToMatches();
        matchesPage.createMatchFromPlayersList(playerList);
    }
}
