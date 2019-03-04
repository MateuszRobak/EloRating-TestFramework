package objects;

import java.util.ArrayList;

public class PlayerCreator {
    String affix = "a";
    public PlayerCreator(){
    }


    public ArrayList<Player> createPlayers(int quantity){
        ArrayList<Player> players = new ArrayList<Player>();
        for(int i =0; i< quantity; i++){
            Player player = new Player();
            player.setId(i);
            player.setName("Test Test" + affix);
        }
        return players;
    }
}
