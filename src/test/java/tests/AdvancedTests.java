package tests;

import config.Configuration;
import objects.*;
import objects.Player.Player;
import org.testng.annotations.Test;

import java.util.List;

public class AdvancedTests extends Configuration{

    @Test()
    public void createLeaguePlayersAndMatch() throws Exception {
        MainPage mainPage = logIntoApplication().signIn().goToLeague("xxxx");
        System.out.println("klasa T");
    }
}
