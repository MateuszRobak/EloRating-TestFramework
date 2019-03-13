package objects.Player;

import java.util.ArrayList;

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
}
