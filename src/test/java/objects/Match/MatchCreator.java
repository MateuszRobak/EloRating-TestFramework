package objects.Match;

import helpers.Dates;
import objects.Player.Player;


import java.util.ArrayList;

public class MatchCreator {


    public ArrayList<Match> createMatch(Player playerOne, Player playerTwo, int minutes){
        ArrayList<Match> matchList = new ArrayList<>();
        for(int i = 0; i<1; i++){
            Match match = new Match();
            match.setId(i);
            match.setPlaeyrOne(playerOne.getName());
            match.setPlayerTwo(playerTwo.getName());
            match.setHour(Dates.addHoursToCurrentHour(1));
            match.setMinute(Dates.addMinutesToCurrentMinute(minutes));
            matchList.add(match);
        }
        return matchList;
    }

    public ArrayList<Match> createMatch2(Player playerOne, Player playerTwo){
        ArrayList<Match> matchList = new ArrayList<>();
        for(int i = 0; i<1; i++){
            Match match = new Match();
            match.setId(i);
            match.setPlaeyrOne(playerOne.getName());
            match.setPlayerTwo(playerTwo.getName());
            match.setHour(Dates.addHoursToCurrentHour(1));
            match.setMinute(Dates.addMinutesToCurrentMinute(10));
            matchList.add(match);
        }
        return matchList;
    }

//    public ArrayList<Match> createMatch(String playerOne, String playerTwo){
//        ArrayList<Match> matchList = new ArrayList<>();
//        for(int i = 0; i<1; i++){
//            Match match = new Match();
//            match.setId(i);
//            match.setPlaeyrOne(playerOne);
//            match.setPlayerTwo(playerTwo);
//            match.setHour(15);
//            match.setMinute(30);
//            matchList.add(match);
//        }
//        return matchList;
//    }
}
