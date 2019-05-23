package objects.Player;

import java.util.ArrayList;

public class PlayerCreator {
    public static java.lang.String playerName = "Test";

    public ArrayList<Player> createPlayerList(int quantity){
        ArrayList<Player> playerList = new ArrayList<>();
        for(int i = 0; i< quantity; i++){
            Player player = new Player();
            player.setId(i+1);
            player.setName(playerName + player.getId());
            playerList.add(player);
            System.out.println(player.getName());
        }
        return playerList;
    }
}
