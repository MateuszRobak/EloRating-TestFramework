package tests;

import config.Configuration;
import objects.*;
import objects.Match.MatchCreator;
import objects.Player.Player;
import objects.Player.PlayerCreator;
import org.testng.annotations.Test;

import java.util.List;

public class MainTest extends Configuration{


    @Test()
    public void test() throws Exception{
        MainPage mainPage = openMainPage().signIn().createLeague();
        PlayersPage playersPage = new PlayersPage(driver);
        playersPage.addPlayer(2,false);


        MatchesPage matchesPage = mainPage.goToMatches();
        matchesPage.createMatch("Test0","Test01");










    }


}
