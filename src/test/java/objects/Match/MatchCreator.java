package objects.Match;

import objects.Player.Player;

import java.util.ArrayList;

public class MatchCreator {


    public ArrayList<Match> createMatch(String playerOne, String playerTwo){
        ArrayList<Match> matchList = new ArrayList<>();
        for(int i = 0; i<1; i++){
            Match match = new Match();
            match.setId(i);
            match.setPlaeyrOne(playerOne);
            match.setPlayerTwo(playerTwo);
            match.setHour(15);
            match.setMinute(30);
            matchList.add(match);
        }
        return matchList;
    }






}
