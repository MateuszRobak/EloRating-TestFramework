package tests;

import config.Configuration;
import helpers.Dates;
import objects.*;
import objects.Player.Player;
import org.testng.annotations.Test;

import java.util.List;

public class MainTest extends Configuration{


    @Test()
    public void createMatchFromExistingPlayerList() throws Exception {
        MainPage mainPage = openMainPage().signIn().goToLeague("xxxx");
        PlayersPage playersPage = mainPage.goToPlayersPage();
        List<Player> playerList = playersPage.getPlayersList();
        MatchesPage matchesPage = playersPage.goToMatches();
        matchesPage.createMatchFromPlayersList(playerList);
    }

    @Test()
    public void createLeaguePlayersAndMatch() throws Exception {
        MainPage mainPage = openMainPage().signIn().createLeague();
        PlayersPage playersPage = mainPage.goToPlayersPage();
        List<Player> playerList = playersPage.createPlayers(4,false);
        MatchesPage matchesPage = playersPage.goToMatches();
        matchesPage.createMatch(playerList,0,1,10);
        matchesPage.createMatch(playerList,2,3, 20);




//        List<Player> playerList = playersPage.createPlayers(2,false);
//
//        MatchesPage matchesPage = mainPage.goToMatches();
//        matchesPage.createMatch(playerList,0,1);











    }


}
