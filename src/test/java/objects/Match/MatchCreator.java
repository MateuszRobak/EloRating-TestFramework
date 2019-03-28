package objects.Match;
import helpers.Dates;
import objects.Player.Player;
import java.util.ArrayList;
import java.util.List;

public class MatchCreator {
    private int minPlayersQuantityForOneMatch = 2;

    private int maxNumberOfMatchesOddPlayerList(List<Player> playerList) {
        return (playerList.size() - 1) / 2;
    }

    private int maxNumberOfMatchesEvenPlayerList(List<Player> playerList) {
        return (playerList.size()) / 2;
    }

    private void createMatch(int matchID, List<Match> matchList, Player playerOne, Player playerTwo, int addMinutesToCurrentTime) {
        Match match = new Match();
        match.setId(matchID);
        match.setPlaeyrOne(playerOne.getName());
        match.setPlayerTwo(playerTwo.getName());
        match.setHour(Dates.addHoursToCurrentHour(1));
        match.setMinute(Dates.addMinutesToCurrentMinute(addMinutesToCurrentTime));
        matchList.add(match);
    }

    public ArrayList<Match> createOneMatch(Player playerOne, Player playerTwo, int addMinutesToCurrentTime) {
        ArrayList<Match> matchList = new ArrayList<>();
        for (int matchID = 0; matchID < 1; matchID++) {
            createMatch(matchID, matchList, playerOne, playerTwo, addMinutesToCurrentTime);
        }
        return matchList;
    }

    public ArrayList<Match> createMatchFromPlayerList(List<Player> playerList, Player playerOne, Player playerTwo) {
        ArrayList<Match> matchList = new ArrayList<>();
        if (playerList.size() % minPlayersQuantityForOneMatch > 0) {
            for (int matchID = 0; matchID < (maxNumberOfMatchesOddPlayerList(playerList)); matchID++) {
                createMatch(matchID, matchList, playerOne, playerTwo, 10 + matchID);
            }
        } else {
            for (int matchID = 0; matchID < (maxNumberOfMatchesEvenPlayerList(playerList)); matchID++) {
                createMatch(matchID, matchList, playerOne, playerTwo, 10 + matchID);
            }
        }
        return matchList;
    }
}
