package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.FootballClub;
import entities.Match;
import play.mvc.Result;
import services.LeagueService;

import java.io.IOException;
import java.util.ArrayList;

import static play.mvc.Results.ok;

public class LeagueController {

    public Result getClubs() throws IOException {
        ArrayList<FootballClub> result = LeagueService.getInstance().getClub();
        ObjectMapper map = new ObjectMapper();

        JsonNode data = map.convertValue(result,JsonNode.class);
        return ok(data);
    }

    public Result getMatches() throws IOException {
        ArrayList<Match> result = LeagueService.getInstance().getMatch();
        ObjectMapper map = new ObjectMapper();

        JsonNode data = map.convertValue(result,JsonNode.class);
        return ok(data);
    }

    public Result getClubsWin() throws IOException {
        ArrayList<FootballClub> result = LeagueService.getInstance().getWinClub();
        ObjectMapper map = new ObjectMapper();

        JsonNode data = map.convertValue(result,JsonNode.class);
        return ok(data);
    }

    public Result getClubsScore() throws IOException {
        ArrayList<FootballClub> result = LeagueService.getInstance().getScoreClub();
        ObjectMapper map = new ObjectMapper();

        JsonNode data = map.convertValue(result,JsonNode.class);
        return ok(data);
    }

//    public Result getRandom() throws IOException,ClassNotFoundException {
//        Match result = LeagueService.getInstance().randomMatch();
//        ObjectMapper map = new ObjectMapper();
//
//        JsonNode data = map.convertValue(result,JsonNode.class);
//        return ok(data);
//    }

}
