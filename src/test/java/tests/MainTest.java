package tests;

import config.Configuration;
import objects.MainPage;
import objects.PlayersPage;
import objects.Profile;
import org.testng.annotations.Test;

public class MainTest extends Configuration{

    @Test()
    public void test() throws Exception{
        MainPage mainPage = openMainPage().signIn();
        Profile profile = mainPage.goToLeague("League4");
        PlayersPage players = profile.assignProfileToCreatedLeague();
        players.addPlayer();
        //
    }


}
