package objects.Player;

import helpers.Dates;
import objects.Match.Match;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class PlayerCreator {
    public static java.lang.String playerName = "Test";

    public ArrayList<Player> createPlayers(int quantity){
        ArrayList<Player> players = new ArrayList<>();
        for(int i = 0; i< quantity; i++){
            Player player = new Player();
            player.setId(i+1);
            player.setName(playerName + player.getId());
            players.add(player);
            System.out.println(player.getName());
        }
        return players;
    }

    public ArrayList<Player> getPlayer(Player playerID, int quantity){
        ArrayList<Player> players = new ArrayList<>();
        for(int i = 0; i<quantity; i++){
            Player player = new Player();
            player.setName(player.getName());
            players.add(player);
        }
        return players;
    }

//    public ArrayList<Player> getPlayers(){
//        int playersQuantity = driver.findElements(By.xpath("//table[@class='shadedtable table']/tr")).size();
//        ArrayList<Player> players = new ArrayList<>();
//        for(int i = 0; i<playersQuantity; i++){
//            Player player = new Player();
//            player.setName(getText(getPlayerName(player.getId())));
//            players.add(player);
//
//        }
//        return players;
//    }
}
